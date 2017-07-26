package org.yakindu.sct.ui.editor.partitioning;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

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
}
