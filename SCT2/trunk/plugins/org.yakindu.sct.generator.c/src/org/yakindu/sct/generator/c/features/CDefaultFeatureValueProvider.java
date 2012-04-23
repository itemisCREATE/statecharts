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
package org.yakindu.sct.generator.c.features;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return CFeatureConstants.LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			EObject contextElement) {
		// TODO: Implement my default properties
	}

	public IStatus validateParameterValue(FeatureParameterValue value) {
		return Status.OK_STATUS;
	}

}
