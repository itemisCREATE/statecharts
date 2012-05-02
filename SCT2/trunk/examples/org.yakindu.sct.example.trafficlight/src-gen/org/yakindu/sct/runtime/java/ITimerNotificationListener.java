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
	 * @param timeEvent
	 */
	public void onTimeEventRaised(TimeEvent<? extends Enum<?>> timeEvent);

}
