package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.ui.integration.stext.parsers.StateAntlrParser;
/**
 * 
 * @author muelder
 *
 */
public class StateRuntimeModule extends STextRuntimeModule{
	@Override
	public Class<? extends IParser> bindIParser() {
		return StateAntlrParser.class;
	}
}
