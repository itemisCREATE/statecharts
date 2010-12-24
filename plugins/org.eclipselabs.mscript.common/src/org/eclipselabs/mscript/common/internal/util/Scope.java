/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.common.internal.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class Scope<T extends IScope<T, K, E>, K, E> implements IScope<T, K, E> {

	private T outerScope;
	private Map<K, E> elements = new HashMap<K, E>();
	
	/**
	 * 
	 */
	public Scope(T outerScope) {
		this.outerScope = outerScope;
	}
	
	/**
	 * @return the outerScope
	 */
	public T getOuterScope() {
		return outerScope;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.internal.util.IScope#getElements()
	 */
	public Collection<E> getAll() {
		return Collections.unmodifiableCollection(elements.values());
	}
	
	public E get(K key) {
		return elements.get(key);
	}
	
	public E findInEnclosingScopes(K key) {
		E element;
		IScope<T, K, E> scope = this;
		do {
			element = scope.get(key);
		} while (element == null && (scope = scope.getOuterScope()) != null);
		return element;
	}
	
	public void add(K key, E element) {
		elements.put(key, element);
	}

}
