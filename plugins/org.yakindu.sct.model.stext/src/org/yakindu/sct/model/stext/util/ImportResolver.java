package org.yakindu.sct.model.stext.util;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
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

public class ImportResolver {

	@Inject
	private IContainer.Manager containerManager;
	@Inject
	private IResourceDescriptions resourceDescriptions;

	public <T extends EObject> List<T> getImportedElementsOfType(Import importedNamespace, Class<T> type) {
		List<T> varDefs = Lists.newArrayList();
		Package importedPackage = getPackageForImport(importedNamespace.eResource(), importedNamespace.getImportedNamespace());
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

	public Package getPackageForImport(Resource contextResource, String namespace) {
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

	private void initResourceDescriptions(Resource contextResource) {
		if (resourceDescriptions instanceof ResourceSetBasedResourceDescriptions) {
			ResourceSet rset = buildResourceSet(contextResource);
			((ResourceSetBasedResourceDescriptions) resourceDescriptions).setContext(rset);
		}
	}

	private ResourceSet buildResourceSet(Resource contextResource) {
		final ResourceSet rset = new ResourceSetImpl();
		IProject project = WorkspaceSynchronizer.getFile(contextResource).getProject();
		try {
			project.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if ("types".equals(resource.getFileExtension())) {
						String filePath = resource.getFullPath().toString();
						rset.createResource(URI.createPlatformResourceURI(filePath, true));
					}
					return true;
				}
			});

		} catch (CoreException e) {
			e.printStackTrace();
		}
		rset.getResources().add(contextResource);

		return rset;
	}
}
