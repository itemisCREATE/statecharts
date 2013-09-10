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

import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

/**
 * Cycle based implementation of {@link ISimulationEngine}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CycleBasedSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	private Timer timer;

	private long cyclePeriod;

	public CycleBasedSimulationEngine(Statechart statechart, long cyclePeriod) {
		super(statechart);
		this.cyclePeriod = cyclePeriod;
		timer = new Timer();
	}

	protected void scheduleCycle() {
		if (!terminated && !suspended) {
			TimerTask virtualTimerTask = new TimerTask() {
				public void run() {
					runCycle();
					scheduleCycle();
				}
			};
			timer.schedule(virtualTimerTask, cyclePeriod);
		}
	}

	public void start() {
		super.start();
		scheduleCycle();
	}

	public void resume() {
		super.resume();
		scheduleCycle();
	}

	public void terminate() {
		super.terminate();
		timer.cancel();
	}

}
