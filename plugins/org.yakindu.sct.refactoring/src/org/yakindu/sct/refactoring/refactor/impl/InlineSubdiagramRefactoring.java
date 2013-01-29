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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramRefactoring extends SubdiagramRefactoring {

	@Override
	public boolean isExecutable() {
		return super.isExecutable() && !getInlineStyle().isBooleanValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void internalExecute() {
		getInlineStyle().setBooleanValue(true);

		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();
		Diagram inlineDiagram = findDiagramForState(contextElement);
		View figureCompartment = ViewUtil.getChildBySemanticHint(contextView,
				SemanticHints.STATE_FIGURE_COMPARTMENT);

		EList<View> children = inlineDiagram.getChildren();
		for (View view : children) {
			figureCompartment.insertChild(view);
		}
		getResource().getContents().remove(inlineDiagram);
	}

	protected Diagram findDiagramForState(State state) {
		EList<EObject> contents = getResource().getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Diagram) {
				if (EcoreUtil.equals(((Diagram) eObject).getElement(), state)) {
					return (Diagram) eObject;
				}
			}
		}
		return null;
	}
}
