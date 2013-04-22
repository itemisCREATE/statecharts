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
package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeController;

/**
 * Cycle based implementation of {@link IExecutionFacadeController}.
 * 
 * runCycle is called on {@link IExecutionFacade} periodically, depending on the
 * cyclePeriod value.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CycleBasedExecutionFacadeController extends
		AbstractExecutionFacadeController {

	private Timer timer;

	private long cyclePeriod;

	public CycleBasedExecutionFacadeController(SCTDebugTarget target,
			long cyclePeriod) {
		super(target);
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
