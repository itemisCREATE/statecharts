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
package org.yakindu.sct.simulation.core.runtime.impl;

import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;


/**
 * Read only access to ScopeVariables. Value can only be changed via
 * {@link IExecutionContext}#setVariableValue
 * 
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 * 
 */
public class ExecutionVariable extends AbstractSlot {

	public ExecutionVariable(String name, InferredType type, Object value) {
		super(name, type, value);
	}

}