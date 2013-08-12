/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * 
 * @author martin esser
 * 
 */
public class SimulationPerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);

	}

	private void defineLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT,
				0.16f, editorArea);
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		// Included to get rid of a warning issued by the workbench
		left.addPlaceholder("org.eclipse.jdt.ui.PackageExplorer");

		IFolderLayout topRight = layout.createFolder("topRight",
				IPageLayout.RIGHT, 0.84f, editorArea);
		topRight.addView(IPageLayout.ID_OUTLINE);

		IFolderLayout bottomRight = layout.createFolder("bottomRight",
				IPageLayout.BOTTOM, 0.33f, "topRight");
		bottomRight.addView("org.yakindu.sct.simulation.ui.declarationview");
		bottomRight.addView("org.eclipse.debug.ui.BreakpointView");

		IFolderLayout top = layout.createFolder("top", IPageLayout.TOP, 0.22f,
				editorArea);
		top.addView("org.eclipse.debug.ui.DebugView");
	}

	private void defineActions(IPageLayout layout) {
		layout.addPerspectiveShortcut(IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_MODELING);
		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
	}

}
