/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java;

/**
 * 
 * Interface for {@link TimeEvent} listeners. These listers can be registered at
 * a {@link ITimerService}. Used by {@link ITimedStatemachine} to register
 * itself at the {@link ITimerService}.
 * 
 */
public interface ITimerNotificationListener {

	/**
	 * Callback method if a {@link TimeEvent} occurred.
	 * 
	 * @param timeEvent
	 */
	public void onTimeEventRaised(TimeEvent<? extends Enum<?>> timeEvent);

}
