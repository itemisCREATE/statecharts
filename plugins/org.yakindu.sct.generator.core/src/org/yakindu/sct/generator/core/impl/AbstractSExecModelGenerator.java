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

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.DEBUG_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.DEBUG_FEATURE_DUMP_SEXEC;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_CHOICES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_REACTIONS;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xpand2.output.Output;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
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

	private static final String SEXEC_FILE_EXTENSION = "sexec";
	private static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";
	private final MessageConsoleStream info;
	private final MessageConsoleStream error;

	protected abstract void generate(ExecutionFlow flow, GeneratorEntry entry);

	public AbstractSExecModelGenerator() {
		super();
		info = getConsole().newMessageStream();
		error = getConsole().newMessageStream();
		error.setActivateOnWrite(true);
	}

	@Override
	protected void finalize() throws Throwable {
		info.close();
		error.close();
		super.finalize();
	}

	public final void generate(GeneratorEntry entry) {
		writeToConsole(String.format("Generating Statechart %s ...", entry
				.getStatechart().getName()));
		try {
			prepareGenerator(entry);
			generate(createExecutionFlow(entry.getStatechart(), entry), entry);
			writeToConsole("Done.");
		} catch (Exception e) {
			writeToConsole(e);
		} finally {
			finishGenerator(entry);
		}
	}

	/**
	 * override this method to do any setup needed before generation
	 */
	protected void prepareGenerator(GeneratorEntry entry) {
		// override if needed
	}

	/**
	 * override this method to do any cleanup needed after generation
	 */
	protected void finishGenerator(GeneratorEntry entry) {
		// override if needed
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	protected ExecutionFlow createExecutionFlow(Statechart statechart,
			GeneratorEntry entry) {
		Injector injector = Guice.createInjector(new SequencerModule());
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow, "Error creation ExecutionFlow");

		FeatureConfiguration optimizeConfig = entry
				.getFeatureConfiguration(FUNCTION_INLINING_FEATURE);

		FlowOptimizer optimizer = injector.getInstance(FlowOptimizer.class);

		optimizer.inlineReactions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_REACTIONS, true));
		optimizer.inlineExitActions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS, true));
		optimizer.inlineEntryActions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS, true));
		optimizer.inlineEnterSequences(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES, true));
		optimizer.inlineExitSequences(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES, true));
		optimizer.inlineChoices(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_CHOICES, true));
		optimizer.inlineEnterRegion(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION, true));
		optimizer.inlineExitRegion(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION, true));

		flow = optimizer.transform(flow);

		return flow;
	}

	boolean getBoolValue(FeatureConfiguration conf, String param,
			boolean defaultValue) {
		if (conf != null && conf.getParameterValue(param) != null) {
			return conf.getParameterValue(param).getBooleanValue();
		}

		return defaultValue;
	}

	protected final void writeToConsole(Throwable t) {
		PrintWriter printWriter = new PrintWriter(error);
		t.printStackTrace(printWriter);
		printWriter.flush();
		printWriter.close();
	}

	protected final void writeToConsole(String line) {
		info.println(line);
	}

	private MessageConsole getConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (SCT_GENERATOR_CONSOLE.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		MessageConsole myConsole = new MessageConsole(SCT_GENERATOR_CONSOLE,
				null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	protected final void refreshTargetProject(GeneratorEntry entry) {
		try {
			IProject project = getTargetProject(entry);
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	};

	protected final IProject getTargetProject(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		String projectName = outletConfig.getParameterValue(
				OUTLET_FEATURE_TARGET_PROJECT).getStringValue();
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);
		if (!project.exists()) {
			createProject(project, entry);
		}
		return project;
	}

	/**
	 * The default implementation only creates a new default project. Clients
	 * may override if they want to contribute generatorspecific project setup
	 */
	protected void createProject(IProject project, GeneratorEntry entry) {
		try {
			NullProgressMonitor monitor = new NullProgressMonitor();
			project.create(monitor);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected FeatureConfiguration getOutletFeatureConfiguration(
			GeneratorEntry entry) {
		FeatureConfiguration outletConfig = entry
				.getFeatureConfiguration(OUTLET_FEATURE);
		return outletConfig;
	}

	protected boolean isDumpSexec(GeneratorEntry entry) {
		FeatureParameterValue dumpSexec = getFeatureParameter(entry,
				DEBUG_FEATURE, DEBUG_FEATURE_DUMP_SEXEC);
		if (dumpSexec == null) {
			return false;
		}
		return dumpSexec.getBooleanValue();
	}

	protected FeatureParameterValue getFeatureParameter(GeneratorEntry entry,
			String featureName, String paramName) {
		FeatureConfiguration feature = entry
				.getFeatureConfiguration(featureName);

		if (feature != null) {
			return feature.getParameterValue(paramName);
		}

		return null;
	}

	protected void dumpSexec(GeneratorEntry entry, ExecutionFlow flow,
			Output output) {

		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		URI fileURI = entry.getStatechart().eResource().getURI()
				.trimFileExtension().appendFileExtension(SEXEC_FILE_EXTENSION);
		// URI fileURI = URI.createFileURI(new
		// File("mylibrary.xmi").getAbsolutePath());

		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(flow);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}

}
