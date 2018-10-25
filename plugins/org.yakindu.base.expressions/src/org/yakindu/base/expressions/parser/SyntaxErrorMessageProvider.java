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
