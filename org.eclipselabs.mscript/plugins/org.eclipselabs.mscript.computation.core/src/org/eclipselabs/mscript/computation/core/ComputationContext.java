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

import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class ComputationContext implements IComputationContext {

	private ComputationModel computationModel;
	
	private IOverflowMonitor overflowMonitor;

	public ComputationContext() {
		this(ComputationModelUtil.constructDefaultComputationModel());
	}

	public ComputationContext(ComputationModel computationModel) {
		this(computationModel, new NullOverflowMonitor());
	}

	public ComputationContext(ComputationModel computationModel, IOverflowMonitor overflowMonitor) {
		this.computationModel = computationModel;
		this.overflowMonitor = overflowMonitor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.IComputationContext#getComputationModel()
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.IComputationContext#getOverflowMonitor()
	 */
	public IOverflowMonitor getOverflowMonitor() {
		return overflowMonitor;
	}

}
