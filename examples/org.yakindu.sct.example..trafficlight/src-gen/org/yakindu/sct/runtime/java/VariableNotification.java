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
 * Class to transmit a variable within a notification.
 * 
 */
public class VariableNotification<T> extends Notification {

	private T oldValue;
	private T newValue;
	private Enum<?> id;

	/**
	 * Constructor for VariableNotification.
	 * 
	 * @param id
	 *            : the variable id
	 * @param newValue
	 *            : new variable value
	 * @param oldValue
	 *            : old variable value
	 */
	public VariableNotification(Enum<?> id, T newValue, T oldValue) {
		super(NotificationType.VariableNotification);
		this.id = id;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/**
	 * Returns the variable identifier.
	 */
	public Enum<?> getId() {
		return id;
	}

	/**
	 * Returns the new value.
	 */
	public T getNewValue() {
		return newValue;
	}

	/**
	 * Returns the old value.
	 */
	public T getOldValue() {
		return oldValue;
	}
}
