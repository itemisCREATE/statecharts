/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.resource.factory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.model.stext.resource.impl.StextResource;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * ResourceFactory for the {@link InjectMembersResource} with services for the
 * statechart model.
 * 
 * @author andreas muelder
 * 
 */
public class StextResourceFactory extends XMIResourceFactoryImpl {

	@Inject
	Injector injector;

	@Override
	public Resource createResource(URI uri) {
		final StextResource resource = new StextResource(
				uri);
		injector.injectMembers(resource);
		return resource;
	}
}
