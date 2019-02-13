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
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.expressions.expressions.EventValueReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition

class JavaExpressionsGenerator extends ExpressionsGenerator {

	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer

	var List<TimeEvent> timeEvents;

	def private getTimeEvents(TimeEvent it) {
		if (timeEvents === null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}

	def dispatch String code(OperationDefinition it) {
		return getContext + "operationCallback." + name.asEscapedIdentifier;
	}

	/* Assignment */
	override dispatch String code(AssignmentExpression it) {
		if (varRef.definition instanceof Property) {
			var property = varRef.definition as Property
			if (property.eContainer instanceof LocalVariableDefinition) {
				return '''«property.getContext»«property.name» = «assignCmdArgument(property)»'''
			} else {
				if (eContainer instanceof Expression) {
					return '''«property.getContext»«property.assign»(«assignCmdArgument(property)»)'''
				} else {
					return '''«property.getContext»«property.setter»(«assignCmdArgument(property)»)'''
				}
			}
		}
	}

	def assignCmdArgument(AssignmentExpression it, Property property) {
		var cmd = ""
		if (!AssignmentOperator.ASSIGN.equals(operator)) {
			cmd = property.getContext + property.getter + " " + operator.literal.replaceFirst("=", "") + " "

			if (expression instanceof PrimitiveValueExpression || expression instanceof ElementReferenceExpression ||
				expression instanceof AssignmentExpression) {
				cmd += expression.code
			} else {
				cmd += "(" + expression.code + ")"
			}

		} else {
			cmd = expression.code.toString
		}
		return cmd
	}

	def dispatch String code(LogicalRelationExpression expression) {
		if (isSame(expression.leftOperand.infer.type, getType(GenericTypeSystem.STRING))) {
			expression.logicalString
		} else
			expression.leftOperand.code + expression.operator.literal + expression.rightOperand.code;
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

	def dispatch String code(ActiveStateReferenceExpression it) {
		"isStateActive(State." + value.stateName.asEscapedIdentifier + ")";
	}

	def dispatch String code(EventRaisingExpression it) {
		if (value !== null) {
			event.definition.getContext + "raise" + event.definition.name.toFirstUpper + "(" + value.code + ")"
		} else {
			event.definition.getContext + "raise" + event.definition.name.toFirstUpper + "()"
		}
	}

	def dispatch String code(EventValueReferenceExpression it) {
		value.definition.getContext + value.definition.event.getter
	}

	def protected dispatch String code(ElementReferenceExpression it) {
		if(it.reference instanceof Parameter) {
			(it.reference as Parameter).name
		}
		else {
			(it.reference as Declaration).codeDeclaration(it).toString
		}
	}

	def protected dispatch String code(FeatureCall it) {
		it.feature.codeDeclaration(it).toString
	}

	def protected codeDeclaration(Declaration it, ArgumentExpression exp) {
		switch it {
			Operation:
				return operationCall(it, exp)
			Property case exp.isAssignmentContained:
				return getStaticContext + identifier
			Property case exp.isPropertyContained:
				return getStaticContext + identifier
			Declaration:
				return exp.definition.code
		}
	}

	def protected String operationCall(Operation it, ArgumentExpression exp) {
		'''«code»(«FOR arg : exp.expressions SEPARATOR ", "»«arg.code»«ENDFOR»)'''
	}

	def dispatch String code(Declaration it) {
		getContext + identifier
	}

	def dispatch String code(Property it) {
		if(eContainer instanceof LocalVariableDefinition){
			return it.name
		}
		getContext + getter
	}

	def dispatch String code(TimeEvent it) {
		"timeEvents[" + getTimeEvents.indexOf(it) + "]"
	}

	def dispatch String getContext(Property it) {
		if (interfaceScope !== null) {
			return interfaceScope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getStaticContext(Property it) {
		if (it.const) {
			if (interfaceScope !== null) {
				var result = interfaceScope.interfaceName + "."
				return result
			} else {
				var result = it.flow.statemachineInterfaceName + "."
				return result
			}
		}
		return getContext()
	}

	def dispatch String getContext(Declaration it) {
		if (interfaceScope !== null) {
			return interfaceScope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(EObject it) {
		return "//ERROR: No context for " + it
	}

	def dispatch String getStaticContext(EObject it) {
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
