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

package org.eclipselabs.mscript.language.imperativemodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeModelUtil {

	public static DataType getDataType(EObject eObject) {
		DataTypeAdapter adapter = (DataTypeAdapter) EcoreUtil.getAdapter(eObject.eAdapters(), DataTypeAdapter.class);
		return adapter != null ? adapter.getDataType() : null;
	}
	
	public static void adaptDataType(EObject eObject, DataType dataType) {
		eObject.eAdapters().add(new DataTypeAdapter(dataType));
	}
	
}
