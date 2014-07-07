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
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

/**
 * Implementation of {@link ITimingService} interface using standard
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultTimingService implements ITimingService {

	private Timer timer;

	private Map<String, TimerTask> timerTasks;

	public DefaultTimingService() {
		timer = new Timer();
		timerTasks = new HashMap<String, TimerTask>();
	}

	public void scheduleTimeEvent(ExecutionContext context, String eventName, boolean isPeriodical, long duration) {
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

		private final ExecutionContext context;
		private final String eventName;

		public TimeEventTask(ExecutionContext context, String eventName) {
			this.context = context;
			this.eventName = eventName;
		}

		public void run() {
			context.getEvent(eventName).setScheduled(true);
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
