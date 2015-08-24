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
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.yakindu.base.gmf.runtime.palette.CreationTool;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author muehlbrandt
 * 
 */
public class StatechartDiagramPaletteFactory extends PaletteFactory.Adapter {

	@Override
	public Tool createTool(String toolId) {
		IElementType elementType = ElementTypeRegistry.getInstance().getType(
				toolId);
		if (elementType == null)
			throw new IllegalStateException("No Element Id for toolId "
					+ toolId + " found!");
		if (toolId.equals(StatechartElementTypes.TRANSITION.getId())) {
			return new ConnectionCreationTool(elementType);
		}
		if (toolId.equals(StatechartElementTypes.ENTRY.getId())
				|| toolId.equals(StatechartElementTypes.DEEPHISTORY.getId())
				|| toolId.equals(StatechartElementTypes.SHALLOWHISTORY.getId())
				|| toolId.equals(StatechartElementTypes.EXIT.getId())) {
			return new CreationTool(elementType, false);
		} else
			return new CreationTool(elementType, true);
	}
}
