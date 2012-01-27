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

public class VariableNotification<T> extends Notification {

	private T oldValue;
	private T newValue;
	private Enum<?> id;

	public VariableNotification(Enum<?> id, T newValue, T oldValue) {
		super(NotificationType.VariableNotification);
		this.id = id;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public Enum<?> getId() {
		return id;
	}

	public T getNewValue() {
		return newValue;
	}

	public T getOldValue() {
		return oldValue;
	}
}
