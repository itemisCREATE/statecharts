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
package org.yakindu.base.expressions.interpreter

import com.google.inject.Inject
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionSlot

/**
 * Default implementation for resolving execution slots based on expressions.
 * 
 * @author Thomas Kutz
 * @author axel terfloth
 */
class DefaultExecutionSlotResolver implements IExecutionSlotResolver {

	@Inject
	protected extension IQualifiedNameProvider
	
	def dispatch Optional<ExecutionSlot> resolve(ExecutionContext context, FeatureCall e) {
		return Optional.ofNullable(resolveByFeature(context, e, e.feature))
	}

	def dispatch Optional<ExecutionSlot> resolve(ExecutionContext context, ElementReferenceExpression e) {
		return Optional.ofNullable(packageNamespaceAwareResolve(context, e.reference))
	}

	def dispatch Optional<ExecutionSlot> resolve(ExecutionContext context, AssignmentExpression e) {
		return context.resolve(e.varRef)
	}

	def protected dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, EObject feature) {
		return context.getVariable(e.feature.fullyQualifiedName.toString)
	}

	def protected dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, Operation feature) {
		return resolveCompositeSlot(context, e)
	}

	def protected dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, Event feature) {
		return resolveCompositeSlot(context, e)
	}

	def protected dispatch ExecutionSlot resolveByFeature(ExecutionContext context, FeatureCall e, Property feature) {
		return resolveCompositeSlot(context, e)
	}

	def protected ExecutionSlot resolveCompositeSlot(ExecutionContext context, FeatureCall e) {
		var featureSlot = resolve(context, e.owner)
		if (!featureSlot.isPresent) {
			return null
		}
		return resolveFromSlot(featureSlot.get, e)
	}
	
	def protected dispatch ExecutionSlot resolveFromSlot(ExecutionSlot slot, FeatureCall call) {
		slot // fallback
	}

	def protected dispatch ExecutionSlot resolveFromSlot(CompositeSlot slot, Operation call) {
		resolveByFeature(slot, call)
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

	def protected dispatch ExecutionSlot resolveByFeature(CompositeSlot slot, Operation feature) {
		resolveByName(slot, feature)
	}

	def protected dispatch ExecutionSlot resolveByFeature(CompositeSlot slot, Event feature) {
		resolveByName(slot, feature)
	}

	def protected ExecutionSlot resolveByName(CompositeSlot slot, NamedElement element) {
		slot.slots.findFirst[name == element.name]
	}

	def protected ExecutionSlot packageNamespaceAwareResolve(ExecutionContext context, EObject element) {
		context.getSlot(element.fullyQualifiedName.toString)
	}

	def protected name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
	}
}
