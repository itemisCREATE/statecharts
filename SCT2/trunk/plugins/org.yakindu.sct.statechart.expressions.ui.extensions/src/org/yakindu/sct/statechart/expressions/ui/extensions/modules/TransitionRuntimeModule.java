package org.yakindu.sct.statechart.expressions.ui.extensions.modules;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.statechart.ExpressionsRuntimeModule;
import org.yakindu.sct.statechart.expressions.ui.extensions.parsers.TransitionAntlrParser;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionRuntimeModule extends ExpressionsRuntimeModule {
	@Override
	public Class<? extends IParser> bindIParser() {
		return TransitionAntlrParser.class;
	}
}
