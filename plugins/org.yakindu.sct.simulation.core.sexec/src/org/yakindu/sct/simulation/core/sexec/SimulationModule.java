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
package org.yakindu.sct.simulation.core.sexec;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.container.DefaultExecutionContextInitializer;
import org.yakindu.sct.simulation.core.sexec.container.DefaultSimulationEngineFactory;
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer;
import org.yakindu.sct.simulation.core.sexec.container.ISimulationEngineFactory;
import org.yakindu.sct.simulation.core.sexec.interpreter.DefaultExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.DefaultTimingService;
import org.yakindu.sct.simulation.core.sexec.interpreter.DefaultTraceStepInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.IOperationMockup;
import org.yakindu.sct.simulation.core.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.ITimingService;
import org.yakindu.sct.simulation.core.sexec.interpreter.ITraceStepInterpreter;
import org.yakindu.sct.simulation.core.sexec.interpreter.JavaOperationMockup;
import org.yakindu.sct.simulation.core.sexec.interpreter.StextStatementInterpreter;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.impl.ExecutionContextImpl;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Default Module used by the {@link ISimulationEngine}. Override bindings to
 * specify custom behavior.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationModule extends AbstractGenericModule {

	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(Boolean.class).annotatedWith(Names.named(SequencerModule.ADD_TRACES)).toInstance(Boolean.TRUE);
	}

	public Class<? extends IExecutionContextInitializer> bindIExecutionContextInitializer() {
		return DefaultExecutionContextInitializer.class;
	}

	public Class<? extends ISimulationEngineFactory> bindISimulationEngineFactory() {
		return DefaultSimulationEngineFactory.class;
	}

	public Class<? extends ITraceStepInterpreter> bindITraceStepInterpreter() {
		return DefaultTraceStepInterpreter.class;
	}

	public Class<? extends IModelSequencer> bindIModelSequencer() {
		return ModelSequencer.class;
	}

	public Class<? extends IOperationMockup> bindIOperationMockup() {
		return JavaOperationMockup.class;
	}

	public Class<? extends ExecutionContext> bindExecutionContext() {
		return ExecutionContextImpl.class;
	}

	public Class<? extends IExecutionFlowInterpreter> bindIExecutionFlowInterpreter() {
		return DefaultExecutionFlowInterpreter.class;
	}

	public Class<? extends ITimingService> bindITimingService() {
		return DefaultTimingService.class;
	}

	public Class<? extends IStatementInterpreter> bindIStatementInterpreter() {
		return StextStatementInterpreter.class;
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	public Class<? extends ITypeSystemInferrer> bindISTextTypeInferrer() {
		return STextTypeInferrer.class;
	}
	
	public Class<? extends IResourceDescriptions> bindIResourceDescriptions() {
		return ResourceSetBasedResourceDescriptions.class;
	}

}
