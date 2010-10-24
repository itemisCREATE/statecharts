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

package org.eclipselabs.mscript.language.internal.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.ecore.EObject;

public class TreeIterator extends AbstractTreeIterator<EObject> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param object
	 */
	public TreeIterator(EObject object, boolean includeRoot) {
		super(object, includeRoot);
	}

	@Override
	public Iterator<EObject> getChildren(Object object) {
		return ((EObject) object).eContents().iterator();
	}

}
