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
package org.yakindu.sct.model.stext.ui.contentassist;

import java.lang.reflect.Method;
import java.util.Collection;

import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.yakindu.sct.model.stext.parser.IParserConstants;
import org.yakindu.sct.model.stext.ui.contentassist.antlr.STextParser;
import org.yakindu.sct.model.stext.ui.contentassist.antlr.internal.InternalSTextParser;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 
 * @author muelder
 * 
 */
public class EntryRuleContentAssistParser extends STextParser implements IParserConstants {

	@Inject(optional = true)
	@Named(ENTRY_RULE)
	private String entryRule;

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		if (entryRule == null)
			return super.getFollowElements(parser);
		try {
			InternalSTextParser typedParser = (InternalSTextParser) parser;
			Method method = typedParser.getClass().getMethod(ENTRY_RULE + entryRule);
			method.invoke(typedParser);
			return typedParser.getFollowElements();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
