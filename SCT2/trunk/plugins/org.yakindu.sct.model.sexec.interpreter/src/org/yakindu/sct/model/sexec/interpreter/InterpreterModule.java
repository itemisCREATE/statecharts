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

import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.impl.BaseTypeSystemAccessImpl;
import org.yakindu.sct.model.sexec.interpreter.impl.ExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.interpreter.impl.TimerTaskTimingService;
import org.yakindu.sct.model.sexec.interpreter.stext.StextStatementInterpreter;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionContextImpl;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InterpreterModule implements Module {

	public static final String INTERPRETER_NAME = "InterpreterName";

	public void configure(Binder binder) {
		binder.bind(Boolean.class)
				.annotatedWith(Names.named(SequencerModule.ADD_TRACES))
				.toInstance(Boolean.TRUE);
		binder.bind(String.class).annotatedWith(Names.named(INTERPRETER_NAME))
				.toInstance("SExecution Interpreter");
		binder.bind(IStatementInterpreter.class).to(
				StextStatementInterpreter.class);
		binder.bind(IExecutionContext.class).to(ExecutionContextImpl.class);
		binder.bind(ITimingService.class).to(TimerTaskTimingService.class);
		binder.bind(IExecutionFlowInterpreter.class).to(
				ExecutionFlowInterpreter.class);
		binder.bind(ITypeSystemAccess.class).to(BaseTypeSystemAccessImpl.class);
	}
}
