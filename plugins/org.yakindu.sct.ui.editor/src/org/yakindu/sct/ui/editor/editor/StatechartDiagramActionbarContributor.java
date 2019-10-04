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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ViewSite;
import org.yakindu.sct.ui.editor.commands.DocumentationMenuAction;
import org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author bohl - extracted actions
 */
public class StatechartDiagramActionbarContributor extends DiagramActionBarContributor {

	@Override
	public void init(IActionBars bars) {
		super.init(bars);

		List<IContributionItem> items = new ArrayList<IContributionItem>();
		items.add(bars.getToolBarManager().remove(ActionIds.CUSTOM_FILL_COLOR));
		items.add(bars.getToolBarManager().remove(ActionIds.CUSTOM_FONT_SIZE));
		items.add(bars.getToolBarManager().remove(ActionIds.CUSTOM_LINE_COLOR));
		items.add(bars.getToolBarManager().remove(ActionIds.CUSTOM_ZOOM));

		bars.getToolBarManager().add(new DocumentationMenuAction());

		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=346648
		bars.setGlobalActionHandler(GlobalActionId.SAVE, null);

		items.forEach(item -> {
			bars.getToolBarManager().add(item);
		});

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();

		win.addPerspectiveListener(new IPerspectiveListener() {
			@Override
			public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {

				if (!IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION.equals(perspective.getId()))
					return;

				IWorkbench wb = PlatformUI.getWorkbench();
				IWorkbenchWindow win = wb.getActiveWorkbenchWindow();

				for (IViewReference view : page.getViewReferences()) {

					if (!"Simulation".equals(view.getPartName()) || view.getPart(false) == null) {
						continue;
					}

					IWorkbenchPart part = view.getPart(false);
					IWorkbenchPartSite site = part.getSite();

					if (site instanceof IViewSite) {
						IViewSite viewSite = (IViewSite) site;
						IActionBars bla = viewSite.getActionBars();
						bla.getToolBarManager().remove(ActionIds.ACTION_FONT_BOLD);
						bla.getToolBarManager().remove(ActionIds.CUSTOM_FONT_NAME);
						bla.updateActionBars();
						System.out.println();

					}
				}

			}

			@Override
			public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
				System.out.println("changed -> " + changeId);
//					perspectiveActivated(page, perspective);

			}
		});

		// remove 'arrange all' and 'arrange selection' actions
		bars.getToolBarManager().remove(ActionIds.MENU_ARRANGE);
		bars.getMenuManager().findMenuUsingPath(ActionIds.MENU_DIAGRAM).remove(ActionIds.MENU_ARRANGE);
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
