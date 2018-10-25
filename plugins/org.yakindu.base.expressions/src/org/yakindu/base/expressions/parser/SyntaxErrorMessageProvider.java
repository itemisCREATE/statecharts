/**
 * Copyright (c) 2018 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * Tobias Angele - Itemis AG
 * 
 */
package org.yakindu.base.expressions.parser;

import static org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC;

import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

public class SyntaxErrorMessageProvider extends org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider {

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {		
		String defaultMessage = context.getDefaultMessage();
		if (defaultMessage.contains(SyntaxErrorMessages.MISSING_EOF)) {
			return new SyntaxErrorMessage("Failed to parse Expression '" + context.getRecognitionException().token.getText() + "'.", SYNTAX_DIAGNOSTIC);
		} else {
			return new SyntaxErrorMessage(defaultMessage, SYNTAX_DIAGNOSTIC);
		}
	}
}
