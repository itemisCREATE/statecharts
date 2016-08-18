package org.yakindu.sct.domain.generic.editor;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.sct.refactoring.proposals.RefactoringProposalProvider;
import org.yakindu.sct.ui.editor.editor.proposals.SmartEditProposalProvider;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;
import org.yakindu.sct.ui.editor.providers.DefaultSCTPaletteFactory;
import org.yakindu.sct.ui.editor.providers.ISCTPaletteFactory;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

public class GenericEditorModule extends AbstractGenericModule {

	public void configure(Binder binder) {
		super.configure(binder);

		Multibinder<IEditProposalProvider> proposalProviderBinder = Multibinder.newSetBinder(binder,
				IEditProposalProvider.class);
		proposalProviderBinder.addBinding().to(SmartEditProposalProvider.class);
		proposalProviderBinder.addBinding().to(RefactoringProposalProvider.class);
	}

	public Class<? extends ISCTPaletteFactory> bindISCTPaletteFactory() {
		return DefaultSCTPaletteFactory.class;
	}
}
