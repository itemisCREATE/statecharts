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

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.lib.StatechartAnnotations;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask.Priority;

import com.google.inject.Inject;

/**
 * Cycle based implementation of {@link ISimulationEngine}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CycleBasedSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	@Inject StatechartAnnotations annotations;

	public CycleBasedSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		scheduleCycleEvent();
	}

	private void scheduleCycleEvent() {
		Long cyclePeriod = annotations.getCyclePeriod(getStatechart());
		TimeTask cycleTask = new TimeTask("$cycle", () -> {
			try {
				interpreter.runCycle();
			} catch (Exception e) {
				handleException(e);
			}
		}, Priority.LOW);
		timeTaskScheduler.scheduleTimeTask(cycleTask, true, cyclePeriod);
	}
}
