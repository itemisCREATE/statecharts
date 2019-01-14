/**
 * Copyright (c) 2016-2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp;

import static org.yakindu.sct.generator.c.features.ICFeatureConstants.FEATURE_TRACING;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_ENTER_STATE;
import static org.yakindu.sct.generator.c.features.ICFeatureConstants.PARAMETER_TRACING_EXIT_STATE;
import static org.yakindu.sct.generator.cpp.features.CPPFeatureConstants.FEATURE_INCLUDES;
import static org.yakindu.sct.generator.cpp.features.CPPFeatureConstants.PARAMETER_INCLUDES_USE_RELATIVE_PATHS;
import static org.yakindu.sct.model.sexec.transformation.IModelSequencer.ADD_TRACES;

import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.sct.generator.c.DefaultGenArtifactConfigurations;
import org.yakindu.sct.generator.c.IGenArtifactConfigurations;
import org.yakindu.sct.generator.c.IncludeProvider;
import org.yakindu.sct.generator.c.ScTypesIncludeProvider;
import org.yakindu.sct.generator.c.SimpleGenArtifactConfigurations;
import org.yakindu.sct.generator.c.extensions.GenmodelEntries;
import org.yakindu.sct.generator.c.extensions.Naming;
import org.yakindu.sct.generator.c.types.CTypeSystemAccess;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.extensions.AnnotationExtensions;
import org.yakindu.sct.generator.core.submodules.lifecycle.Enter;
import org.yakindu.sct.generator.core.submodules.lifecycle.Exit;
import org.yakindu.sct.generator.core.submodules.lifecycle.Init;
import org.yakindu.sct.generator.core.submodules.lifecycle.IsActive;
import org.yakindu.sct.generator.core.submodules.lifecycle.IsFinal;
import org.yakindu.sct.generator.core.submodules.lifecycle.IsStateActive;
import org.yakindu.sct.generator.core.submodules.lifecycle.RunCycle;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.cpp.CodeGeneratorFragmentProvider.ClassLoadingContext;
import org.yakindu.sct.generator.cpp.eventdriven.CppEventDrivenIncludeProvider;
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenExpressionCode;
import org.yakindu.sct.generator.cpp.providers.ISourceFragment;
import org.yakindu.sct.generator.cpp.submodules.EventCode;
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions;
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions;
import org.yakindu.sct.generator.cpp.submodules.eventdriven.EventDrivenEventCode;
import org.yakindu.sct.generator.cpp.submodules.eventdriven.EventDrivenInterfaceFunctions;
import org.yakindu.sct.generator.cpp.submodules.eventdriven.EventDrivenRunCycle;
import org.yakindu.sct.generator.cpp.submodules.eventdriven.EventDrivenTimingFunctions;
import org.yakindu.sct.generator.cpp.submodules.lifecycle.LifecycleFunctions;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.ng.ModelSequencer;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class CppCodeGeneratorModule implements IGeneratorModule {
	public static final String NAMED_PACKAGES = "Packages";
	
	protected AnnotationExtensions annotations = new AnnotationExtensions();
	protected Multibinder<IncludeProvider> includeBinder;
	protected Multibinder<ISourceFragment> headerSourceProviderBinder;
	protected Multibinder<ISourceFragment> implSourceProviderBinder;
	protected Multibinder<CodeGeneratorFragmentProvider.ClassLoadingContext> packages;

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		includeBinder = Multibinder.newSetBinder(binder, IncludeProvider.class);
		packages = Multibinder.newSetBinder(binder, ClassLoadingContext.class,
				Names.named(NAMED_PACKAGES));
		
		packages.addBinding()
				.toInstance(new ClassLoadingContext(getClass().getClassLoader(), "org.yakindu.sct.generator.cpp"));
		
		binder.bind(IModelSequencer.class).to(ModelSequencer.class);
		binder.bind(BehaviorMapping.class).to(org.yakindu.sct.model.sexec.transformation.ng.BehaviorMapping.class);
		binder.bind(GeneratorEntry.class).toInstance(entry);
		binder.bind(String.class).annotatedWith(Names.named("Separator")).toInstance(getSeparator(entry));
		binder.bind(IExecutionFlowGenerator.class).to(CppGenerator.class);
		binder.bind(ICodegenTypeSystemAccess.class).to(CTypeSystemAccess.class);
		binder.bind(INamingService.class).to(CppNamingService.class);
		binder.bind(ITypeSystemInferrer.class).to(STextTypeInferrer.class);
		binder.bind(Naming.class).to(CppNaming.class);
		bindTracingProperty(entry, binder);
		if ((new AnnotationExtensions()).isEventDriven(entry)) {
			bindEventDrivenClasses(binder);
		} else {
			bindCycleBasedClasses(binder);
		}
		bindDefaultClasses(binder);
		bindIGenArtifactConfigurations(entry, binder);
		addIncludeProvider(ScTypesIncludeProvider.class);
		addIncludeProvider(CppInterfaceIncludeProvider.class);
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

	protected void addIncludeProvider(Class<? extends IncludeProvider> provider) {
		includeBinder.addBinding().to(provider);
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

	/** Only for event driven case */
	protected void bindEventDrivenClasses(Binder binder) {
		binder.bind(CppExpressionsGenerator.class).to(EventDrivenExpressionCode.class);
		binder.bind(EventCode.class).to(EventDrivenEventCode.class);
		
		binder.bind(RunCycle.class).to(EventDrivenRunCycle.class);
		binder.bind(InterfaceFunctions.class).to(EventDrivenInterfaceFunctions.class);
		binder.bind(TimingFunctions.class).to(EventDrivenTimingFunctions.class);
		
		addIncludeProvider(CppEventDrivenIncludeProvider.class);
	}

	/** Only for cycle based case */
	protected void bindCycleBasedClasses(Binder binder) {
		binder.bind(RunCycle.class).to(LifecycleFunctions.class);
	}
	
	/** Needed for cycle based AND event driven */
	protected void bindDefaultClasses(Binder binder) {
		binder.bind(Init.class).to(LifecycleFunctions.class);
		binder.bind(Enter.class).to(LifecycleFunctions.class);
		binder.bind(Exit.class).to(LifecycleFunctions.class);
		binder.bind(IsActive.class).to(LifecycleFunctions.class);
		binder.bind(IsFinal.class).to(LifecycleFunctions.class);
		binder.bind(IsStateActive.class).to(LifecycleFunctions.class);
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
