package org.yakindu.sct.model.sgraph;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class SGraphRuntimeModule extends AbstractGenericModule {

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SGraphNameProvider.class;
	}

	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return DefaultGlobalScopeProvider.class;
	}

	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class)
				.annotatedWith(Names.named(Constants.FILE_EXTENSIONS))
				.toInstance("");
	}

	public void configureLanguageName(Binder binder) {
		binder.bind(String.class)
				.annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance("org.yakindu.sct.model.sgraph.SGraph");
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
				.to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by
	// org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsBuilderScope(
			com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class)
				.annotatedWith(
						com.google.inject.name.Names
								.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class)
				.annotatedWith(
						Names.named(ResourceDescriptionsProvider.LIVE_SCOPE))
				.to(ResourceSetBasedResourceDescriptions.class);
	}
}
