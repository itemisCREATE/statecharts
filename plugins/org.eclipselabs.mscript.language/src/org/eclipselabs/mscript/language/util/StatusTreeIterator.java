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

package org.eclipselabs.mscript.language.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.AbstractTreeIterator;

/**
 * @author Andreas Unger
 *
 */
public class StatusTreeIterator extends AbstractTreeIterator<IStatus> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param object
	 */
	public StatusTreeIterator(IStatus status, boolean includeRoot) {
		super(status, includeRoot);
	}

	@Override
	public Iterator<IStatus> getChildren(Object object) {
		IStatus status = (IStatus) object;
		if (status.isMultiStatus()) {
			return Arrays.asList(status.getChildren()).iterator();
		}
		return Collections.<IStatus>emptyList().iterator();
	}

}
