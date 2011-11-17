/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.runtime.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.runtime.java.EventNotification;

public class TimerHandler implements ITimerHandler {

	private final ITimedStatemachine statemachine;

	private final Timer timer = new Timer();

	private final Map<TimeEvent, TimerTask> timerTaskMap = new HashMap<TimeEvent, TimerTask>();;

	public TimerHandler(ITimedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	@Override
	public void setTimer(final TimeEvent event, long time, long cycleStartTime) {
		// Reset existing TimerTask for event. This step isn't necessary if
		// timer tasks are properly reset by sexec model.
		if (timerTaskMap.containsKey(event)) {
			resetTimer(event);
		}

		// Create a new TimerTask for given event.
		timerTaskMap.put(event, new TimerTask() {
			@Override
			public void run() {
				statemachine.notify(new EventNotification(event));
			}
		});
		
		//set time field of event
		event.setTime(time);
		
		// start scheduling the timer
		if (event.getValue()) {
			timer.scheduleAtFixedRate(timerTaskMap.get(event),
					time - (System.currentTimeMillis() - cycleStartTime), time);
		} else {
			timer.schedule(timerTaskMap.get(event),
					time - (System.currentTimeMillis() - cycleStartTime));
		}
	}

	@Override
	public void resetTimer(TimeEvent event) {
		if (timerTaskMap.containsKey(event) && timerTaskMap.get(event) != null) {
			timerTaskMap.get(event).cancel();
			timer.purge();
		}
		timerTaskMap.remove(event);
	}
	
	/**
	 * Cancels all running TimersTasks
	 */
	public void cancel() {
		timer.cancel();
	}
}
