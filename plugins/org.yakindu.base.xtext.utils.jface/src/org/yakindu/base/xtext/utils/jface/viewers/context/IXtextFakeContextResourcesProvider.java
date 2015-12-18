/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.xtext.utils.jface.viewers.context;

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
