package org.yakindu.sct.ui.editor.providers;

import java.util.Map;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

public class StatechartPaletteProvider extends DefaultPaletteProvider {

	@Override
	public void contributeToPalette(IEditorPart editor, Object content,
			PaletteRoot root, Map predefinedEntries) {
		if (editor instanceof StatechartDiagramEditor) {
			StatechartDiagramEditor scEditor = (StatechartDiagramEditor) editor;
			if (StatechartDiagramEditor.ID.equals(scEditor.getContributorId())) {
				super.contributeToPalette(editor, content, root,
						predefinedEntries);
			}
		}
		return;
	}
}
