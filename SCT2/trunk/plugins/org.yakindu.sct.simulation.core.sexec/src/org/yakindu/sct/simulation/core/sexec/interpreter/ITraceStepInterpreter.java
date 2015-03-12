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

import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultTraceStepInterpreter.class)
public interface ITraceStepInterpreter {

	public void evaluate(Trace trace, ExecutionContext context);

}
