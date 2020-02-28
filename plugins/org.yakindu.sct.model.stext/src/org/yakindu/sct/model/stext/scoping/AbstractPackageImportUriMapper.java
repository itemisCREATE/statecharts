/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public abstract class AbstractPackageImportUriMapper implements IPackageImport2URIMapper {

	public abstract Set<PackageImport> getAllImports(Resource context);

	@Override
	public Optional<PackageImport> findPackageImport(Resource context, String packageImport) {
		try {
			return TransactionUtil.runExclusive(getSharedEditingDomain(),
					new RunnableWithResult.Impl<Optional<PackageImport>>() {
						@Override
						public void run() {
							Set<PackageImport> allImports = getAllImports(getContextResource(context));
							for (PackageImport currentImport : allImports) {
								if (currentImport.getName().equals(packageImport)) {
									setResult(Optional.of(currentImport));
									return;
								}
							}
							setResult(Optional.empty());
						}

					});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	protected Optional<IFile> getImportedFile(Resource context, String packageImport) {
		IFile file = WorkspaceSynchronizer.getFile(getContextResource(context));
		if (file == null)
			return Optional.empty();
		IPath importPath = file.getFullPath().removeLastSegments(1).append(packageImport);
		IFile wsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(importPath);
		if (wsFile.exists()) {
			return Optional.of(wsFile);
		}
		return Optional.empty();
	}

	protected Resource getContextResource(Resource context) {
		TransactionalEditingDomain editingDomain = getSharedEditingDomain();
		try {
			return (Resource) editingDomain.runExclusive(new RunnableWithResult.Impl<Resource>() {
				@Override
				public void run() {
					final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context,
							ContextElementAdapter.class);
					if (provider != null) {
						setResult(provider.getElement().eResource());
						return;
					}
					setResult(context);
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return context;
		}
	}

	protected TransactionalEditingDomain getSharedEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(SharedEditingDomainFactory.DOMAIN_ID);
	}
}
