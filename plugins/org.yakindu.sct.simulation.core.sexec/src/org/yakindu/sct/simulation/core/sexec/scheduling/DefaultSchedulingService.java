/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.common.base.Stopwatch;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class VirtualTimingService implements ISchedulingService {

	private long stopTime = 0;
	protected long currentTime = 0;
	protected long scheduleCount = 0;

	@ImplementedBy(RealTime.class)
	public static interface IWaitingStrategy {

		public void waitfor(long ms);

	}

	public static class Instantly implements IWaitingStrategy {

		@Override
		public void waitfor(long ms) {
		}
	}

	public static class RealTime implements IWaitingStrategy {
		@Override
		public void waitfor(long ms) {
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Inject
	private IWaitingStrategy waitingStrategy;

	private Queue<VirtualTimeTask> tasks;

	public abstract static class VirtualTimeTask implements Runnable, Comparable<VirtualTimeTask> {

		long nextExecutionTime = 0;
		long interval = 0;
		long period = -1;
		long scheduleOrder = 0;
		boolean isCanceled = false;

		public int compareTo(VirtualTimeTask o) {
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

	public static class VirtualTimeEventTask extends VirtualTimeTask {

		private final ExecutionContext context;
		private final String eventName;

		public VirtualTimeEventTask(ExecutionContext context, String eventName) {
			this.context = context;
			this.eventName = eventName;
		}

		public String getEventName() {
			return eventName;
		}

		public void run() {
			context.getEvent(eventName).setRaised(true);
		}

	}

	public static class CycleTimeEventTask extends VirtualTimeTask {

		private final Runnable callBack;

		public CycleTimeEventTask(Runnable interpreter) {
			this.callBack = interpreter;
		}

		public void run() {
			callBack.run();
		}
	}

	public VirtualTimingService() {
		tasks = new PriorityQueue<VirtualTimeTask>();
	}

	long timeLeapDelta = 0;

	@Override
	public void timeLeap(long ms) {
		Stopwatch watch = Stopwatch.createStarted();
		stopTime = currentTime + ms;
		processTasks();
		timeLeapDelta += watch.elapsed(TimeUnit.MILLISECONDS);
	}

	@Override
	public void timeLeapToNextEvent() {
		VirtualTimeTask nextTask = this.tasks.peek();
		if (nextTask != null) {
			long timeToNextEvent = nextTask.nextExecutionTime - currentTime;
			long waitingTime = timeToNextEvent - timeLeapDelta;
			if (waitingTime >= 0) {
				waitingStrategy.waitfor(waitingTime);
				timeLeapDelta = 0;
			} else {
				// System.out.println("Interpreter is behind " + timeLeapDelta + " ms");
			}
			timeLeap(timeToNextEvent);
		}
	}

	public synchronized void scheduleTimeEvent(ExecutionContext context, String eventName, boolean isPeriodical,
			long duration) {
		// This is called with zero for nano and micro seconds
		if (duration <= 0)
			duration = 1;
		VirtualTimeEventTask timeEventTask = new VirtualTimeEventTask(context, eventName);
		if (isPeriodical) {
			schedulePeriodicalTask(timeEventTask, duration, duration);
		} else {
			scheduleTask(timeEventTask, duration);
		}
	}

	protected void scheduleTask(VirtualTimeTask task, long interval) {
		task.interval = interval;
		scheduleInternal(task, currentTime + interval, -1);
	}

	protected void schedulePeriodicalTask(VirtualTimeTask task, long interval, long period) {
		scheduleInternal(task, currentTime + interval, period);
	}

	protected void scheduleInternal(VirtualTimeTask task, long time, long period) {
		task.nextExecutionTime = time;
		task.period = period;
		task.scheduleOrder = scheduleCount;
		scheduleCount++;
		tasks.add(task);
	}

	@Override
	public void unscheduleTimeEvent(String eventName) {
		VirtualTimeTask timerTask = getTask(eventName);
		if (timerTask != null)
			timerTask.cancel();
	}

	@Override
	public void scheduleCycleEvent(Runnable runnable, long period) {
		scheduleInternal(new CycleTimeEventTask(runnable), period, period);
	}

	protected VirtualTimeTask getTask(String eventName) {
		for (VirtualTimeTask virtualTimeTask : tasks) {
			if (!(virtualTimeTask instanceof VirtualTimeEventTask))
				continue;
			if (((VirtualTimeEventTask) virtualTimeTask).getEventName().equals(eventName))
				return virtualTimeTask;
		}
		return null;
	}

	protected void processTasks() {
		boolean processTasks = !tasks.isEmpty();
		while (processTasks) {
			VirtualTimeTask task = tasks.peek();
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
		for (VirtualTimeTask timerTask : tasks) {
			timerTask.cancel();
		}
		cancel();
	}

	public void cancel() {
		synchronized (tasks) {
			currentTime = 0;
			stopTime = 0;
			tasks.clear();
		}
	}
}
