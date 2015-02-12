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

import org.yakindu.sct.domain.default_.modules.DefaultSequencerModule;
import org.yakindu.sct.domain.default_.modules.DefaultSimulationModule;
import org.yakindu.sct.domain.default_.modules.DefaultTypeSystemModule;
import org.yakindu.sct.domain.default_.modules.StateExpressionProvider;
import org.yakindu.sct.domain.default_.modules.StatechartExpressionProvider;
import org.yakindu.sct.domain.default_.modules.TransitionExpressionProvider;
import org.yakindu.sct.domain.extension.IDomainModuleProvider;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.STextRuntimeModule;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultDomainModuleProvider implements IDomainModuleProvider {

	protected Module getTypeSystemModule() {
		return new DefaultTypeSystemModule();
	}

	@Override
	public Module getSimulationModule() {
		return new DefaultSimulationModule();
	}

	@Override
	public Module getResourceModule() {
		return Modules.combine(new STextRuntimeModule(), getTypeSystemModule());
	}
	
	@Override
	public Module getSequencerModule() {
		return new DefaultSequencerModule();
	}

	@Override
	public Module getEmbeddedEditorModule(String semanticTarget) {
		if (Statechart.class.getName().equals(semanticTarget)) {
			return getEmbeddedStatechartEditorModule();
		}
		if (State.class.getName().equals(semanticTarget)) {
			return getEmbeddedStateEditorModule();
		}
		if (Transition.class.getName().equals(semanticTarget)) {
			return getEmbeddedTransitionEditorModule();
		}
		throw new IllegalArgumentException("Illegal semantic target " + semanticTarget);
	}

	protected Module getEmbeddedTransitionEditorModule() {
		TransitionExpressionProvider provider = new TransitionExpressionProvider();
		Module module = provider.getModule();
		return Modules.combine(module, getTypeSystemModule());
	}

	protected Module getEmbeddedStateEditorModule() {
		StateExpressionProvider provider = new StateExpressionProvider();
		Module module = provider.getModule();
		return Modules.combine(module, getTypeSystemModule());
	}

	protected Module getEmbeddedStatechartEditorModule() {
		StatechartExpressionProvider provider = new StatechartExpressionProvider();
		Module module = provider.getModule();
		return Modules.combine(module, getTypeSystemModule());
	}

}
