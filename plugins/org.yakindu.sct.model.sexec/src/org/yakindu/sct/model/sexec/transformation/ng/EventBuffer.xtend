package org.yakindu.sct.model.sexec.transformation.ng

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
import org.yakindu.sct.model.sexec.extensions.BufferEventExtensions
import org.yakindu.sct.model.sexec.extensions.EventBufferExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sexec.concepts.ShadowMemberScope

class EventBuffer {
	
	@Inject extension TypeBuilder
	@Inject extension BufferEventExtensions	
	@Inject extension EventBufferExtensions	
	@Inject extension INamingService
	@Inject extension OriginTracing
	@Inject extension StatechartAnnotations
	@Inject extension ExpressionBuilder
	@Inject extension ShadowMemberScope
	
	def defineEventBuffer(ExecutionFlow flow, Statechart sc){
		
		if (sc.isEventDriven) return 
		
		val bufferType = _complexType() => [ bt |
			flow.scopes.filter[hasBufferedEvents].forEach[ scope | 
				val scopeBufferType = _complexType() => [ scopeType |
					scope.declarations
						.filter(Event)
						.filter[ e | e.direction != Direction::OUT ]
						.forEach[ e | e.createBufferEvent => [
							scopeType.features.add(it)
							it.traceOrigin(e)
						]]
					scopeType._annotate(EventBufferExtensions::EVENT_BUFFER_ANNOTATION)
				]
				
				scopeBufferType.traceOrigin(scope)
				bt.features += _variable(scope.featureName, scopeBufferType)
			]
			
			bt._annotate(EventBufferExtensions::EVENT_BUFFER_ANNOTATION)
			bt.traceOrigin(flow)
		]
		
		flow.features += _variable("_current", bufferType)
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
	
	def eventBuffers(ComplexType it) {
		features
			.filter(Property)
			.filter[ p | p.type instanceof ComplexType && p.type.isEventBuffer]
	}

	def List<List<Declaration>> bufferEvents(Property it) {

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
			.map[ p | p.bufferEvents]
			.forEach[ bel | 
				bel.forEach[ be | be.add(0,it)] 
				l.addAll(bel)
			]

		return l			
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