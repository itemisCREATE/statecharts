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
