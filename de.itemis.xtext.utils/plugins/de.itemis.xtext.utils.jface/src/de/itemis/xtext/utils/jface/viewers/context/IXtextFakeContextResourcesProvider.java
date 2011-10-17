package de.itemis.xtext.utils.jface.viewers.context;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;

/**
 * 
 * @author alexander.nyssen@itemis.de
 * 
 */
public interface IXtextFakeContextResourcesProvider {

	public static final IXtextFakeContextResourcesProvider NULL_CONTEXT_PROVIDER = new IXtextFakeContextResourcesProvider() {
		public void populateFakeResourceSet(
				ResourceSet fakeResourceSet, XtextResource fakeResource) {
		};
	};

	/**
	 * Populate the fake resource set with additional resources that may be
	 * needed for scoping/linking. The fake resource used will be passe in as
	 * context information. Note that at the time this callback is invoked, the
	 * fake resource will not be contained in the fake resource set, because
	 * that may cause problems when working with the resource set (as the fake
	 * resource does actually not exist in the file system).
	 * 
	 * @param fakeResourceSet
	 *            the {@link ResourceSet} to populate
	 * @param fakeResource
	 *            the fake {@link XtextResource} as context information.
	 */
	void populateFakeResourceSet(ResourceSet fakeResourceSet,
			XtextResource fakeResource);
}
