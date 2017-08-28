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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

/**
 * Event Driven implementation of the {@link ISimulationEngine}.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EventDrivenSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	private EventDrivenCycleAdapter cycleAdapter;

	public EventDrivenSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		cycleAdapter = new EventDrivenCycleAdapter(interpreter);
		context.eAdapters().add(cycleAdapter);
	}

	@Override
	public void terminate() {
		context.eAdapters().remove(cycleAdapter);
		super.terminate();
	}

	@Override
	public void suspend() {
		cycleAdapter.suspend();
		super.suspend();
	}

	@Override
	public void resume() {
		cycleAdapter.resume();
		super.resume();
	}

	@Override
	public void stepForward() {
		interpreter.runCycle();
		super.stepForward();
	}

	@Override
	protected boolean useInternalEventQueue() {
		return true;
	}

	public static class EventDrivenCycleAdapter extends EContentAdapter {

		private IExecutionFlowInterpreter interpreter;

		private boolean suspended = false;
		private boolean cycleAfterResume = false;

		public EventDrivenCycleAdapter(IExecutionFlowInterpreter interpreter) {
			this.interpreter = interpreter;

		}

		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED) {
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					if (notification.getNewBooleanValue()) {
						if (!suspended)
							interpreter.runCycle();
						else {
							cycleAfterResume = true;
						}
					}
				}
			}

		}

		public boolean isAdapterForType(Object type) {
			return type == EventDrivenCycleAdapter.class;
		}

		public void suspend() {
			suspended = true;
		}

		public void resume() {
			suspended = false;
			if (cycleAfterResume)
				interpreter.runCycle();
			cycleAfterResume = false;
		}
	}
}
