package org.yakindu.sct.ui.integration.stext.parsers;

import org.yakindu.sct.model.stext.parser.antlr.STextParser;
import org.yakindu.sct.model.stext.stext.StateSpecification;


/**
 * 
 * @author muelder
 * 
 */
public class StateAntlrParser extends STextParser {
	@Override
	protected String getDefaultRuleName() {
		return StateSpecification.class.getSimpleName();
	}
}
