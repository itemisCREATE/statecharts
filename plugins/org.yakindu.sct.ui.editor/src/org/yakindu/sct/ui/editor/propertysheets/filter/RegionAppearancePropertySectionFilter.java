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
package org.yakindu.sct.ui.editor.propertysheets.filter;

import org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter;
import org.yakindu.sct.ui.editor.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionNameEditPart;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public class RegionAppearancePropertySectionFilter extends ShapeEditPartPropertySectionFilter {

	public boolean select(Object object) {
		if (object instanceof RegionEditPart || object instanceof RegionNameEditPart || object instanceof RegionCompartmentEditPart)
			return true;
		return false;
	}
}
