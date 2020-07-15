/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.lib;

import org.yakindu.base.expressions.interpreter.IExpressionInterpreter;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.Expression;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.SRuntimeFactory;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartAnnotations {

	public static final String CYCLE_BASED_ANNOTATION = "CycleBased";
	public static final String EVENT_DRIVEN_ANNOTATION = "EventDriven";
	public static final String PARENT_FIRST_ANNOTATION = "ParentFirstExecution";
	public static final String CHILD_FIRST_ANNOTATION = "ChildFirstExecution";
	public static final String SUPERSTEP_ANNOTATION = "SuperSteps";
	public static final String EVENTBUFFERING_ANNOTATION = "EventBuffering";

	@Inject(optional = true)
	private IExpressionInterpreter interpreter;

	public boolean isCycleBased(Statechart statechart) {
		return statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION) != null;
	}

	public long getCyclePeriod(Statechart statechart) {
		Annotation annotation = statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION);
		long cyclePeriod = 200;
		if (annotation != null) {
			cyclePeriod = (Long) interpreter.evaluate(annotation.getExpressions().get(0),
					SRuntimeFactory.eINSTANCE.createExecutionContext());
		}
		return cyclePeriod;
	}

	public boolean isEventDriven(Statechart statechart) {
		return statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION) == null;
	}

	public boolean isParentFirstExecution(Statechart statechart) {
		return statechart.getAnnotationOfType(PARENT_FIRST_ANNOTATION) != null;
	}

	public boolean isChildFirstExecution(Statechart statechart) {
		return statechart.getAnnotationOfType(PARENT_FIRST_ANNOTATION) == null;
	}
	
	public boolean isInternalEventBuffer(Statechart statechart) {
		Annotation eventBuffering = statechart.getAnnotationOfType(EVENTBUFFERING_ANNOTATION);
		if(eventBuffering == null)
			return true; //Enabled by default
		return (Boolean) interpreter.evaluate(eventBuffering.getExpressions().get(1), SRuntimeFactory.eINSTANCE.createExecutionContext());
	}
	
	public boolean isInEventBuffer(Statechart statechart) {
		Annotation eventBuffering = statechart.getAnnotationOfType(EVENTBUFFERING_ANNOTATION);
		if(eventBuffering == null)
			return true; //Enabled by default
		return (Boolean) interpreter.evaluate(eventBuffering.getExpressions().get(0), SRuntimeFactory.eINSTANCE.createExecutionContext());
	}

	public boolean isSuperStep(Statechart statechart) {
		Annotation superStep = statechart.getAnnotationOfType(SUPERSTEP_ANNOTATION);
		if (superStep == null)
			return false; // Disabled by default
		Expression expression = superStep.getExpressions().get(0);
		return (Boolean) interpreter.evaluate(expression, SRuntimeFactory.eINSTANCE.createExecutionContext());

	}
}
