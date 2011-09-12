/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.debugmodel;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugElement extends DebugElement {

	public SCTDebugElement(IDebugTarget target, String resourceString) {
		super(target);
		this.resourceString = resourceString;
	}

	private String resourceString;

	public String getResourceString() {
		return resourceString;
	}

	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

}
