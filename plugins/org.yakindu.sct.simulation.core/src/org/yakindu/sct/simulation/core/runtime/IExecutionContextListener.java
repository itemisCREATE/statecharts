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
package org.yakindu.sct.simulation.core.runtime;

import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExecutionContextListener {

	/**
	 * called when an event is raised
	 */
	public void eventRaised(ExecutionEvent event);

	/**
	 * called when a variable value changed
	 */
	public void slotValueChanged(AbstractSlot variable);
}
