/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.container;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

/**
 * Factory interface to create implementations of {@link ISimulationEngine}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISimulationEngineFactory {

	public ISimulationEngine createExecutionContainer(Statechart statechart, ILaunch launch) throws CoreException;
}
