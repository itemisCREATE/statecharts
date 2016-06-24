/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainDescriptor;

import com.google.inject.Injector;

/**
 * @author andreas muelder - Initial contribution and API
 */
public class SCTResourceFactory extends XMIResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {

		// if file is not existing, AND no generic/default domain is available, resource creation will fail
		if (!URIConverter.INSTANCE.exists(uri, null)) {
			return new GMFResource(uri);
		}

		String determinedDomainID = DomainRegistry.determineDomainID(uri);
		IDomainDescriptor domainDescriptor = DomainRegistry.getDomainDescriptor(determinedDomainID);
		Injector injector = domainDescriptor.getDomainInjectorProvider().getResourceInjector();
		Resource resource = injector.getInstance(Resource.class);

		ResourceSet set = new ResourceSetImpl();
		set.getResources().add(resource);
		resource.setURI(uri);
		return resource;
	}
}
