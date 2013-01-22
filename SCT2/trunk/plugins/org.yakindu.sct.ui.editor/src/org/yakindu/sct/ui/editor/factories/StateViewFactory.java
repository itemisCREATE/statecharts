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
package org.yakindu.sct.ui.editor.factories;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StateViewFactory extends AbstractShapeViewFactory {

	public static final String ALIGNMENT_ORIENTATION = "isHorizontal";

	@SuppressWarnings("unchecked")
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
		// State name
		FactoryUtils.createLabel(view, SemanticHints.STATE_NAME);
		// Text compartment
		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.STATE_TEXT_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());
		// Figure compartment
		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.STATE_FIGURE_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());

		// Create a boolean value style that indicates the alignment of
		// subregions
		BooleanValueStyle layout = (BooleanValueStyle) NotationFactory.eINSTANCE
				.createBooleanValueStyle();
		layout.setBooleanValue(true);
		layout.setName(ALIGNMENT_ORIENTATION);
		view.getStyles().add(layout);

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint()
				.getPreferenceStore();
		if (store == null) {
			return;
		}
		// Create states default styles
		ShapeStyle style = (ShapeStyle) view
				.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		RGB fillRGB = PreferenceConverter.getColor(store,
				StatechartPreferenceConstants.PREF_STATE_BACKGROUND);
		style.setFillColor(FigureUtilities.RGBToInteger(fillRGB));
		RGB lineRGB = PreferenceConverter.getColor(store,
				StatechartPreferenceConstants.PREF_STATE_LINE);
		style.setLineColor(FigureUtilities.RGBToInteger(lineRGB));
	}

	@Override
	protected List<Style> createStyles(View view) {
		@SuppressWarnings("unchecked")
		List<Style> styles = super.createStyles(view);
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}
}
