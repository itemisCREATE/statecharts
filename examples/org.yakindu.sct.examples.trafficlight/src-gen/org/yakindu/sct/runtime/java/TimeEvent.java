package org.yakindu.sct.runtime.java;

/**
 * Event that reflects a time event. It's internally used by
 * {@link ITimedStatemachine}.
 * 
 * @author muehlbrandt
 * 
 * @param <T>
 */
public class TimeEvent<T extends Enum<T>> extends ValuedEvent<T, Boolean> {

	private long time = -1;

	private ITimedStatemachine statemachine;

	/**
	 * Constructor for a time event.
	 * 
	 * @param id
	 *            : The event id.
	 * @param offset
	 *            : Offset which is added to the index position within the state
	 *            machine's {@link EventVector}.
	 * @param periodic
	 *            : Set to {@code true} if event should be repeated
	 *            periodically.
	 */
	public TimeEvent(T id, int offset, boolean periodic) {
		super(id, offset, periodic);
	}

	/**
	 * Sets the time delay after the event is called.
	 * 
	 * @param time
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * Returns the time delay after the event is called.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Returns the state machine reference of the event.
	 * 
	 */
	public ITimedStatemachine getStatemachine() {
		return statemachine;
	}

	/**
	 * Sets the state machine reference of the event.
	 * 
	 * @param statemachine
	 */
	public void setStatemachine(ITimedStatemachine statemachine) {
		this.statemachine = statemachine;
	}
}
