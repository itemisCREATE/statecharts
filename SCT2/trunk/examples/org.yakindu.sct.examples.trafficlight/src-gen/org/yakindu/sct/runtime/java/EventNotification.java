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
