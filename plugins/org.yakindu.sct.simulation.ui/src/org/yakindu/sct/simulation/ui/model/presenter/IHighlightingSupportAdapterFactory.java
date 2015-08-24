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
package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.yakindu.base.gmf.runtime.highlighting.HighlightingSupportAdapter;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;

/**
 * Adapts GMF Editors to a {@link IHighlightingSupport}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings({ "rawtypes" })
public class IHighlightingSupportAdapterFactory implements IAdapterFactory {

	private static Map<DiagramDocumentEditor, IHighlightingSupport> cache;
	static {
		cache = new HashMap<DiagramDocumentEditor, IHighlightingSupport>();
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IHighlightingSupport.class) {
			if (adaptableObject instanceof DiagramDocumentEditor) {
				IHighlightingSupport supportFromCache = cache
						.get((DiagramDocumentEditor) adaptableObject);
				if (supportFromCache != null)
					return supportFromCache;
				supportFromCache = new HighlightingSupportAdapter(
						(DiagramDocumentEditor) adaptableObject);
				cache.put((DiagramDocumentEditor) adaptableObject,
						supportFromCache);
				return supportFromCache;
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IHighlightingSupport.class };
	}

}
