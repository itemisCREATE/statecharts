package org.yakindu.base.expressions.scoping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

public class GenericImport2URIMapper implements IPackageImport2URIMapper {

	@Override
	public Optional<PackageImport> findPackageImport(Resource context, String packageImport) {
//		WorkspaceSynchronizer.getFile(context).
		return null;
	}

	@Override
	public Set<PackageImport> getAllImports(Resource context) {
		return new HashSet<>();
	}

}
