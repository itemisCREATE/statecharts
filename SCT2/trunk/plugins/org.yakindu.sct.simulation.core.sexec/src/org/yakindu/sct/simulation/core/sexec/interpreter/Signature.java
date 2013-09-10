/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.Arrays;


/**
 * This class represents a function signature consisting of the function name and the parameter types.
 * Instances are used as keys for function mappings.
 * 
 * @author axel terfloth 
 */
public class Signature {
	
	protected String name;
	protected Class<?>[] paramTypes;

	public Signature(String name, Class<?>[] paramTypes) {
		super();
		this.name = name;
		this.paramTypes = paramTypes;
	}

	
	public String getName() {
		return name;
	}

	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(paramTypes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signature other = (Signature) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(paramTypes, other.paramTypes))
			return false;
		return true;
	}
	
	

}
