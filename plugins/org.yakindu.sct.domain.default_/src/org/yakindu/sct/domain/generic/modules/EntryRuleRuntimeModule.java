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
package org.yakindu.sct.domain.generic.modules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.sct.model.stext.parser.EntryRuleAntlrSTextParser;

import com.google.inject.Binder;
import com.google.inject.name.Names;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
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
