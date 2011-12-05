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
package org.yakindu.sct.model.sexec.interpreter;

import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IStatementInterpreter {
	/**
	 * 
	 * @param statement
	 * @param context
	 * @return
	 * @throws ExecutionException
	 */
	public Object evaluateStatement(Statement statement,
			IExecutionContext context) throws ExecutionException;

}
