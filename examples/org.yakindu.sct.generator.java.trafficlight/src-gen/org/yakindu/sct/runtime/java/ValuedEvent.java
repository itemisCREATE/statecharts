/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
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
