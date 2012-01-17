/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.yakindu.sct.simulation.core.runtime.timer;

import java.util.Arrays;

/**
 * This is a full copy of {@link java.util.Timer}. Some changes made to use the
 * {@link VirtualClock} instead of {@link System.currentTimeMillies}
 */

public class VirtualTimer {
	/**
	 * The timer task queue. This data structure is shared with the timer
	 * thread. The timer produces tasks, via its various schedule calls, and the
	 * timer thread consumes, executing timer tasks as appropriate, and removing
	 * them from the queue when they're obsolete.
	 */
	private TaskQueue queue = new TaskQueue();

	/**
	 * The timer thread.
	 */

	private VirtualClock clock = new VirtualClock();
	{
		clock.start();
	}

	public VirtualClock getClock() {
		return clock;
	}

	private TimerThread thread = new TimerThread(queue, clock);
	/**
	 * This object causes the timer's task execution thread to exit gracefully
	 * when there are no live references to the Timer object and no tasks in the
	 * timer queue. It is used in preference to a finalizer on Timer as such a
	 * finalizer would be susceptible to a subclass's finalizer forgetting to
	 * call it.
	 */
	@SuppressWarnings("unused")
	private Object threadReaper = new Object() {
		protected void finalize() throws Throwable {
			synchronized (queue) {
				thread.newTasksMayBeScheduled = false;
				queue.notify(); // In case queue is empty.
			}
		}
	};

	/**
	 * This ID is used to generate thread names. (It could be replaced by an
	 * AtomicInteger as soon as they become available.)
	 */
	private static int nextSerialNumber = 0;

	private static synchronized int serialNumber() {
		return nextSerialNumber++;
	}

	/**
	 * Creates a new timer. The associated thread does <i>not</i> run as a
	 * daemon.
	 * 
	 * @see Thread
	 * @see #cancel()
	 */
	public VirtualTimer() {
		this("Timer-" + serialNumber());
	}

	/**
	 * Creates a new timer whose associated thread may be specified to run as a
	 * daemon. A daemon thread is called for if the timer will be used to
	 * schedule repeating "maintenance activities", which must be performed as
	 * long as the application is running, but should not prolong the lifetime
	 * of the application.
	 * 
	 * @param isDaemon
	 *            true if the associated thread should run as a daemon.
	 * 
	 * @see Thread
	 * @see #cancel()
	 */
	public VirtualTimer(boolean isDaemon) {
		this("Timer-" + serialNumber(), isDaemon);
	}

	/**
	 * Creates a new timer whose associated thread has the specified name. The
	 * associated thread does <i>not</i> run as a daemon.
	 * 
	 * @param name
	 *            the name of the associated thread
	 * @throws NullPointerException
	 *             if name is null
	 * @see Thread#getName()
	 * @see Thread#isDaemon()
	 * @since 1.5
	 */
	public VirtualTimer(String name) {
		thread.setName(name);
		thread.start();
	}

	/**
	 * Creates a new timer whose associated thread has the specified name, and
	 * may be specified to run as a daemon.
	 * 
	 * @param name
	 *            the name of the associated thread
	 * @param isDaemon
	 *            true if the associated thread should run as a daemon
	 * @throws NullPointerException
	 *             if name is null
	 * @see Thread#getName()
	 * @see Thread#isDaemon()
	 * @since 1.5
	 */
	public VirtualTimer(String name, boolean isDaemon) {
		thread.setName(name);
		thread.setDaemon(isDaemon);
		thread.start();
	}

	/**
	 * Schedules the specified task for execution after the specified delay.
	 * 
	 * @param task
	 *            task to be scheduled.
	 * @param delay
	 *            delay in milliseconds before task is to be executed.
	 * @throws IllegalArgumentException
	 *             if <tt>delay</tt> is negative, or
	 *             <tt>delay + System.currentTimeMillis()</tt> is negative.
	 * @throws IllegalStateException
	 *             if task was already scheduled or cancelled, or timer was
	 *             cancelled.
	 */
	public void schedule(VirtualTimerTask task, long delay) {
		if (delay < 0)
			throw new IllegalArgumentException("Negative delay.");
		sched(task, clock.getTime() + delay, 0);
	}

	/**
	 * Schedules the specified task for repeated <i>fixed-rate execution</i>,
	 * beginning after the specified delay. Subsequent executions take place at
	 * approximately regular intervals, separated by the specified period.
	 * 
	 * <p>
	 * In fixed-rate execution, each execution is scheduled relative to the
	 * scheduled execution time of the initial execution. If an execution is
	 * delayed for any reason (such as garbage collection or other background
	 * activity), two or more executions will occur in rapid succession to
	 * "catch up." In the long run, the frequency of execution will be exactly
	 * the reciprocal of the specified period (assuming the system clock
	 * underlying <tt>Object.wait(long)</tt> is accurate).
	 * 
	 * <p>
	 * Fixed-rate execution is appropriate for recurring activities that are
	 * sensitive to <i>absolute</i> time, such as ringing a chime every hour on
	 * the hour, or running scheduled maintenance every day at a particular
	 * time. It is also appropriate for recurring activities where the total
	 * time to perform a fixed number of executions is important, such as a
	 * countdown timer that ticks once every second for ten seconds. Finally,
	 * fixed-rate execution is appropriate for scheduling multiple repeating
	 * timer tasks that must remain synchronized with respect to one another.
	 * 
	 * @param task
	 *            task to be scheduled.
	 * @param delay
	 *            delay in milliseconds before task is to be executed.
	 * @param period
	 *            time in milliseconds between successive task executions.
	 * @throws IllegalArgumentException
	 *             if <tt>delay</tt> is negative, or
	 *             <tt>delay + System.currentTimeMillis()</tt> is negative.
	 * @throws IllegalStateException
	 *             if task was already scheduled or cancelled, timer was
	 *             cancelled, or timer thread terminated.
	 */
	public void scheduleAtFixedRate(VirtualTimerTask task, long delay,
			long period) {
		if (delay < 0)
			throw new IllegalArgumentException("Negative delay.");
		if (period <= 0)
			throw new IllegalArgumentException("Non-positive period.");
		sched(task, clock.getTime() + delay, period);
	}

	/**
	 * Schedule the specified timer task for execution at the specified time
	 * with the specified period, in milliseconds. If period is positive, the
	 * task is scheduled for repeated execution; if period is zero, the task is
	 * scheduled for one-time execution. Time is specified in Date.getTime()
	 * format. This method checks timer state, task state, and initial execution
	 * time, but not period.
	 * 
	 * @throws IllegalArgumentException
	 *             if <tt>time()</tt> is negative.
	 * @throws IllegalStateException
	 *             if task was already scheduled or cancelled, timer was
	 *             cancelled, or timer thread terminated.
	 */
	private void sched(VirtualTimerTask task, long time, long period) {
		if (time < 0)
			throw new IllegalArgumentException("Illegal execution time.");

		synchronized (queue) {
			if (!thread.newTasksMayBeScheduled)
				throw new IllegalStateException("Timer already cancelled.");

			synchronized (task.lock) {
				if (task.state != VirtualTimerTask.VIRGIN)
					throw new IllegalStateException(
							"Task already scheduled or cancelled");
				task.nextExecutionTime = time;
				task.period = period;
				task.state = VirtualTimerTask.SCHEDULED;
			}

			queue.add(task);
			if (queue.getMin() == task)
				queue.notify();
		}
	}

	/**
	 * Terminates this timer, discarding any currently scheduled tasks. Does not
	 * interfere with a currently executing task (if it exists). Once a timer
	 * has been terminated, its execution thread terminates gracefully, and no
	 * more tasks may be scheduled on it.
	 * 
	 * <p>
	 * Note that calling this method from within the run method of a timer task
	 * that was invoked by this timer absolutely guarantees that the ongoing
	 * task execution is the last task execution that will ever be performed by
	 * this timer.
	 * 
	 * <p>
	 * This method may be called repeatedly; the second and subsequent calls
	 * have no effect.
	 */
	public void cancel() {
		synchronized (queue) {
			thread.newTasksMayBeScheduled = false;
			queue.clear();
			queue.notify(); // In case queue was already empty.
		}
	}

	/**
	 * Removes all cancelled tasks from this timer's task queue. <i>Calling this
	 * method has no effect on the behavior of the timer</i>, but eliminates the
	 * references to the cancelled tasks from the queue. If there are no
	 * external references to these tasks, they become eligible for garbage
	 * collection.
	 * 
	 * <p>
	 * Most programs will have no need to call this method. It is designed for
	 * use by the rare application that cancels a large number of tasks. Calling
	 * this method trades time for space: the runtime of the method may be
	 * proportional to n + c log n, where n is the number of tasks in the queue
	 * and c is the number of cancelled tasks.
	 * 
	 * <p>
	 * Note that it is permissible to call this method from within a a task
	 * scheduled on this timer.
	 * 
	 * @return the number of tasks removed from the queue.
	 * @since 1.5
	 */
	public int purge() {
		int result = 0;

		synchronized (queue) {
			for (int i = queue.size(); i > 0; i--) {
				if (queue.get(i).state == VirtualTimerTask.CANCELLED) {
					queue.quickRemove(i);
					result++;
				}
			}

			if (result != 0)
				queue.heapify();
		}

		return result;
	}
}

/**
 * This "helper class" implements the timer's task execution thread, which waits
 * for tasks on the timer queue, executions them when they fire, reschedules
 * repeating tasks, and removes cancelled tasks and spent non-repeating tasks
 * from the queue.
 */
class TimerThread extends Thread {
	/**
	 * This flag is set to false by the reaper to inform us that there are no
	 * more live references to our Timer object. Once this flag is true and
	 * there are no more tasks in our queue, there is no work left for us to do,
	 * so we terminate gracefully. Note that this field is protected by queue's
	 * monitor!
	 */
	boolean newTasksMayBeScheduled = true;

	/**
	 * Our Timer's queue. We store this reference in preference to a reference
	 * to the Timer so the reference graph remains acyclic. Otherwise, the Timer
	 * would never be garbage-collected and this thread would never go away.
	 */
	private TaskQueue queue;

	private final VirtualClock clock;

	TimerThread(TaskQueue queue, VirtualClock clock) {
		this.queue = queue;
		this.clock = clock;
	}

	public void run() {
		try {
			mainLoop();
		} finally {
			// Someone killed this Thread, behave as if Timer cancelled
			synchronized (queue) {
				newTasksMayBeScheduled = false;
				queue.clear(); // Eliminate obsolete references
			}
		}
	}

	/**
	 * The main timer loop. (See class comment.)
	 */
	private void mainLoop() {
		while (true) {
			try {
				VirtualTimerTask task;
				boolean taskFired;
				synchronized (queue) {
					// Wait for queue to become non-empty
					while (queue.isEmpty() && newTasksMayBeScheduled)
						queue.wait();
					if (queue.isEmpty())
						break; // Queue is empty and will forever remain; die

					// Queue nonempty; look at first evt and do the right thing
					long currentTime, executionTime;
					task = queue.getMin();
					synchronized (task.lock) {
						if (task.state == VirtualTimerTask.CANCELLED) {
							queue.removeMin();
							continue; // No action required, poll queue again
						}
						currentTime = clock.getTime();
						executionTime = task.nextExecutionTime;
						if (taskFired = (executionTime <= currentTime)) {
							if (task.period == 0) { // Non-repeating, remove
								queue.removeMin();
								task.state = VirtualTimerTask.EXECUTED;
							} else { // Repeating task, reschedule
								queue.rescheduleMin(task.period < 0 ? currentTime
										- task.period
										: executionTime + task.period);
							}
						}
					}
					if (!taskFired) {
						//CHANGED
						// Task hasn't yet fired; wait
						// queue.wait((long)((executionTime - currentTime) /
						// clock.getFactor()));
						queue.wait(100);
					}
				}
				if (taskFired) {// Task fired; run it, holding no locks
					task.run();
				}
			} catch (InterruptedException e) {
			}
		}
	}
}

/**
 * This class represents a timer task queue: a priority queue of
 * VirtualTimerTasks, ordered on nextExecutionTime. Each Timer object has one of
 * these, which it shares with its TimerThread. Internally this class uses a
 * heap, which offers log(n) performance for the add, removeMin and
 * rescheduleMin operations, and constant time performance for the getMin
 * operation.
 */
class TaskQueue {
	/**
	 * Priority queue represented as a balanced binary heap: the two children of
	 * queue[n] are queue[2*n] and queue[2*n+1]. The priority queue is ordered
	 * on the nextExecutionTime field: The VirtualTimerTask with the lowest
	 * nextExecutionTime is in queue[1] (assuming the queue is nonempty). For
	 * each node n in the heap, and each descendant of n, d, n.nextExecutionTime
	 * <= d.nextExecutionTime.
	 */
	private VirtualTimerTask[] queue = new VirtualTimerTask[128];

	/**
	 * The number of tasks in the priority queue. (The tasks are stored in
	 * queue[1] up to queue[size]).
	 */
	private int size = 0;

	/**
	 * Returns the number of tasks currently on the queue.
	 */
	int size() {
		return size;
	}

	/**
	 * Adds a new task to the priority queue.
	 */
	void add(VirtualTimerTask task) {
		// Grow backing store if necessary
		if (size + 1 == queue.length)
			queue = Arrays.copyOf(queue, 2 * queue.length);

		queue[++size] = task;
		fixUp(size);
	}

	/**
	 * Return the "head task" of the priority queue. (The head task is an task
	 * with the lowest nextExecutionTime.)
	 */
	VirtualTimerTask getMin() {
		return queue[1];
	}

	/**
	 * Return the ith task in the priority queue, where i ranges from 1 (the
	 * head task, which is returned by getMin) to the number of tasks on the
	 * queue, inclusive.
	 */
	VirtualTimerTask get(int i) {
		return queue[i];
	}

	/**
	 * Remove the head task from the priority queue.
	 */
	void removeMin() {
		queue[1] = queue[size];
		queue[size--] = null; // Drop extra reference to prevent memory leak
		fixDown(1);
	}

	/**
	 * Removes the ith element from queue without regard for maintaining the
	 * heap invariant. Recall that queue is one-based, so 1 <= i <= size.
	 */
	void quickRemove(int i) {
		assert i <= size;

		queue[i] = queue[size];
		queue[size--] = null; // Drop extra ref to prevent memory leak
	}

	/**
	 * Sets the nextExecutionTime associated with the head task to the specified
	 * value, and adjusts priority queue accordingly.
	 */
	void rescheduleMin(long newTime) {
		queue[1].nextExecutionTime = newTime;
		fixDown(1);
	}

	/**
	 * Returns true if the priority queue contains no elements.
	 */
	boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all elements from the priority queue.
	 */
	void clear() {
		// Null out task references to prevent memory leak
		for (int i = 1; i <= size; i++)
			queue[i] = null;

		size = 0;
	}

	/**
	 * Establishes the heap invariant (described above) assuming the heap
	 * satisfies the invariant except possibly for the leaf-node indexed by k
	 * (which may have a nextExecutionTime less than its parent's).
	 * 
	 * This method functions by "promoting" queue[k] up the hierarchy (by
	 * swapping it with its parent) repeatedly until queue[k]'s
	 * nextExecutionTime is greater than or equal to that of its parent.
	 */
	private void fixUp(int k) {
		while (k > 1) {
			int j = k >> 1;
			if (queue[j].nextExecutionTime <= queue[k].nextExecutionTime)
				break;
			VirtualTimerTask tmp = queue[j];
			queue[j] = queue[k];
			queue[k] = tmp;
			k = j;
		}
	}

	/**
	 * Establishes the heap invariant (described above) in the subtree rooted at
	 * k, which is assumed to satisfy the heap invariant except possibly for
	 * node k itself (which may have a nextExecutionTime greater than its
	 * children's).
	 * 
	 * This method functions by "demoting" queue[k] down the hierarchy (by
	 * swapping it with its smaller child) repeatedly until queue[k]'s
	 * nextExecutionTime is less than or equal to those of its children.
	 */
	private void fixDown(int k) {
		int j;
		while ((j = k << 1) <= size && j > 0) {
			if (j < size
					&& queue[j].nextExecutionTime > queue[j + 1].nextExecutionTime)
				j++; // j indexes smallest kid
			if (queue[k].nextExecutionTime <= queue[j].nextExecutionTime)
				break;
			VirtualTimerTask tmp = queue[j];
			queue[j] = queue[k];
			queue[k] = tmp;
			k = j;
		}
	}

	/**
	 * Establishes the heap invariant (described above) in the entire tree,
	 * assuming nothing about the order of the elements prior to the call.
	 */
	void heapify() {
		for (int i = size / 2; i >= 1; i--)
			fixDown(i);
	}
}
