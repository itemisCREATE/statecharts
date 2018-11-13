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

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @authos axel terfloth - additions
 * 
 */
class StextExpressionInterpreter extends DefaultExpressionInterpreter {

	@Inject
	extension IQualifiedNameProvider provider
	@Inject(optional=true)
	protected extension IEventRaiser eventRaiser
	@Inject protected extension ExecutionContextExtensions

	def dispatch Object execute(EventRaisingExpression eventRaising) {
		var event = context.resolve(eventRaising.event)
		if (event instanceof ExecutionEvent) {
			val value = eventRaising.value?.execute
			if(eventRaiser !== null) event.raise(value)
		}
		null
	}

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			val executionSlot = context.resolve(expression.value)
			if (executionSlot instanceof ExecutionEvent && executionSlot.fqName == event.fqName) {
				return event.getValue;
			};
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
