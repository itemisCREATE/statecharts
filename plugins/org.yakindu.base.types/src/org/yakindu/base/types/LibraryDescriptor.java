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
package org.yakindu.base.types;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

public class LibraryDescriptor {

	private final URI location;
	private final Bundle bundle;

	public LibraryDescriptor(URI location, Bundle bundle) {
		this.location = location;
		this.bundle = bundle;
	}

	public URI getLocation() {
		return location;
	}

	public URL getLocationAsURL() {
		return bundle.getResource(location.toPlatformString(true));
	}

	public Bundle getBundle() {
		return bundle;
	}

}
