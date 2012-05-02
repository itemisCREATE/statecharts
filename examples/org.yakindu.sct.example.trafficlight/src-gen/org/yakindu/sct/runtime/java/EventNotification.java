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

import org.yakindu.sct.runtime.java.Event;

/**
 * 
 * Class to transmit an event within a notification.
 * 
 * 
 */
public class EventNotification extends Notification {

	private Event<? extends Enum<?>> event;

	/**
	 * Initializes the notification with an {@link Event}.
	 * @param event
	 */
	public EventNotification(Event<? extends Enum<?>> event) {
		super(NotificationType.EventNotification);
		this.event = event;
	}

	/**
	 * Returns the contained {@code Event}.
	 * @return {@link Event}
	 */
	public Event<? extends Enum<?>> getEvent() {
		return event;
	}
}
