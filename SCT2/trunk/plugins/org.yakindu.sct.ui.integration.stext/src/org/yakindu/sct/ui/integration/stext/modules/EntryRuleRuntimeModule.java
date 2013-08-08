package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.sct.ui.integration.stext.parsers.EntryRuleAntlrSTextParser;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class EntryRuleRuntimeModule extends AbstractGenericModule {

	private Class<? extends EObject> parserRule;

	public EntryRuleRuntimeModule(Class<? extends EObject> parserRule) {
		this.parserRule = parserRule;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(EntryRuleAntlrSTextParser.ENTRY_RULE))
				.toInstance(parserRule.getSimpleName());
	}

	public Class<? extends IParser> bindIParser() {
		return EntryRuleAntlrSTextParser.class;
	}
}
