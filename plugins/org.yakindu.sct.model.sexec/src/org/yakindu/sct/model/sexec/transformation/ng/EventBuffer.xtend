package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.BufferEventExtensions
import org.yakindu.sct.model.sexec.extensions.EventBufferExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope

class EventBuffer {
	
	@Inject extension TypeBuilder
	@Inject extension BufferEventExtensions	
	@Inject extension INamingService
	@Inject extension OriginTracing
	@Inject extension StatechartAnnotations
	
	def defineEventBuffer(ExecutionFlow flow, Statechart sc){
		
		if (sc.isEventDriven) return 
		
		val bufferType = _complexType() => [ bt |
			flow.scopes.filter[hasBufferedEvents].forEach[ scope | 
				val scopeBufferType = _complexType() => [ scopeType |
					scope.declarations
						.filter(Event)
						.filter[ e | e.direction != Direction::OUT ]
						.forEach[ e | e.createBufferEvent => [scopeType.features.add(it)]]
					scopeType._annotate(EventBufferExtensions::EVENT_BUFFER_ANNOTATION)
				]
				
				scopeBufferType.traceOrigin(scope)
				bt.features += _variable(scope.featureName, scopeBufferType)
			]
			
			bt._annotate(EventBufferExtensions::EVENT_BUFFER_ANNOTATION)
			bt.traceOrigin(flow)
		]
		
		flow.features += _variable("eventBuffer", bufferType)
	}
	
	def dispatch featureName(Scope it) {
		'timeEvents'	
	}

	def dispatch featureName(InternalScope it) {
		"internal"	
	}
	
	def dispatch featureName(InterfaceScope it) {
		'iface' + (if(name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper
	}
		
	def hasBufferedEvents(Scope it) {
		it.declarations.filter(Event).exists[ e | e.direction != Direction::OUT]	
	}
		
	
}