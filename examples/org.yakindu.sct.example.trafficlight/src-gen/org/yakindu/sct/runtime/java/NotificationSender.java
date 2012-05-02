package org.yakindu.sct.runtime.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of a notification sender. This implementation is used by the
 * statemachine and the generated interfaces to notify registered observers.
 * Inherit from this class if necessary.
 * 
 */
public class NotificationSender implements INotificationSender {

	private Set<INotificationListener> listeners = new HashSet<INotificationListener>();

	public boolean addNotificationListener(INotificationListener listener) {
		return listeners.add(listener);
	}

	public boolean removeNotificationListener(INotificationListener listener) {
		return listeners.remove(listener);
	}

	/**
	 * Notify all registered listeners with the given {@link EventNotification}
	 * 
	 * @param notification
	 */
	protected void notifyListenersOnEventRaised(EventNotification notification) {
		for (INotificationListener listener : listeners) {
			listener.onEventRaised(notification);
		}
	}

	/**
	 * Notify all registered listeners with the given
	 * {@link VariableNotification}
	 * 
	 * @param notification
	 */
	protected void notifyListenersOnVariableChanged(
			VariableNotification<?> notification) {
		for (INotificationListener listener : listeners) {
			listener.onVariableChanged(notification);
		}
	}
}
