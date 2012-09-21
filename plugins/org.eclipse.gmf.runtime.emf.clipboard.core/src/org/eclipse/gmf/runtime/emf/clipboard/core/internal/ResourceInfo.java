/******************************************************************************
 * Copyright (c) 2002, 2009 IBM Corporation and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;


/**
 * Meta-data on the resource that is serialized to a string by the copy
 * operation.  The resource info is (de)serialized by the
 * {@link ResourceInfoProcessor}.
 * 
 * @author Yasser Lulu
 * 
 * @see ResourceInfoProcessor
 */
public class ResourceInfo {

	/**
	 * Initializes me.
	 */
	public ResourceInfo() {
		super();
	}

	public String data;

	String info;

	String version;

	String type;

	public String encoding;

	public Map objects = new LinkedHashMap();

	private Map objectInfoTypeMap;

	Map getObjectInfoTypeMap() {
		if (objectInfoTypeMap == null) {
			objectInfoTypeMap = new HashMap();
			Iterator it = objects.values().iterator();
			ObjectInfo objectInfo = null;
			while (it.hasNext()) {
				objectInfo = (ObjectInfo) it.next();
				List list = (List)objectInfoTypeMap
					.get(objectInfo.objCopyType);
				if (list == null) {
					list = new ArrayList();
					objectInfoTypeMap.put(objectInfo.objCopyType, list);
				}
				list.add(objectInfo);
			}
		}
		return objectInfoTypeMap;
	}

	List getObjectInfoTypes(String objectInfoType) {
		List list = (List)getObjectInfoTypeMap().get(objectInfoType);
		return (list != null) ? list
			: Collections.EMPTY_LIST;
	}

	void completeEObjectInitialization() {
		Iterator it = objects.values().iterator();
		ObjectInfo objectInfo = null;
		while (it.hasNext()) {
			objectInfo = (ObjectInfo) it.next();
			objectInfo
				.makeCopyAlwaysObjectInfoList(getObjectInfoTypes(ObjectCopyType.OBJ_COPY_TYPE_ALWAYS));
		}
	}

}