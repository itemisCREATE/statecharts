/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.simulation.core.sexec.scheduling;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.base.Stopwatch;
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
		stopTime = currentTime + ms;
		processTasks();
	}

	protected boolean timeLeapToNextEvent() {
		TimeTask nextTask = tasks.peek();
		if (nextTask != null) {
			long timeToNextEvent = nextTask.getNextExecutionTime() - currentTime;
			Stopwatch watch = Stopwatch.createStarted();
			try {
				lock.lock();
				if (!topLevelElementCondition.await(timeToNextEvent, TimeUnit.MILLISECONDS)) {
					timeLeap(timeToNextEvent);
				} else {
					timeLeap(watch.elapsed(TimeUnit.MILLISECONDS));
				}
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
		Optional<TimeTask> timerTask = getTask(eventName);
		if (timerTask.isPresent())
			timerTask.get().cancel();
	}

	protected void schedulePeriodicalTask(TimeTask task, long interval, long period) {
		scheduleInternal(task, currentTime + interval, period);
	}

	protected void scheduleTask(TimeTask task, long interval) {
		scheduleInternal(task, currentTime + interval, -1);
	}

	protected void scheduleInternal(TimeTask task, long time, long period) {
		task.setNextExecutionTime(time);
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

	protected Optional<TimeTask> getTask(final String eventName) {
		return tasks.stream().filter((task) -> task.name.equals(eventName)).findFirst();
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
		suspended = true;
	}

	@Override
	public void resume() {
		suspended = false;
		start();

	}

	@Override
	public void step() {
		work();
	}
}
