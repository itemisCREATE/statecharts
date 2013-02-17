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

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.sct.model.sexec.interpreter.impl.ExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.interpreter.impl.TimerTaskTimingService;
import org.yakindu.sct.model.sexec.interpreter.stext.StextStatementInterpreter;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;
import org.yakindu.sct.model.stext.types.STextDefaulTypeSystem;
import org.yakindu.sct.model.stext.types.STextDefaultTypeInferrer;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionContextImpl;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen (alexander.nyssen@itemis.de) - Refactored to
 *         AbstractGenericModule to allow subclasses to overwrite bindings
 * 
 */
public class InterpreterModule extends AbstractGenericModule {

	public static final String INTERPRETER_NAME = "InterpreterName";

	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(Boolean.class)
				.annotatedWith(Names.named(SequencerModule.ADD_TRACES))
				.toInstance(Boolean.TRUE);
		binder.bind(String.class).annotatedWith(Names.named(INTERPRETER_NAME))
				.toInstance("SExecution Interpreter");
	}
	
	public Class<? extends ITimingService> bindITimingService(){
		return TimerTaskTimingService.class;
	}
	
	public Class<? extends IExecutionContext> bindIExecutionContext(){
		return ExecutionContextImpl.class;
	}
	
	public Class<? extends IStatementInterpreter> bindIStatementInterpreter(){
		return StextStatementInterpreter.class;
	}
	
	public Class<? extends IExecutionFlowInterpreter> bindIExecutionFlowInterpreter(){
		return ExecutionFlowInterpreter.class;
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	public Class<? extends ITypeSystem> bindITypeSystem() {
		return STextDefaulTypeSystem.class;
	}

	public Class<? extends ISTextTypeSystem> bindISTextTypeSystem() {
		return STextDefaulTypeSystem.class;
	}
	
	public Class<? extends ISTextTypeInferrer> bindISTextTypeInferrer(){
		return STextDefaultTypeInferrer.class;
	}
}
