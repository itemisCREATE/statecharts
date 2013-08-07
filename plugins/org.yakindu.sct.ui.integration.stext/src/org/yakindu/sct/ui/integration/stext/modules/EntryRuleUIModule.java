package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.ui.integration.stext.parsers.EntryRuleAntlrSTextParser;
import org.yakindu.sct.ui.integration.stext.parsers.EntryRuleContentAssistParser;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class EntryRuleUIModule extends STextUiModule {

	private Class<? extends EObject> parserRule;

	public EntryRuleUIModule(AbstractUIPlugin plugin, Class<? extends EObject> parserRule) {
		super(plugin);
		this.parserRule = parserRule;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(EntryRuleAntlrSTextParser.ENTRY_RULE))
				.toInstance(parserRule.getSimpleName());
	}

	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return EntryRuleContentAssistParser.class;
	}

}
