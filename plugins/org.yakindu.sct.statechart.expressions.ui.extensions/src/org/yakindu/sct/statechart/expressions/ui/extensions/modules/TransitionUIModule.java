package org.yakindu.sct.statechart.expressions.ui.extensions.modules;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.yakindu.sct.statechart.expressions.ui.extensions.parsers.TransitionContentAssistParser;
import org.yakindu.sct.statechart.ui.ExpressionsUiModule;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionUIModule extends ExpressionsUiModule {

	public TransitionUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return TransitionContentAssistParser.class;
	}
	
	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return ProblemAnnotationHover.class;
	}
}
