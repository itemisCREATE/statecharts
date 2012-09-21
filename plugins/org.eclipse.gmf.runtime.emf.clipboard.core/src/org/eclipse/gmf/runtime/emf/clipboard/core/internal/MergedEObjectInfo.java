/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Yasser Lulu 
 */
public class MergedEObjectInfo {

	public String mergedEObjectID;

	public EObject mergedEObject;

	public List targetEObjects;

	/**
	 * 
	 */
	public MergedEObjectInfo() {
		targetEObjects = new ArrayList();
	}
}