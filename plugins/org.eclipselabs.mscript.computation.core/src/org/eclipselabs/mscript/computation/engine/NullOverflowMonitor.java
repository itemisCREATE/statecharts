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

package org.eclipselabs.mscript.computation.engine;

/**
 * @author Andreas Unger
 *
 */
public class NullOverflowMonitor implements IOverflowMonitor {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.IOverflowMonitor#overflow(org.eclipselabs.mscript.computation.engine.OverflowEvent)
	 */
	public void handleOverflow(OverflowInfo info) {
	}
	
}
