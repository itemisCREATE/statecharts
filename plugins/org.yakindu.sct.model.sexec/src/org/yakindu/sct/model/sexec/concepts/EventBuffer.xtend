/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.concepts

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sexec.concepts.ShadowMemberScope
import org.yakindu.sct.model.sexec.transformation.config.IFlowConfiguration
import org.yakindu.base.types.Type

/**
 * This class defines the concept of an event buffer which can be applied to cycle based state machines.
 * It defines additional types and members which implement a double buffering of events. 
 * 
 * @author aterfloth
 */
class EventBuffer {
	
	public static String EVENT_BUFFER_ANNOTATION = "__event_buffer__"
	
	@Inject extension TypeBuilder
	@Inject extension BufferEvent	
	@Inject extension INamingService
	@Inject extension OriginTracing
	@Inject extension ExpressionBuilder
	@Inject extension ShadowMemberScope
	
	@Inject protected extension IFlowConfiguration config
	
	def defineEventBuffer(ExecutionFlow flow, Statechart sc){
		
		if (! (applyIncomingEventBuffer || applyInternalEventBuffer)) return 
		
		val bufferType = _complexType() => [ bt |
			flow.scopes.filter[hasBufferedEvents].forEach[ scope | 
				val scopeBufferType = _complexType() => [ scopeType |
					scope.declarations
						.filter(Event)
						.filter[ e | e.isBuffered]
						.forEach[ e | e.createBufferEvent => [
							scopeType.features.add(it)
							it.traceOrigin(e)
						]]
					scopeType._annotate(EVENT_BUFFER_ANNOTATION)
				]
				
				scopeBufferType.traceOrigin(scope)
				if (!scopeBufferType.features.empty) bt.features += _variable(scope.featureName, scopeBufferType)
			]
			
			bt._annotate(EVENT_BUFFER_ANNOTATION)
			bt.traceOrigin(flow)
		]
		
		if (!bufferType.features.empty) flow.features += _variable("_current", bufferType)
	}
	
	def protected dispatch featureName(Scope it) {
		'timeEvents'	
	}

	def protected dispatch featureName(InternalScope it) {
		if ( isShadowMemberScope ) "shadow"
		else "internal"	
	}
	
	def protected dispatch featureName(InterfaceScope it) {
		'iface' + (if(name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper
	}
		
	def hasBufferedEvents(Scope it) {
		it.declarations.filter(Event).exists[ e | e.direction != Direction::OUT]	
	}
		
	def eventBuffer(ExecutionFlow it) {
		eventBuffers.head
	}
	
	def hasEventBuffer (ExecutionFlow it) {
		eventBuffer !== null
	}
	
	def eventBuffers(ComplexType it) {
		features
			.filter(Property)
			.filter[ p | p.type instanceof ComplexType && p.type.isEventBuffer]
	}

	def List<List<Declaration>> bufferEventPaths(Property it) {

		val l = newArrayList
		l.addAll(
			features
				.filter(Event)
				.filter[ e | e.isBufferEvent]
				.map[ e | newArrayList(it, e as Declaration) as List<Declaration>]
		)
		features
			.filter(Property)
			.filter[p | p.type.isEventBuffer]
			.map[ p | p.bufferEventPaths]
			.forEach[ bel | 
				bel.forEach[ be | be.add(0,it)] 
				l.addAll(bel)
			]

		return l			
	}
	
	def isBuffered(Event e) {
		(applyIncomingEventBuffer && e.direction == Direction.IN) || 
		(applyInternalEventBuffer && e.direction == Direction.LOCAL) 
	}
	
	
	def isEventBuffer(Type it){
		annotations.exists[ a | a.type.name == EVENT_BUFFER_ANNOTATION]		
	}
	
	
	def Event originEvent(Event it) {
		originTraces.filter(Event).head
	}

	def List<Expression> asExpressions(List<List<Declaration>> declPaths) {
		declPaths.map[ path | 
			path.fold(null as Expression, [ 
				expr, decl | if (expr === null) decl._ref else expr._dot(decl)
			])
		]	
	}
	
	def features(Property it) {
		if (it.type instanceof ComplexType) (type as ComplexType).features
		else #[]
	}
}