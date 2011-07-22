/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Andreas Unger
 *
 */
public class MscriptHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String FUNCTION_ID = "function";
	public static final String ITERATION_ID = "iteration";
	public static final String BUILTIN_ID = "builtin";
	public static final String UNIT_ID = "unit";
	public static final String STEP_EXPRESSION_ID = "stepExpression";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(FUNCTION_ID, "Function", functionTextStyle());
		acceptor.acceptDefaultHighlighting(ITERATION_ID, "Iteration", iterationTextStyle());
		acceptor.acceptDefaultHighlighting(BUILTIN_ID, "Built-in Symbol", builtinTextStyle());
		acceptor.acceptDefaultHighlighting(UNIT_ID, "Unit", unitTextStyle());
		acceptor.acceptDefaultHighlighting(STEP_EXPRESSION_ID, "Step Expression", stepExpressionTextStyle());
	}

	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	
	public TextStyle functionTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle iterationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100, 40, 128));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle builtinTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100, 40, 128));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle unitTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100, 100, 100));
		return textStyle;
	}

	public TextStyle stepExpressionTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 76, 25));
		return textStyle;
	}

}
