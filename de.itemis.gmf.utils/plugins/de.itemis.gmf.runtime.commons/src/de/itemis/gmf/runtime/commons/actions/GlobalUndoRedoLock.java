package de.itemis.gmf.runtime.commons.actions;

/**
 * Copied from
 * org.eclipse.gmf.runtime.common.ui.action.actions.global.GlobalUndoRedoLock
 * because of visibility restrictions.
 * 
 */
public class GlobalUndoRedoLock {
	/**
	 * Lock instance.
	 */
	public static final GlobalUndoRedoLock INSTANCE = new GlobalUndoRedoLock();

	/**
	 * The locking object.
	 */
	private Object owner = null;
	
	/**
	 * Private constructor.
	 */
	private GlobalUndoRedoLock() {
		// private
	}

	/**
	 * Acquires the lock if the lock is free and returns true, otherwise false.
	 * 
	 * @param key the key Object which can release the lock.
	 * @return <code>true</code> if lock acquired, otherwise <code>false</code>
	 */
	synchronized boolean acquire(Object key) {
		if (owner == null) {
			owner = key;
			return true;
		}
		return false;
	}
	
	/**
	 * Releases the lock if the key is correct. If the key is incorrect,
	 * then an IllegalArgumentException is thrown.
	 * 
	 * @param key the key which acquired the lock
	 */
	synchronized void release(Object key) {
		if (owner == key) {
			owner = null;
			return;
		}
		if (owner == null) {
			return;
		}
		throw new IllegalArgumentException("Unable to release lock, incorrect key."); //$NON-NLS-1$
	}
}
