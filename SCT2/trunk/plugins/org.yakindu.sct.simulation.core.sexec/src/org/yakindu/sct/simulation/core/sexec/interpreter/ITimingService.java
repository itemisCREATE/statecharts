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
package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

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
	public void scheduleTimeEvent(ExecutionContext context, String eventName, boolean periodical, long duration);

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

}
