/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import static org.yakindu.sct.model.stext.scoping.SharedEditingDomainFactory.*;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class ImportedResourceCache {

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(DOMAIN_ID);
	}

	public IResourceDescription get(final URI uri) {
		try {
			return (IResourceDescription) getEditingDomain()
					.runExclusive(new RunnableWithResult.Impl<IResourceDescription>() {
						@Override
						public void run() {
							final ResourceSet set = getResourceSet();
							final Resource resource = set.getResource(uri, true);
							if (resource != null) {
								IResourceServiceProvider serviceProvider = serviceProviderRegistry
										.getResourceServiceProvider(uri);
								if (serviceProvider == null)
									return;
								final Manager resourceDescriptionManager = serviceProvider
										.getResourceDescriptionManager();
								if (resourceDescriptionManager == null)
									return;
								IResourceDescription result = resourceDescriptionManager
										.getResourceDescription(resource);
								setResult(result);
							}
						}
					});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

}
