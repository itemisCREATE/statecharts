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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Convenience methods for semantic and notation model element creation.
 *
 * @author muelder
 *
 */
public final class FactoryUtils {

	private FactoryUtils() {
	}

	@SuppressWarnings("unchecked")
	public static Node createLabel(View owner, String hint) {
		DecorationNode nameLabel = NotationFactory.eINSTANCE.createDecorationNode();
		nameLabel.setType(hint);

		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		style.setFontColor(FigureUtilities.RGBToInteger(ColorConstants.black.getRGB()));
		nameLabel.getStyles().add(style);

		ViewUtil.insertChildView(owner, nameLabel, ViewUtil.APPEND, true);
		nameLabel.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		return nameLabel;
	}

}
