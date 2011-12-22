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
