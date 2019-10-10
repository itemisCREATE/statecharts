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

import static org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
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

		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=346648
		bars.setGlobalActionHandler(GlobalActionId.SAVE, null);
		bars.getToolBarManager().add(new DocumentationMenuAction());

		removeAppearanceButtonsInSimulationAndTestingPerspective(bars);

		// remove 'arrange all' and 'arrange selection' actions
		bars.getToolBarManager().remove(ActionIds.MENU_ARRANGE);
		bars.getMenuManager().findMenuUsingPath(ActionIds.MENU_DIAGRAM).remove(ActionIds.MENU_ARRANGE);
	}

	private void removeAppearanceButtonsInSimulationAndTestingPerspective(IActionBars bars) {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();

		win.addPerspectiveListener(new IPerspectiveListener() {

			@Override
			public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
				setToolbarButtons(bars, perspective);
			}

			@Override
			public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
				setToolbarButtons(bars, perspective);
			}

			private void setToolbarButtons(IActionBars bars, IPerspectiveDescriptor perspective) {
				boolean isSimulationPers = ID_PERSPECTIVE_SCT_SIMULATION.equals(perspective.getId());
				enableAppearanceButtons(bars.getToolBarManager(), !isSimulationPers);
			}

			private void enableAppearanceButtons(IToolBarManager tb, boolean b) {
				tb.find(ActionIds.CUSTOM_FONT_NAME).setVisible(b);
				tb.find(ActionIds.CUSTOM_FONT_SIZE).setVisible(b);
				tb.find(ActionIds.CUSTOM_ZOOM).setVisible(b);
				tb.find(ActionIds.CUSTOM_FILL_COLOR).setVisible(b);
				tb.find(ActionIds.CUSTOM_LINE_COLOR).setVisible(b);
				tb.find(ActionIds.CUSTOM_FONT_COLOR).setVisible(b);
				tb.find(ActionIds.ACTION_FONT_BOLD).setVisible(b);
				tb.find(ActionIds.ACTION_FONT_ITALIC).setVisible(b);
				tb.find(ActionIds.ACTION_AUTOSIZE).setVisible(b);
				tb.find(ActionIds.MENU_ROUTER).setVisible(b);
				tb.find(ActionIds.MENU_SELECT).setVisible(b);
				tb.find(ActionIds.MENU_COMPARTMENT).setVisible(b);
				tb.find(ActionIds.MENU_ALIGN).setVisible(b);
				tb.find(ActionIds.ACTION_HIDE_CONNECTION_LABELS).setVisible(b);
				tb.find(ActionIds.ACTION_SHOW_CONNECTION_LABELS).setVisible(b);
				tb.find(ActionIds.ACTION_COPY_APPEARANCE_PROPERTIES).setVisible(b);
				tb.update(true);
			}
		});
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
