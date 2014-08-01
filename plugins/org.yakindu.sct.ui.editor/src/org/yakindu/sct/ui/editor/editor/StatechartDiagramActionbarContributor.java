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

import java.util.List;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartDiagramActionbarContributor extends DiagramActionBarContributor {

	@Override
	public void init(IActionBars bars) {
		super.init(bars);
		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=346648
		bars.setGlobalActionHandler(GlobalActionId.SAVE, null);
		bars.getToolBarManager().add(new ToggleDocumentationAction());
	}

	@Override
	protected String getEditorId() {
		return StatechartDiagramEditor.ID;
	}

	@Override
	protected Class<StatechartDiagramEditor> getEditorClass() {
		return StatechartDiagramEditor.class;
	}

	public static class ToggleDocumentationAction extends Action {
		public ToggleDocumentationAction() {
			setText("Toggle Documentation");
			setImageDescriptor(StatechartImages.MENU.imageDescriptor());
		}
		@Override
		public void run() {
			IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			if (activeEditor instanceof StatechartDiagramEditor) {
				Diagram diagram = ((StatechartDiagramEditor) activeEditor).getDiagram();
				List<View> result = EcoreUtil2.getAllContentsOfType(diagram, View.class);
				ToggleShowDocumentationCommand.toggleDocumentation(result);
			}

		}
	}

}
