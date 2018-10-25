package org.yakindu.base.expressions.linking;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class LinkingDiagnosticMessageProvider extends org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider {
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		String message;
		if (context.getLinkText() == null) {
			ICompositeNode node = NodeModelUtils.getNode(context.getContext());
			message = node.getText();
		} else {
			message = context.getLinkText();
		}
		return new DiagnosticMessage("Could not find declaration of '" + message + "'", Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
}
