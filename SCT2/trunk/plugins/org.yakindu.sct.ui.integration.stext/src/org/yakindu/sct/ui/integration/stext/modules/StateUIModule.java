/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.integration.stext.modules;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.ui.integration.stext.parsers.StateContentAssistParser;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateUIModule extends STextUiModule {

	public StateUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return StateContentAssistParser.class;
	}

	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return ProblemAnnotationHover.class;
	}
}
