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
package org.yakindu.sct.domain.extension;

import java.net.URL;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDomain {

	public static final String FEATURE_EDITOR = "org.yakindu.sct.editor";
	public static final String FEATURE_SIMULATION = "org.yakindu.sct.simulation";
	public static final String FEATURE_GENERATOR = "org.yakindu.sct.generator";
	public static final String FEATURE_RESOURCE = "org.yakindu.sct.resource";

	String getDomainID();

	String getName();

	String getDescription();

	/**
	 * Injector instances are cached for the features and the specified options
	 */
	Injector getInjector(String feature, String... options);

	Module getModule(String feature, String... options);

	URL getImagePath();

	DomainStatus getAvailabilityStatus();

}
