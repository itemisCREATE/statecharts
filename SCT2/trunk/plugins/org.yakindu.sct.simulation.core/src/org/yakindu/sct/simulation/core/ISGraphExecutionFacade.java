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

/**
 * Facade for executable statechart implementation.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphExecutionFacade {

	public void enter();

	public void runCycle();

	public void addExecutionListener(ISGraphExecutionListener listener);

	public void removeExecutionListener(ISGraphExecutionListener listener);

	public ISGraphExecutionScope getExecutionScope();
}
