/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.parser;

import static org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

public class SyntaxErrorMessageProvider extends org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider {

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		String defaultMessage = context.getDefaultMessage();
		if (!defaultMessage.contains(SyntaxErrorMessages.MISSING_EOF)) {
			return new SyntaxErrorMessage(defaultMessage, SYNTAX_DIAGNOSTIC);
		}
		
		RecognitionException recognitionException = context.getRecognitionException();
		String message = "";
		boolean lexicalAnalysisFailed = recognitionException == null;
		
		if (lexicalAnalysisFailed) {
			message = "Failed to parse Expression.";
		} else {
			message = "Failed to parse Expression '" + recognitionException.token.getText() + "'.";
		}
		return new SyntaxErrorMessage(message, SYNTAX_DIAGNOSTIC);
	}
}
