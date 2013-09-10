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
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

/**
 * Event Driven implementation of the {@link ISimulationEngine}.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EventDrivenSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	private Thread cycleRunner;

	public EventDrivenSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	public void start() {
		super.start();
		cycleRunner = new Thread(new CycleRunner());
		cycleRunner.start();
	}

	public void resume() {
		super.resume();
		cycleRunner = new Thread(new CycleRunner());
		cycleRunner.start();
	}

	public void terminate() {
		super.terminate();
	}

	private final class CycleRunner implements Runnable {
		public void run() {
			while (!terminated && !suspended) {
				if (context.getRaisedEvents().size() > 0 || context.getScheduledEvents().size() > 0) {
					runCycle();
				}
			}
		}
	}
}
