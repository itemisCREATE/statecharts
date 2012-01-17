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

/**
 * VirtualClock to be used instead of {@link System}currentTimeMillis. Allows to
 * scale the time with a given factor.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class VirtualClock {

	//real time in ms since start of the clock
	private long startTime;
	//real time in ms since last factor change
	private long realTime;
	//virtual time in ms since last factor change
	private long virtualTime;


	private double factor = 1.0d;

	public void start() {
		startTime = System.currentTimeMillis();
		virtualTime = System.currentTimeMillis();
		realTime = System.currentTimeMillis();
	}

	public void setFactor(double factor) {
		virtualTime = getTime();
		realTime = System.currentTimeMillis();
		this.factor = factor;
	}

	public long getTime() {
		long difference = System.currentTimeMillis() - this.realTime;
		difference = (long) (difference * factor);
		return virtualTime + difference;
	}

	public double getFactor() {
		return factor;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getRealTime() {
		return realTime;
	}

	public long getVirtualTime() {
		return virtualTime;
	}

}
