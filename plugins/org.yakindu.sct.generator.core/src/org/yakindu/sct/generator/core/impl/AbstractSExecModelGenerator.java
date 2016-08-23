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

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_CHOICES;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTRIES;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES;
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.FUNCTION_INLINING_FEATURE_INLINE_REACTIONS;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSExecModelGenerator extends AbstractSGraphModelGenerator {

	private static final String SEXEC_FILE_EXTENSION = "sexec";
	public static final String ADD_TRACES = "ADD_TRACES";

	@Inject
	private FlowOptimizer optimizer;
	@Inject
	private IModelSequencer sequencer;

	public AbstractSExecModelGenerator() {
		super();
	}

	@Override
	protected void runGenerator(Statechart statechart, GeneratorEntry entry) {
		if (this instanceof IExecutionFlowGenerator) {
			IExecutionFlowGenerator flowGenerator = (IExecutionFlowGenerator) this;
			flowGenerator.generate(createExecutionFlow(statechart, entry), entry, sctFsa);
		}
		super.runGenerator(statechart, entry);
	}

	@Override
	public Module getOverridesModule(GeneratorEntry entry) {
		Module module = super.getOverridesModule(entry);

		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {
				// by default, traces should not be generated
				binder.bind(Boolean.class).annotatedWith(Names.named(ADD_TRACES))
						.toInstance(Boolean.FALSE);
			}
		});
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	protected ExecutionFlow createExecutionFlow(Statechart statechart, GeneratorEntry entry) {
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow, "Error creation ExecutionFlow");

		FeatureConfiguration optimizeConfig = entry.getFeatureConfiguration(FUNCTION_INLINING_FEATURE);

		optimizer.inlineReactions(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_REACTIONS, false));
		optimizer.inlineExitActions(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS, false));
		optimizer.inlineEntryActions(
				getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS, false));
		optimizer.inlineEnterSequences(
				getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES, false));
		optimizer.inlineExitSequences(
				getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES, false));
		optimizer.inlineChoices(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_CHOICES, false));
		optimizer.inlineEntries(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_ENTRIES, false));
		optimizer.inlineEnterRegion(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION, false));
		optimizer.inlineExitRegion(getBoolValue(optimizeConfig, FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION, false));

		flow = optimizer.transform(flow);

		return flow;
	}

	protected boolean getBoolValue(FeatureConfiguration conf, String param, boolean defaultValue) {
		if (conf != null && conf.getParameterValue(param) != null) {
			return conf.getParameterValue(param).getBooleanValue();
		}

		return defaultValue;
	}

	protected void dumpSexec(GeneratorEntry entry, ExecutionFlow flow) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		URI fileURI = entry.getElementRef().eResource().getURI().trimFileExtension()
				.appendFileExtension(SEXEC_FILE_EXTENSION);
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(flow);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}

}
