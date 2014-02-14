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
package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;

/**
 * Called during simulation when an {@link Operation} is executed. Allows to
 * implement Mockups for operation calls.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IOperationMockup {
	/**
	 * Called before an operation is executed
	 * 
	 * @return true if the implementation provides a mockup for the given
	 *         definition, false otherwise
	 */
	public boolean canExecute(Operation definition, Object[] parameter);

	public boolean canExecute(FeatureCall call, Object[] parameter);

	/**
	 * Called when the operation is executed
	 * 
	 * @return the operations return value, maybe null
	 */
	public Object execute(Operation definition, Object[] parameter);

	public Object execute(FeatureCall definition, Object[] parameter);

}
