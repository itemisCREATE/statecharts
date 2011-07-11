/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.internal.il.builtin;

import java.util.Collections;
import java.util.List;

import org.eclipselabs.mscript.language.il.builtin.Signature;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class UnitSignature extends Signature {

	public UnitSignature() {
		super(createInputDataTypes(), TypeSystemFactory.eINSTANCE.createUnitType());
	}
	
	private static List<DataType> createInputDataTypes() {
		RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
		realType.setUnit(TypeSystemUtil.createUnit());
		return Collections.<DataType>singletonList(realType);
	}

}
