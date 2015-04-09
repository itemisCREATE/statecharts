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

import java.io.File;
import java.io.PrintWriter;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.generator.core.IGeneratorBridge;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.util.GeneratorUtils;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSGraphModelGenerator implements ISCTGenerator {

	public static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";
	private final MessageConsoleStream info;
	private final MessageConsoleStream error;

	protected final IGeneratorBridge bridge = new IGeneratorBridge() {

		public void writeToConsole(Throwable t) {
			AbstractSGraphModelGenerator.this.writeToConsole(t);
		}

		public void writeToConsole(String s) {
			AbstractSGraphModelGenerator.this.writeToConsole(s);
		}

		public FeatureParameterValue getFeatureParameter(GeneratorEntry entry, String featureName, String paramName) {
			return GeneratorUtils.getFeatureParameter(entry, featureName, paramName);
		}

		public void refreshTargetProject(GeneratorEntry entry) {
			GeneratorUtils.refreshTargetProject(entry);
		}

		public File getTargetProject(GeneratorEntry entry) {
			IProject targetProject = AbstractSGraphModelGenerator.this.getTargetProject(entry);
			return targetProject.getLocation().toFile();
		}

		public File getTargetFolder(GeneratorEntry entry) {
			return GeneratorUtils.getTargetFolder(entry);
		}
	};

	protected void runGenerator(Statechart statechart, GeneratorEntry entry) {
		if (this instanceof ISGraphGenerator) {
			ISGraphGenerator graphGenerator = (ISGraphGenerator) this;
			graphGenerator.generate(statechart, entry);
		}
	}

	public AbstractSGraphModelGenerator() {
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
		EObject element = entry.getElementRef();
		if (element == null || !(element instanceof Statechart)) {
			writeToConsole("No Statechart selected in genmodel (" + entry + ")");
			return;
		}
		Statechart statechart = (Statechart) element;
		try {
			writeToConsole(String.format("Generating Statechart %s ...", statechart.getName()));
			prepareGenerator(entry);
			runGenerator(statechart, entry);
			writeToConsole("Done.");
		} catch (Exception e) {
			writeToConsole(e);
		} finally {
			finishGenerator(entry);
			injector = null;
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

	private Injector injector;

	protected Injector createInjector(GeneratorEntry entry) {
		Injector sequencerInjector = DomainRegistry.getDomainDescriptor(entry.getElementRef()).getDomainInjectorProvider().getSequencerInjector();
		return sequencerInjector.createChildInjector(getChildInjectorModule(entry));
	}

	protected Module getChildInjectorModule(GeneratorEntry entry) {
		Module bridgeModule = new Module() {
			public void configure(Binder binder) {
				binder.bind(IGeneratorBridge.class).toInstance(bridge);
			}
		};
		return bridgeModule;
	}

	protected Injector getInjector(GeneratorEntry entry) {
		if (injector == null) {
			injector = createInjector(entry);
		}
		return injector;
	}

	protected final void writeToConsole(Throwable t) {
		PrintWriter printWriter = new PrintWriter(error);
		t.printStackTrace(printWriter);
		printWriter.flush();
		printWriter.close();
	}

	protected final void writeToConsole(String line) {
		if (!info.isClosed() && PlatformUI.isWorkbenchRunning()) {
			info.println(line);
		}
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
		MessageConsole myConsole = new MessageConsole(SCT_GENERATOR_CONSOLE, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	protected final IProject getTargetProject(GeneratorEntry entry) {
		IProject project = GeneratorUtils.getTargetProject(entry);
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
		GeneratorUtils.createEmptyProject(project);
	}

}
