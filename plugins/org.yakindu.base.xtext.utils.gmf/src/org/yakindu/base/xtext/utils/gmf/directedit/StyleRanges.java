package org.yakindu.base.xtext.utils.gmf.directedit;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ITextAttributeProvider;

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
		return ranges;
	}

}
