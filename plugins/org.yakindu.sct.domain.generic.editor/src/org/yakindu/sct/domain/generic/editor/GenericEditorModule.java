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
package org.yakindu.sct.domain.generic.editor;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.yakindu.sct.model.sexec.validation.SExecValidator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTDiagnosticConverterImpl;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerTypeProvider;
import org.yakindu.sct.model.stext.resource.SCTResourceValidatorImpl;
import org.yakindu.sct.model.stext.validation.STextValidator;
import org.yakindu.sct.refactoring.proposals.RefactoringProposalProvider;
import org.yakindu.sct.ui.editor.editor.proposals.SmartEditProposalProvider;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;
import org.yakindu.sct.ui.editor.providers.DefaultSCTPaletteFactory;
import org.yakindu.sct.ui.editor.providers.ISCTPaletteFactory;
import org.yakindu.sct.ui.editor.validation.DefaultValidationIssueStore;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenericEditorModule extends AbstractGenericModule {

	public void configure(Binder binder) {
		super.configure(binder);
		Multibinder<IEditProposalProvider> proposalProviderBinder = Multibinder.newSetBinder(binder,
				IEditProposalProvider.class);
		proposalProviderBinder.addBinding().to(SmartEditProposalProvider.class);
		proposalProviderBinder.addBinding().to(RefactoringProposalProvider.class);
		binder.bind(IResourceValidator.class).to(SCTResourceValidatorImpl.class);
		binder.bind(IValidationIssueProcessor.class).to(DefaultValidationIssueStore.class);
	}

	public Class<? extends ISCTPaletteFactory> bindISCTPaletteFactory() {
		return DefaultSCTPaletteFactory.class;
	}

	public Class<? extends IDiagnosticConverter> bindIDiagnosticConverter() {
		return SCTDiagnosticConverterImpl.class;
	}

	public Class<? extends MarkerCreator> bindMarkerCreator() {
		return SCTMarkerCreator.class;
	}

	public Class<? extends MarkerTypeProvider> bindMarkerTypeProvider() {
		return SCTMarkerTypeProvider.class;
	}
	
	@SingletonBinding(eager = true)
	public Class<? extends STextValidator> bindSTextValidator() {
		return SExecValidator.class;
	}

}
