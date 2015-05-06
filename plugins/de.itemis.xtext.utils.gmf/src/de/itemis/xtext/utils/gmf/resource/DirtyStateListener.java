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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.shared.Access;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Some content of this class is initially copied from
 * org.eclipse.xtext.gmf.glue.concurrency.EditingDomainAdapter and adopted to
 * work on {@link XMIResource}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DirtyStateListener implements ResourceSetListener {

	private IDirtyStateManager dirtyStateManager;

	private Map<URI, IDirtyResource> uri2dirtyResource;

	public DirtyStateListener() {
		dirtyStateManager = Access.getIDirtyStateManager().get();
		uri2dirtyResource = Maps.newHashMap();
	}

	public void resourceSetChanged(ResourceSetChangeEvent event) {
		List<URI> remainingURIs = Lists
				.newArrayList(uri2dirtyResource.keySet());
		for (Resource currentResource : event.getEditingDomain()
				.getResourceSet().getResources()) {
			if (currentResource instanceof XMIResource) {
				XMIResource resource = (XMIResource) currentResource;
				remainingURIs.remove(resource.getURI());
				IDirtyResource dirtyResource = uri2dirtyResource.get(resource
						.getURI());
				if (resource.isModified()) {
					if (dirtyResource == null) {
						createAndRegisterDirtyState(resource);
					}
				} else {
					if (dirtyResource != null) {
						uri2dirtyResource.remove(resource.getURI());
						dirtyStateManager.discardDirtyState(dirtyResource);
					}
				}
			}
		}
		for (URI remainingURI : remainingURIs) {
			IDirtyResource dirtyResource = uri2dirtyResource.get(remainingURI);
			dirtyStateManager.discardDirtyState(dirtyResource);
			uri2dirtyResource.remove(remainingURI);
		}
	}

	protected boolean createAndRegisterDirtyState(XMIResource resource) {
		IDirtyResource dirtyResource = createDirtyResource(resource);
		if (dirtyResource == null) {
			return true;
		} else {
			boolean isSuccess = dirtyStateManager
					.manageDirtyState(dirtyResource);
			if (isSuccess) {
				uri2dirtyResource.put(resource.getURI(), dirtyResource);
			}
			return isSuccess;
		}
	}

	protected IDirtyResource createDirtyResource(XMIResource resource) {
		IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider == null) {
			return null;
		}
		return new XMIDirtyResource(resource, resourceServiceProvider);
	}

	public void dispose() {
		if (uri2dirtyResource != null) {
			for (IDirtyResource dirtyResource : uri2dirtyResource.values()) {
				dirtyStateManager.discardDirtyState(dirtyResource);
			}
			uri2dirtyResource = null;
		}
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		return null;
	}

	public boolean isAggregatePrecommitListener() {
		return true;
	}

	public boolean isPostcommitOnly() {
		return false;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public NotificationFilter getFilter() {
		return null;
	}
}
