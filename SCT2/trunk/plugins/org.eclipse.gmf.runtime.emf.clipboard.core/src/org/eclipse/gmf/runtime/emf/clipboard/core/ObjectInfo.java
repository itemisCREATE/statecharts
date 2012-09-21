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

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data structure storing meta-data related to the copying of an element.
 * 
 * @author Yasser Lulu 
 */
public class ObjectInfo {

	private static final int NONE = -1;

	/** Indicates the reason why the corresponding object was copied. */
	public String objCopyType;

	/** The corresponding object's original ID. */
	public String objId;

	/**
	 * The corresponding object's original container's ID. This can be different
	 * from the "parent" object's ID in cases where the "parent" object is not
	 * the copied object's direct container.
	 */
	public String containerId;

	/**
	 * Fully-qualified name of the corresponding object's original parent's class
	 */
	public String containerClass;

	/** The copy hints associated with the corresponding object. */
	public String hints;

	/**
	 * The corresponding object's original parent's ID. This can be different
	 * from the "container" object's ID in cases where the "parent" object is not
	 * the copied object's direct container.
	 */
	public String copyParentId;

	/**
	 * IDs of objects related to the corresponding element that must be
	 * copied along with it.
	 */
	public List copyAlwaysIds;

	/**
	 * The <code>ObjectInfo</code> meta-data for the associated copy-always
	 * objects, corresponding one-for-one with the {@link #copyAlwaysIds}.
	 * 
	 * @see #copyAlwaysIds
	 */
	private List alwaysCopyEObjectInfoList;

	/**
	 * Initializes me.
	 */
	public ObjectInfo() {
		copyAlwaysIds = new ArrayList();
		alwaysCopyEObjectInfoList = new ArrayList();
	}

	/**
	 * Queries whether my hints include the specified <code>hint</code>.
	 * 
	 * @param hint a hint to look for
	 * @return <code>true</code> if I have this hint; <code>false</code>,
	 *     otherwise
	 */
	public boolean hasHint(String hint) {
		return hints.indexOf(hint) != NONE;
	}

	public void makeCopyAlwaysObjectInfoList(List allCopyAlwaysObjectsInfoList) {
		Iterator it = allCopyAlwaysObjectsInfoList.iterator();
		ObjectInfo objInfo = null;
		while (it.hasNext()) {
			objInfo = (ObjectInfo) it.next();
			if (copyAlwaysIds.contains(objInfo.objId)) {
				alwaysCopyEObjectInfoList.add(objInfo);
			}
		}
	}

	/**
	 * Obtains the <code>ObjectInfo</code> meta-data for the associated
	 * copy-always objects, corresponding one-for-one with the 
	 * {@link #copyAlwaysIds}.
	 * 
	 * @return the copy-always object <code>ObjectInfo</code>s
	 * 
	 * @see #copyAlwaysIds
	 */
	public List getCopyAlwaysObjectInfoList() {
		return alwaysCopyEObjectInfoList;
	}

}