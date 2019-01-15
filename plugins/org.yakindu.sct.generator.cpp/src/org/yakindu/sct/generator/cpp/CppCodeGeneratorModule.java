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
import org.yakindu.sct.generator.cpp.eventdriven.CppEventDrivenIncludeProvider;
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenEventRaisingCode;
import org.yakindu.sct.generator.cpp.files.StatemachineHeader;
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation;
import org.yakindu.sct.generator.cpp.providers.ConstantsProvider;
import org.yakindu.sct.generator.cpp.providers.ConstructorProvider;
import org.yakindu.sct.generator.cpp.providers.DefaultFunctionProvider;
import org.yakindu.sct.generator.cpp.providers.ISourceFragment;
import org.yakindu.sct.generator.cpp.providers.OCBDestructorProvider;
import org.yakindu.sct.generator.cpp.providers.StatemachineClassDeclaration;
import org.yakindu.sct.generator.cpp.providers.StatevectorDefineProvider;
import org.yakindu.sct.generator.cpp.providers.classdecl.InnerClassesProvider;
import org.yakindu.sct.generator.cpp.providers.classdecl.PublicClassMemberProvider;
import org.yakindu.sct.generator.cpp.providers.eventdriven.EventDrivenConstructorProvider;
import org.yakindu.sct.generator.cpp.providers.eventdriven.StatechartEventImpl;
import org.yakindu.sct.generator.cpp.providers.eventdriven.StatechartEvents;
import org.yakindu.sct.generator.cpp.providers.eventdriven.UsingNamespaceProvider;
import org.yakindu.sct.generator.cpp.providers.eventdriven.classdecl.QueueMemberProvider;
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

	public static final String CLASS_PUBLIC_TARGET = "Header.Class.Public";
	public static final String CLASS_PROTECTED_TARGET = "Header.Class.Protected";
	public static final String CLASS_PRIVATE_TARGET = "Header.Class.Private";
	public static final String CLASS_INNER_TARGET = "Header.Class.InnerClasses";

	public static final String STATEMACHINE_IMPL_TARGET = StatemachineImplementation.class.getSimpleName();
	public static final String STATEMACHINE_HEADER_TARGET = StatemachineHeader.class.getSimpleName();

	protected AnnotationExtensions annotations = new AnnotationExtensions();
	protected Multibinder<IncludeProvider> includeBinder;
	protected Multibinder<ISourceFragment> fragmentProvider;

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {

		bindFragments(binder, entry);

		includeBinder = Multibinder.newSetBinder(binder, IncludeProvider.class);

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

	protected void bindFragments(Binder binder, GeneratorEntry entry) {
		bindFragment(binder, ConstantsProvider.class, STATEMACHINE_IMPL_TARGET);
		bindFragment(binder, getConstructorProvider(entry), STATEMACHINE_IMPL_TARGET);

		if ((new AnnotationExtensions()).isEventDriven(entry)) {
			bindFragment(binder, UsingNamespaceProvider.class, STATEMACHINE_IMPL_TARGET);
			bindFragment(binder, QueueMemberProvider.class, CLASS_PRIVATE_TARGET);
			bindFragment(binder, StatechartEventImpl.class, STATEMACHINE_IMPL_TARGET);
			bindFragment(binder, StatechartEvents.class, STATEMACHINE_HEADER_TARGET);
		}
		bindFragment(binder, DefaultFunctionProvider.class, STATEMACHINE_IMPL_TARGET);
		bindFragment(binder, OCBDestructorProvider.class, STATEMACHINE_IMPL_TARGET);
		bindFragment(binder, StatevectorDefineProvider.class, STATEMACHINE_HEADER_TARGET);
		bindFragment(binder, StatemachineClassDeclaration.class, STATEMACHINE_HEADER_TARGET);
		bindFragment(binder, InnerClassesProvider.class, CLASS_INNER_TARGET);
		bindFragment(binder, PublicClassMemberProvider.class, CLASS_PUBLIC_TARGET);

	}

	protected Class<? extends ConstructorProvider> getConstructorProvider(GeneratorEntry entry) {
		if ((new AnnotationExtensions()).isEventDriven(entry)) {
			return EventDrivenConstructorProvider.class;
		} else {
			return ConstructorProvider.class;
		}
	}

	protected void bindFragment(Binder binder, Class<? extends ISourceFragment> cls, String target) {
		Multibinder<ISourceFragment> fragmentProvider = Multibinder.newSetBinder(binder, ISourceFragment.class,
				Names.named(target));
		fragmentProvider.addBinding().to(cls);
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
		bindEventRaisingCode(binder);
		binder.bind(EventCode.class).to(EventDrivenEventCode.class);
		binder.bind(RunCycle.class).to(EventDrivenRunCycle.class);
		binder.bind(InterfaceFunctions.class).to(EventDrivenInterfaceFunctions.class);
		binder.bind(TimingFunctions.class).to(EventDrivenTimingFunctions.class);

		addIncludeProvider(CppEventDrivenIncludeProvider.class);
	}

	protected void bindEventRaisingCode(Binder binder) {
		binder.bind(EventRaisingCode.class).to(EventDrivenEventRaisingCode.class);
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
