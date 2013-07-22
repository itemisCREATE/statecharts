package org.yakindu.scr;

/**
 * Interface a timer service has to implement. Use to implement your own timer
 * service. A timer service has to be added to a timed state machine.
 * 
 */
public interface ITimerService {

	/**
	 * Starts the timing for a given {@link TimeEvent}.
	 * 
	 * @param event
	 *            : The TimeEvent the timer service should throw if timed out.
	 * @param time
	 *            : Time in milliseconds after the given time event should be
	 *            triggered
	 * @param cycleStartTime
	 *            : The absolute start time in milliseconds at which the last
	 *            run cycle was called. Can be used to produce a more accurate
	 *            timing behavior.
	 */
	public void setTimer(TimeEvent event, long time, long cycleStartTime);

	/**
	 * Unset the given {@link TimeEvent}. Use to unset cyclic repeated time
	 * events.
	 * 
	 * @param event
	 */
	public void resetTimer(TimeEvent event);

	/**
	 * Cancel timer service. Use this to end possible timing threads and free
	 * memory resources.
	 */
	public void cancel();

	/**
	 * Returns the system time in milliseconds.
	 * 
	 * @return the difference, measured in milliseconds, between the current
	 *         time and a defined point of time in the past.
	 */
	public long getSystemTimeMillis();
}
