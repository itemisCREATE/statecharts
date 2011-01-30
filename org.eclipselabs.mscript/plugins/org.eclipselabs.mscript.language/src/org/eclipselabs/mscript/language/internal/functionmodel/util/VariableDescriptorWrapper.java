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

package org.eclipselabs.mscript.language.internal.functionmodel.util;

public class VariableDescriptorWrapper {
	
	private String name;
	private int step;
	private boolean initial;
	
	/**
	 * 
	 */
	public VariableDescriptorWrapper(String name, int step) {
		this(name, step, false);
	}
	
	/**
	 * 
	 */
	public VariableDescriptorWrapper(String name, int step, boolean initial) {
		this.name = name;
		this.step = step;
		this.initial = initial;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode() ^ step ^ (initial ? 1 : 0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof VariableDescriptorWrapper) {
			VariableDescriptorWrapper other = (VariableDescriptorWrapper) obj;
			return other.name.equals(name) && other.step == step && other.initial == initial;
		}
		return false;
	}
	
}