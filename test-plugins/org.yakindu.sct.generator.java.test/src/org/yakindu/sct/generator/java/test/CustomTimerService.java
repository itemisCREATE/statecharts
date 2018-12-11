/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.generator.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.yakindu.scr.ITimer;
import org.yakindu.scr.ITimerCallback;

/**
 * Default timer service implementation.
 *
 */
public class CustomTimerService implements ITimer {
	
	private final Timer timer = new Timer();
	
	private final List<TimeEventTask> timerTaskList = new ArrayList<>();
	
	private final Lock lock = new ReentrantLock();
	
	public List<Integer> timerCallbacks = new ArrayList<>();
	
	/**
	 * Timer task that reflects a time event. It's internally used by
	 * {@link CustomTimerService}.
	 *
	 */
	private class TimeEventTask extends TimerTask {
		
		private ITimerCallback callback;
		
		int eventID;
		
		/**
		 * Constructor for a time event.
		 *
		 * @param callback
		 *            : Set to {@code true} if event should be repeated
		 *            periodically.
		 *
		 * @param eventID
		 *            : Index position within the state machine's timeEvent
		 *            array.
		 */
		public TimeEventTask(ITimerCallback callback, int eventID) {
			this.callback = callback;
			this.eventID = eventID;
		}
		
		@Override
		public void run() {
			timerCallbacks.add(new Integer(eventID));
			callback.timeElapsed(eventID);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TimeEventTask) {
				return ((TimeEventTask) obj).callback.equals(callback) && ((TimeEventTask) obj).eventID == eventID;
			}
			return super.equals(obj);
		}
	}
	
	@Override
	public void setTimer(final ITimerCallback callback, final int eventID, long time, boolean isPeriodic) {
		
		// Create a new TimerTask for given event and store it.
		TimeEventTask timerTask = new TimeEventTask(callback, eventID);
		lock.lock();
		timerTaskList.add(timerTask);
		
		// start scheduling the timer
		if (isPeriodic) {
			timer.scheduleAtFixedRate(timerTask, time, time);
		} else {
			timer.schedule(timerTask, time);
		}
		lock.unlock();
	}
	
	@Override
	public void unsetTimer(ITimerCallback callback, int eventID) {
		lock.lock();
		int index = timerTaskList.indexOf(new TimeEventTask(callback, eventID));
		if (index != -1) {
			timerTaskList.get(index).cancel();
			timer.purge();
			timerTaskList.remove(index);
		}
		lock.unlock();
	}
	
	public int getTimerCallbackCount(int eventID) {
		int i = 0;
		for (Integer event : timerCallbacks) {
			if (event.intValue() == eventID)
				i++;
		}
		return i;
	}
	
	/**
	 * Cancel timer service. Use this to end possible timing threads and free
	 * memory resources.
	 */
	public void cancel() {
		lock.lock();
		timer.cancel();
		timer.purge();
		lock.unlock();
	}
}
