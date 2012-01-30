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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeController;

/**
 * Event Driven implementation of the {@link IExecutionFacadeController}.
 * 
 * RunCycle is invoked on the {@link IExecutionFacade} each time a event is
 * raised.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EventDrivenExecutionFacadeController extends
		AbstractExecutionFacadeController implements IExecutionContextListener {

	private Thread cycleRunner;

	private BlockingQueue<ExecutionEvent> events;

	public EventDrivenExecutionFacadeController(IExecutionFacade facade) {
		super(facade);
		facade.getExecutionContext().addExecutionContextListener(this);
		events = new LinkedBlockingQueue<ExecutionEvent>();
	}

	public void start() {
		super.start();
		cycleRunner = new Thread(new CycleRunner());
		cycleRunner.start();
	}

	public void suspend() {
		super.suspend();
	}

	public void resume() {
		super.resume();
		cycleRunner = new Thread(new CycleRunner());
		cycleRunner.start();
	}

	public void terminate() {
		super.terminate();
	}

	public void eventRaised(ExecutionEvent event) {
		events.add(event);
	}

	public void variableValueChanged(ExecutionVariable variable) {
		// Nothing to do
	}

	private final class CycleRunner implements Runnable {
		public void run() {
			try {
				while (!terminated && !suspended) {
					events.take();
					if (facade.getExecutionContext().getRaisedEvents().size() > 0) {
						facade.runCycle();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void timeScaleFactorChanged(double oldFactor, double newFactor) {

	}
}
