/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.container;

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CYCLE_BASED_ANNOTATION;

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.ArgumentedAnnotation;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.simulation.core.sexec.scheduling.ITimeTaskScheduler.TimeTask;
import org.yakindu.sct.simulation.core.sexec.scheduling.ITimeTaskScheduler.TimeTask.Priority;
import org.yakindu.sct.simulation.core.sruntime.SRuntimeFactory;

import com.google.inject.Inject;

/**
 * Cycle based implementation of {@link ISimulationEngine}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CycleBasedSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	public static final long DEFAULT_CYCLE_PERIOD = 200;

	@Inject
	private IStatementInterpreter statementInterpreter;

	public CycleBasedSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		scheduleCycleEvent();
	}

	private void scheduleCycleEvent() {
		Long cyclePeriod = DEFAULT_CYCLE_PERIOD;
		ArgumentedAnnotation cycleBased = (ArgumentedAnnotation) getStatechart()
				.getAnnotationOfType(CYCLE_BASED_ANNOTATION);
		if (cycleBased != null) {
			cyclePeriod = (Long) statementInterpreter.evaluateStatement(cycleBased.getExpressions().get(0),
					SRuntimeFactory.eINSTANCE.createExecutionContext());
		}

		TimeTask cycleTask = new TimeTask("$cycle", () -> interpreter.runCycle(), Priority.LOW);
		timeTaskScheduler.scheduleTimeTask(cycleTask, true, cyclePeriod);
	}
}
