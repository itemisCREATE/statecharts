package de.itemis.xtext.gmf.integration.celleditors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Injector;

import de.itemis.xtext.gmf.integration.utils.XtextUtils;

/**
 * Implementation of {@link IContentProposalProvider} that converts the
 * {@link ICompletionProposal} from the xText Proposal Provider to
 * {@link IContentProposal} that is compatible with JFace Viewers
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * 
 */
class XTextProposalProvider implements IContentProposalProvider {

	private final Injector injector;
	private final TextViewer viewer;
	private XtextDocument document = null;

	public XTextProposalProvider(Injector injector) {
		this.injector = injector;
		// Unfortunately the content proposal API of xtext is
		// depending on TextViewers, so we have to fake a TextViewer with
		// Documents etc.
		this.viewer = new TextViewer(new Shell(), SWT.NONE);
		this.document = XtextUtils.createDummyDocument(injector, null);
		viewer.setDocument(document);
	}

	public IContentProposal[] getProposals(final String contents,
			final int position) {
		XtextUtils.updateDocument(document, contents);
		viewer.refresh();
		IContentAssistProcessor processor = injector
				.getInstance(IContentAssistProcessor.class);
		ICompletionProposal[] proposals = processor.computeCompletionProposals(
				viewer, position);
		return adaptXtextProposals(proposals);
	}

	public IContentProposal[] adaptXtextProposals(
			ICompletionProposal[] proposals) {
		List<IContentProposal> contentProposals = new ArrayList<IContentProposal>();
		for (ICompletionProposal proposal : proposals) {
			contentProposals.add(new XtextContentProposal(document,
					(ConfigurableCompletionProposal) proposal));
		}
		return contentProposals.toArray(new IContentProposal[] {});
	}

	/**
	 * 
	 * Adapter class that adapts the editors {@link ICompletionProposal} to
	 * CellEditors {@link IContentProposal}
	 * 
	 * @author andreas.muelder@itemis.de
	 * 
	 */
	class XtextContentProposal implements IContentProposal {

		private final ConfigurableCompletionProposal completionProposal;
		private final XtextDocument document;

		public XtextContentProposal(XtextDocument document,
				ConfigurableCompletionProposal completionProposal) {
			this.document = document;
			this.completionProposal = completionProposal;
		}

		public String getContent() {
			// always compute and return the text as it would be after the
			// completion of the proposal
			// i.e. a REPLACE is always assumed.
			StringBuffer text = new StringBuffer(document.get());
			text.replace(completionProposal.getReplacementOffset(),
					completionProposal.getReplacementOffset()
							+ completionProposal.getReplacementLength(),
					completionProposal.getReplacementString());
			return text.toString();

		}

		public int getCursorPosition() {
			return completionProposal.getReplacementOffset()
					+ completionProposal.getCursorPosition();
		}

		public String getDescription() {
			return completionProposal.getAdditionalProposalInfo();
		}

		public String getLabel() {
			return completionProposal.getDisplayString();
		}
	}
}
