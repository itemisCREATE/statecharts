package de.itemis.xtext.utils.jface.viewers.util;

/**
 * A runnable that may return a result.
 * 
 * @author nyssen
 *
 * @param <T>
 */
public interface RunnableWithResult<T> extends Runnable {
	T getResult();
}
