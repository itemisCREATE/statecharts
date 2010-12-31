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

package org.eclipselabs.mscript.language.il.util;

import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public enum BuiltinFunctionDescriptor {
	
	UNIT(
			"unit",
			BuiltinFunctionDescriptor.PROPERTY,
			new FixedSignature(
					TypeSystemFactory.eINSTANCE.createRealType(),
					TypeSystemFactory.eINSTANCE.createUnitType()));

	public static final int FUNCTION = 0x01;
	public static final int PROPERTY = 0x02;
	public static final int OPERATION = 0x04;
	
	private String name;
	private int kind;
	private ISignature signature;

	BuiltinFunctionDescriptor(String name, int kind, ISignature signature) {
		this.name = name;
		this.kind = kind;
		this.signature = signature;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the kind
	 */
	public int getKind() {
		return kind;
	}
	
	/**
	 * @return the signature
	 */
	public ISignature getSignature() {
		return signature;
	}
	
	/**
	 * 
	 */
	public static BuiltinFunctionDescriptor get(String name) {
		for (BuiltinFunctionDescriptor builtinFunctions : values()) {
			if (builtinFunctions.name.equals(name)) {
				return builtinFunctions;
			}
		}
		return null;
	}
	
}
