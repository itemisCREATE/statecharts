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
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 *
 */
public class PackageImport2URIMultiMapper implements IPackageImport2URIMapper {

	public static final String MULTI_MAPPINGS = "MULTI_MAPPINGS";

	@Inject(optional = true)
	@Named(MULTI_MAPPINGS)
	private Set<IPackageImport2URIMapper> mapper = Sets.newHashSet();

	@Override
	public Optional<PackageImport> findPackageImport(Resource context, String packageImport) {
		Optional<Optional<PackageImport>> any = mapper.stream().filter((current) -> current.canHandle(packageImport))
				.map((mapper) -> mapper.findPackageImport(context, packageImport))
				.filter((optional) -> optional.isPresent()).findFirst();
		return any.isPresent() ? any.get() : Optional.empty();
	}

	@Override
	public Set<PackageImport> getAllImports(Resource context) {
		return mapper.stream().flatMap(current -> current.getAllImports(context).stream()).collect(Collectors.toSet());
	}

}
