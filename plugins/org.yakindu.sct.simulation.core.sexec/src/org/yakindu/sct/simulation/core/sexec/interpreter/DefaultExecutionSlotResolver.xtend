/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable

/**
 * Default implementation for resolving execution slots based on expressions.
 * 
 * @author Thomas Kutz
 */
class DefaultExecutionSlotResolver implements IExecutionSlotResolver {

	@Inject
	extension IQualifiedNameProvider nameProvider

	def dispatch ExecutionSlot resolve(ExecutionContext context, FeatureCall e) {
		if (e.feature instanceof VariableDefinition) {
			return context.getVariable(e.feature.fullyQualifiedName.toString)
		}
		if (e.feature instanceof Operation) {
			// for operation return the execution variable of the operation call's owner on which the operation is to be executed
			return context.resolve(e.owner)
		}
		if (e.feature instanceof Property || e.feature instanceof Event) {
			var current = e
			val List<EObject> calls = newArrayList
			calls.add(0, e.feature)
			while (!(current.owner instanceof ElementReferenceExpression)) {
				current = current.owner as FeatureCall
				calls.add(0, current.feature)
			}

			// first: get the root slot where to start the search searching
			val root = (current.owner as ElementReferenceExpression).reference
			var ExecutionSlot featureSlot = null
			
			if (root instanceof InterfaceScope) {
				featureSlot = context.getSlot(calls.get(0).fullyQualifiedName.toString)
				calls.remove(0)
			}
			else {
				var varDefFqn = getFqn(root).toString
				featureSlot = context.getSlot(varDefFqn)
				if (featureSlot == null) {
					featureSlot = context.getSlot(root.fullyQualifiedName.toString)
					if (featureSlot == null)
						return null // could not find starting slot for feature call
				}
			}
			// go through all calls and traverse execution context hierarchy accordingly
			for (EObject feature : calls) {

				if (featureSlot instanceof CompositeSlot && (feature instanceof Property || feature instanceof Event)) {
					featureSlot = (featureSlot as CompositeSlot).slots.findFirst[slot|slot.name == feature.name]
				}
				if (featureSlot instanceof ExecutionVariable && feature instanceof Operation) {
					//					TODO (featureSlot as ExecutionVariable).value
				}
			}

			return featureSlot
		}
	}
	
	def dispatch ExecutionSlot resolve(ExecutionContext context, ElementReferenceExpression e) {
		context.getSlot(e.reference.fullyQualifiedName.toString)
	}
	
	def dispatch ExecutionSlot resolve(ExecutionContext context, AssignmentExpression e) {
		return context.resolve(e.varRef)
	}
	
	def getFqn(EObject varDef) {
		varDef.getFullyQualifiedName
	}

	def private name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
	}
}
