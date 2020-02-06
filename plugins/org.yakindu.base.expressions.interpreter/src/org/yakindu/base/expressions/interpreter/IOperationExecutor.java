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
package org.yakindu.base.expressions.interpreter;

import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.model.sruntime.ExecutionContext;

/**
 * Called during simulation when an {@link Operation} is executed. Allows to
 * implement Mockups for operation calls.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IOperationExecutor {
	/**
	 * Called before an operation is executed
	 * 
	 * @return true if the implementation provides an implementation for the given
	 *         definition, false otherwise
	 */
	public boolean canExecute(ArgumentExpression expression, ExecutionContext context);

	/**
	 * Called when the operation is executed
	 * 
	 * @return the operations return value, maybe null
	 */
	public Object execute(ArgumentExpression expression, ExecutionContext context);

	/**
	 * @author Johannes Dicks - Initial contribution and API
	 */
	public static final class NullOperationMock implements IOperationExecutor {

		@Override
		public boolean canExecute(ArgumentExpression expression, ExecutionContext context) {
			return false;
		}

		@Override
		public Object execute(ArgumentExpression expression, ExecutionContext context) {
			return null;
		}
	}

}
