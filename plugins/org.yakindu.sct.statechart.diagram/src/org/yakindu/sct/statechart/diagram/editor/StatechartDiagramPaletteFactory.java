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
package org.yakindu.sct.statechart.diagram.editor;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.yakindu.sct.statechart.diagram.providers.ProviderException;

/**
 * Implementation of {@link PaletteFactory}.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartDiagramPaletteFactory extends PaletteFactory.Adapter {

	@Override
	public Tool createTool(String toolId) {
		IElementType elementType = StatechartElementTypes.fromSemanticId(toolId);
		if (elementType == null)
			throw new ProviderException("No Tool for toolId " + toolId + " found!");
		if (toolId.equals("Transition")) {
			return new ConnectionCreationTool(elementType);
		} else
			return new CreationTool(elementType);
	}

}
