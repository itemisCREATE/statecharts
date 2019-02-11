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
package org.yakindu.base.expressions.scoping;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider.URICollector;
import org.eclipse.xtext.util.IAcceptor;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.base.types.TypesPackage;

import com.google.inject.Inject;

/**
 * @author Thomas Kutz - Extracted from {@link STextGlobalScopeProvider}
 */
public class ExpressionsImportUriProvider {

	@Inject
	private IPackageImport2URIMapper mapper;

	public LinkedHashSet<URI> get(Resource resource) {
		final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<>(5);
		IAcceptor<String> collector = new URICollector(resource.getResourceSet(), uniqueImportURIs);
		collectFromPackage(resource, collector);
		removeInvalidUris(resource, uniqueImportURIs);
		return uniqueImportURIs;
	}

	protected void collectFromPackage(Resource resource, IAcceptor<String> collector) {
		Collection<org.yakindu.base.types.Package> packages = EcoreUtil.getObjectsByType(resource.getContents(),
				TypesPackage.Literals.PACKAGE);
		for (org.yakindu.base.types.Package p : packages) {
			EList<String> imports = p.getImports();
			for (String packageImport : imports) {
				collectPackageImports(resource, packageImport, collector);
			}
		}
	}

	protected void removeInvalidUris(Resource resource, final LinkedHashSet<URI> uniqueImportURIs) {
		Iterator<URI> uriIter = uniqueImportURIs.iterator();
		while (uriIter.hasNext()) {
			if (!isValidUri(resource, uriIter.next().trimQuery()))
				uriIter.remove();
		}
	}

	protected void collectPackageImports(Resource resource, String packageImport, IAcceptor<String> acceptor) {
		Optional<PackageImport> pkgImport = mapper.findPackageImport(resource, packageImport);
		if (pkgImport.isPresent() && pkgImport.get().getUri() != null
				&& getConverter(resource).exists(pkgImport.get().getUri().trimQuery(), null)) {
			acceptor.accept(pkgImport.get().getUri().toString());
		}
	}

	protected boolean isValidUri(Resource context, URI uri) {
		boolean validURI = EcoreUtil2.isValidUri(context, uri);
		if (!validURI) {
			return getConverter(context).exists(uri, null);
		}
		return true;
	}

	protected URIConverter getConverter(Resource context) {
		return URIConverter.INSTANCE;
	}

}
