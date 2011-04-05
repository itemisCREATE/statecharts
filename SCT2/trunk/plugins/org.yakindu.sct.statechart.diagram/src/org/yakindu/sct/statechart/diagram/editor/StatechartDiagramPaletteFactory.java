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
import org.eclipse.swt.SWT;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartDiagramPaletteFactory extends PaletteFactory.Adapter {

	@Override
	public Tool createTool(String toolId) {
		IElementType elementType = StatechartElementTypes
				.fromSemanticId(toolId);
		if (elementType == null)
			throw new IllegalStateException("No Tool for toolId " + toolId
					+ " found!");
		if (toolId.equals("Transition")) {
			return new ConnectionCreationTool(elementType){
				//https://bugs.eclipse.org/bugs/show_bug.cgi?id=341893
				protected void handleFinished() {
			        if (!getCurrentInput().isModKeyDown(SWT.MOD1)) {
			            super.handleFinished();
			        } else {
			            reactivate();
			        }
			    }
			};
		} else
			return new CreationTool(elementType) {
			//https://bugs.eclipse.org/bugs/show_bug.cgi?id=341893
			protected void handleFinished() {
		        if (!getCurrentInput().isModKeyDown(SWT.MOD1)) {
		            super.handleFinished();
		        } else {
		            reactivate();
		        }
		    }
		};
	}

}
