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
 * Interface a notification sender has to implement.
 * 
 */
public interface INotificationSender {

	/**
	 * Registers a notification listener.
	 * 
	 * @param listener
	 *            {@link INotificationListener}
	 * @return {@code true} if correct registered.
	 */
	public boolean addNotificationListener(INotificationListener listener);

	/**
	 * Unregisters a notification listener.
	 * 
	 * @param listener
	 *            {@link INotificationListener}
	 * @return {@code true} if correct unregistered.
	 */
	public boolean removeNotificationListener(INotificationListener listener);
}
