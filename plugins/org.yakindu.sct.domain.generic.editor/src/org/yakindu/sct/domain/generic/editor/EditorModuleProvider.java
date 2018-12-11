/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.domain.generic.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ide.STextIdeModule;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.StextActivator;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EditorModuleProvider implements IModuleProvider {

	private static final ImmutableMap<String, Class<? extends EObject>> GRAMMAR_RULE_MAP = ImmutableMap.of(
			Statechart.class.getName(), StatechartSpecification.class, Transition.class.getName(),
			TransitionSpecification.class, State.class.getName(), StateSpecification.class, Guard.class.getName(),
			Guard.class);

	@Override
	public Module getModule(String... options) {
		if (options.length == 0)
			return new GenericEditorModule();
		String semanticTarget = options[0];
		if (!GRAMMAR_RULE_MAP.containsKey(semanticTarget))
			throw new IllegalArgumentException(
					String.format("No grammar rule for semantic target '%s' found", semanticTarget));
		return getEmbeddedEditorModule(semanticTarget);
	}

	protected Module getEmbeddedEditorModule(String semanticTarget) {
		Class<? extends EObject> rule = GRAMMAR_RULE_MAP.get(semanticTarget);
		return Modules.override(getLanguageModule()).with(new EntryRuleRuntimeModule(rule),
				new EntryRuleUIModule(rule));
	}

	protected Module getLanguageModule() {
		Module languageModule = Modules.override(getLanguageRuntimeModule()).with(getLanguageUiModule());
		return Modules.override(languageModule).with(new SharedStateModule());
	}

	protected Module getLanguageUiModule() {
		return new STextUiModule(StextActivator.getInstance());
	}

	protected Module getLanguageRuntimeModule() {
		return new STextRuntimeModule();
	}

}
