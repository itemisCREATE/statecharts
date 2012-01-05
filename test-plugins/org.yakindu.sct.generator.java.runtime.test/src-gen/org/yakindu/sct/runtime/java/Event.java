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

public class Event<Type extends Enum<Type>> {

	private Type id;

	private int offset;

	public Event(Type id, int offset) {
		this.id = id;
		this.offset = offset;
	}

	public Type getId() {
		return id;
	}

	public int getIndex() {
		return offset + id.ordinal();
	}
}
