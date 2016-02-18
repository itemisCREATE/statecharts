/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.inject.Singleton;

/**
 * Implementation of {@link ITimingService} interface using
 * {@link ScheduledExecutorService}
 * 
 * @author andreas muelder
 * @author thomas kutz
 * 
 */
@Singleton
public class SuspendableTimingService implements ITimingService {

	protected class ScheduleEventRunnable implements Runnable {

		private final ExecutionContext context;
		private final String eventName;
		private boolean isPeriodical;
		private long initialDuration;
		private long duration;

		public ScheduleEventRunnable(ExecutionContext context, String eventName, boolean isPeriodical, long duration) {
			this(context, eventName, isPeriodical, duration, duration);
		}

		public ScheduleEventRunnable(ExecutionContext context, String eventName, boolean isPeriodical,
				long initialDuration, long duration) {
			this.context = context;
			this.eventName = eventName;
			this.isPeriodical = isPeriodical;
			this.initialDuration = initialDuration;
			this.duration = duration;
		}

		public void run() {
			context.getEvent(eventName).setScheduled(true);
		}

		public ExecutionContext getContext() {
			return context;
		}

		public String getEventName() {
			return eventName;
		}

		public boolean isPeriodical() {
			return isPeriodical;
		}

		public long getDuration() {
			return duration;
		}

		public long getInitialDuration() {
			return initialDuration;
		}

		public void setInitialDuration(long initialDuration) {
			this.initialDuration = initialDuration;
		}

	}

	private ScheduledExecutorService scheduler;

	private Map<String, ScheduleEventRunnable> runnables;
	private Map<String, ScheduledFuture<?>> futures;

	public SuspendableTimingService() {
		scheduler = Executors.newScheduledThreadPool(1);
		runnables = new HashMap<String, ScheduleEventRunnable>();
		futures = new HashMap<String, ScheduledFuture<?>>();
	}

	public synchronized void scheduleTimeEvent(ExecutionContext context, String eventName, boolean isPeriodical,
			long duration) {
		if (duration <= 0)
			duration = 1;
		ScheduleEventRunnable eventRunnable = new ScheduleEventRunnable(context, eventName, isPeriodical, duration);
		scheduleTimeEvent(eventRunnable);
	}

	protected void scheduleTimeEvent(ScheduleEventRunnable eventRunnable) {
		ScheduledFuture<?> future = null;
		if (eventRunnable.isPeriodical) {
			future = scheduler.scheduleAtFixedRate(eventRunnable, eventRunnable.initialDuration, eventRunnable.duration,
					TimeUnit.MILLISECONDS);
		} else {
			future = scheduler.schedule(eventRunnable, eventRunnable.initialDuration, TimeUnit.MILLISECONDS);
		}
		runnables.put(eventRunnable.getEventName(), eventRunnable);
		futures.put(eventRunnable.getEventName(), future);
	}

	public synchronized void unscheduleTimeEvent(String eventName) {
		ScheduledFuture<?> future = futures.remove(eventName);
		future.cancel(false);
		runnables.remove(eventName);
	}

	public synchronized void pause() {
		Set<Entry<String, ScheduledFuture<?>>> entrySet = futures.entrySet();
		for (Entry<String, ScheduledFuture<?>> entry : entrySet) {
			ScheduledFuture<?> future = entry.getValue();
			long delay = future.getDelay(TimeUnit.MILLISECONDS);
			future.cancel(false);
			ScheduleEventRunnable runnable = runnables.get(entry.getKey());
			runnable.setInitialDuration(delay);
		}
		futures.clear();
	}

	public synchronized void resume() {
		for (ScheduleEventRunnable event : runnables.values()) {
			scheduleTimeEvent(event);
		}
	}

	public synchronized void stop() {
		Collection<ScheduledFuture<?>> values = futures.values();
		for (ScheduledFuture<?> scheduledFuture : values) {
			scheduledFuture.cancel(false);
		}
		futures.clear();
		runnables.clear();
		scheduler.shutdownNow();
	}

}
