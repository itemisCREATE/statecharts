package org.yakindu.sct.statechart.expressions.ui.extensions.modules;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.yakindu.sct.statechart.expressions.ui.extensions.parsers.StateContentAssistParser;
import org.yakindu.sct.statechart.ui.ExpressionsUiModule;
/**
 * 
 * @author muelder
 *
 */
public class StateUIModule extends ExpressionsUiModule{

	public StateUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return StateContentAssistParser.class;
	}
}
