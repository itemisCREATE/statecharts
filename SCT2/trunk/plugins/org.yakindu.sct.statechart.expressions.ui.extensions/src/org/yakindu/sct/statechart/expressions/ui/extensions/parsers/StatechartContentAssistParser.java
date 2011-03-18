package org.yakindu.sct.statechart.expressions.ui.extensions.parsers;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.yakindu.sct.statechart.ui.contentassist.antlr.ExpressionsParser;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartContentAssistParser extends ExpressionsParser {

	@Override
	protected Collection<FollowElement> getFollowElements(
			AbstractInternalContentAssistParser parser) {
		try {
			org.yakindu.sct.statechart.ui.contentassist.antlr.internal.InternalExpressionsParser typedParser = (org.yakindu.sct.statechart.ui.contentassist.antlr.internal.InternalExpressionsParser) parser;
			typedParser.entryRuleElementDefinition();
			return typedParser.getFollowElements();
		} catch (RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}
}
