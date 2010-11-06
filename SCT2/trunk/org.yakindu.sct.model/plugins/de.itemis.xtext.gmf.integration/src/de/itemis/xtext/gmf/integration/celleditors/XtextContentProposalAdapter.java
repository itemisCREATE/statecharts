package de.itemis.xtext.gmf.integration.celleditors;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Control;

import com.google.inject.Injector;

public class XtextContentProposalAdapter extends
		ContentProposalAdapter {
	
	public XtextContentProposalAdapter(Control control,
			Injector injector, KeyStroke keyStroke,
			char[] autoActivationCharacters) {
		super(control, new TextContentAdapter(),
				new XTextProposalProvider(injector), keyStroke,
				autoActivationCharacters);
		// always replace (xtext proposal provider always returns a complete replacement text)
		setProposalAcceptanceStyle(PROPOSAL_REPLACE);
	}
}