package org.yakindu.sct.ui.integration.stext.parsers;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.yakindu.sct.model.stext.ui.contentassist.antlr.STextParser;
import org.yakindu.sct.model.stext.ui.contentassist.antlr.internal.InternalSTextParser;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartContentAssistParser extends STextParser {

	@Override
	protected Collection<FollowElement> getFollowElements(
			AbstractInternalContentAssistParser parser) {
		try {
			InternalSTextParser typedParser = (InternalSTextParser) parser;
			typedParser.entryRuleStatechartSpecification();
			return typedParser.getFollowElements();
		} catch (RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}
}
