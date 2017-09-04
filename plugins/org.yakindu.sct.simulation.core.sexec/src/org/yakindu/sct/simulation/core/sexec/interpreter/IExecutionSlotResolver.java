/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

import com.google.inject.ImplementedBy;

/**
 * Resolves execution variables and events for given context and expression.
 * 
 * @author Thomas Kutz
 *
 */
@ImplementedBy(DefaultExecutionSlotResolver.class)
public interface IExecutionSlotResolver {
	
	/**
	 * Resolves for a given {@link Expression} the corresponding {@link ExecutionSlot} within the given {@link ExecutionContext}.
	 * 
	 * @param context
	 * @param expression
	 * @return
	 */
	ExecutionSlot resolve(ExecutionContext context, Expression expression);

}
