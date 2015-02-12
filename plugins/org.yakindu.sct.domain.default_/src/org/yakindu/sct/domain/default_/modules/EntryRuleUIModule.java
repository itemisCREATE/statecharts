/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.domain.default_.modules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.yakindu.sct.model.stext.parser.EntryRuleAntlrSTextParser;
import org.yakindu.sct.model.stext.ui.contentassist.EntryRuleContentAssistParser;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
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
