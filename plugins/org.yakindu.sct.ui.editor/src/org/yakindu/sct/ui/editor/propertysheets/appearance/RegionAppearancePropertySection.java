/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets.appearance;

import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ShapeColorsAndFontsPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.propertysheets.util.SelectionUnwrapperUtil;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public class RegionAppearancePropertySection extends ShapeColorsAndFontsPropertySection {

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, SelectionUnwrapperUtil.unwrapSelectionForType(selection, RegionEditPart.class));
	}
}
