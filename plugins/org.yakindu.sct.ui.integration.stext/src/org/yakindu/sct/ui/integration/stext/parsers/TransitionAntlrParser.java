package org.yakindu.sct.ui.integration.stext.parsers;

import org.yakindu.sct.model.stext.parser.antlr.STextParser;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

/**
 * @author muelder
 */
public class TransitionAntlrParser extends STextParser {
	@Override
	protected String getDefaultRuleName() {
		return TransitionSpecification.class.getSimpleName();
	}
}
