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

package org.eclipselabs.mscript.computation.core;

/**
 * @author Andreas Unger
 *
 */
public class OverflowMonitor implements IOverflowMonitor {

	private boolean overflowed;

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.IOverflowMonitor#overflow(org.eclipselabs.mscript.computation.core.OverflowEvent)
	 */
	public void handleOverflow(OverflowInfo info) {
		overflowed = true;
	}
	
	public boolean hasOverflowed() {
		return overflowed;
	}
	
}
