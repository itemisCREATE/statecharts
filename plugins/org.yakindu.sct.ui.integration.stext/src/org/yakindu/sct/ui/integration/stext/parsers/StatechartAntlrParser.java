package org.yakindu.sct.ui.integration.stext.parsers;

import org.yakindu.sct.model.stext.parser.antlr.STextParser;
import org.yakindu.sct.model.stext.stext.StatechartDefinition;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartAntlrParser extends STextParser {
	@Override
	protected String getDefaultRuleName() {
		return StatechartDefinition.class.getSimpleName();
	}
}
