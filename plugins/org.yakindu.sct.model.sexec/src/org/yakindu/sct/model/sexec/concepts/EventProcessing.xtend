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
import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.config.IFlowConfiguration
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression

/**
 * This class defines the concept of event processing. It defines how events are processed for
 * cycle based and event driven execution. 
 * 
 * @author aterfloth
 */
class EventProcessing {


	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	
	@Inject extension SExecExtensions
	@Inject extension StateMachineBehaviorConcept
	@Inject protected extension EventBuffer
	@Inject protected extension BufferEvent
	
	@Inject protected extension IFlowConfiguration config
	
	

	public static val CLEAR_EVENT = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "clearEvent"
	public static val MOVE_EVENT = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "moveEvent"
	public static val NEXT_EVENT = StateMachineBehaviorConcept.CONCEPT_NAME_PREFIX + "nextEvent"
	public static val CLEAR_OUT_EVENTS = "clearOutEvents"
	public static val CLEAR_IN_EVENTS = "clearInEvents"
	public static val CLEAR_INTERNAL_EVENTS = "clearInternalEvents"
	public static val SWAP_IN_EVENTS = "swapInEvents"
	public static val SWAP_INTERNAL_EVENTS = "swapInternalEvents"


	def defineFeatures (ExecutionFlow it) {
		if (hasOutgoingEvents && applyOutgoingEventBuffer) defineClearOutEvents
		if (hasIncomingEvents) {
			if (applyIncomingEventBuffer) defineSwapInEvents
			defineClearInEvents
		}
		if (hasLocalEvents) {
			if (applyInternalEventBuffer) defineSwapInternalEvents
			defineClearInternalEvents
		}
	}


	def defineClearOutEvents(ExecutionFlow it) {
		it._method(CLEAR_OUT_EVENTS) => [ m | 
			m._type(_void)
			m._body(
				outgoingEvents.map[ o |
					o._clear
				]
			)
		]
	}
	
	def defineClearInEvents(ExecutionFlow it) {
		it._method(CLEAR_IN_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				#[flow.incomingEvents, flow.timeEvents].flatten.map[ i |
					i._clear
				]
			)
		]
	}
	
	def defineClearInternalEvents(ExecutionFlow it) {
		it._method(CLEAR_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				localEvents.map[ i |
					i._clear
				]
			)
		]
	}


	def defineSwapInEvents(ExecutionFlow it) {
		it._method(SWAP_IN_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				it.bufferEventExpressions.incoming
					.map[ e |
						e.event.originEvent._move(e)
					]
			)
		]
	}
	


	def defineSwapInternalEvents(ExecutionFlow it) {
		it._method(SWAP_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				_sequence(
					it.bufferEventExpressions.incoming
					.map[ e | 
						e._clear()
					]						
				) => [ comment = "When processing internal events all incoming events are processed and must be cleared from current buffer."],
				_sequence(
					it.bufferEventExpressions.internal
					.map[ e | 
						e.event.originEvent._move(e)
					]	
				) => [ comment = "Swap all internal events."]
			)
		]
	}
	
	def Step _eventProcessing(ExecutionFlow it, Step body) {
		
		if (isCycleBased) 
			_sequence(
				_clearOutEvents,
				_swapIncomingEvents,
				_eventLoop(body),
				_clearInEvents._when(!applyIncomingEventBuffer),
				_clearInternalEvents._when(!applyInternalEventBuffer)	
			)
		else 
			_sequence(
				_clearOutEvents,
				_processEventQueues(body)
			)
			
	}


	def Step _eventLoop(ExecutionFlow it, Step body) {
		if (hasLocalEvents && applyInternalEventBuffer) 
			_do(_sequence(
				body,
				_swapInternalEvents
			))._while(
				bufferEventExpressions.internal.reduce[r1, r2| r1._or(r2)]
			)
		else 
			body	
	}

	def Step _processEventQueues(ExecutionFlow it, Step body) {
		if (hasLocalEvents || applyIncomingEventQueue) {
		
			_sequence(
				_conceptSequence(NEXT_EVENT),
				_do(_sequence(
					body,
					_clearInEvents,
					_clearInternalEvents,
					_conceptSequence(NEXT_EVENT)
				))._while( #[incomingEvents,localEvents]
							.flatten
							.map[ ev | ev._ref as Expression ]
							.reduce[ e1, e2 | e1._or(e2) ]
				) 
			)			
		}
		else 
			_sequence(
				body,
				_clearInEvents,
				_clearInternalEvents	
			)
	}

	def Step _clearOutEvents(ExecutionFlow it) {
		if ( clearOutEvents !== null ) clearOutEvents._call._statement 
		else _empty	
	}


	def Step _clearInEvents(ExecutionFlow it) {
		if ( clearInEvents !== null) clearInEvents._call._statement 
		else _empty	
	}

	def Step _clearInternalEvents(ExecutionFlow it) {
		if ( clearInternalEvents !== null) clearInternalEvents._call._statement 
		else _empty	
	}

	def Step _swapIncomingEvents(ExecutionFlow it) {
		if (swapIncomingEvents !== null)
			swapIncomingEvents._call._statement
		else _empty
	}

	def Step _swapInternalEvents(ExecutionFlow it) {
		if (swapInternalEvents !== null)
			swapInternalEvents._call._statement
		else _empty
	}


	def Step _clear(EObject it){
		_conceptSequence(CLEAR_EVENT, it)	
	}
	
	def Step _move(EObject source, EObject target){
		_conceptSequence(MOVE_EVENT, source, target)	
	}
	
	
	def transformEventAccess(ExecutionFlow flow) {
	
		if ( ! flow.hasEventBuffer ) return 
		
		val bufferedEvents = #[flow.incomingEvents, flow.timeEvents, flow.localEvents].flatten.toSet

		val allEventReferences = flow.eAllContents
										.filter(Expression)
										.filter[ e | 
											bufferedEvents.contains(e.referenceOrFeature)
											&& !(e.eContainer instanceof FeatureCall)
											&& !(e.eContainer instanceof EventRaisingExpression)
										]
										
		val HashMap<EObject, Expression> allEventAccessExpression = newHashMap
		flow.bufferEventExpressions.forEach[ e | if (e.referenceOrFeature !== null) allEventAccessExpression.put(e.referenceOrFeature, e)]
													
		allEventReferences.forEach[ expression | 
			val event = expression.referenceOrFeature as Event
			val bufferEvent = event.createBufferEvent
			val bufferEventExpression = EcoreUtil.copy(allEventAccessExpression.get(bufferEvent))
			
			if ( expression.eContainer instanceof EventValueReferenceExpression ) {
				expression.eContainer.eContainer.substitute(expression.eContainer, bufferEventExpression._meta(bufferEvent.valueFeature))
			} else {
				expression.eContainer.substitute(expression, bufferEventExpression)			
			}
		]
				
	}
	
	/* Substitutes the EObject oldValue which is contained in EObject parent by EObject newValue.
	 * If oldValue is not contained in parent then nothing happens. 
	 */
	protected def substitute(EObject parent, EObject oldValue, EObject newValue) {
		if (parent !== null ) {
			val ref = parent.eClass.getEAllStructuralFeatures
				.filter(EReference)
				.filter[ f | 
					f.isChangeable 
					&& !f.isDerived 
					&& f.isContainment
					&& parent.eIsSet(f)
				]
				.findFirst[ f | 
					if (f.isMany) {
						(parent.eGet(f) as List<EObject>).contains(oldValue)
					} else {
						parent.eGet(f) === oldValue
					}
				]
			
			EcoreUtil.replace(parent, ref, oldValue, newValue);
		}	
	}
		
	
	protected def dispatch EObject referenceOrFeature(Expression e) { return null }
	protected def dispatch EObject referenceOrFeature(ElementReferenceExpression e) { return e.reference }
	protected def dispatch EObject referenceOrFeature(FeatureCall e) { return e.feature }
	
	
	
	def dispatch Event event(Sequence it){
		it.getParameter as Event
	}
	
	def protected List<Expression> bufferEventExpressions(ExecutionFlow it) {
		it
			.eventBuffer
			.bufferEvents
			.asExpressions		
	}
	
	def protected internal(List<Expression> it) {
		filter[ e | 
			val o = e.event.originEvent;
			o instanceof EventDefinition && o.direction == Direction.LOCAL
		]
	}
	
	def protected incoming(List<Expression> it) {
		filter[ e | 
			val o = e.event.originEvent;
			(o instanceof EventDefinition && o.direction == Direction.IN) || (o instanceof TimeEvent) 
		]
	}
	
	def dispatch Event event(ElementReferenceExpression it){
		it.reference as Event
	}
	
	def Property valueFeature(Event it) {
		it.metaFeatures.filter(Property).filter[ p | p.name == "value"].head
	} 
	
	def dispatch Event event(FeatureCall it){
		it.feature as Event
	}
	

	def Method clearOutEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_OUT_EVENTS).head
	}
	
	def Method clearInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_IN_EVENTS).head
	}
	
	def Method clearInternalEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == CLEAR_INTERNAL_EVENTS).head
	}
	
	def Method swapInternalEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == SWAP_INTERNAL_EVENTS).head
	}

	def Method swapIncomingEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == SWAP_IN_EVENTS).head
	}
	

	def hasIncomingEvents(ExecutionFlow it) {
		hasInEvents || timeEvents.size > 0 	
	}
	
}