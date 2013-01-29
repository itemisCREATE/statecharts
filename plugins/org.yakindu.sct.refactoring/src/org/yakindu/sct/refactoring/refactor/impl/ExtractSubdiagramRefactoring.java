/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExtractSubdiagramRefactoring extends SubdiagramRefactoring {


	@Override
	public boolean isExecutable() {
		State state = (State) getContextObject().getElement();
		return super.isExecutable() && state.isComposite()
				&& getInlineStyle().isBooleanValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void internalExecute() {
		getInlineStyle().setBooleanValue(false);

		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();

		Diagram subdiagram = ViewService.createDiagram(contextElement,
				StatechartDiagramEditor.ID, preferencesHint);
		View figureCompartment = ViewUtil.getChildBySemanticHint(contextView,
				SemanticHints.STATE_FIGURE_COMPARTMENT);
		EList<View> children = figureCompartment.getChildren();
		for (View view : children) {
			if (view.getElement() instanceof Region) {
				subdiagram.insertChild(view);
			}
		}
		getResource().getContents().add(subdiagram);

	}
}
