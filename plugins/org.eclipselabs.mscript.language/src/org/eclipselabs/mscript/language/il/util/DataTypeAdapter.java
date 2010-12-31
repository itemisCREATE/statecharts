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

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeAdapter extends AdapterImpl {

	private DataType dataType;
	
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == DataTypeAdapter.class;
	}
	
}
