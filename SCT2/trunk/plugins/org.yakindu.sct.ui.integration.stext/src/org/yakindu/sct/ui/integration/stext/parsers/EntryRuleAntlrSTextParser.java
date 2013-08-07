package org.yakindu.sct.ui.integration.stext.parsers;

import org.yakindu.sct.model.stext.parser.antlr.STextParser;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class EntryRuleAntlrSTextParser extends STextParser implements IParserConstants {

	@Inject(optional = true)
	@Named(ENTRY_RULE)
	private String entryRule;

	@Override
	protected String getDefaultRuleName() {
		return entryRule != null ? entryRule : super.getDefaultRuleName();
	}

}
