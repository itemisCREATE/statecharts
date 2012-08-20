/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.model.sexec.interpreter.ITimingService;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

/**
 * Implementation of {@link ITimingService} interface using standard
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TimerTaskTimingService implements ITimingService {

	private Timer timer;

	private Map<String, TimerTask> timerTasks;

	public TimerTaskTimingService() {
		timer = new Timer();
		timerTasks = new HashMap<String, TimerTask>();
	}

	public void scheduleTimeEvent(IExecutionContext context, String eventName,
			boolean isPeriodical, int duration) {
		TimeEventTask timeEventTask = new TimeEventTask(context, eventName);
		timerTasks.put(eventName, timeEventTask);
		if (isPeriodical) {
			timer.scheduleAtFixedRate(timeEventTask, duration, duration);
		} else {
			timer.schedule(timeEventTask, duration);
		}
	}

	public void unscheduleTimeEvent(String eventName) {
		TimerTask timerTask = timerTasks.get(eventName);
		timerTask.cancel();
	}

	public class TimeEventTask extends TimerTask {

		private final IExecutionContext context;
		private final String eventName;

		public TimeEventTask(IExecutionContext context, String eventName) {
			this.context = context;
			this.eventName = eventName;
		}

		public void run() {
			context.raiseEvent(eventName, null);
		}
	}

	public void pause() {
		throw new RuntimeException("Implement me");
	}

	public void resume() {
		throw new RuntimeException("Implement me");
	}

	public void stop() {
		Collection<TimerTask> values = timerTasks.values();
		for (TimerTask timerTask : values) {
			timerTask.cancel();
		}
		timer.cancel();
	}

}
