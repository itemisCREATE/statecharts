/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.features.impl;

import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.LIBRARY_NAME;
import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.DEBUG_FEATURE_DUMP_SEXEC;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.BoolLiteral;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author oliver bohl - Initial contribution
 */
public class SCTBaseLibaryDefaultFeatureValueProvider extends
AbstractDefaultFeatureValueProvider{

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return LIBRARY_NAME.equals(library.getName());
	}	
	
	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue, EObject contextElement) {
		String parameterName = parameterValue.getParameter().getName();
		if (DEBUG_FEATURE_DUMP_SEXEC.equals(parameterName)) {
			parameterValue.setValue(false);
		}
	}
	
	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		String parameterName = parameterValue.getParameter().getName();
		if (DEBUG_FEATURE_DUMP_SEXEC.equals(parameterName)
				&& !(parameterValue.getExpression() instanceof BoolLiteral)) {
			return error("Illegal Value. Must be 'true' or 'false'");
		}
		return Status.OK_STATUS;
	}
}
