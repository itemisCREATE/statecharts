package org.yakindu.sct.generator.c.files

import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.extensions.Naming

class MetaHeader implements IContentTemplate {
	@Inject extension GenmodelEntries
	@Inject extension Naming
	
	override content(ExecutionFlow flow, GeneratorEntry entry, extension IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»

		#ifndef «flow.name.toUpperCase»META_H_
		#define «flow.name.toUpperCase»META_H_

		#include "«("sc_types".h).relativeTo(flow.name.toFirstUpper + "Meta.h")»"

		#ifdef __cplusplus
		extern "C" {
		#endif
		
		extern «CGeneratorConstants::STRING_TYPE» feature_names[];
		
		extern «CGeneratorConstants::STRING_TYPE» state_names[];
		
		#ifdef __cplusplus
		}
		#endif

		#endif /* «flow.name.toUpperCase»META_H_ */
		'''
	}
	
	def protected removePrefix(String s){
		return s.substring(s.indexOf(".")+1)
	}
}