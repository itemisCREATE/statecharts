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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sexec.scheduling.ITimeTaskScheduler;
import org.yakindu.sct.simulation.core.sexec.scheduling.ITimeTaskScheduler.TimeTask;
import org.yakindu.sct.simulation.core.sexec.scheduling.ITimeTaskScheduler.TimeTask.Priority;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

/**
 * Event Driven implementation of the {@link ISimulationEngine}.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EventDrivenSimulationEngine extends AbstractExecutionFlowSimulationEngine {

	public EventDrivenSimulationEngine(Statechart statechart) {
		super(statechart);
	}

	@Override
	public void init() {
		super.init();
		context.eAdapters().add(new EventDrivenCycleAdapter(timeTaskScheduler, interpreter));
	}

	@Override
	public void terminate() {
		Adapter adapter = EcoreUtil.getExistingAdapter(context, EventDrivenCycleAdapter.class);
		if (adapter != null)
			context.eAdapters().remove(adapter);
		super.terminate();
	}

	@Override
	protected boolean useInternalEventQueue() {
		return true;
	}

	public static class EventDrivenCycleAdapter extends EContentAdapter {

		private ITimeTaskScheduler scheduler;
		private IExecutionFlowInterpreter interpreter;

		public EventDrivenCycleAdapter(ITimeTaskScheduler taskScheduler, IExecutionFlowInterpreter interpreter) {
			this.scheduler = taskScheduler;
			this.interpreter = interpreter;

		}

		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__SCHEDULED) {
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					final ExecutionEvent event = (ExecutionEvent) notification.getNotifier();
					if (notification.getNewBooleanValue()) {
						TimeTask eventTask = new TimeTask(event.getFqName(), () -> event.setRaised(true),
								Priority.NORMAL);
						scheduler.scheduleTimeTask(eventTask, false, 0);
					} else {
						scheduler.unscheduleTimeTask(event.getFqName());
					}
				}
			}

			if (notification.getNotifier() instanceof ExecutionEvent
					&& notification.getFeature() == SRuntimePackage.Literals.EXECUTION_EVENT__RAISED) {
				if (notification.getNewBooleanValue() != notification.getOldBooleanValue()) {
					interpreter.runCycle();
				}
			}

		}

		public boolean isAdapterForType(Object type) {
			return type == EventDrivenCycleAdapter.class;
		}
	}
}
