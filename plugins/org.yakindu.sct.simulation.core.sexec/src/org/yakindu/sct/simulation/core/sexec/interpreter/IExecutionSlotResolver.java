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

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
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
	
	// TODO use Expression instead of EObject
	ExecutionSlot resolveVariable(ExecutionContext context, EObject expression);
	
	ExecutionEvent resolveEvent(ExecutionContext context, Expression expression);
}
