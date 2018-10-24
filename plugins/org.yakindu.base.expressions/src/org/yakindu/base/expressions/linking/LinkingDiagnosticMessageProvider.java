package org.yakindu.base.expressions.linking;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;

public class LinkingDiagnosticMessageProvider extends org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider {
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		String message = "Could not find declaration of '" + context.getLinkText() + "'";
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
}
