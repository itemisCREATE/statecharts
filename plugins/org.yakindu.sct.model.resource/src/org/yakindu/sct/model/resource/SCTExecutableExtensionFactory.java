/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.osgi.framework.Bundle;
import org.yakindu.sct.model.resource.tasks.DomainSpecificTaskFinder;
import org.yakindu.sct.model.sgraph.ui.validation.SCTDiagnosticConverterImpl;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerTypeProvider;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.resource.SCTResourceDescriptionStrategy;
import org.yakindu.sct.model.stext.resource.SCTResourceValidatorImpl;
import org.yakindu.sct.ui.editor.editor.SCTFileEditorOpener;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected Injector getInjector() {
		// TODO: Provide a sharedDomainModule via DomainRegistry to allow
		// overriding of generic bindings
		return Guice.createInjector(new SharedStateModule(), new Module() {
			@Override
			@SuppressWarnings("restriction")
			public void configure(Binder binder) {
				binder.bind(IResourceValidator.class).to(SCTResourceValidatorImpl.class);
				binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("sct");
				binder.bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
				binder.bind(IQualifiedNameProvider.class).to(StextNameProvider.class);
				binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
						.annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)
						.to(DefaultDescriptionLabelProvider.class);
				binder.bind(IDefaultResourceDescriptionStrategy.class).to(SCTResourceDescriptionStrategy.class);
				
				binder.bind(MarkerCreator.class).to(SCTMarkerCreator.class);
				binder.bind(MarkerTypeProvider.class).to(SCTMarkerTypeProvider.class);
				binder.bind(IDiagnosticConverter.class).to(SCTDiagnosticConverterImpl.class);
				binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(SCTFileEditorOpener.class);
				
				binder.bind(IMarkerContributor.class).to(TaskMarkerContributor.class);
				binder.bind(ITaskFinder.class).to(DomainSpecificTaskFinder.class);
			}
		});
	}

}