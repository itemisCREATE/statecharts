/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.simulation.core.engine.scheduling;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.time.StopWatch;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class DefaultTimeTaskScheduler implements ITimeTaskScheduler {

	protected long stopTime = 0;
	protected long currentTime = 0;
	protected long scheduleCount = 0;
	protected Queue<TimeTask> tasks;
	protected Lock lock;
	protected Condition elementAddedCondition;
	protected Condition topLevelElementCondition;

	protected Runnable queueWorker;

	protected boolean canceled;
	protected boolean suspended;
	protected boolean terminated;
	private StopWatch watch;

	public DefaultTimeTaskScheduler() {
		tasks = new PriorityQueue<TimeTask>();
		lock = new ReentrantLock();
		elementAddedCondition = lock.newCondition();
		topLevelElementCondition = lock.newCondition();
		queueWorker = () -> {
			while (!terminated && !suspended) {
				work();
			}
		};
	}

	protected void work() {
		try {
			lock.lock();
			boolean processed = timeLeapToNextEvent();
			if (!processed) {
				try {
					elementAddedCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void timeLeap(long ms) {
		watch = null;
		stopTime = currentTime + ms;
		processTasks();
	}

	protected boolean timeLeapToNextEvent() {
		TimeTask nextTask = tasks.peek();
		if (nextTask != null) {
			long timeToNextEvent = nextTask.getNextExecutionTime() - currentTime;
			try {
				lock.lock();
				watch = new StopWatch();
				watch.start();
				topLevelElementCondition.await(timeToNextEvent, TimeUnit.MILLISECONDS);
				timeLeap(watch != null ? watch.getTime() : 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			return true;
		}
		return false;
	}

	@Override
	public void start() {
		Thread thread = new Thread(queueWorker);
		thread.start();
	}

	@Override
	public void scheduleTimeTask(TimeTask task, boolean isPeriodical, long duration) {
		if (duration <= 0)
			duration = 1;
		if (isPeriodical) {
			schedulePeriodicalTask(task, duration, duration);
		} else {
			scheduleTask(task, duration);
		}
	}

	@Override
	public void unscheduleTimeTask(String eventName) {
		Optional<TimeTask> timerTask = getActiveTask(eventName);
		if (timerTask.isPresent()) {
			timerTask.get().cancel();
			if (tasks.peek() == timerTask.get()) {
				lock.lock();
				topLevelElementCondition.signal();
				lock.unlock();
			}
		}
	}

	protected void schedulePeriodicalTask(TimeTask task, long interval, long period) {
		scheduleInternal(task, interval, period);
	}

	protected void scheduleTask(TimeTask task, long interval) {
		scheduleInternal(task, interval, -1);
	}
	
	protected long computeNextExecutionTime(long interval) {
		return currentTime + interval + (watch != null ? watch.getTime() : 0);
	}

	protected void scheduleInternal(TimeTask task, long time, long period) {
		task.setNextExecutionTime(computeNextExecutionTime(time));
		task.period = period;
		task.scheduleOrder = scheduleCount;
		scheduleCount++;
		try {
			lock.lock();
			tasks.add(task);
			if (tasks.size() > 1 && tasks.peek() == task) {
				topLevelElementCondition.signal();
			}
			elementAddedCondition.signal();
		} finally {
			lock.unlock();
		}
	}

	protected synchronized Optional<TimeTask> getActiveTask(final String eventName) {
		return tasks.stream().filter((task) -> !task.isCanceled() && task.name.equals(eventName)).findFirst();
	}

	protected synchronized void processTasks() {
		boolean processTasks = !tasks.isEmpty();
		while (processTasks) {
			TimeTask task = tasks.peek();
			if (task == null)
				break;
			if (task.isCanceled) {
				tasks.remove();
				continue;
			}
			long executionTime = task.getNextExecutionTime();
			if (executionTime <= stopTime) {
				currentTime = task.getNextExecutionTime();
				task = tasks.poll();
				if (task.period > -1) {
					schedulePeriodicalTask(task, task.period, task.period);
				}
				task.run();
			} else {
				currentTime = stopTime;
				processTasks = false;
			}
		}
	}

	public void terminate() {
		terminated = true;
		currentTime = 0;
		stopTime = 0;
		synchronized (tasks) {
			for (TimeTask timerTask : tasks) {
				timerTask.cancel();
			}
			tasks.clear();
		}
	}

	@Override
	public void suspend() {
		if (watch != null) {
			watch.suspend();
		}
		lock.lock();
		topLevelElementCondition.signal();
		lock.unlock();
		suspended = true;
	}

	@Override
	public void resume() {
		if (suspended) {
			suspended = false;
			if (watch != null) {
				watch.resume();
			}
			start();
		}
	}

	@Override
	public void step() {
		if (suspended) {
			timeLeapToNextEvent();
		}
	}

	@Override
	public long getCurrentTime() {
		return this.currentTime;
	}
}
