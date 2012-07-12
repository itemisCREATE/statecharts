package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.base.types.Type

class Base {
	
		def licenseHeader(GeneratorEntry it) {
//		 .getFeatureConfiguration(getLicenseFeature())!=null
//		&& this.genEntry().getFeatureConfiguration(getLicenseFeature()).getParameterValue(getLicenseText()) != null then
//		this.genEntry().getFeatureConfiguration(getLicenseFeature()).getParameterValue(getLicenseText()).getStringValue()
//	else 
//		null;	
	}
	
	def cPrimitive(Type it) {
		switch (if (it == null) 'void' else name ) {
			case 'void' 	: 'void'
			case 'integer'	: 'sc_integer'
			case 'real'		: 'sc_real'
			case 'boolean'	: 'sc_boolean'
			case 'string'	: 'sc_string'
		}
	}
	
}