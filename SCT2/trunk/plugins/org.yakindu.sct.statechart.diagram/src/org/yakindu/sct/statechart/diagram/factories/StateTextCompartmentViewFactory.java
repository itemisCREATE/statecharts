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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.CompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author muelder
 *
 */
public class StateTextCompartmentViewFactory extends CompartmentViewFactory {

	@Override
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
			int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);

//		IAdaptable eObjectAdapter = null;
//		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
//		if (eObject != null) {
//			eObjectAdapter = new EObjectAdapter(eObject);
//		}
//		getViewService().createNode(eObjectAdapter, view,
//				SemanticHints.STATE_TEXT_COMPARTMENT_EXPRESSION,
//			ViewUtil.APPEND, true, getPreferencesHint());
	
	}
	
	
}
