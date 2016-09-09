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
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Event
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot

/**
 * Default implementation for resolving execution slots based on expressions.
 * 
 * @author Thomas Kutz
 * @author axel terfloth
 */
class DefaultExecutionSlotResolver implements IExecutionSlotResolver {

	@Inject
	protected extension IQualifiedNameProvider nameProvider

	def dispatch ExecutionSlot resolve(ExecutionContext context, FeatureCall e) {		
		return resolveByFeature(context, e, e.feature)		
	}
	
	def dispatch ExecutionSlot resolve(ExecutionContext context, ElementReferenceExpression e) {
		packageNamespaceAwareResolve(context, e.reference)
	}
	
	def dispatch ExecutionSlot resolve(ExecutionContext context, AssignmentExpression e) {
		return context.resolve(e.varRef)
	}
	
	def dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, EObject feature){
		return context.getVariable(e.feature.fullyQualifiedName.toString)
	}
	
	def dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, Event feature){
		return resolveCompositeSlot(context, e)
	}
	
	def dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, Property feature){
		return resolveCompositeSlot(context, e)
	}
	
	
	def ExecutionSlot resolveCompositeSlot(ExecutionContext context, FeatureCall e){
		var current = e
		val Stack<FeatureCall> callStack = new Stack
		callStack.add(0, e)
		while (!(current.owner instanceof ElementReferenceExpression)) {
			current = current.owner as FeatureCall
			callStack.add(0, current)
		}
		// first: get the root slot where to start the search
		val root = (current.owner as ElementReferenceExpression).reference
		var ExecutionSlot featureSlot = null
		
		if (root instanceof InterfaceScope) {
			featureSlot = context.getSlot(callStack.pop.feature.fullyQualifiedName.toString)
		} else {
			featureSlot = packageNamespaceAwareResolve(context, root)
			if (featureSlot == null) {
				return null // could not find starting slot for feature call
			}
		}
		// go through all calls and traverse execution context hierarchy accordingly
		for (FeatureCall call : callStack) {
			featureSlot = resolveFromSlot(featureSlot, call)
		}
		return featureSlot
	}
	
	def protected dispatch ExecutionSlot resolveFromSlot(ExecutionSlot slot, FeatureCall call) {
		slot // fallback
	}
	
	def protected dispatch ExecutionSlot resolveFromSlot(CompositeSlot slot, FeatureCall call) {
		resolveByFeature(slot, call.feature)
	}
	
	def protected dispatch ExecutionSlot resolveByFeature(CompositeSlot slot, EObject feature) {
		slot // fallback
	}
	
	def protected dispatch ExecutionSlot resolveByFeature(CompositeSlot slot, Property feature) {
		resolveByName(slot, feature)
	}
	
	def protected dispatch ExecutionSlot resolveByFeature(CompositeSlot slot, Event feature) {
		resolveByName(slot, feature)
	}
	
	def protected ExecutionSlot resolveByName(CompositeSlot slot, NamedElement element) {
		slot.slots.findFirst[name == element.name]
	}
	
	def protected ExecutionSlot packageNamespaceAwareResolve(ExecutionContext context, EObject element) {
		val pkg = EcoreUtil2.getContainerOfType(element, Package)
		if (pkg != null) {
			context.getSlot(pkg.name + "." + element.fullyQualifiedName.toString)
		}
		else {
			context.getSlot(element.fullyQualifiedName.toString)
		}
	}

	def protected name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
	}
}