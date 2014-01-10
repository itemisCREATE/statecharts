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

import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.createInlineStyle;
import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.getInlineStyle;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramRefactoring extends AbstractRefactoring<View> {

	@Override
	public boolean isExecutable() {
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
		return super.isExecutable() && inlineStyle != null && !inlineStyle.isBooleanValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void internalExecute() {
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
		if (inlineStyle == null) {
			inlineStyle = createInlineStyle();
			getContextObject().getStyles().add(inlineStyle);
		}
		inlineStyle.setBooleanValue(true);
		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();
		Diagram diagramToInline = DiagramPartitioningUtil.getSubDiagram(contextElement);
		View containerView = ViewUtil.getChildBySemanticHint(contextView, SemanticHints.STATE_FIGURE_COMPARTMENT);

		while (diagramToInline.getChildren().size() > 0) {
			containerView.insertChild((View) diagramToInline.getChildren().get(0));
		}
		while (diagramToInline.getEdges().size() > 0) {
			containerView.getDiagram().insertEdge((Edge) diagramToInline.getEdges().get(0));

		}
		getResource().getContents().remove(diagramToInline);
	}
}
