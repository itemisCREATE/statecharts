package org.yakindu.sct.generator.genmodel.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class SGenHighlightingConfiguration extends
		DefaultHighlightingConfiguration {

	public static final String DEPRECATION = "deprecation";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(DEPRECATION, "Deprecation",
				deprecationTextStyle());
	}

	public TextStyle deprecationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.UNDERLINE_SQUIGGLE);
		return textStyle;
	}
}
