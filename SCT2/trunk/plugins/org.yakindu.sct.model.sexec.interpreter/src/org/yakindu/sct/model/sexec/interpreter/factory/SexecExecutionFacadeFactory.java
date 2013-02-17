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
package org.yakindu.sct.model.sexec.interpreter.factory;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.interpreter.InterpreterModule;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.util.Modules;

/**
 * Factory registered via extension point
 * 'org.yakindu.sct.simulation.core.executionfactory'
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SexecExecutionFacadeFactory implements IExecutionFacadeFactory {

	@Inject
	protected IModelSequencer sequencer;
	@Inject
	protected IExecutionFlowInterpreter interpreter;

	public SexecExecutionFacadeFactory() {
		Guice.createInjector(
				Modules.override(new SequencerModule()).with(
						new InterpreterModule())).injectMembers(this);
	}

	public IExecutionFlowInterpreter createExecutionFacade(Statechart statechart) {
		ExecutionFlow flow = sequencer.transform(statechart);
		interpreter.initialize(flow);
		return interpreter;

	}

	public boolean isApplicable(Statechart statechart) {
		return statechart.eResource().getURI().fileExtension().equals("sct");
	}

   
}
