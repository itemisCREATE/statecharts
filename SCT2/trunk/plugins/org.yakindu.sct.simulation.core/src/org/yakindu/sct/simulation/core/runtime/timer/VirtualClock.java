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

	private List<PropertyChangeListener> _listeners;

	public VirtualClock() {
		_listeners = new ArrayList<PropertyChangeListener>();
	}

	private double factor = 1.0d;

	public synchronized void start() {
		startTime = System.currentTimeMillis();
		virtualTime = System.currentTimeMillis();
		realTime = System.currentTimeMillis();
	}

	public synchronized void pause() {
		
	}

	public synchronized void stop() {
		virtualTime = 0;
		realTime = 0;
		startTime = 0;
	}

	public synchronized void setFactor(double factor) {
		virtualTime = getTime();
		realTime = System.currentTimeMillis();
		double oldFactor = this.factor;
		this.factor = factor;
		notifyListeners(new PropertyChangeEvent(this, "factor", oldFactor,
				factor));
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
		long difference = System.currentTimeMillis() - this.realTime;
		difference = (long) (difference * factor);
		return virtualTime + difference;
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
