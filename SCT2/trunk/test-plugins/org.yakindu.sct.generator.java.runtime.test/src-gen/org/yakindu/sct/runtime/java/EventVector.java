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

import java.util.Collection;
import java.util.Iterator;

public class EventVector<E extends Event<? extends Enum<?>>>
		implements
			Collection<E> {

	private boolean events[];

	public EventVector(int size) {
		events = new boolean[size];
	}

	public int size() {
		return events.length;
	}

	public boolean isEmpty() {
		for (int i = 0; i < events.length; i++) {
			if (events[i]) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean contains(Object o) {
		if (o instanceof Event) {
			Event<? extends Enum<?>> event = (Event<? extends Enum<?>>) o;
			return events[event.getIndex()];
		}
		return false;
	}

	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Iterator not supported!");
	}

	public Object[] toArray() {
		throw new UnsupportedOperationException("toArray not supported!");
	}

	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("toArray not supported!");
	}

	public boolean add(E e) {
		if (e.getIndex() > -1 && e.getIndex() < events.length) {
			events[e.getIndex()] = true;
			return true;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean remove(Object o) {
		if (o instanceof Event) {
			Event event = (Event) o;
			if (event.getIndex() > -1 && event.getIndex() < events.length) {
				events[event.getIndex()] = true;
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (o instanceof Event) {
				Event event = (Event) o;
				if (!events[event.getIndex()]) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean addAll(Collection<? extends E> c) {
		for (E event : c) {
			if (!add(event)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeAll(Collection<?> c) {
		for (Object o : c) {
			if (!remove(o)) {
				return false;
			}
		}
		return true;
	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("retainAll not supported!");
	}

	public void clear() {
		for (int i = 0; i < events.length; i++) {
			events[i] = false;
		}
	}
}
