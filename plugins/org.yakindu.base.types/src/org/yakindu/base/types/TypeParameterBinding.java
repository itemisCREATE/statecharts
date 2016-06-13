/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TypeParameterBinding extends AdapterImpl {

	private Type actualType;

	public TypeParameterBinding(Type actualType) {
		this.actualType = actualType;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return TypeParameterBinding.class == type;
	}

	public Type getActualType() {
		return actualType;
	}
}