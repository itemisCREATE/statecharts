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
package org.yakindu.sct.ui.editor.factories;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextFactory extends ShapeViewFactory implements
		SemanticHints {

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
		//Create the statechart name label
		FactoryUtils.createLabel(view, STATECHART_NAME);
		//create the expressions compartment
		Node textCompartment = getViewService().createNode(eObjectAdapter,
				view, STATECHART_TEXT_EXPRESSION, ViewUtil.APPEND, true,
				getPreferencesHint());
		Assert.isNotNull(textCompartment);
		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.eINSTANCE
				.getShapeStyle());
		style.setFillColor(FigureUtilities.RGBToInteger(ColorConstants.white
				.getRGB()));
	}
}
