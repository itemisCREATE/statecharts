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
package org.yakindu.sct.generator.c;

import static org.yakindu.sct.generator.c.features.ICFeatureConstants.FEATURE_INCLUDES;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.FEATURE_TRACING;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_INCLUDES_USE_RELATIVE_PATHS;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE;
import static org.yakindu.sct.model.sexec.transformation.IModelSequencer.ADD_TRACES;
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;

import org.yakindu.base.types.Annotation;
import org.yakindu.sct.generator.c.eventdriven.EventDrivenStatemachineHeader;
import org.yakindu.sct.generator.c.eventdriven.EventDrivenStatemachineSourceContentProvider;
import org.yakindu.sct.generator.c.extensions.APIGenerator;
import org.yakindu.sct.generator.c.extensions.EventCode;
import org.yakindu.sct.generator.c.extensions.EventDrivenAPIGenerator;
import org.yakindu.sct.generator.c.extensions.EventDrivenEventCode;
import org.yakindu.sct.generator.c.extensions.EventDrivenInternalFunctionsGenerator;
import org.yakindu.sct.generator.c.extensions.GenmodelEntries;
import org.yakindu.sct.generator.c.extensions.InternalFunctionsGenerator;
import org.yakindu.sct.generator.c.types.CTypeSystemAccess;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Names;
/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class CCodeGeneratorModule implements IGeneratorModule {

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.bind(GeneratorEntry.class).toInstance(entry);
		binder.bind(IExecutionFlowGenerator.class).to(CGenerator.class);
		binder.bind(ICodegenTypeSystemAccess.class).to(CTypeSystemAccess.class);
		binder.bind(IncludeProvider.class).to(StandardIncludeProvider.class);
		binder.bind(INamingService.class).to(CNamingService.class);
		bindIGenArtifactConfigurations(entry, binder);
		bindTracingProperty(entry, binder);
		configureEventDriven(entry, binder);
		binder.bind(String.class).annotatedWith(Names.named("Separator")).toInstance(getSeparator(entry));
	}

	protected void bindTracingProperty(GeneratorEntry entry, Binder binder) {
		FeatureParameterValue traceEnterFeature = entry.getFeatureParameterValue(FEATURE_TRACING,
				PARAMETER_TRACING_ENTER_STATE);
		FeatureParameterValue traceExitFeature = entry.getFeatureParameterValue(FEATURE_TRACING,
				PARAMETER_TRACING_EXIT_STATE);
		boolean traceEnter = traceEnterFeature != null ? traceEnterFeature.getBooleanValue() : false;
		boolean traceExit = traceExitFeature != null ? traceEnterFeature.getBooleanValue() : false;
		binder.bind(Boolean.class).annotatedWith(Names.named(ADD_TRACES)).toInstance(traceEnter || traceExit);
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

	protected void configureEventDriven(GeneratorEntry entry, Binder binder) {
		if (isEventDriven(entry)) {
			binder.bind(StatemachineHeader.class).to(EventDrivenStatemachineHeader.class);
			binder.bind(APIGenerator.class).to(EventDrivenAPIGenerator.class);
			binder.bind(EventCode.class).to(EventDrivenEventCode.class);
			binder.bind(InternalFunctionsGenerator.class).to(EventDrivenInternalFunctionsGenerator.class);
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

	protected boolean isEventDriven(GeneratorEntry entry) {
		Statechart statechart = (Statechart) entry.getElementRef();
		Annotation eventDrivenAnnotation = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		return eventDrivenAnnotation != null;
	}

	@Provides
	StatemachineSource getStatemachineSource(Injector injector) {
		StatemachineSource source = new StatemachineSource();
		injector.injectMembers(source);

		GeneratorEntry entry = injector.getInstance(GeneratorEntry.class);

		source.getContentProviders().add(injector.getInstance(StatemachineSourceContentProvider.class));
		if (isEventDriven(entry)) {
			source.getContentProviders().add(injector.getInstance(EventDrivenStatemachineSourceContentProvider.class));
		}
		return source;
	}
}
