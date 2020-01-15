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
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.multism.MultiStatemachineHelper
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.OperationDefinition

class JavaExpressionsGenerator extends ExpressionsGenerator {

	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension OriginTracing
	@Inject protected extension StatechartUtil
	@Inject protected extension MultiStatemachineHelper
	
	var List<TimeEvent> timeEvents;

	def private getTimeEvents(TimeEvent it) {
		if (timeEvents === null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}

	def dispatch String code(OperationDefinition it) {
		return "operationCallback." + name.asEscapedIdentifier;
	}

	/* Assignment */
	override dispatch String code(AssignmentExpression it) {
		val property = varRef.definition
		if (property instanceof Property) {
			if (property.eContainer instanceof LocalVariableDefinition) {
				return '''«property.getContext»«property.name» = «assignCmdArgument(property)»'''
			}
			if (property.eContainer instanceof ComplexType) {
				return '''«varRef.getContext»«property.name» = «assignCmdArgument(property)»'''
			}
			if (eContainer instanceof Expression) {
				return '''«property.getContext»«property.assign»(«assignCmdArgument(property)»)'''
			}
			return '''«varRef.getContext»«property.setter»(«assignCmdArgument(property)»)'''
		}
	}

	def protected assignCmdArgument(AssignmentExpression it, Property property) {
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
		if (expression.leftOperand.infer.type.isString) {
			expression.logicalString
		} else
			expression.leftOperand.code + expression.operator.literal + expression.rightOperand.code;
	}

	def protected String logicalString(LogicalRelationExpression expression) {
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
			event.getContext + "raise" + event.definition.name.toFirstUpper + "(" + value.code + ")"
		} else {
			event.getContext + "raise" + event.definition.name.toFirstUpper + "()"
		}
	}

	def dispatch String code(EventValueReferenceExpression it) {
		value.getContext + value.definition.event.getter
	}

	def dispatch String code(ElementReferenceExpression it) {
		val ref = it.reference
		switch ref {
			Parameter: return ref.name
			ComplexType: return ref.name
			Declaration: return codeDeclaration(ref, it).toString
		}
	}

	def dispatch String code(FeatureCall it) {
		it.feature.codeDeclaration(it).toString
	}

	def protected codeDeclaration(Declaration it, ArgumentExpression exp) {
		switch it {
			Operation:
				return operationCall(it, exp)
			Event case exp.isComplexTypeContained:
				return exp.getContext + "isRaised" + name.toFirstUpper + "()"
			Enumerator case it.eContainer.isOriginStateEnum:
				return stateEnumAccess
			Declaration case exp.isComplexTypeContained:
				return exp.getContext + exp.definition.code
			Property case exp.isAssignmentContained:
				return getStaticContext + identifier
			Property case exp.isPropertyContained:
				return getStaticContext + identifier
			Property case exp.isPostFixContained:
				return getStaticContext + identifier
			Declaration:
				return exp.definition.code
		}
	}
	
	def protected stateEnumAccess(Enumerator stateEnum) {
		val statechart = stateEnum.eContainer.originStatechart
		val state = stateEnum.originState
		
		'''«statechart.executionFlow.statemachineClassName».State.«IF state !== null»«state.stateName.asEscapedIdentifier»«ELSE»«nullStateName»«ENDIF»'''
	}
	
	def dispatch protected String operationCall(Method it, ArgumentExpression exp) {
		'''«code»(«FOR arg : exp.expressions SEPARATOR ", "»«arg.code»«ENDFOR»)'''
	}
	
	def dispatch protected String operationCall(Operation it, ArgumentExpression exp) {
		'''«exp.getContext»«code»(«FOR arg : exp.expressions SEPARATOR ", "»«arg.code»«ENDFOR»)'''
	}

	def dispatch String code(Declaration it) {
		getContext + identifier
	}

	def dispatch String code(Property it) {
		if (eContainer instanceof ComplexType) {
			if (isInterfaceProperty) {
				return '''get«interfacePropertyScope.interfaceName»()'''
			}
			return getter
		}
		if (eContainer instanceof LocalVariableDefinition) {
			return it.name
		}
		getContext + getter
	}
	
	def protected getInterfacePropertyScope(Property it) {
		type.originTraces.filter(InterfaceScope).head
	}
	
	def protected isInterfaceProperty(Property it) {
		getInterfacePropertyScope !== null
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
	
	def dispatch String getContext(FeatureCall it) {
		val owner = it.owner
		if (owner instanceof ElementReferenceExpression) {
			if (owner.reference instanceof InterfaceScope) {
				// interface context
				return it.definition.getContext
			}
		}
		return it.owner.code + "."
	}
	
	def dispatch String getContext(ElementReferenceExpression it) {
		return it.definition.getContext
	}

	def dispatch String getStaticContext(Property it) {
		if (it.const) {
			if (interfaceScope !== null) {
				return interfaceScope.interfaceName + "."
			} else {
				return it.flow.statemachineInterfaceName + "."
			}
		}
		return getContext
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

	def protected boolean isAssignmentContained(Expression it) {
		eContainerOfType(AssignmentExpression) !== null
	}

	def protected boolean isPropertyContained(Expression it) {
		eContainerOfType(Property) !== null
	}
	
	def protected dispatch boolean isComplexTypeContained(FeatureCall it) {
		definition.eContainer instanceof ComplexType
	}
	
	def protected dispatch boolean isComplexTypeContained(ElementReferenceExpression it) {
		false
	}

    def protected boolean isPostFixContained(Expression it) {
       eContainerOfType(PostFixUnaryExpression) !== null
    }

	override dispatch CharSequence code(FloatLiteral it) '''«value.toString»f'''
}
