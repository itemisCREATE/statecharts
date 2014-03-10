package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.SimpleAttributeResolver

class ExecutionContextHelper {
	
	@Inject
	extension IQualifiedNameProvider nameProvider
	
	def dispatch ExecutionVariable resolveVariable(ExecutionContext context, ElementReferenceExpression e) {
		if (e.reference instanceof VariableDefinition) {
			return context.getVariable(e.reference.getFullyQualifiedName.toString)
		} 
		else null
	}

	def dispatch ExecutionVariable resolveVariable(ExecutionContext context, FeatureCall e) {
		if (e.feature instanceof VariableDefinition) {
			return context.getVariable(e.feature.getFullyQualifiedName.toString)
		}
		else if (e.feature instanceof Property) {
			// get var def where to set this property (TODO: nested properties?)
			var current = e
			while (!(current.owner instanceof ElementReferenceExpression))
				current = current.owner as FeatureCall
				
			val varDef = (current.owner as ElementReferenceExpression).reference as VariableDefinition
			return context.getVariable(varDef.getFullyQualifiedName.append(e.feature.name).toString)
		}
		else if (e.feature instanceof Operation) {
			// for operation return the execution variable of the operation call's owner on which the operation is to be executed
			return context.resolveVariable(e.owner)
		}
		else null
	}

	def dispatch ExecutionVariable resolveVariable(ExecutionContext context, AssignmentExpression e) {
		return context.resolveVariable(e.varRef)
	}
	
	def private name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
	}
}