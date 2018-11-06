/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.scoping;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SharedEditingDomainFactory extends DiagramEditingDomainFactory
		implements TransactionalEditingDomain.Factory {

	public static final String DOMAIN_ID = "org.yakindu.sct.domain";

	@Override
	public TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = super.createEditingDomain();
		setup(domain);
		return domain;
	}

	@Override
	public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
		TransactionalEditingDomain domain = super.createEditingDomain(rset);
		setup(domain);
		return domain;
	}

	@Override
	public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
		TransactionalEditingDomain domain = super.createEditingDomain(rset);
		setup(domain);
		return domain;
	}

	protected void setup(TransactionalEditingDomain editingDomain) {
		editingDomain.setID(DOMAIN_ID);
		replaceCrossReferenceAdapterWithNonResolvingAdapter(editingDomain);
		new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public boolean handleResourceDeleted(Resource resource) {
				unloadWithReferences(resource);
				return true;
			}

			public boolean handleResourceMoved(Resource resource, URI newURI) {
				unloadWithReferences(resource);
				return true;
			}

			public boolean handleResourceChanged(Resource resource) {
				unloadWithReferences(resource);
				try {
					if (resource instanceof AbstractSCTResource) {
						// do not unload GMF resources as it might be the one
						// underlying the currently opened editor
						return true;
					}
					resource.load(resource.getResourceSet().getLoadOptions());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}

			public void dispose() {
				// nothing to dispose (especially as I am shared)
			}
		});
		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				try {
					if (delta != null) {
						delta.accept(new IResourceDeltaVisitor() {
							@Override
							public boolean visit(IResourceDelta delta) throws CoreException {
								if (delta.getKind() == IResourceDelta.ADDED) {
									IResource resource = delta.getResource();
									if (resource instanceof IFile) {
										URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(),
												true);
										Resource existingResource = editingDomain.getResourceSet().getResource(uri,
												false);
										if (existingResource != null
												&& !(existingResource instanceof AbstractSCTResource))
											unloadWithReferences(existingResource);

									}
								}
								return true;
							}
						});
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		});
	}
	protected void unloadWithReferences(Resource resource) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
		try {
			editingDomain.runExclusive(new Runnable() {
				@Override
				public void run() {
					Set<Resource> resourcesToUnload = new HashSet<>();
					collectTransitiveReferences(resource, resourcesToUnload);
					resourcesToUnload.add(resource);
					
					collectResourcesWithErrors(resource, resourcesToUnload);
					
					for (Resource current : resourcesToUnload) {
						if (current instanceof AbstractSCTResource || !current.getURI().isPlatform())
							continue;
						current.unload();
					}
				}

			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void collectResourcesWithErrors(Resource resource, Set<Resource> resourcesToUnload) {
		for (Resource currentResource : resource.getResourceSet().getResources()) {
			if (currentResource.getErrors().size() > 0) {
				collectTransitiveReferences(currentResource, resourcesToUnload);
				resourcesToUnload.add(currentResource);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void collectTransitiveReferences(Resource resource, Set<Resource> references) {
		EList<Resource> resources = resource.getResourceSet().getResources();
		for (Resource currentResource : resources) {
			final Collection<Resource> allImports = EMFCoreUtil.getImports(currentResource);
			for (Resource currentImport : allImports) {
				if (currentImport == resource) {
					if (!references.contains(currentResource)) {
						references.add(currentResource);
						collectTransitiveReferences(currentResource, references);
					}
				}
			}
		}
	}
	protected void replaceCrossReferenceAdapterWithNonResolvingAdapter(final TransactionalEditingDomain domain) {
		final CrossReferenceAdapter adapter = getCrossReferenceAdapter(domain);
		if (null != adapter) {
			adapter.unsetTarget(domain.getResourceSet());
			domain.getResourceSet().eAdapters().remove(adapter);
			domain.getResourceSet().eAdapters().add(new CrossReferenceAdapter(false));
		}
	}

	protected CrossReferenceAdapter getCrossReferenceAdapter(final TransactionalEditingDomain domain) {
		final EList<Adapter> eAdapters = domain.getResourceSet().eAdapters();
		for (final Adapter adapter : eAdapters) {
			if (adapter instanceof CrossReferenceAdapter) {
				return (CrossReferenceAdapter) adapter;
			}
		}
		return null;
	}

	
}
