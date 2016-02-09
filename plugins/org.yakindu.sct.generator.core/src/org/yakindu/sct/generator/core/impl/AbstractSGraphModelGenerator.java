/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Mülder - Initial API and implementation
 *     Alexaner Nyßen - Refactored to use overriding module instead of child injector
 */
package org.yakindu.sct.generator.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.filesystem.EFSResourceFileSystemAccess;
import org.yakindu.sct.generator.core.filesystem.SCTFileSystemAccess;
import org.yakindu.sct.generator.core.library.DebugFeatureHelperImpl;
import org.yakindu.sct.generator.core.library.IDebugFeatureHelper;
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper;
import org.yakindu.sct.generator.core.library.OutletFeatureHelperImpl;
import org.yakindu.sct.generator.core.util.EclipseConsoleLog;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author Andreas Mülder - Initial contribution and API
 * 
 */
public abstract class AbstractSGraphModelGenerator implements ISCTGenerator {

	public static final String SCT_GENERATOR_CONSOLE = "SCT Generator Console";

	@Inject
	protected IGeneratorLog log;
	@Inject
	protected IOutletFeatureHelper outletFeatureHelper;
	@Inject
	protected DebugFeatureHelperImpl debugFeatureHelper;
	@Inject
	protected SCTFileSystemAccess sctFileSystemAccess;

	protected void runGenerator(Statechart statechart, GeneratorEntry entry) {
		if (this instanceof ISGraphGenerator) {
			ISGraphGenerator graphGenerator = (ISGraphGenerator) this;
			graphGenerator.generate(statechart, entry);
		}
	}

	public AbstractSGraphModelGenerator() {
		super();
	}

	@Override
	protected void finalize() throws Throwable {
		log.close();
		super.finalize();
	}

	public final void generate(GeneratorEntry entry) {
		getInjector(entry).injectMembers(this);

		EObject element = entry.getElementRef();
		if (element == null || !(element instanceof Statechart)) {
			log.writeToConsole("No Statechart selected in genmodel (" + entry + ")");
			return;
		}
		Statechart statechart = (Statechart) element;
		try {
			log.writeToConsole(String.format("Generating Statechart %s ...", statechart.getName()));
			prepareGenerator(entry);
			runGenerator(statechart, entry);
			log.writeToConsole("Done.");
		} catch (Exception e) {
			log.writeToConsole(e);
		} finally {
			finishGenerator(entry);
			injector = null;
		}
	}

	/**
	 * override this method to do any setup needed before generation
	 */
	protected void prepareGenerator(GeneratorEntry entry) {
	}

	/**
	 * override this method to do any cleanup needed after generation
	 */
	protected void finishGenerator(GeneratorEntry entry) {
		sctFileSystemAccess.afterGeneration();
	}

	private Injector injector;

	protected Injector createInjector(GeneratorEntry entry) {
		//FIXME !!! right injector, why? 
		return DomainRegistry.getDomainDescriptor(entry.getElementRef()).getDomainInjectorProvider()
				.getSequencerInjector(getOverridesModule(entry));
	}

	protected Module getOverridesModule(final GeneratorEntry entry) {
		Module baseModule = new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(SCTFileSystemAccess.class).to(EFSResourceFileSystemAccess.class);
				binder.bind(IGeneratorLog.class).to(EclipseConsoleLog.class);
				binder.bind(IOutletFeatureHelper.class).to(OutletFeatureHelperImpl.class);
				binder.bind(IDebugFeatureHelper.class).to(DebugFeatureHelperImpl.class);
			}
		};
		return baseModule;
	}

	protected Injector getInjector(GeneratorEntry entry) {
		if (injector == null) {
			injector = createInjector(entry);
		}
		return injector;
	}

}
