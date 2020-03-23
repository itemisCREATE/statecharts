/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.interpreter.DefaultExpressionInterpreter
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions
import org.yakindu.base.expressions.interpreter.SlotResolutionExceptionSupplier
import org.yakindu.base.expressions.expressions.ArgumentExpression

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @author axel terfloth - additions
 * 
 */
class StextExpressionInterpreter extends DefaultExpressionInterpreter {

	@Inject
	extension IQualifiedNameProvider provider
	
	@Inject(optional=true)
	protected extension IEventRaiser defaultEventRaiser
	
	@Inject protected extension ExecutionContextExtensions
	
	@Inject protected extension SubchartInterpreterProvider subchartInterpreterProvider

	def dispatch Object execute(EventRaisingExpression eventRaising) {
		val event = context.resolve(eventRaising.event)
			.orElseThrow(SlotResolutionExceptionSupplier.forContext(eventRaising.event))
		if (event instanceof ExecutionEvent) {
			val value = eventRaising.value?.execute
			val eventRaiser = eventRaising.event.eventRaiser
			if (eventRaiser !== null) eventRaiser.raise(event, value)
		}
		null
	}
	
	def dispatch protected getEventRaiser(Expression exp) {
		return defaultEventRaiser
	}
	
	def dispatch protected getEventRaiser(ArgumentExpression exp) {
		val subInterpreter = subchartInterpreterProvider.findInterpreter(exp, context)
		if (subInterpreter.isPresent && subInterpreter.get instanceof IEventRaiser) {
			return subInterpreter.get as IEventRaiser
		}
		return defaultEventRaiser
	}

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			val slot = context.resolve(expression.value)
				.orElseThrow(SlotResolutionExceptionSupplier.forContext(expression.value))
			if (slot instanceof ExecutionEvent && slot.fqName == event.fqName) {
				return event.getValue;
			}
		}
		throw new UndefinedValueException("Undefined value of event '" + expression.value.eventName + "'\n" +
			"Event values only exist in the same cycle in which the event was raised.")
	}

	def dispatch Object execute(ActiveStateReferenceExpression expression) {
		var state = expression.value
		return context.allActiveStates.contains(state)
	}

	def dispatch protected getEventName(Expression it) {
		return "null"
	}

	def dispatch protected getEventName(ElementReferenceExpression it) {
		if (reference instanceof Event) {
			return (reference as Event).name
		}
		return "null"
	}

	def dispatch protected getEventName(FeatureCall it) {
		if (feature instanceof Event) {
			return (feature as Event).name
		}
		return "null"
	}

	def dispatch qname(FeatureCall e) {
		return e.feature.getFullyQualifiedName.toString
	}

	def dispatch qname(ElementReferenceExpression e) {
		e.reference.getFullyQualifiedName.toString
	}

	def String fqn(EObject obj) {
		obj.getFullyQualifiedName.toString
	}

	protected static class UndefinedValueException extends IllegalStateException {

		new(String message) {
			super(message)
		}

	}

}
