/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.scheduling;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultTimeTaskScheduler.class)
public interface ITimeTaskScheduler {

	public void scheduleTimeTask(TimeTask task, boolean isPeriodical, long duration);

	public void unscheduleTimeTask(String eventName);

	public void timeLeap(long ms);

	public void start();

	public void suspend();

	public void resume();

	public void step();

	public void terminate();

	public static class TimeTask implements Runnable, Comparable<TimeTask> {

		public static enum Priority {

			LOW(0), NORMAL(50), HIGH(100);

			private int intValue;

			Priority(int prio) {
				this.intValue = prio;
			}

			public int getIntValue() {
				return intValue;
			}
		}

		private long nextExecutionTime = 0;
		long period = -1;
		long scheduleOrder = 0;
		boolean isCanceled = false;
		Priority priority = Priority.NORMAL;
		String name;

		private final Runnable callBack;

		public TimeTask(String name, Runnable callBack) {
			this(name, callBack, Priority.NORMAL);
		}

		public TimeTask(String name, Runnable callBack, Priority priority) {
			this.callBack = callBack;
			this.name = name;
			this.priority = priority;
		}

		public void run() {
			callBack.run();
		}

		public int compareTo(TimeTask other) {
			if (nextExecutionTime != other.nextExecutionTime) {
				return (int) (nextExecutionTime - other.nextExecutionTime);
			} else if (other.priority != this.priority) {
				return other.priority.getIntValue() - this.priority.getIntValue();
			} else if (period != other.period) {
				return (int) (period - other.period);
			}
			return (int) (scheduleOrder - other.scheduleOrder);
		}

		public boolean isCanceled() {
			return isCanceled;
		}

		public void cancel() {
			isCanceled = true;
		}

		public long getNextExecutionTime() {
			return nextExecutionTime;
		}

		public void setNextExecutionTime(long nextExecutionTime) {
			this.nextExecutionTime = nextExecutionTime;
		}
	}

}
