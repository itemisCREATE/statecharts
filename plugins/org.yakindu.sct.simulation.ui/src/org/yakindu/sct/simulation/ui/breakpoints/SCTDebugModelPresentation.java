/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.breakpoints;

import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateOrSelectElementCommand.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugModelPresentation extends LabelProvider implements IDebugModelPresentation {

	private AdapterFactoryLabelProvider labelProvider;

	public SCTDebugModelPresentation() {
		labelProvider = new AdapterFactoryLabelProvider(new SGraphItemProviderAdapterFactory());
	}

	public String getEditorId(IEditorInput input, Object element) {
		return StatechartDiagramEditor.ID;
	}

	public Image getImage(Object element) {
		return labelProvider.getImage(((SCTBreakpoint) element).getSemanticObject());
	}

	public String getText(Object element) {
		return labelProvider.getText(((SCTBreakpoint) element).getSemanticObject());
	}

	public IEditorInput getEditorInput(Object element) {
		return null;
	}

	public void computeDetail(IValue value, IValueDetailListener listener) {
		// Nothing to do
	}

	public void setAttribute(String attribute, Object value) {
		// Nothing to do
	}

}
