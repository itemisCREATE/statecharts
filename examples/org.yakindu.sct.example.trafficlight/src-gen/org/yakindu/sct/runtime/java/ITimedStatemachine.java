package org.yakindu.sct.runtime.java;

import org.yakindu.sct.runtime.java.ITimerNotificationListener;

/**
 * Interface for state machines which use timed event triggers.
 */
public interface ITimedStatemachine
		extends
			IStatemachine,
			ITimerNotificationListener {

	/**
	 * Set the {@link ITimerService} for the state machine. It must be set
	 * externally on a timed state machine before a run cycle can be correct
	 * executed.
	 * 
	 * @param timerService
	 */
	public void setTimerService(ITimerService timerService);

	/**
	 * Returns the currently used timer service.
	 * 
	 * @return {@link ITimerService}
	 */
	public ITimerService getTimerService();
}
