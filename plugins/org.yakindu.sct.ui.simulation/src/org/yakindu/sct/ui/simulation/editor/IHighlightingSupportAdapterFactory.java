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
package org.yakindu.sct.ui.simulation.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingSupportAdapter;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * Adapts GMF Editors to a {@link IHighlightingSupport}
 * 
 * @author andreas muelder - Initial contribution and API
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
