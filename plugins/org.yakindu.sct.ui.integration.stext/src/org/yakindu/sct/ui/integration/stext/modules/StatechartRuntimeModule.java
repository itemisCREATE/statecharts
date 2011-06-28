package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.ui.integration.stext.parsers.StatechartAntlrParser;

public class StatechartRuntimeModule extends STextRuntimeModule{
	@Override
	public Class<? extends IParser> bindIParser() {
		return StatechartAntlrParser.class;
	}
}
