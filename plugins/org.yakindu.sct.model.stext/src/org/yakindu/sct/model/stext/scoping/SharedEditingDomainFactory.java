/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.scoping;

import java.io.IOException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SharedEditingDomainFactory extends DiagramEditingDomainFactory
		implements TransactionalEditingDomain.Factory {

	public static final String DOMAIN_ID = "org.yakindu.sct.domain";

	@Override
	public TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = super.createEditingDomain();
		setup(domain);
		return domain;
	}

	@Override
	public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
		TransactionalEditingDomain domain = super.createEditingDomain(rset);
		setup(domain);
		return domain;
	}

	@Override
	public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
		TransactionalEditingDomain domain = super.createEditingDomain(rset);
		setup(domain);
		return domain;
	}

	protected void setup(TransactionalEditingDomain editingDomain) {
		editingDomain.setID(DOMAIN_ID);
		replaceCrossReferenceAdapterWithNonResolvingAdapter(editingDomain);
		new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public boolean handleResourceDeleted(Resource resource) {
				resource.unload();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, URI newURI) {
				resource.unload();
				return true;
			}

			public boolean handleResourceChanged(Resource resource) {
				if (resource instanceof AbstractSCTResource) {
					// do not unload GMF resources as it might be the one
					// underlying the currently opened editor
					return true;
				}
				resource.unload();
				try {
					resource.load(resource.getResourceSet().getLoadOptions());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}

			public void dispose() {
				// nothing to dispose (especially as I am shared)
			}
		});
	}

	protected void replaceCrossReferenceAdapterWithNonResolvingAdapter(final TransactionalEditingDomain domain) {
		final CrossReferenceAdapter adapter = getCrossReferenceAdapter(domain);
		if (null != adapter) {
			adapter.unsetTarget(domain.getResourceSet());

			domain.getResourceSet().eAdapters().remove(adapter);
			domain.getResourceSet().eAdapters().add(new CrossReferenceAdapter(false));
		}
	}

	protected CrossReferenceAdapter getCrossReferenceAdapter(final TransactionalEditingDomain domain) {
		final EList<Adapter> eAdapters = domain.getResourceSet().eAdapters();
		for (final Adapter adapter : eAdapters) {
			if (adapter instanceof CrossReferenceAdapter) {
				return (CrossReferenceAdapter) adapter;
			}
		}
		return null;
	}
}
