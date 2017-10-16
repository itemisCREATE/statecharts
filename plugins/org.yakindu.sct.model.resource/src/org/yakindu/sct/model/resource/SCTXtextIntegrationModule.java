/**
 * Copyright (c) 2017 committers of YAKINDU and others.
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
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.yakindu.sct.model.resource.tasks.DomainSpecificTaskFinder;
import org.yakindu.sct.model.sgraph.ui.validation.SCTDiagnosticConverterImpl;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerTypeProvider;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.resource.SCTResourceDescriptionStrategy;
import org.yakindu.sct.model.stext.resource.SCTResourceValidatorImpl;
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerCreator;
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerTypeProvider;
import org.yakindu.sct.ui.editor.editor.SCTFileEditorOpener;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
/**
 * @author Johannes Dicks - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class SCTXtextIntegrationModule implements Module {
	@Override
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
		binder.bind(TaskMarkerCreator.class).to(SCTTaskMarkerCreator.class);
		binder.bind(TaskMarkerTypeProvider.class).to(SCTTaskMarkerTypeProvider.class);
	}
}