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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;
import org.osgi.framework.Bundle;
import org.yakindu.base.types.LibrariesExtensions;
import org.yakindu.base.types.LibraryDescriptor;

import com.google.inject.Singleton;

public class TypeLibraryLocation {

	private final LibraryDescriptor descriptor;
	private Set<QualifiedName> containedDescriptionNames;

	public TypeLibraryLocation(LibraryDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	
	public Bundle getBundle() {
		return descriptor.getBundle();
	}
	
	public URI getLocation() {
		return descriptor.getLocation();
	}

	public URL getLocationAsURL() {
		return descriptor.getLocationAsURL();
	}

	public Set<QualifiedName> getContainedDescriptionNames() {
		return containedDescriptionNames;
	}

	public void setContainedDescriptionNames(
			Set<QualifiedName> containedDescriptionNames) {
		this.containedDescriptionNames = containedDescriptionNames;
	}

	@Singleton
	public static class Registry {

		private volatile List<TypeLibraryLocation> allLocations;

		public List<TypeLibraryLocation> getAllLocations() {
			if (allLocations == null) {
				synchronized (this) {
					if (allLocations == null) {
						allLocations = doGetAllLocations();
					}
				}
			}
			return allLocations;
		}

		protected List<TypeLibraryLocation> doGetAllLocations() {
			List<TypeLibraryLocation> locations = new ArrayList<TypeLibraryLocation>();
			Iterable<LibraryDescriptor> descriptors = LibrariesExtensions
					.getRegisteredTypeLibraries();
			for (LibraryDescriptor descriptor : descriptors) {
				locations.add(new TypeLibraryLocation(descriptor));
			}
			return locations;
		}
	}

	
}
