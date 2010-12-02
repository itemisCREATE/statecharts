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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.IGotoMarker;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.validation.ValidationAction;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {

	public static final String ID = "org.yakindu.sct.statechart.diagram.StatechartDiagramEditor";

	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public String getContributorId() {
		return DiagramActivator.PLUGIN_ID;
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				ValidationAction.validate(getDiagramEditPart(), getDiagram());
			}
		});
		super.doSave(progressMonitor);
	}
	
	@Override
	public void setInput(IEditorInput input) {
		
		super.setInput(input);
	}
	
	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}
}
