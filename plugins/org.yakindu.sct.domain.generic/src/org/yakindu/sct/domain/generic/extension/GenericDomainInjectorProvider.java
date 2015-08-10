/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.generic.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.domain.extension.IDomainInjectorProvider;
import org.yakindu.sct.domain.generic.modules.EntryRuleRuntimeModule;
import org.yakindu.sct.domain.generic.modules.EntryRuleUIModule;
import org.yakindu.sct.domain.generic.modules.GenericSequencerModule;
import org.yakindu.sct.domain.generic.modules.GenericSimulationModule;
import org.yakindu.sct.domain.generic.modules.GenericTypeSystemModule;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenericDomainInjectorProvider implements IDomainInjectorProvider {

	private static final Map<String, Class<? extends EObject>> semanticTargetToRuleMap = new HashMap<String, Class<? extends EObject>>();

	private static Injector resourceInjector;
	private Map<String, Injector> embeddedInjectors = new HashMap<String, Injector>();

	static {
		semanticTargetToRuleMap.put(Statechart.class.getName(), StatechartSpecification.class);
		semanticTargetToRuleMap.put(Transition.class.getName(), TransitionSpecification.class);
		semanticTargetToRuleMap.put(State.class.getName(), StateSpecification.class);
		semanticTargetToRuleMap.put(Guard.class.getName(), Guard.class);
	}

	public Module getSharedStateModule() {
		return new SharedStateModule();
	}

	public Module getLanguageRuntimeModule() {
		return new STextRuntimeModule();
	}

	public Module getLanguageUIModule() {
		return new STextUiModule(STextActivator.getInstance());
	}

	public Module getTypeSystemModule() {
		return new GenericTypeSystemModule();
	}

	public Module getSimulationModule() {
		return new GenericSimulationModule();
	}

	public Module getSequencerModule() {
		return new GenericSequencerModule();
	}

	protected Module getResourceModule() {
		Module uiModule = Modules.override(getLanguageRuntimeModule()).with(getLanguageUIModule());
		Module result = Modules.override(uiModule).with(getSharedStateModule());
		return Modules.override(result).with(getTypeSystemModule());
	}

	protected Module getEmbeddedEditorModule(Class<? extends EObject> rule) {
		Module runtimeModule = Modules.override(getLanguageRuntimeModule()).with(new EntryRuleRuntimeModule(rule));
		Module uiModule = Modules.override(getLanguageUIModule()).with(new EntryRuleUIModule(rule));
		Module result = Modules.override(Modules.override(runtimeModule).with(uiModule)).with(getSharedStateModule());
		return Modules.override(result).with(getTypeSystemModule());
	}

	@Override
	public Injector getEmbeddedEditorInjector(String semanticTarget) {
		if (embeddedInjectors.get(semanticTarget) == null) {
			Class<? extends EObject> rule = semanticTargetToRuleMap.get(semanticTarget);
			org.eclipse.core.runtime.Assert.isNotNull(rule);
			embeddedInjectors.put(semanticTarget, Guice.createInjector(getEmbeddedEditorModule(rule)));
		}
		return embeddedInjectors.get(semanticTarget);
	}

	@Override
	public Injector getResourceInjector() {
		if (resourceInjector == null)
			resourceInjector = Guice.createInjector(getResourceModule());
		return resourceInjector;
	}

	@Override
	public Injector getSimulationInjector() {
		return Guice.createInjector(getSimulationModule());
	}

	@Override
	public Injector getSequencerInjector() {
		return Guice.createInjector(getSequencerModule());
	}
}
