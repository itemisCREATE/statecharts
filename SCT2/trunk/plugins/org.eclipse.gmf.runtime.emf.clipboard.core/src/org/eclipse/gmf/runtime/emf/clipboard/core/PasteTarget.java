/******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * A class which stores the target object for the paste operation.
 * 
 * @author Christian Vogt (cvogt)
 */
public class PasteTarget {

	/**
	 * The paste target object.
	 */
	private Object target;
	
	/**
	 * True if the target object is of type <code>Resource</code>.
	 */
	private boolean isResource;

	/**
	 * Constructs a <code>PasteTarget</code> for the given
	 * <code>EObject</code>.
	 * 
	 * @param target the 
	 */
	public PasteTarget(EObject target) {
		this.target = target;
		this.isResource = false;
	}
	
	/**
	 * Constructs a <code>PasteTarget</code> for the given
	 * <code>Resource</code>.
	 * 
	 * @param target the 
	 */
	public PasteTarget(Resource target) {
		this.target = target;
		this.isResource = true;
	}
	
	/**
	 * Return the underlying target object.
	 * 
	 * @return the target object
	 */
	public Object getObject() {
		return target;
	}
	
	
	/**
	 * Return true if the target object is of type <code>Resource</code>.
	 * 
	 * @return true if the target object is of type <code>Resource</code>
	 */
	public boolean isResource() {
		return isResource;
	}
}
