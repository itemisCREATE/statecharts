/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.parser;

import org.yakindu.sct.model.stext.parser.antlr.STextParser;

import com.google.inject.Inject;
import com.google.inject.name.Named;
/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryRuleAntlrSTextParser extends STextParser implements IParserConstants {

	@Inject(optional = true)
	@Named(ENTRY_RULE)
	private String entryRule;

	@Override
	protected String getDefaultRuleName() {
		return entryRule != null ? entryRule : super.getDefaultRuleName();
	}

}
