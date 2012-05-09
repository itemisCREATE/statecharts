package org.yakindu.sct.runtime.java;

/**
 * 
 * Basic event class.
 * 
 * @param <T>
 */
public class Event<T extends Enum<T>> {

	private T id;

	private int offset;

	/**
	 * Creates an event with the given id and an offset. The offset represents
	 * the start index of the events position in the {@link EventVector} of the
	 * statemachine.
	 * 
	 * @param id
	 * @param offset
	 */
	public Event(T id, int offset) {
		this.id = id;
		this.offset = offset;
	}

	/**
	 * Returns the event identifier.
	 * 
	 * @return
	 */
	public T getId() {
		return id;
	}

	/**
	 * Returns the position of the event in the statemachines
	 * {@link EventVector}
	 * 
	 * @return {@code int}
	 */
	public int getIndex() {
		return offset + id.ordinal();
	}
}
