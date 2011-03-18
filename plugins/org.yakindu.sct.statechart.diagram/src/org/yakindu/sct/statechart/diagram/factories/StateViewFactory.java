/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StateViewFactory extends AbstractShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}

		FactoryUtils.createLabel(view, SemanticHints.STATE_NAME);
		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.STATE_TEXT_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());

		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.STATE_FIGURE_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());

		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.eINSTANCE
				.getShapeStyle());
		style.setLineColor(FigureUtilities.RGBToInteger(ColorConstants.darkGray
				.getRGB()));
	}

}
