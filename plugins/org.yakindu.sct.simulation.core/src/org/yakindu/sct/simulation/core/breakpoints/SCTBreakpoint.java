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
package org.yakindu.sct.simulation.core.breakpoints;

import java.util.Collections;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBreakpoint extends Breakpoint {

	public static final String BREAKPOINT_ID = "org.yakindu.sct.debug.core.breakpoints";
	public static final String MARKER_ID = "org.yakindu.sct.simulation.core.breakpoints";

	public static final String EOBJECT_URI = " org.yakindu.sct.simulation.core.breakpoint.eobjectrui";
	private static final String ELEMENT_ID = "elementId";
	private static final String EXPRESSION = " org.yakindu.sct.simulation.core.breakpoints.expression";

	private transient EObject semanticObject;

	public SCTBreakpoint() {
		// Default c'tor to restore from marker
	}

	public SCTBreakpoint(EObject semanticObject) {
		this.semanticObject = semanticObject;
		createMarker(semanticObject);
	}

	private void createMarker(EObject semanticObject) {
		try {
			IMarker marker = WorkspaceSynchronizer.getFile(semanticObject.eResource()).createMarker(MARKER_ID);
			setMarker(marker);
			setEnabled(true);
			ensureMarker().setAttribute(IBreakpoint.ID, BREAKPOINT_ID);
			setAttribute(IMarker.MESSAGE, semanticObject.eClass().getInstanceTypeName() + " Breakpoint");
			setAttribute(EOBJECT_URI, EcoreUtil.getURI(semanticObject).toString());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public String getModelIdentifier() {
		return BREAKPOINT_ID;
	}

	public EObject getSemanticObject() {
		if (semanticObject == null) {
			try {
				initSemanticObject();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return semanticObject;
	}

	protected void initSemanticObject() throws CoreException {
		ResourceSet set = new ResourceSetImpl();
		String objectUri = getMarker().getAttribute(EOBJECT_URI, "");
		URI uri = URI.createURI(objectUri);
		if (URIConverter.INSTANCE.exists(uri, Collections.emptyMap())) {
			semanticObject = set.getEObject(uri, true);
		} else
			delete();
	}

	public void setSemanticObject(EObject semanticObject) {
		this.semanticObject = semanticObject;
	}

	public void setNotationViewURI(String uri) {
		try {
			setAttribute(ELEMENT_ID, uri);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void setExpression(String expression) {
		try {
			setAttribute(EXPRESSION, expression);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	public String getExpression() {
		return getMarker().getAttribute(EXPRESSION, "");
	}

}
