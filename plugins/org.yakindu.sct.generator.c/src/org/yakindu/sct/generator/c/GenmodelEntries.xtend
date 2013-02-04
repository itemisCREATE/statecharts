/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.c

import org.yakindu.sct.generator.core.features.ICoreFeatureConstants
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

class GenmodelEntries {
	
	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreFeatureConstants::LICENSE_HEADER)
	}
	
	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(ICoreFeatureConstants::LICENSE_TEXT)
	}
	
	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter != null) {
			return "/*"+licenseTextParameter.stringValue+"*/"
		}
		return null
	}
}