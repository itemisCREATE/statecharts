/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;

/**
 * This class is initially copied from
 * org.eclipse.xtext.gmf.glue.concurrency.SimpleDirtyResource and adopted to
 * work on {@link XMIResource}s instead of {@link XtextResource}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class XMIDirtyResource implements IDirtyResource {

	private XMIResource resource;

	private Manager resourceDescriptionManager;

	public XMIDirtyResource(XMIResource resource,
			IResourceServiceProvider resourceServiceProvider) {
		this.resource = resource;
		this.resourceDescriptionManager = resourceServiceProvider
				.getResourceDescriptionManager();
	}

	public String getContents() {
		throw new UnsupportedOperationException();
	}

	public String getActualContents() {
		throw new UnsupportedOperationException();
	}

	public IResourceDescription getDescription() {
		return resourceDescriptionManager.getResourceDescription(resource);
	}

	public URI getURI() {
		return resource.getURI();
	}

	public Resource getResource() {
		return resource;
	}

}
