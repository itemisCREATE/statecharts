package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.ui.integration.stext.parsers.StateContentAssistParser;
/**
 * 
 * @author muelder
 *
 */
public class StateUIModule extends STextUiModule{

	public StateUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return StateContentAssistParser.class;
	}
	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return ProblemAnnotationHover.class;
	}
}
