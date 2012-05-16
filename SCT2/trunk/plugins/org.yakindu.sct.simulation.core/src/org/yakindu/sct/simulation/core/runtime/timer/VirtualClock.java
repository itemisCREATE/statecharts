/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime.timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * VirtualClock to be used instead of {@link System}currentTimeMillis. Allows to
 * scale the time with a given factor.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class VirtualClock {

	// real time in ms since start of the clock
	private long startTime;
	// real time in ms since last factor change
	private long realTime;
	// virtual time in ms since last factor change
	private long virtualTime;
	// accumulated suspend time in ms
	private long accumulatedSuspendTime;
	// last time stamp in which the clock was suspended
	private long startSuspendTime;
	// flag to decide if the clock is currently suspended
	private boolean isSuspended;
	// factor to set after the clock is resumed (only if it is greater than
	// zero))
	private double factorToSet;

	private List<PropertyChangeListener> _listeners;

	public VirtualClock() {
		_listeners = new ArrayList<PropertyChangeListener>();
	}

	private double factor = 1.0d;

	public synchronized void start() {
		reset();
		startTime = System.currentTimeMillis();
		virtualTime = System.currentTimeMillis();
		realTime = System.currentTimeMillis();
	}

	public synchronized void suspend() {
		startSuspendTime = System.currentTimeMillis();
		isSuspended = true;
	}

	public synchronized void resume() {
		accumulatedSuspendTime += System.currentTimeMillis() - startSuspendTime;
		isSuspended = false;
		if (factorToSet > 0) {
			setFactor(factorToSet);
			factorToSet = 0;
		}
	}

	public synchronized void stop() {
		reset();
	}

	private void reset() {
		virtualTime = 0;
		realTime = 0;
		startTime = 0;
		accumulatedSuspendTime = 0;
		startSuspendTime = 0;
		factorToSet = 0;
	}

	public synchronized void setFactor(double factor) {
		if (!isSuspended) {
			virtualTime = getTime();
			realTime = System.currentTimeMillis() - getPauseTime();
			double oldFactor = this.factor;
			this.factor = factor;
			notifyListeners(new PropertyChangeEvent(this, "factor", oldFactor,
					factor));
		} else {
			factorToSet = factor;
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		synchronized (_listeners) {
			_listeners.add(listener);
		}
	}

	protected void notifyListeners(PropertyChangeEvent event) {
		synchronized (_listeners) {
			for (PropertyChangeListener listener : _listeners) {
				listener.propertyChange(event);
			}
		}
	}

	public synchronized long getTime() {
		long difference = System.currentTimeMillis() - getPauseTime()
				- this.realTime;
		difference = (long) (difference * factor);
		return virtualTime + difference;
	}

	public long getPauseTime() {
		if (isSuspended) {
			return (System.currentTimeMillis() - startSuspendTime)
					+ accumulatedSuspendTime;
		}
		return this.accumulatedSuspendTime;
	}

	public long getAccumulatedSuspendTime() {
		return accumulatedSuspendTime;
	}

	public synchronized double getFactor() {
		return factor;
	}

	public synchronized long getStartTime() {
		return startTime;
	}

	public long getRealTime() {
		return realTime;
	}

	public long getVirtualTime() {
		return virtualTime;
	}

}
