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
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class TransitionViewFactory extends ConnectionViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable element, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index,
				persisted);

		Node label = FactoryUtils.createLabel(view,
				SemanticHints.TRANSITION_EXPRESSION);
		Location location = (Location) label.getLayoutConstraint();
		location.setX(0);
		location.setY(40);
		
	}
}
