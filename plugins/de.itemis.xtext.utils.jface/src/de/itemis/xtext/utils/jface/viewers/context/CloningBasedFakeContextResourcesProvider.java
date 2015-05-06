package de.itemis.xtext.utils.jface.viewers.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;

/**
 * An {@link IXtextFakeContextResourcesProvider} that populates the fake
 * {@link ResourceSet} with 'clones' of the passed in context resources.
 * 
 * @author alexander.nyssen@itemis.de
 * 
 */
public class CloningBasedFakeContextResourcesProvider implements
		IXtextFakeContextResourcesProvider {

	private final List<Resource> contextResources = new ArrayList<Resource>();

	public CloningBasedFakeContextResourcesProvider(
			List<Resource> contextResources) {
		this.contextResources.addAll(contextResources);
	}

	public void populateFakeResourceSet(
			ResourceSet fakeResourceSet, XtextResource fakeResource) {
		for (Resource r : contextResources) {
			createContextResourceCopyInResourceSet(fakeResourceSet, r);
		}
	}

	protected void createContextResourceCopyInResourceSet(
			ResourceSet resourceSet, Resource contextResource) {
		// we may not add the context resource to the fake resource set, because
		// it would be removed from its original resource set then. We can also
		// not simply load the resource by its uri, because this would not be
		// "dirty-aware". Therefore we perform a deep copy here.
		Resource contextResourceCopy = resourceSet
				.createResource(contextResource.getURI());
		contextResourceCopy.getContents().addAll(
				EcoreUtil.copyAll(contextResource.getContents()));
	}
}
