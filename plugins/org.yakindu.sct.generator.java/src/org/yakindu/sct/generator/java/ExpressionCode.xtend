/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.ShiftOperator
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryOperator
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition

class ExpressionCode {

	@Inject extension Naming
	@Inject extension JavaNamingService
	@Inject extension Navigation
	@Inject extension ITypeSystem
	@Inject extension ITypeSystemInferrer
	@Inject extension ICodegenTypeSystemAccess

	private var List<TimeEvent> timeEvents;

	def private getTimeEvents(TimeEvent it) {
		if (timeEvents == null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}

	def dispatch String code(EObject it) '''
		//ERROR: Template in ExpressionCode.xtend for class '«getClass().name»' not define.
		//Container: «eContainer?.getClass().name»
	'''

	def dispatch String code(OperationDefinition it) {
		return getContext + "operationCallback." + name.asEscapedIdentifier;
	}

	def dispatch String code(PrimitiveValueExpression primValue) {
		primValue.value.code;
	}

	def dispatch String code(ParenthesizedExpression e) {
		"(" + e.expression.code + ")";
	}

	/* Assignment */
	def dispatch String code(AssignmentExpression it) {
		if (varRef.definition instanceof Property) {
			var property = varRef.definition as Property
			if (eContainer instanceof Expression) {
				return '''«property.getContext»«property.assign»(«assignCmdArgument(property)»)'''
			} else {
				return '''«property.getContext»«property.setter»(«assignCmdArgument(property)»)'''
			}
		}
	}

	def assignCmdArgument(AssignmentExpression it, Property property) {
		var cmd = ""
		if (!AssignmentOperator.ASSIGN.equals(operator)) {
			cmd = property.getContext + property.getter + " " + operator.code.replaceFirst("=", "") + " "

			if (expression instanceof PrimitiveValueExpression || expression instanceof ElementReferenceExpression ||
				expression instanceof AssignmentExpression) {
				cmd += expression.code
			} else {
				cmd += "(" + expression.code + ")"
			}

		} else {
			cmd = expression.code
		}
		return cmd
	}

	/* Literals */
	def dispatch String code(BoolLiteral expression) {
		expression.value.toString()
	}

	def dispatch String code(IntLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(HexLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(DoubleLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(FloatLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(NullLiteral expression) {
		'null'
	}

	def dispatch String code(StringLiteral expression) {
		"\"" + expression.value.toString().escaped + "\""
	}

	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	/* Logical Expressions */
	def dispatch String code(LogicalOrExpression expression) {
		expression.leftOperand.code + " || " + expression.rightOperand.code
	}

	def dispatch String code(ConditionalExpression expression) {
		expression.condition.code + ' ? ' + expression.trueCase.code + ' : ' + expression.falseCase.code
	}

	def dispatch String code(LogicalAndExpression expression) {
		expression.leftOperand.code + " && " + expression.rightOperand.code
	}

	def dispatch String code(LogicalNotExpression expression) {
		" !" + expression.operand.code
	}

	def dispatch String code(LogicalRelationExpression expression) {
		if (isSame(expression.leftOperand.infer.type, getType(GenericTypeSystem.STRING))) {
			expression.logicalString
		} else
			expression.leftOperand.code + expression.operator.code + expression.rightOperand.code;
	}

	def String logicalString(LogicalRelationExpression expression) {
		if (expression.operator == RelationalOperator::EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null :" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + "))"
		} else if (expression.operator == RelationalOperator::NOT_EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " !=null : !" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + "))"
		}
	}

	def dispatch String code(BitwiseAndExpression expression) {
		expression.leftOperand.code + " & " + expression.rightOperand.code
	}

	def dispatch String code(BitwiseOrExpression expression) {
		expression.leftOperand.code + " | " + expression.rightOperand.code
	}

	def dispatch String code(BitwiseXorExpression expression) {
		expression.leftOperand.code + " ^ " + expression.rightOperand.code
	}

	def dispatch String code(ShiftExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code
	}

	def dispatch String code(NumericalAddSubtractExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code
	}

	def dispatch String code(NumericalMultiplyDivideExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code
	}

	def dispatch String code(NumericalUnaryExpression expression) {
		expression.operator.code + expression.operand.code
	}

	def dispatch String code(ActiveStateReferenceExpression it) {
		"isStateActive(State." + value.stateName.asEscapedIdentifier + ")";
	}

	def dispatch String code(AdditiveOperator operator) {
		operator.literal
	}

	def dispatch String code(ShiftOperator operator) {
		operator.literal
	}

	def dispatch String code(UnaryOperator operator) {
		operator.literal
	}

	def dispatch String code(MultiplicativeOperator operator) {
		operator.literal
	}

	def dispatch String code(RelationalOperator operator) {
		operator.literal
	}

	def dispatch String code(AssignmentOperator operator) {
		operator.literal
	}

	def dispatch String code(EventRaisingExpression it) {
		if (value != null) {
			event.definition.getContext + "raise" + event.definition.name.toFirstUpper + "(" + value.code + ")"
		} else {
			event.definition.getContext + "raise" + event.definition.name.toFirstUpper + "()"
		}
	}

	def dispatch String code(EventValueReferenceExpression it) {
		value.definition.getContext + value.definition.event.getter
	}

	def dispatch String code(ElementReferenceExpression it) {
		if (it.reference instanceof OperationDefinition)
			'''«reference.code»(«FOR arg : args SEPARATOR ", "»«arg.code»«ENDFOR»)'''
		else {
			val myDef = definition
			if (myDef instanceof Property && isAssignmentContained) {
				'''«myDef.getContext + myDef.identifier»'''
			} else if (myDef instanceof Property && isPropertyContained) {
				'''«myDef.getStaticContext + myDef.identifier»'''
			} else {
				'''«definition.code»'''
			}
		}
	} 
		
	def dispatch String code(FeatureCall it) {
		if (feature instanceof Operation) {
			return '''«feature.code»(«FOR arg : args SEPARATOR ", "»«arg.code»«ENDFOR»)'''
		} else {
			return '''«definition.getContext + definition.name.asEscapedIdentifier»''' 
		}
	} 

	def dispatch String code(Declaration it) {
		getContext+ identifier
	}

	def dispatch String code(Property it) {
		getContext + getter
	}

	def dispatch String code(TimeEvent it) {
		"timeEvents[" + getTimeEvents.indexOf(it) + "]"
	}

	def dispatch String code(TypeCastExpression it) {
		'''((«type.getTargetLanguageName») «operand.code»)'''
	}

	def dispatch String getContext(Property it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}
	
	def dispatch String getStaticContext(Property it) {
		if (it.const) {
			return getConstContext(it)
		}
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}
	
	def dispatch String getStaticContext(EObject it) {
		return "//ERROR: No context for " + it
	}

	def getConstContext(Property it) {
		if (scope != null) {
			return scope.interfaceName + "."
		} else {
			return it.flow.statemachineInterfaceName + "."
		}
	}

	def dispatch String getContext(Event it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(OperationDefinition it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(EObject it) {
		return "//ERROR: No context for " + it
	}

	def boolean isAssignmentContained(Expression it) {
		if (it instanceof AssignmentExpression) {
			return true
		} else if (eContainer instanceof Expression) {
			return isAssignmentContained(eContainer as Expression)
		}
		return false // default
	}

	def boolean isPropertyContained(Expression it) {
		if (eContainer instanceof Property) {
			return true
		} else if (eContainer instanceof Expression) {
			return isPropertyContained(eContainer as Expression)
		}
		return false // default
	}

}
