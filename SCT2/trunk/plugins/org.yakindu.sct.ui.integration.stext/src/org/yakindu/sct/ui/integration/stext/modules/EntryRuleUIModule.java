package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.yakindu.sct.ui.integration.stext.parsers.EntryRuleAntlrSTextParser;
import org.yakindu.sct.ui.integration.stext.parsers.EntryRuleContentAssistParser;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class EntryRuleUIModule extends AbstractGenericModule {

	private Class<? extends EObject> parserRule;

	public EntryRuleUIModule(Class<? extends EObject> parserRule) {
		this.parserRule = parserRule;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(EntryRuleAntlrSTextParser.ENTRY_RULE))
				.toInstance(parserRule.getSimpleName());
	}

	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return EntryRuleContentAssistParser.class;
	}

}
