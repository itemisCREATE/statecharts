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
package org.yakindu.sct.simulation.core.engine;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISimulationEngine {

	public IExecutionControl getExecutionControl();
	
	public ExecutionContext getExecutionContext();
	
	public void setExecutionContext(ExecutionContext context);

}
