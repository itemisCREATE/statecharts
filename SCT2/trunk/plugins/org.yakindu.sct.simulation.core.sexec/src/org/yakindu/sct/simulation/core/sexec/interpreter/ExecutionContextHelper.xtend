package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable

class ExecutionContextHelper {
	
	@Inject
	extension IQualifiedNameProvider nameProvider
	
	def dispatch ExecutionSlot resolveVariable(ExecutionContext context, ElementReferenceExpression e) {
		if (e.reference instanceof VariableDefinition) {
			return context.getVariable(e.reference.getFullyQualifiedName.toString)
		} 
		else null
	}

	def dispatch ExecutionSlot resolveVariable(ExecutionContext context, FeatureCall e) {
		if (e.feature instanceof VariableDefinition) {
			return context.getVariable(e.feature.getFullyQualifiedName.toString)
		}
		else if (e.feature instanceof Property) {
			var current = e
			val List<EObject> calls = newArrayList
			calls.add(0, e.feature)
			while (!(current.owner instanceof ElementReferenceExpression)) {
				current = current.owner as FeatureCall
				calls.add(0, current.feature)
			}
			
			val varDef = (current.owner as ElementReferenceExpression).reference as VariableDefinition
			val varDefFqn = varDef.getFullyQualifiedName.toString
			
			var featureSlot = context.getSlot(varDefFqn)
			if (featureSlot == null) {
				featureSlot = context.getVariable(varDef.getFullyQualifiedName.toString)
				if (featureSlot == null)
					return null // could not find starting slot for feature call
			}
			
			// go through all calls and traverse execution context hierarchy accordingly
			for (EObject feature : calls) {
				
				if (featureSlot instanceof CompositeSlot && feature instanceof Property) {
					featureSlot = (featureSlot as CompositeSlot).slots.findFirst[slot | slot.name == feature.name]
				}
				if (featureSlot instanceof ExecutionVariable && feature instanceof Operation) {
//					TODO (featureSlot as ExecutionVariable).value
				}
			}
			
			return featureSlot
		}
		else if (e.feature instanceof Operation) {
			// for operation return the execution variable of the operation call's owner on which the operation is to be executed
			return context.resolveVariable(e.owner)
		}
		else null
	}
	
	def private ExecutionSlot getSlot(CompositeSlot root, String name) {
		for (ExecutionSlot slot : root.slots) {
			if (slot.fqName == name) {
				return slot
			}
			if (slot instanceof CompositeSlot) {
				val foundSlot = (slot as CompositeSlot).getSlot(name)
				if (foundSlot != null)
					return foundSlot
			}
		}
		return null
	}

	def dispatch ExecutionSlot resolveVariable(ExecutionContext context, AssignmentExpression e) {
		return context.resolveVariable(e.varRef)
	}
	
	def ExecutionEvent resolveEvent(ExecutionContext context, FeatureCall call) {
		// TODO consider deeper nested calls as done in resolveVariable
		var fqn = call.feature.fullyQualifiedName.toString
		if (call.owner instanceof ElementReferenceExpression) {
			val ref = (call.owner as ElementReferenceExpression).reference
			val variableSlot = context.getSlot(ref.fullyQualifiedName.toString)
			if (variableSlot != null) {
				fqn = variableSlot.fqName + "." + call.feature.fullyQualifiedName.toString
			}
		}
		context.getEvent(fqn)
	}
	
	def private name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
	}
}