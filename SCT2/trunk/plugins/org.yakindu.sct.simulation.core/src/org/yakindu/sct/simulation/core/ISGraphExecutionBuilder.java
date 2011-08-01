/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphExecutionBuilder {
	/**
	 * Returns an execution facade for a statechart model. Execution Builder can
	 * be registered via extension point
	 * "org.yakindu.sct.simulation.core.sgraph.executionbuilder"
	 * 
	 * @param statechart
	 * @return
	 */
	public ISGraphExecutionFacade build(Statechart statechart);
}
