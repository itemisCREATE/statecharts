package org.yakindu.sct.statechart.expressions.ui.extensions.parsers;

import org.yakindu.sct.statechart.parser.antlr.ExpressionsParser;

/**
 * 
 * @author muelder
 * 
 */
public class StateAntlrParser extends ExpressionsParser {
	@Override
	protected String getDefaultRuleName() {
		return "StateDefinition";
	}
}
