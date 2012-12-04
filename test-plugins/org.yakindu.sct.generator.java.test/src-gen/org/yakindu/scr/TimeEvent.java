package org.yakindu.scr;

/**
 * Event that reflects a time event. It's internally used by
 * {@link ITimedStatemachine}.
 * 
 * @author muehlbrandt
 * 
 * @param <T>
 */
public class TimeEvent {

	private boolean periodic;

	private ITimedStatemachine statemachine;
	
	int index;

	/**
	 * Constructor for a time event.
	 * 
	 * @param periodic
	 *            : Set to {@code true} if event should be repeated
	 *            periodically.
	 * 
	 * @param index
	 *            : Index position within the state machine's timeEvent array.
	 */
	public TimeEvent(boolean periodic, int index) {
		this.periodic = periodic;
		this.index = index;
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

	public boolean isPeriodic() {
		return periodic;
	}

	public int getIndex() {
		return index;
	}
}
