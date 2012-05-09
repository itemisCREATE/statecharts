package org.yakindu.sct.runtime.java;

/**
 * 
 * Basic class to represent a notification.
 * 
 * 
 */
public class Notification {

	private NotificationType notificationType;

	/**
	 * Creates a notification with the given {@link NotificationType}
	 * 
	 * @param notificationType
	 */
	public Notification(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * Returns the {@link NotificationType} of notification.
	 * 
	 * @return {@link NotificationType}
	 */
	public NotificationType getNotificationType() {
		return notificationType;
	}
}
