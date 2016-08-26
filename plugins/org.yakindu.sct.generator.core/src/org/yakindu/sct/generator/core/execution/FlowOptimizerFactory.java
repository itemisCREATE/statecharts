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
package org.yakindu.sct.generator.core.execution;

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

import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FlowOptimizerFactory {

	@Inject
	private Provider<FlowOptimizer> optimizerProvider;

	public FlowOptimizer create(GeneratorEntry entry) {
		FlowOptimizer optimizer = optimizerProvider.get();
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
		return optimizer;
	}

	protected boolean getBoolValue(FeatureConfiguration conf, String param, boolean defaultValue) {
		if (conf != null && conf.getParameterValue(param) != null) {
			return conf.getParameterValue(param).getBooleanValue();
		}

		return defaultValue;
	}

}
