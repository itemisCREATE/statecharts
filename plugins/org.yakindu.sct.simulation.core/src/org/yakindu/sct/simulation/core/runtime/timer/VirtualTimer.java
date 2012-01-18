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
package org.yakindu.sct.simulation.core.runtime.timer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implementation of a {@link VirtualTimer} that operates on a virtual time.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class VirtualTimer {

	public static abstract class VirtualTimerTask implements Runnable,
			Comparable<VirtualTimerTask> {
		long nextExecutionTime = 0;
		long interval = 0;
		long period = -1;
		boolean isCanceled = false;

		public int compareTo(VirtualTimerTask o) {
			return (int) (nextExecutionTime - o.nextExecutionTime);
		}

		public boolean isCanceled() {
			return isCanceled;
		}

		public void cancel() {
			isCanceled = true;
		}
	}

	private Queue<VirtualTimerTask> queue = new PriorityQueue<VirtualTimerTask>();

	private VirtualClock clock;

	private boolean canceled;
	private Thread executer;

	public VirtualClock getClock() {
		return clock;
	}

	public VirtualTimer(VirtualClock clock) {
		this.clock = clock;
		executer = new Thread(new TaskExecuter());
		executer.start();
	}

	public void scheduleTask(VirtualTimerTask task, long interval) {
		task.interval = interval;
		scheduleInternal(task, clock.getTime() + interval, -1);
	}

	public void schedulePeriodicalTask(VirtualTimerTask task, long interval,
			long period) {
		task.interval = interval;
		scheduleInternal(task, clock.getTime() + interval, period);
	}

	private void scheduleInternal(VirtualTimerTask task, long time, long period) {
		task.nextExecutionTime = time;
		task.period = period;
		synchronized (queue) {
			queue.add(task);
			if (queue.peek() == task)
				queue.notify();
		}
	}

	public void cancel() {
		canceled = true;
		synchronized (queue) {
			queue.clear();
		}
	}

	public class TaskExecuter implements Runnable {
		public void run() {
			try {
				while (!canceled) {
					synchronized (queue) {
						while (queue.isEmpty()) {
							System.out.println("Wait");
							queue.wait();
						}
						VirtualTimerTask task = queue.peek();
						if (task.isCanceled) {
							queue.remove();
							continue;
						}
						long virtualTime = clock.getTime();
						long executionTime = task.nextExecutionTime;
						if (executionTime <= virtualTime) {
							task = queue.poll();
							task.run();
							if (task.period > -1) {
								schedulePeriodicalTask(task, task.interval,
										task.period);
							}
						}
					}
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
