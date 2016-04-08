/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.csharp.features;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.LICENSE_HEADER;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.LICENSE_TEXT;
/**
 * 
 * @author muehlbrandt
 */
public final class CSharpFeatureConstants implements ICSharpFeatureConstants {
	
	public static final String getNamingFeature() {
		return NAMING_FEATURE;
	}
	
	public static final String getNamespaceName() {
		return NAMESPACE_NAME;
	}
	
	public static final String getImplementationSuffix() {
		return IMPLEMENTATION_SUFFIX;
	}
		
	public static final String getLicenseHeader() {
		return LICENSE_HEADER;
	}
	
	public static final String getLicenseText() {
		return LICENSE_TEXT;
	}
	
	public static final String getGeneralFeature() {
		return GENERAL_FEATURES;
	}
	
	public static final String getEventBasedStatemachine() {
		return CREATE_EVENTBASEDSTATEMACHINE;
	}
	
	public static final String getRuntimeService() {
		return RUNTIME_SERVICE;
	}
	
	public static final String getTimerService() {
		return TIMER_SERVICE;
	}
	
	public static final String getInterfaceObserverSupport() {
		return INTERFACE_OBSERVER_SUPPORT;
	}
	
	public static final String getGenericInterfaceSupport() {
		return GENERIC_INTERFACE_SUPPORT;
	}
	
	public static final String getStatemachineFactorySupport() {
		return STATEMACHINE_FACTORY_SUPPORT;
	}
	
	public static final String getUseCSharpIntForInteger() {
		return USE_CSHARP_INT_FOR_INTEGER;
	}
}