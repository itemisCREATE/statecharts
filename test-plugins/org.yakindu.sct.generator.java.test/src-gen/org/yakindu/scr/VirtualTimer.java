package org.yakindu.scr;

import java.util.PriorityQueue;
import java.util.Queue;
import org.yakindu.scr.ITimer;
import org.yakindu.scr.ITimerCallback;

public class VirtualTimer implements ITimer {

	private long virtualTime = 0;

	private Queue<VirtualTimeTask> tasks;

	public abstract static class VirtualTimeTask implements Runnable, Comparable<VirtualTimeTask> {

		long nextExecutionTime = 0;
		long interval = 0;
		long period = -1;
		boolean isCanceled = false;

		public int compareTo(VirtualTimeTask o) {
			return (int) (nextExecutionTime - o.nextExecutionTime);
		}

		public boolean isCanceled() {
			return isCanceled;
		}

		public void cancel() {
			isCanceled = true;
		}
	}

	public static class VirtualTimeEventTask extends VirtualTimeTask {

		private final int eventID;
		private ITimerCallback callback;

		public VirtualTimeEventTask(ITimerCallback callback, int eventID) {
			this.callback = callback;
			this.eventID = eventID;
		}

		public int getEventId() {
			return eventID;
		}

		public void run() {
			callback.timeElapsed(eventID);
		}

	}

	public VirtualTimer() {
		tasks = new PriorityQueue<VirtualTimeTask>();
	}

	public void timeLeap(long ms) {
		virtualTime += ms;
		processTasks();
	}

	@Override
	public void setTimer(ITimerCallback callback, int eventID, long duration, boolean isPeriodical) {
		if (duration <= 0)
			duration = 1;
		VirtualTimeEventTask timeEventTask = new VirtualTimeEventTask(callback, eventID);
		if (isPeriodical) {
			schedulePeriodicalTask(timeEventTask, duration, duration);
		} else {
			scheduleTask(timeEventTask, duration);
		}
	}

	@Override
	public void unsetTimer(ITimerCallback callback, int eventID) {
		VirtualTimeTask timerTask = getTask(eventID);
		if (timerTask != null)
			timerTask.cancel();
	}

	public void scheduleTask(VirtualTimeTask task, long interval) {
		task.interval = interval;
		scheduleInternal(task, virtualTime + interval, -1);
	}

	public void schedulePeriodicalTask(VirtualTimeTask task, long interval, long period) {
		task.interval = interval;
		scheduleInternal(task, virtualTime + interval, period);
	}

	private void scheduleInternal(VirtualTimeTask task, long time, long period) {
		task.nextExecutionTime = time;
		task.period = period;
		tasks.add(task);
	}

	protected VirtualTimeTask getTask(int eventName) {
		for (VirtualTimeTask virtualTimeTask : tasks) {
			if (!(virtualTimeTask instanceof VirtualTimeEventTask))
				continue;
			if (((VirtualTimeEventTask) virtualTimeTask).getEventId() == eventName)
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
			if (executionTime <= virtualTime) {
				task = tasks.poll();
				task.run();
				if (task.period > -1) {
					schedulePeriodicalTask(task, task.interval, task.period);
				}
			} else {
				processTasks = false;
			}
		}
	}

	public synchronized void pause() {
		throw new RuntimeException("Implement me");
	}

	public synchronized void resume() {
		throw new RuntimeException("Implement me");
	}

	public synchronized void stop() {
		for (VirtualTimeTask timerTask : tasks) {
			timerTask.cancel();
		}
		cancel();
	}

	public void cancel() {
		synchronized (tasks) {
			tasks.clear();
		}
	}

}
