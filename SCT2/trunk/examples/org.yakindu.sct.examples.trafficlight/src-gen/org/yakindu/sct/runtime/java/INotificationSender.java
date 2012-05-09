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
