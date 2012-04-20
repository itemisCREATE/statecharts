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
 * This notification type is thrown by the runtime service if a statemachine
 * cycle is executed.
 * 
 */
public class RuntimeCycleNotification extends Notification {

	private IStatemachine statemachine;

	/**
	 * Initializes notification with the given statemachine.
	 * 
	 * @param statemachine
	 */
	public RuntimeCycleNotification(IStatemachine statemachine) {
		super(NotificationType.RuntimeCycleNotification);
		this.statemachine = statemachine;
	}

	/**
	 * Get the statemachine on which a run to completion step was executed by
	 * the runtime service.
	 * 
	 * @return
	 */
	public IStatemachine getStatemachine() {
		return statemachine;
	}
}
