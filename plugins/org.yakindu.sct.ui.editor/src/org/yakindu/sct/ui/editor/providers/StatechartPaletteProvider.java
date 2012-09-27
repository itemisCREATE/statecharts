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
package org.yakindu.sct.ui.editor.providers;

import java.util.Map;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

public class StatechartPaletteProvider extends DefaultPaletteProvider {

	@Override
	public void contributeToPalette(IEditorPart editor, Object content,
			PaletteRoot root, @SuppressWarnings("rawtypes") Map predefinedEntries) {
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
