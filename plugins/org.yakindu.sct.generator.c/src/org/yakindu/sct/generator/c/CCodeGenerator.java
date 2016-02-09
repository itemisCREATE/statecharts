/**
 * Copyright (c) 2012, 2015 Committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	
 * Andreas Mülder  - Initial API and implementation
 * Alexander Nyßen - Support for 'Tracing' feature
 * 
 */
package org.yakindu.sct.generator.c;

import org.yakindu.sct.domain.generic.modules.GenericSequencerModule;
import org.yakindu.sct.generator.c.features.ICFeatureConstants;
import org.yakindu.sct.generator.c.types.CTypeSystemAccess;
import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * Provides a C code generator implementation that is based on SExec.
 * 
 * @author Andreas Mülder
 * @author Alexander Nyßen
 * 
 */
public class CCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart statechart, GeneratorEntry entry) {
		CGenerator delegate = getInjector(entry).getInstance(CGenerator.class);
		ExecutionFlow flow = createExecutionFlow(statechart, entry);
		if (debugFeatureHelper.isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}
		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}

	@Override
	protected Module getOverridesModule(final GeneratorEntry entry) {
		Module module = super.getOverridesModule(entry);

		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {

				binder.bind(GeneratorEntry.class).toInstance(entry);
				binder.bind(INamingService.class).to(CNamingService.class);
				binder.bind(ICodegenTypeSystemAccess.class).to(CTypeSystemAccess.class);

				// Enable generation of trace steps in case the Tracing feature
				// is specified and at least one of enter/exit states is
				// enabled.
				FeatureConfiguration tracingFeatureConfiguration = entry
						.getFeatureConfiguration(ICFeatureConstants.FEATURE_TRACING);
				if (tracingFeatureConfiguration != null && ((tracingFeatureConfiguration
						.getParameterValue(ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE) != null
						&& tracingFeatureConfiguration
								.getParameterValue(ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE)
								.getBooleanValue() == true)
						|| (tracingFeatureConfiguration
								.getParameterValue(ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE) != null
								&& tracingFeatureConfiguration
										.getParameterValue(ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE)
										.getBooleanValue() == true))) {
					binder.bind(Boolean.class).annotatedWith(Names.named(GenericSequencerModule.ADD_TRACES))
							.toInstance(Boolean.TRUE);
				}
			}
		});
	}
}
