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

import java.util.Collections;
import java.util.List;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public enum BuiltinFunctionDescriptor {
	
	UNIT(
			"unit",
			new Signature(
					Collections.<DataType>singletonList(TypeSystemFactory.eINSTANCE.createRealType()),
					TypeSystemFactory.eINSTANCE.createUnitType()));
	
//	SUM(
//			"sum",
//			new ISignature() {
//				
//				public List<DataType> evaluateOutputParameterDataTypes(DataType targetDataType, List<DataType> inputDataTypes) {
//					if (targetDataType instanceof TensorType && inputDataTypes.isEmpty()) {
//						TensorType tensorType = (TensorType) targetDataType;
//						if (tensorType.getDimensionality() == 1) {
//							return Collections.<DataType>singletonList(tensorType.getElementType());
//						}
//					}
//					return null;
//				}
//				
//			});

	private String name;
	private ISignature signature;

	BuiltinFunctionDescriptor(String name, ISignature signature) {
		this.name = name;
		this.signature = signature;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	public static BuiltinFunctionDescriptor get(String name, List<DataType> inputParameterDataTypes) {
		for (BuiltinFunctionDescriptor descriptor : values()) {
			if (descriptor.name.equals(name) && descriptor.signature.evaluateOutputParameterDataTypes(inputParameterDataTypes) != null) {
				return descriptor;
			}
		}
		return null;
	}
	
}
