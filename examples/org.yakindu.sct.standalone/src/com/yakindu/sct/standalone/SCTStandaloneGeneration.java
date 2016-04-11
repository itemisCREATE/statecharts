package com.yakindu.sct.standalone;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ResourceSetGlobalScopeProvider;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainDescriptor;
import org.yakindu.sct.generator.core.GeneratorExecutor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.features.impl.CoreLibraryDefaultFeatureValueProvider;
import org.yakindu.sct.generator.core.features.impl.GenericJavaLibraryDefaultValueProvider;
import org.yakindu.sct.generator.core.features.impl.SCTBaseLibaryDefaultFeatureValueProvider;
import org.yakindu.sct.generator.genmodel.SGenRuntimeModule;
import org.yakindu.sct.generator.genmodel.SGenStandaloneSetup;
import org.yakindu.sct.model.resource.SCTResourceFactory;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.STextStandaloneSetup;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.yakindu.sct.standalone.extension.GenericDomainDesciptor;
import com.yakindu.sct.standalone.extension.JavaGeneratorDescriptor;
import com.yakindu.sct.standalone.extension.LibraryDescriptor;

public class SCTStandaloneGeneration {

	private static final String SCT_FILE_EXTENSION = "sct";
	private static ResourceSet resourceSet;
	private static Charset encoding = StandardCharsets.UTF_8;

	private static String absoluteLibrariesDir = System.getProperty("user.dir") + "/libraries";
	private static String absoluteWorkspaceDir = System.getProperty("user.dir") + "/workspace";
	private static String relativeSgenPath = "/test.java.plain/java.sgen";
	private static String relativeSCTPath = "/test.java.plain/default.sct";

	public static void main(String[] args) {

		initLanguages();
		initResourceSet();

		initSCTDomain();
		initSgenLibraries();
		initSCTGenerator();

		loadSCTModels();

		generateAll();

	}

	protected static void loadSCTModels() {
		load(absoluteWorkspaceDir + relativeSCTPath);
		load(absoluteWorkspaceDir + relativeSgenPath);
	}

	protected static void generateAll() {
		EList<Resource> resources = resourceSet.getResources();
		List<GeneratorModel> genModels = Lists.newArrayList();
		for (Resource resource : resources) {
			EObject content = resource.getContents().get(0);
			if (content instanceof GeneratorModel)
				genModels.add((GeneratorModel) content);
		}
		for (GeneratorModel generatorModel : genModels) {
			new GeneratorExecutor().executeGenerator(generatorModel);
		}
	}

	protected static void initSCTGenerator() {
		GeneratorExtensions.getGeneratorDescriptors().add(new JavaGeneratorDescriptor());
	}
	
	protected static void initSgenLibraries() {
		LibraryExtensions.getLibraryDescriptors()
				.add(new LibraryDescriptor("org.yakindu.generator.core.features",
						URI.createFileURI(absoluteLibrariesDir + "/CoreFeatureTypeLibrary.xmi"),
						new CoreLibraryDefaultFeatureValueProvider()));
		LibraryExtensions.getLibraryDescriptors()
				.add(new LibraryDescriptor("org.yakindu.sct.generator.feature.java",
						URI.createFileURI(absoluteLibrariesDir + "/GenericJavaFeatureTypeLibrary.xmi"),
						new GenericJavaLibraryDefaultValueProvider()));
		LibraryExtensions.getLibraryDescriptors()
				.add(new LibraryDescriptor("org.yakindu.generator.core.features.sctbase",
						URI.createFileURI(SCTStandaloneGeneration.absoluteLibrariesDir + "/SCTBaseFeatureLibrary.xmi"),
						new SCTBaseLibaryDefaultFeatureValueProvider()));
	}

	protected static Resource load(String string) {
		return resourceSet.getResource(URI.createFileURI(string), true);
	}

	protected static void initSCTDomain() {
		IDomainDescriptor domainDescriptor = new GenericDomainDesciptor(absoluteWorkspaceDir, encoding);
		DomainRegistry.getDomainDescriptors().add(domainDescriptor);
	}

	protected static void initResourceSet() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SCT_FILE_EXTENSION,
				new SCTResourceFactory());
	}

	protected static void initLanguages() {
		doSgenSetup();
		doSTextSetup();
	}

	protected static void doSgenSetup() {
		SGenPackage.eINSTANCE.eClass();
		new SGenStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules.override(new SGenRuntimeModule()).with(new Module() {
							@Override
							public void configure(Binder binder) {
								binder.bind(IGlobalScopeProvider.class).to(ResourceSetGlobalScopeProvider.class);
							}
						}));
			}
		}.createInjectorAndDoEMFRegistration();
	}

	protected static void doSTextSetup() {
		NotationPackage.eINSTANCE.eClass();

		Injector stextInjector = new STextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(
						Modules.override(new STextRuntimeModule()).with(new Module() {
							@Override
							public void configure(Binder binder) {
								binder.bind(IGlobalScopeProvider.class).to(ResourceSetGlobalScopeProvider.class);
							}
						}));
			}
		}.createInjectorAndDoEMFRegistration();
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(SCT_FILE_EXTENSION,
				stextInjector.getInstance(IResourceServiceProvider.class));
	}
}
