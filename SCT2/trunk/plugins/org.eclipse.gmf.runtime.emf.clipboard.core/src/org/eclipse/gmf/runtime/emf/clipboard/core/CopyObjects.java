/******************************************************************************
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A data structure that holds info needed through the copy process
 * @author Yasser Lulu 
 */
public class CopyObjects {
	
	public boolean sortTotalCopyObjects = true;

	public Collection originalObjects;

	public Map copyParent2CopyMap = new HashMap();

	public Map copyParent2ObjectsMap = new HashMap();

	public Map copyAlwaysMap = new HashMap();

	public Set combinedCopyAlwaysSet = new HashSet();

	public Map objectsToCopyParentMap = new HashMap();

	public Set totalCopyObjects = new HashSet();

	/**
	 * Initializes me with my original objects.
	 * 
	 * @param originalObjects the objects originally selected for copying
	 */
	public CopyObjects(Collection originalObjects) {
		this.originalObjects = originalObjects;
	}
	
	public void clear(){
		originalObjects.clear();
		copyParent2CopyMap.clear();
		copyAlwaysMap.clear();
		combinedCopyAlwaysSet.clear();
		objectsToCopyParentMap.clear();
		totalCopyObjects.clear();		
	}

}
