/** 
 * Copyright (c) 2020 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.extensions

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.VariableDefinition

class ShadowEventExtensions {

	@Inject protected extension OriginTracing
	@Inject protected extension SExecExtensions
	@Inject protected extension ExpressionExtensions
	@Inject protected extension StatechartUtil

	def getShadowEvents(VariableDefinition member) {
		member.flow.shadowEvents.filter[originTraces.contains(member)]
	}

	def getShadowEvent(VariableDefinition member, Event originalEvent) {
		member.shadowEvents.findFirst[originTraces.contains(originalEvent)]
	}

	def getShadowEvents(ExecutionFlow flow) {
		var internalEvents = flow.scopes.filter(InternalScope).map[members].flatten.filter(Event)
		// in events in internal scope => must be a shadow event
		internalEvents.filter[direction == Direction.IN]
	}
	
	def getShadowEvents(StatechartScope it) {
		scope.flow.shadowEvents
	}
	
	def getShadowEventsByScope(VariableDefinition member) {
		member.shadowEvents.groupBy[originTraces.filter(Event).head.eContainer as InterfaceScope]
	}

	def getShadowEventName(FeatureCall fc) {
		fc.toCallStack.map[featureOrReference].filter(NamedElement).map[name].join("_")
	}
	
	def needsShadowEventMapping(VariableDefinition member) {
		member.type.isOriginStatechart && !member.shadowEvents.nullOrEmpty
	}

	def create StextFactory.eINSTANCE.createEventDefinition createShadowEvent(String shadowEventName,
		EObject member, Event originEvent, ExecutionFlow flow) {

		name = shadowEventName
		direction = Direction.IN
		typeSpecifier = EcoreUtil.copy(originEvent.typeSpecifier)

		// trace to statechart event, not the one in the statechart type
		traceOrigin(originEvent.originTraces.filter(Event).head)
		// also trace to submachine member, so we can properly trace back in getShadowEvent(member, event)
		traceOrigin(member)

		flow.shadowMemberScope.members += it
	}

	protected def create StextFactory.eINSTANCE.createInternalScope shadowMemberScope(ExecutionFlow flow) {
		flow.scopes += it
	}
}
