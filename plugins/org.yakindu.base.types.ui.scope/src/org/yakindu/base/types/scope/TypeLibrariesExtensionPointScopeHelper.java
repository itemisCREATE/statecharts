package org.yakindu.base.types.scope;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;

public class TypeLibrariesExtensionPointScopeHelper {

	@Inject
	private TypeLibraryLocation.Registry locationRegistry;

	@Inject
	private XtextResourceSetProvider resourceSetProvider;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public IScope createExtensionScope(IScope parent) {
		List<TypeLibraryLocation> locations = locationRegistry
				.getAllLocations();
		if (locations != null && !locations.isEmpty()) {
			for (TypeLibraryLocation locationData : locations) {
				parent = new TypeLibrariesExtensionPointScope(parent,
						locationData, resourceSetProvider, qualifiedNameProvider);
			}
		}
		return parent;
	}
}