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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StateViewFactory extends AbstractStateViewFactory {

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
		// Create figure compartment 
		getViewService().createNode(eObjectAdapter, view,
				SemanticHints.COMPOSITE_STATE_FIGURE_COMPARTMENT, ViewUtil.APPEND, true,
				getPreferencesHint());

		// Create a boolean value style that indicates the alignment of
		// subregions
		BooleanValueStyle layout = (BooleanValueStyle) NotationFactory.eINSTANCE
				.createBooleanValueStyle();
		layout.setBooleanValue(false);
		view.getStyles().add(layout);

	}

}
