/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.contentassist;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;

import com.google.common.collect.Lists;

/**
 * This class is used to always set a current model when the context for the
 * proposal provider is created. It is used to propose Events as Transition
 * triggers.
 * 
 */
public class STextStatefulFactory extends StatefulFactory {
	private IParseResult parseResult;

	@Override
	public Builder doCreateContext(INode lastCompleteNode, EObject currentModel, EObject previousModel,
			INode currentNode, String prefix) {
		if (currentModel == null) {
			currentModel = parseResult.getRootASTElement();
		}
		Builder result = super.doCreateContext(lastCompleteNode, currentModel, previousModel, currentNode, prefix);
		return result;
	}

	protected void initializeFromViewerAndResource(int offset) {
		if (Display.getCurrent() == null) {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					initializeAndAdjustCompletionOffset(offset);
					initializeNodeAndModelData();
					contextBuilders = Collections.synchronizedList(Lists.<ContentAssistContext.Builder>newArrayList());
				}
			});
		}
	}
}