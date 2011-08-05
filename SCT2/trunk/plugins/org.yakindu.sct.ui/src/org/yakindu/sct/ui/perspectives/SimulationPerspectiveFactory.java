package org.yakindu.sct.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class SimulationPerspectiveFactory implements IPerspectiveFactory {

	@Override
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

		IFolderLayout top = layout.createFolder("top", IPageLayout.TOP, 0.22f,
				editorArea);
		top.addView("org.eclipse.debug.ui.DebugView");
	}

	private void defineActions(IPageLayout layout) {
		layout.addNewWizardShortcut("org.yakindu.sct.ui.editor.StatechartDiagramWizard");
		layout.addPerspectiveShortcut(IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_MODELING);
		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
	}

}
