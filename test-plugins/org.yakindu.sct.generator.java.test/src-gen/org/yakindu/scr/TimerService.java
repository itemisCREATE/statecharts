package org.yakindu.scr;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Default timer service implementation.
 * 
 */
public class TimerService implements ITimerService {

	private final Timer timer = new Timer();

	private final Map<TimeEvent, TimerTask> timerTaskMap = new HashMap<TimeEvent, TimerTask>();

	public void setTimer(final TimeEvent event, long time,
			long cycleStartTime) {
		// Reset existing TimerTask for event. This step isn't necessary if
		// timer tasks are properly reset by sexec model.
		if (timerTaskMap.containsKey(event)) {
			resetTimer(event);
		}

		// Create a new TimerTask for given event.
		timerTaskMap.put(event, new TimerTask() {
			@Override
			public void run() {
				event.getStatemachine().onTimeEventRaised(event);
			}
		});

		// start scheduling the timer
		if (event.isPeriodic()) {
			timer.scheduleAtFixedRate(timerTaskMap.get(event),
					time - (System.currentTimeMillis() - cycleStartTime), time);
		} else {
			timer.schedule(timerTaskMap.get(event),
					time - (System.currentTimeMillis() - cycleStartTime));
		}
	}

	public void resetTimer(TimeEvent event) {
		if (timerTaskMap.containsKey(event) && timerTaskMap.get(event) != null) {
			timerTaskMap.get(event).cancel();
			timer.purge();
		}
		timerTaskMap.remove(event);
	}

	public void cancel() {
		timer.cancel();
		timer.purge();
	}

	public long getSystemTimeMillis() {
		return System.currentTimeMillis();
	}
}
