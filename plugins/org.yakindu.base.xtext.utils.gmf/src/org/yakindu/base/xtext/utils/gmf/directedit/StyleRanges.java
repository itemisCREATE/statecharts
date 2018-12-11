/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.base.xtext.utils.gmf.directedit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ITextAttributeProvider;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class StyleRanges {
	
	@Inject
	private Provider<DocumentTokenSource> tokenSourceProvider;
	@Inject
	private ITextAttributeProvider attributeProvider;
	@Inject
	private DefaultAntlrTokenToAttributeIdMapper tokenTypeMapper;
	
	public List<StyleRange> getRanges(String expression) {
		final List<StyleRange> ranges = Lists.newArrayList();
		DocumentEvent event = new DocumentEvent();
		event.fDocument = new DummyDocument(expression);
		DocumentTokenSource tokenSource = tokenSourceProvider.get();
		tokenSource.updateStructure(event);
		Iterator<ILexerTokenRegion> iterator = tokenSource.getTokenInfos().iterator();
		while (iterator.hasNext()) {
			ILexerTokenRegion next = iterator.next();
			TextAttribute attribute = attributeProvider.getAttribute(tokenTypeMapper.getId(next.getLexerTokenType()));
			StyleRange range = new StyleRange(next.getOffset(), next.getLength(), attribute.getForeground(),
					attribute.getBackground());
			range.font = attribute.getFont();
			range.fontStyle = attribute.getStyle();
			ranges.add(range);
		}
		return merge(ranges);
	}
	
	protected List<StyleRange> merge(List<StyleRange> ranges) {
		List<StyleRange> result = new ArrayList<>();
		for (StyleRange styleRange : ranges) {
			if (result.isEmpty()) {
				result.add(styleRange);
				continue;
			}
			StyleRange lastRange = result.get(result.size() - 1);
			if (equal(lastRange, styleRange)) {
				lastRange.length += styleRange.length;
			} else
				result.add(styleRange);
		}
		return result;
	}
	
	protected boolean equal(StyleRange lastRange, StyleRange styleRange) {
		return lastRange.fontStyle == styleRange.fontStyle && Objects.equal(lastRange.background, styleRange.background)
				&& Objects.equal(lastRange.foreground, styleRange.foreground);
	}
	
}
