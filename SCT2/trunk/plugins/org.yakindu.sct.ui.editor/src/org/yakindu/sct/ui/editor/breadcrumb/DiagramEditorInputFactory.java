/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.breadcrumb;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DiagramEditorInputFactory implements IElementFactory {

	private static final String EMF_URI = "uri";

	public static final String ID = "org.yakindu.sct.ui.editor.DiagramEditorInputFactory";

	public IAdaptable createElement(IMemento memento) {
		String uriStr = memento.getString(EMF_URI);
		if (uriStr == null) {
			return null;
		}
		URI uri = URI.createURI(uriStr);
		ResourceSet resourceSet = DiagramPartitioningUtil.getSharedDomain().getResourceSet();
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			resource = resourceSet.createResource(uri);
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Diagram diagram = (Diagram) resource.getEObject(uri.fragment());
		return new DiagramEditorInput(diagram);
	}

	public static void saveState(IMemento memento, DiagramEditorInput input) {
		URI uri = EcoreUtil.getURI(input.getDiagram());
		String fileString = uri.toString();
		memento.putString(EMF_URI, fileString);
	}

}
