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
package org.yakindu.sct.model.stext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;

import com.google.inject.Injector;

/**
 * @author andreas muelder - Initial contribution and API
 */
public class StextResourceFactory extends XMIResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		String domainID = DomainRegistry.determineDomainID(uri);
		if (domainID == null || DomainRegistry.getDomain(domainID) == null) {
			return new XMIResourceImpl(uri);
		}
		IDomain domain = DomainRegistry.getDomain(domainID);
		Injector injector = getInjector(domain);
		Resource resource = injector.getInstance(Resource.class);
		ResourceSet set = new ResourceSetImpl();
		set.getResources().add(resource);
		resource.setURI(uri);
		return resource;
	}

	protected Injector getInjector(IDomain domain) {
		return domain.getInjector(IDomain.FEATURE_RESOURCE);
	}
}
