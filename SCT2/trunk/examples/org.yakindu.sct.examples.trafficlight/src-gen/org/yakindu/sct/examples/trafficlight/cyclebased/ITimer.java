/**
Copyright (c) 2012 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
�*/
package org.yakindu.sct.examples.trafficlight.cyclebased;

/**
 * Interface a timer has to implement. Use to implement your own timer
 * service.
 * 
 */
public interface ITimer {

	/**
	 * Starts the timing for a given time event id.
	 * 
	 * @param callback
	 * 			  : The target callback where the time event has to be raised.
	 * 
	 * @param eventID
	 *            : The eventID the timer should use if timed out.
	 *            
	 * @param time
	 *            : Time in milliseconds after the given time event should be
	 *            triggered
	 *            
	 * @param isPeriodic
	 * 			  : Set to true if the time event should be triggered periodically
	 */
	public void setTimer(ITimerCallback callback, int eventID, long time, boolean isPeriodic);

	/**
	 * Unset a time event.
	 * 
	 * @param callback
	 * 			: The target callback for which the time event has to be unset.
	 * 
	 * @param eventID
	 * 			: The time event id.
	 */
	public void unsetTimer(ITimerCallback callback, int eventID);
}
