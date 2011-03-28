package org.yakindu.sct.statechart.expressions.ui.extensions.parsers;

import org.yakindu.sct.statechart.parser.antlr.ExpressionsParser;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartAntlrParser extends ExpressionsParser {
	@Override
	protected String getDefaultRuleName() {
		return "StatechartDefinition";
	}
}
