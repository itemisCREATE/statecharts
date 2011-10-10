package de.itemis.xtext.utils.jface.viewers.context;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * 
 * @author alexander.nyssen@itemis.de
 *
 */
public interface IXtextContextFakeResourcesProvider {

	public static final IXtextContextFakeResourcesProvider NULL_CONTEXT_PROVIDER = new IXtextContextFakeResourcesProvider() {
		public void populateFakeResourceContextResourceSet(ResourceSet fakeResourceSet) {};
	};

	void populateFakeResourceContextResourceSet(ResourceSet fakeResourceSet);
}
