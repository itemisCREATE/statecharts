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
package org.yakindu.sct.generator.core.impl;

import org.eclipse.core.runtime.Assert;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSExecModelGenerator implements ISCTGenerator {

	protected abstract void generate(ExecutionFlow flow, GeneratorEntry entry);

	public final void generate(GeneratorEntry entry) {
		generate(createExecutionFlow(entry.getStatechart()), entry);
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	protected ExecutionFlow createExecutionFlow(Statechart statechart) {
		Injector injector = Guice.createInjector(new SequencerModule());
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow, "Error creation ExecutionFlow");
		return flow;
	}

}
