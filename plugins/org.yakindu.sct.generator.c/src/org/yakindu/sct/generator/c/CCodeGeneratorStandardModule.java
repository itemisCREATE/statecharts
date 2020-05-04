/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c;

import static org.yakindu.sct.generator.c.features.ICFeatureConstants.FEATURE_INCLUDES;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.FEATURE_TRACING;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_INCLUDES_USE_RELATIVE_PATHS;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_GENERIC;
import static org.yakindu.sct.model.sexec.transformation.IModelSequencer.ADD_TRACES;

import org.yakindu.sct.generator.c.extensions.GenmodelEntries;
import org.yakindu.sct.generator.c.files.StatemachineHeader;
import org.yakindu.sct.generator.c.files.StatemachineSource;
import org.yakindu.sct.generator.c.types.CTypeSystemAccess;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.ng.ModelSequencer;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

public class CCodeGeneratorStandardModule implements IGeneratorModule {

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.bind(IModelSequencer.class).to(ModelSequencer.class);
		binder.bind(BehaviorMapping.class).to(org.yakindu.sct.model.sexec.transformation.ng.BehaviorMapping.class);
		binder.bind(GeneratorEntry.class).toInstance(entry);
		binder.bind(IExecutionFlowGenerator.class).to(CGenerator.class);
		binder.bind(ICodegenTypeSystemAccess.class).to(CTypeSystemAccess.class);
		binder.bind(INamingService.class).to(CNamingService.class);
		binder.bind(StatemachineSource.class).toProvider(SourceContentFragmentProvider.class);
		binder.bind(StatemachineHeader.class).toProvider(HeaderContentFragmentProvider.class);
		bindIGenArtifactConfigurations(entry, binder);
		bindTracingProperty(entry, binder);
		binder.bind(String.class).annotatedWith(Names.named("Separator")).toInstance(getSeparator(entry));

		Multibinder<IncludeProvider> includeBinder = Multibinder.newSetBinder(binder, IncludeProvider.class);
		includeBinder.addBinding().to(ScTypesIncludeProvider.class);
		includeBinder.addBinding().to(StatechartIncludeProvider.class);
		includeBinder.addBinding().to(TypesIncludeProvider.class);
	}

	protected void bindTracingProperty(GeneratorEntry entry, Binder binder) {
		FeatureParameterValue traceEnterFeature = entry.getFeatureParameterValue(FEATURE_TRACING,
				PARAMETER_TRACING_ENTER_STATE);
		FeatureParameterValue traceExitFeature = entry.getFeatureParameterValue(FEATURE_TRACING,
				PARAMETER_TRACING_EXIT_STATE);
		FeatureParameterValue traceGenericFeature = entry.getFeatureParameterValue(FEATURE_TRACING,
				PARAMETER_TRACING_GENERIC);
		boolean traceEnter = traceEnterFeature != null ? traceEnterFeature.getBooleanValue() : false;
		boolean traceExit = traceExitFeature != null ? traceExitFeature.getBooleanValue() : false;
		boolean traceGeneric = traceGenericFeature != null ? traceGenericFeature.getBooleanValue() : false;
		
		binder.bind(Boolean.class).annotatedWith(Names.named(ADD_TRACES)).toInstance(traceEnter || traceExit || traceGeneric);

		if(traceGeneric) {
			Multibinder<IncludeProvider> includeBinder = Multibinder.newSetBinder(binder, IncludeProvider.class);
			includeBinder.addBinding().to(ScTracingIncludeProvider.class);
		}
	}

	protected void bindIGenArtifactConfigurations(GeneratorEntry entry, Binder binder) {
		FeatureParameterValue useRelativePathParam = entry.getFeatureParameterValue(FEATURE_INCLUDES,
				PARAMETER_INCLUDES_USE_RELATIVE_PATHS);
		boolean useRelativePath = useRelativePathParam != null ? useRelativePathParam.getBooleanValue() : true;
		if (useRelativePath) {
			binder.bind(IGenArtifactConfigurations.class).to(DefaultGenArtifactConfigurations.class);
		} else {
			binder.bind(IGenArtifactConfigurations.class).to(SimpleGenArtifactConfigurations.class);
		}
	}

	protected String getSeparator(GeneratorEntry entry) {
		GenmodelEntries entries = new GenmodelEntries();
		String separator = entries.getSeparator(entry);
		if (separator == null) {
			return "_";
		} else {
			return separator;
		}
	}
}
