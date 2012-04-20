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
 * Interface a statemachine observer has to implement to receive notifications
 * on event and variable changes.
 * 
 * 
 */
public interface INotificationListener {

	/**
	 * Callback for a {@link EventNotification}
	 * 
	 * @param notification
	 */
	public void onEventRaised(EventNotification notification);

	/**
	 * Callback for a {@link VariableNotification}
	 * 
	 * @param notification
	 */
	public void onVariableChanged(VariableNotification<?> notification);

}
