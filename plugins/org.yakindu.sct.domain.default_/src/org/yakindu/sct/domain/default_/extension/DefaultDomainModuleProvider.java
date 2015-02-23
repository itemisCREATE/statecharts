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
package org.yakindu.sct.domain.default_.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.domain.default_.modules.DefaultSequencerModule;
import org.yakindu.sct.domain.default_.modules.DefaultSimulationModule;
import org.yakindu.sct.domain.default_.modules.DefaultTypeSystemModule;
import org.yakindu.sct.domain.default_.modules.EntryRuleRuntimeModule;
import org.yakindu.sct.domain.default_.modules.EntryRuleUIModule;
import org.yakindu.sct.domain.extension.IDomainModuleProvider;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultDomainModuleProvider implements IDomainModuleProvider {

	private static final Map<String, Class<? extends EObject>> semanticTargetToRuleMap = new HashMap<String, Class<? extends EObject>>();
	static {
		semanticTargetToRuleMap.put(Statechart.class.getName(), StatechartSpecification.class);
		semanticTargetToRuleMap.put(Transition.class.getName(), TransitionSpecification.class);
		semanticTargetToRuleMap.put(State.class.getName(), StateSpecification.class);
	}

	@Override
	public Module getSharedStateModule() {
		return new SharedStateModule();
	}

	@Override
	public Module getLanguageRuntimeModule() {
		return new STextRuntimeModule();
	}

	@Override
	public Module getLanguageUIModule() {
		return new STextUiModule(STextActivator.getInstance());
	}

	protected Module getTypeSystemModule() {
		return new DefaultTypeSystemModule();
	}

	@Override
	public Module getSimulationModule() {
		return new DefaultSimulationModule();
	}

	@Override
	public Module getSequencerModule() {
		return new DefaultSequencerModule();
	}

	@Override
	public Module getResourceModule() {
		Module uiModule = Modules.override(getLanguageRuntimeModule()).with(getLanguageUIModule());
		Module result =  Modules.override(uiModule).with(getSharedStateModule());
		return Modules.override(result).with (getTypeSystemModule());
	}

	@Override
	public Module getEmbeddedEditorModule(String semanticTarget) {
		return getEmbeddedEditorModule(semanticTargetToRuleMap.get(semanticTarget));
	}

	protected Module getEmbeddedEditorModule(Class<? extends EObject> rule) {
		Module runtimeModule = Modules.override(getLanguageRuntimeModule()).with(new EntryRuleRuntimeModule(rule));
		Module uiModule = Modules.override(getLanguageUIModule()).with(new EntryRuleUIModule(rule));
		Module result =  Modules.override(Modules.override(runtimeModule).with(uiModule)).with(getSharedStateModule());
		return Modules.override(result).with (getTypeSystemModule());
	}
}
