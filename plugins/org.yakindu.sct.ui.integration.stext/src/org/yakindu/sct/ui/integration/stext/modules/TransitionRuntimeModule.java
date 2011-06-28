package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.ui.integration.stext.parsers.TransitionAntlrParser;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionRuntimeModule extends STextRuntimeModule {
	@Override
	public Class<? extends IParser> bindIParser() {
		return TransitionAntlrParser.class;
	}
}
