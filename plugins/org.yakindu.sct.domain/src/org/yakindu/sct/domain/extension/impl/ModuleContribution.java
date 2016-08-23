/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.extension.impl;

import org.yakindu.sct.domain.extension.IModuleProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ModuleContribution {

	private String domainID;
	private String feature;
	private IModuleProvider provider;

	public ModuleContribution(String domainID, String feature, IModuleProvider provider) {
		this.domainID = domainID;
		this.feature = feature;
		this.provider = provider;
	}

	public String getDomainID() {
		return domainID;
	}

	public String getFeature() {
		return feature;
	}

	public IModuleProvider getModuleProvider() {
		return provider;
	}

}
