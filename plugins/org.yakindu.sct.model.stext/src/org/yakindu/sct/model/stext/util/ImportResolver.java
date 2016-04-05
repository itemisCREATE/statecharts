/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.sct.model.stext.util;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.yakindu.base.types.Package;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.stext.stext.Import;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Convenience class for retrieving imported elements in the statechart's import scope.
 * 
 * @author Thomas Kutz
 *
 */
public class ImportResolver {

	@Inject
	private IContainer.Manager containerManager;
	@Inject
	private IResourceDescriptions resourceDescriptions;

	/**
	 * Returns for a given {@link Import} declaration all elements of given type that are defined in the imported {@link Package}.
	 * 
	 * @param importDeclaration the import declaration within an import scope
	 * @param type type of imported elements to be returned
	 * @return imported elements of given type
	 */
	public <T extends EObject> List<T> getImportedElementsOfType(Import importDeclaration, Class<T> type) {
		List<T> varDefs = Lists.newArrayList();
		Package importedPackage = getPackageForNamespace(importDeclaration.eResource(), importDeclaration.getImportedNamespace());
		if (importedPackage != null) {
			TreeIterator<EObject> iter = importedPackage.eAllContents();
			while (iter.hasNext()) {
				EObject next = iter.next();
				if (type.isInstance(next)) {
					varDefs.add(type.cast(next));
				}
			}
		}
		return varDefs;
	}

	/**
	 * Returns for a given namespace the {@link Package}.
	 * 
	 * @param contextResource the resource used to decide which packages are visible
	 * @param namespace name of the package to be returned; ending wildcards (.*) will be trimmed
	 * @return first found package with name as defined in namespace
	 */
	public Package getPackageForNamespace(Resource contextResource, String namespace) {
		initResourceDescriptions(contextResource);
		// remove wildcard
		if (namespace.endsWith(".*")) {
			namespace = namespace.substring(0, namespace.length() - 2);
		}
		URI uri = contextResource.getURI();
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(uri);
		if (resourceDescription == null) {
			// no resource description could be found, so package cannot be resolved anyway
			return null;
		}
		for (IContainer container : containerManager.getVisibleContainers(resourceDescription, resourceDescriptions)) {
			final Iterable<IResourceDescription> currentDescriptions = container.getResourceDescriptions();
			for (IResourceDescription resDesc : currentDescriptions) {
				Iterable<IEObjectDescription> visiblePackages = resDesc
						.getExportedObjectsByType(TypesPackage.Literals.PACKAGE);
				for (IEObjectDescription pkgDesc : visiblePackages) {
					if (pkgDesc.getName().toString().equals(namespace)) {
						return (Package) pkgDesc.getEObjectOrProxy();
					}
				}
			}
		}
		return null;
	}

	protected void initResourceDescriptions(Resource contextResource) {
		if (resourceDescriptions instanceof ResourceSetBasedResourceDescriptions) {
			ResourceSet rset = buildResourceSet(contextResource);
			((ResourceSetBasedResourceDescriptions) resourceDescriptions).setContext(rset);
		}
	}

	protected ResourceSet buildResourceSet(Resource contextResource) {
		if (contextResource.getResourceSet() == null) {
			final ResourceSet rset = new ResourceSetImpl();
			rset.getResources().add(contextResource);
			return rset;
		}
		return contextResource.getResourceSet();
	}
}
