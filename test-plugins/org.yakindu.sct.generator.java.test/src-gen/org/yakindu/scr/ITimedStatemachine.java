package org.yakindu.scr;

/**
* Interface for state machines which use timed event triggers.
*/
public interface ITimedStatemachine {

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

	/**
	* Callback method if a {@link TimeEvent} occurred.
	* 
	* @param timeEvent
	*/
	public void onTimeEventRaised(TimeEvent timeEvent);
}
