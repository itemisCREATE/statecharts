/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.simulation.core.sexec.scheduling;

import java.util.PriorityQueue;
import java.util.Queue;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class DefaultSchedulingService implements ISchedulingService {

	private long stopTime = 0;
	protected long currentTime = 0;
	protected long scheduleCount = 0;

	@Inject
	private IWaitingStrategy waitingStrategy;

	private Queue<TimeTask> tasks;

	public static class TimeTask implements Runnable, Comparable<TimeTask> {

		long nextExecutionTime = 0;
		long period = -1;
		long scheduleOrder = 0;
		boolean isCanceled = false;

		private final Runnable callBack;

		public TimeTask(Runnable callBack) {
			this.callBack = callBack;
		}

		public void run() {
			callBack.run();
		}

		public int compareTo(TimeTask o) {
			if (nextExecutionTime != o.nextExecutionTime) {
				return (int) (nextExecutionTime - o.nextExecutionTime);
			} else if (o instanceof CycleTimeEventTask && !(this instanceof CycleTimeEventTask)) {
				return -1;
			} else if (!(o instanceof CycleTimeEventTask) && this instanceof CycleTimeEventTask) {
				return 1;
			} else if (period != o.period) {
				return (int) (period - o.period);
			}
			return (int) (scheduleOrder - o.scheduleOrder);
		}

		public boolean isCanceled() {
			return isCanceled;
		}

		public void cancel() {
			isCanceled = true;
		}
	}

	public static class TimeEventTask extends TimeTask {
		private final String eventName;

		public TimeEventTask(final ExecutionContext context, final String eventName) {
			super(() -> context.getEvent(eventName).setRaised(true));
			this.eventName = eventName;
		}

		public String getEventName() {
			return eventName;
		}
	}

	public static class CycleTimeEventTask extends TimeTask {

		public CycleTimeEventTask(Runnable callBack) {
			super(callBack);
		}

	}

	public DefaultSchedulingService() {
		tasks = new PriorityQueue<TimeTask>();
	}

	@Override
	public void timeLeap(long ms) {
		stopTime = currentTime + ms;
		processTasks();
	}

	@Override
	public void timeLeapToNextEvent() {
		TimeTask nextTask = this.tasks.peek();
		if (nextTask != null) {
			long timeToNextEvent = nextTask.nextExecutionTime - currentTime;
			waitingStrategy.waitfor(timeToNextEvent);
			timeLeap(timeToNextEvent);
		}
	}

	public synchronized void scheduleTimeEvent(ExecutionContext context, String eventName, boolean isPeriodical,
			long duration) {
		// This is called with zero for nano and micro seconds
		if (duration <= 0)
			duration = 1;
		TimeEventTask timeEventTask = new TimeEventTask(context, eventName);
		if (isPeriodical) {
			schedulePeriodicalTask(timeEventTask, duration, duration);
		} else {
			scheduleTask(timeEventTask, duration);
		}
	}

	protected void scheduleTask(TimeTask task, long interval) {
		scheduleInternal(task, currentTime + interval, -1);
	}

	protected void schedulePeriodicalTask(TimeTask task, long interval, long period) {
		scheduleInternal(task, currentTime + interval, period);
	}

	protected void scheduleInternal(TimeTask task, long time, long period) {
		task.nextExecutionTime = time;
		task.period = period;
		task.scheduleOrder = scheduleCount;
		scheduleCount++;
		tasks.add(task);
	}

	@Override
	public void unscheduleTimeEvent(String eventName) {
		TimeTask timerTask = getTask(eventName);
		if (timerTask != null)
			timerTask.cancel();
	}

	@Override
	public void scheduleCycleEvent(Runnable runnable, long period) {
		scheduleInternal(new CycleTimeEventTask(runnable), period, period);
	}

	protected TimeTask getTask(String eventName) {
		for (TimeTask virtualTimeTask : tasks) {
			if (!(virtualTimeTask instanceof TimeEventTask))
				continue;
			if (((TimeEventTask) virtualTimeTask).getEventName().equals(eventName))
				return virtualTimeTask;
		}
		return null;
	}

	protected void processTasks() {
		boolean processTasks = !tasks.isEmpty();
		while (processTasks) {
			TimeTask task = tasks.peek();
			if (task == null)
				break;
			if (task.isCanceled) {
				tasks.remove();
				continue;
			}
			long executionTime = task.nextExecutionTime;
			if (executionTime <= stopTime) {
				currentTime = task.nextExecutionTime;
				task = tasks.poll();
				task.run();
				if (task.period > -1) {
					schedulePeriodicalTask(task, task.period, task.period);
				}
			} else {
				currentTime = stopTime;
				processTasks = false;
			}
		}
	}

	public synchronized void stop() {
		for (TimeTask timerTask : tasks) {
			timerTask.cancel();
		}
		cancel();
	}

	public synchronized void cancel() {
		synchronized (tasks) {
			currentTime = 0;
			stopTime = 0;
			tasks.clear();
		}
	}
}
