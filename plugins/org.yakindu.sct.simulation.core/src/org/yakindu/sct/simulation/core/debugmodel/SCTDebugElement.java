package org.yakindu.sct.simulation.core.debugmodel;

import org.eclipse.core.runtime.PlatformObject;

public class SCTDebugElement extends PlatformObject {

	private String resourceString;

	public SCTDebugElement(String resourceString) {
		this.resourceString = resourceString;
	}

	public String getResourceString() {
		return resourceString;
	}


}
