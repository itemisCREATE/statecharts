package org.yakindu.sct.runtime.java;

/**
 * An Event that contains values.
 * 
 * @param <T>
 * @param <D>
 */
public class ValuedEvent<T extends Enum<T>, D> extends Event<T> {

	private D value;

	/**
	 * Creates an event with the given id and an offset. The offset represents
	 * the start index of the events position in the {@link EventVector} of the
	 * statemachine.
	 * 
	 * @param id
	 * @param offset
	 * @param value
	 */
	public ValuedEvent(T name, int offset, D value) {
		super(name, offset);
		this.value = value;
	}

	/**
	 * Returns the value hold by the event.
	 */
	public D getValue() {
		return value;
	}

	/**
	 * Store a new value in the event.
	 * 
	 * @param value
	 */
	public void setValue(D value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}
}
