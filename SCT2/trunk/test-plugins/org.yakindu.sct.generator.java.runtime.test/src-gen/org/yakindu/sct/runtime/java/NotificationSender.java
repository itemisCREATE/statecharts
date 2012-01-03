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

import java.util.HashSet;
import java.util.Set;

public class NotificationSender implements INotificationSender {

	private Set<INotificationListener> listeners = new HashSet<INotificationListener>();

	public boolean addNotificationListener(INotificationListener listener) {
		return listeners.add(listener);
	}

	public boolean removeNotificationListener(INotificationListener listener) {
		return listeners.remove(listener);
	}

	protected void notifyListeners(Notification<?> notification) {
		for (INotificationListener listener : listeners) {
			listener.notify(notification);
		}
	}
}
