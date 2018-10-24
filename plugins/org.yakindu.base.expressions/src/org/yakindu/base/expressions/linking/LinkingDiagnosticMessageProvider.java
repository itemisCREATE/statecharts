/**
 * Copyright (c) 2018 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * Tobias Angele - Itemis AG
 * 
 */
package org.yakindu.base.expressions.linking;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.IllegalNodeException;

public class LinkingDiagnosticMessageProvider extends org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider {
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		String linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e){
			linkText = e.getNode().getText();
		}
		String message = "Could not find declaration of '" + linkText + "'";
		return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
}
