package org.yakindu.sct.model.sexec.transformation.ng

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
import org.yakindu.sct.model.sexec.extensions.BufferEventExtensions
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.sexec.transformation.config.IFlowConfiguration

class EventProcessing {


	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder
	
	@Inject extension SExecExtensions
	@Inject extension StateMachineConcept
	@Inject protected extension EventBuffer
	@Inject protected extension BufferEventExtensions
	
	@Inject protected extension IFlowConfiguration config
	
	

	public static val CLEAR_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "clearEvent"
	public static val MOVE_EVENT = StateMachineConcept.CONCEPT_NAME_PREFIX + "moveEvent"
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
			else defineClearInternalEvents
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
		it._method(org.yakindu.sct.model.sexec.transformation.ng.EventProcessing.SWAP_IN_EVENTS) => [ m | 
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
		it._method(org.yakindu.sct.model.sexec.transformation.ng.EventProcessing.SWAP_INTERNAL_EVENTS) => [ m | 
			m._type(_void)
			
			m._body(
				it.bufferEventExpressions.internal
					.map[ e | 
						e.event.originEvent._move(e)
					]
			)
		]
	}
	
	def Step _eventProcessing(ExecutionFlow it, Step body) {
		_sequence(
			_takeInEvents,
			_clearOutEvents,
			_eventLoop(body),
			_clearInEvents	
		)
	}


	def Step _eventLoop(ExecutionFlow it, Step body) {
		if (hasLocalEvents) 
			_do(_sequence(
				body,
				_takeInternalEvents
			))._while(
				bufferEventExpressions.internal.reduce[r1, r2| r1._or(r2)]
			)
		else 
			body	
	}

	def Step _clearOutEvents(ExecutionFlow it) {
		if ( clearOutEvents !== null ) clearOutEvents._call._statement 
		else _empty	
	}


	def Step _clearInEvents(ExecutionFlow it) {
		if ( clearInEvents !== null) clearInEvents._call._statement 
		else _empty	
	}

	def Step _takeInEvents(ExecutionFlow it) {
		if (takeInEvents !== null)
			takeInEvents._call._statement
		else _empty
	}

	def Step _takeInternalEvents(ExecutionFlow it) {
		if (takeInternalEvents !== null)
			takeInternalEvents._call._statement
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
			
			expression.eContainer.substitute(expression, bufferEventExpression)
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
			
			if ( ref !== null ) {
				if (ref.isMany) {
					val list = parent.eGet(ref) as List<EObject>
					list.set(list.indexOf(oldValue), newValue)
				}
				else parent.eSet(ref, newValue)				
			}			
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
	
	def Method takeInternalEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == org.yakindu.sct.model.sexec.transformation.ng.EventProcessing.SWAP_INTERNAL_EVENTS).head
	}

	def Method takeInEvents(ExecutionFlow it) {
		features.filter( typeof(Method) ).filter( m | m.name == org.yakindu.sct.model.sexec.transformation.ng.EventProcessing.SWAP_IN_EVENTS).head
	}
	

	def hasIncomingEvents(ExecutionFlow it) {
		hasInEvents || timeEvents.size > 0 	
	}
	
}