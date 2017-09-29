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
public class ModelingPerspectiveFactory implements IPerspectiveFactory {

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

		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM,
				0.68f, "left");
		bottomLeft.addView(IPageLayout.ID_OUTLINE);

		IFolderLayout bottomRight = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.68f, editorArea);
		bottomRight.addView(IPageLayout.ID_PROP_SHEET);
		bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottomRight.addView(IPageLayout.ID_TASK_LIST);
	}

	private void defineActions(IPageLayout layout) {
		layout.addPerspectiveShortcut(IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION);
		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
	}

}
