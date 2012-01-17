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
package org.yakindu.sct.model.sexec.interpreter;

import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.timer.VirtualClock;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ITimingService {

	/**
	 * schedules a new TimeEvent with the given name into the given context.
	 * TimeEvents can be scheduled as periodical with a duration in ms.
	 * 
	 */
	public void scheduleTimeEvent(IExecutionContext context, String eventName,
			boolean periodical, int duration);

	/**
	 * unschedules a scheduled TimeEvent
	 */
	public void unscheduleTimeEvent(String eventName);

	/**
	 * pauses all TimeEvent
	 */
	public void pause();

	/**
	 * resumes the TimeEvents
	 */
	public void resume();

	/**
	 * Stops all TimeEvent
	 */
	public void stop();

	public void setTimeScaleFactor(double factor);
	
	public void init(VirtualClock clock);

}
