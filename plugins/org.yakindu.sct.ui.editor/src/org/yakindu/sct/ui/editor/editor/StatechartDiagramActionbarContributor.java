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


import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.commands.DocumentationMenuAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author bohl - extracted actions
 */
public class StatechartDiagramActionbarContributor extends DiagramActionBarContributor {

	@Override
	public void init(IActionBars bars) {
		super.init(bars);
		bars.getToolBarManager().insertBefore(ActionIds.CUSTOM_ZOOM, new DocumentationMenuAction());

		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=346648
		bars.setGlobalActionHandler(GlobalActionId.SAVE, null);

		showButtonsByPerspective(bars);

		// remove 'arrange all' and 'arrange selection' actions
		bars.getToolBarManager().remove(ActionIds.MENU_ARRANGE);
		bars.getMenuManager().findMenuUsingPath(ActionIds.MENU_DIAGRAM).remove(ActionIds.MENU_ARRANGE);
	}

	private void showButtonsByPerspective(IActionBars bars) {
		IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		win.addPerspectiveListener(new DisableButtonsByPerspectiveListener(bars));
	}

	@Override
	protected String getEditorId() {
		return StatechartDiagramEditor.ID;
	}

	@Override
	protected Class<StatechartDiagramEditor> getEditorClass() {
		return StatechartDiagramEditor.class;
	}

}
