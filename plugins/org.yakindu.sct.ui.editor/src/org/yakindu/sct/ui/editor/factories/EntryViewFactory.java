/**
 * Copyright (c) 2015 committers of YAKINDU and others.
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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryViewFactory extends BorderItemLabelViewFactory {

	public static final String ALLOW_COLORS = "allowColors";

	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);
		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.Literals.SHAPE_STYLE);
		style.setFillColor(FigureUtilities.RGBToInteger(ColorConstants.black.getRGB()));
		style.setLineColor(FigureUtilities.RGBToInteger(ColorConstants.white.getRGB()));
	}

	@Override
	protected List<Style> createStyles(View view) {
		@SuppressWarnings("unchecked")
		List<Style> styles = super.createStyles(view);
		NamedStyle allowColorsStyle = NotationFactory.eINSTANCE.createNamedStyle();
		allowColorsStyle.setName(ALLOW_COLORS);
		styles.add(allowColorsStyle);
		return styles;
	}

}
