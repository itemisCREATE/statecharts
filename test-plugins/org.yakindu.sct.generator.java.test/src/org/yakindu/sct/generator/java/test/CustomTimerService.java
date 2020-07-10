package org.yakindu.sct.generator.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.yakindu.sct.ITimer;
import org.yakindu.sct.ITimerCallback;

/**
 * Default timer service implementation.
 * 
 */
public class CustomTimerService implements ITimer {

	private final Timer timer = new Timer();

	private final List<TimeEventTask> timerTaskList = new ArrayList<TimeEventTask>();

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

		public void run() {
			timerCallbacks.add(new Integer(eventID));
			callback.timeElapsed(eventID);
		}

		public boolean equals(Object obj) {
			if (obj instanceof TimeEventTask) {
				return ((TimeEventTask) obj).callback.equals(callback) && ((TimeEventTask) obj).eventID == eventID;
			}
			return super.equals(obj);
		}
	}

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
