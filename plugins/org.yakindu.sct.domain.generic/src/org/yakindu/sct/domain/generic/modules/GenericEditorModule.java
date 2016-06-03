/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.generic.modules;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.sct.refactoring.proposals.RefactoringProposalProvider;
import org.yakindu.sct.ui.editor.editor.proposals.SmartEditProposalProvider;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;
import org.yakindu.sct.ui.editor.providers.DefaultSCTPaletteFactory;
import org.yakindu.sct.ui.editor.providers.ISCTPaletteFactory;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

/**
 * This module registers services that are intended to be used by the graphical editor.
 * 
 * @author terfloth
 *
 */
public class GenericEditorModule extends AbstractGenericModule {

	public void configure(Binder binder) {
		super.configure(binder);
		
		Multibinder<IEditProposalProvider> proposalProviderBinder = Multibinder.newSetBinder(binder, IEditProposalProvider.class);
	    proposalProviderBinder.addBinding().to(SmartEditProposalProvider.class);
	    proposalProviderBinder.addBinding().to(RefactoringProposalProvider.class);
	}
	
	public Class<? extends ISCTPaletteFactory> bindISCTPaletteFactory() {
		return DefaultSCTPaletteFactory.class;
	}
	
}
