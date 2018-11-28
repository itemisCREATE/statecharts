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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider.URICollector;
import org.eclipse.xtext.util.IAcceptor;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.extensions.STextExtensions;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.inject.Inject;

/**
 * @author Thomas Kutz - Extracted from {@link STextGlobalScopeProvider}
 */
public class ImportUriProvider {

	@Inject
	private IPackageImport2URIMapper mapper;
	@Inject
	private STextExtensions utils;
	
	public LinkedHashSet<URI> get(Resource resource) {
		final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<>(5);
		IAcceptor<String> collector = new URICollector(resource.getResourceSet(), uniqueImportURIs);
		
		collectFromImportScopes(resource, collector);
		collectImplicitImports(resource, collector);
		
		removeInvalidUris(resource, uniqueImportURIs);
		return uniqueImportURIs;
	}

	protected void removeInvalidUris(Resource resource, final LinkedHashSet<URI> uniqueImportURIs) {
		Iterator<URI> uriIter = uniqueImportURIs.iterator();
		while (uriIter.hasNext()) {
			if (!isValidUri(resource, uriIter.next().trimQuery()))
				uriIter.remove();
		}
	}

	protected void collectFromImportScopes(Resource resource, IAcceptor<String> collector) {
		Collection<ImportScope> importScopes = getImportScopes(resource);
		for (ImportScope object : importScopes) {
			EList<String> imports = object.getImports();
			for (String packageImport : imports) {
				collectPackageImports(resource, packageImport, collector);
			}
		}
	}
	
	protected void collectImplicitImports(Resource resource, IAcceptor<String> collector) {
		// no implicit imports
	}

	protected Collection<ImportScope> getImportScopes(final Resource resource) {
		StatechartSpecification specification = (StatechartSpecification) EcoreUtil
				.getObjectByType(resource.getContents(), StextPackage.Literals.STATECHART_SPECIFICATION);
		if (specification != null) {
			return EcoreUtil.getObjectsByType(specification.getScopes(), StextPackage.Literals.IMPORT_SCOPE);
		} else {
			Statechart statechart = utils.getStatechart(resource);
			if (statechart == null) {
				return new LinkedHashSet<>();
			}
			return EcoreUtil.getObjectsByType(statechart.getScopes(), StextPackage.Literals.IMPORT_SCOPE);
		}
	}
	
	protected void collectPackageImports(Resource resource, String packageImport, IAcceptor<String> acceptor) {
		Optional<PackageImport> pkgImport = mapper.findPackageImport(resource, packageImport);
		if (pkgImport.isPresent() && pkgImport.get().getUri() != null
				&& getConverter().exists(pkgImport.get().getUri().trimQuery(), null)) {
			acceptor.accept(pkgImport.get().getUri().toString());
		}
	}
	
	protected boolean isValidUri(Resource context, URI uri) {
		boolean validURI = EcoreUtil2.isValidUri(context, uri);
		if (!validURI) {
			return getConverter().exists(uri, null);
		}
		return true;
	}
	
	protected URIConverter getConverter() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(SharedEditingDomainFactory.DOMAIN_ID)
				.getResourceSet().getURIConverter();
	}

}
