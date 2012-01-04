/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Nyssen (itemis AG) - initial API and implementation
 */
package org.yakindu.base.types.scope;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

public class TypeLibrariesExtensionPointScopeHelper {

	@Inject
	private TypeLibraryLocation.Registry locationRegistry;

	@Inject
	private XtextResourceSet resourceSet;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public IScope createExtensionScope(IScope parent) {
		List<TypeLibraryLocation> locations = locationRegistry
				.getAllLocations();
		if (locations != null && !locations.isEmpty()) {
			for (TypeLibraryLocation locationData : locations) {
				parent = new TypeLibrariesExtensionPointScope(parent,
						locationData, resourceSet, qualifiedNameProvider);
			}
		}
		return parent;
	}
}