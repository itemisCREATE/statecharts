package org.yakindu.sct.statechart.simulation.ui.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingSupportAdapter;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * Adapts GMF Editors to a {@link IHighlightingSupport}
 * 
 * @author muelder
 * 
 */
@SuppressWarnings({ "rawtypes" })
public class IHighlightingSupportAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IHighlightingSupport.class) {
			if (adaptableObject instanceof DiagramDocumentEditor) {
				return new HighlightingSupportAdapter(
						(DiagramDocumentEditor) adaptableObject);
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IHighlightingSupport.class };
	}

}
