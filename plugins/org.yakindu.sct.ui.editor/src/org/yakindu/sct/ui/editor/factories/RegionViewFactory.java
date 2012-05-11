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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RegionViewFactory extends AbstractShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {

		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);

		// Create the region compartment
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		FactoryUtils.createLabel(view, SemanticHints.REGION_NAME);

		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.REGION_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());

	}

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		IPreferenceStore store = (IPreferenceStore) getPreferencesHint()
				.getPreferenceStore();
		if (store == null) {
			return;
		}

		// Create region default styles
		ShapeStyle style = (ShapeStyle) view
				.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		RGB fillRGB = PreferenceConverter.getColor(store,
				StatechartPreferenceConstants.PREF_REGION_BACKGROUND);
		style.setFillColor(FigureUtilities.RGBToInteger(fillRGB));
		RGB lineRGB = PreferenceConverter.getColor(store,
				StatechartPreferenceConstants.PREF_REGION_LINE);
		style.setLineColor(FigureUtilities.RGBToInteger(lineRGB));
	}
}
