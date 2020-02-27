package org.yakindu.sct.generator.c.files

import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.model.sexec.TimeEvent

class MetaSource implements IContentTemplate {
	@Inject extension GenmodelEntries
	
	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		
		#include "«flow.name»Meta.h"
				
				
		static «CGeneratorConstants::STRING_TYPE» feature_names[] = {
			"<nothing>",
			«FOR feature : flow.scopes.map[it | it.declarations].flatten.reject(TimeEvent) SEPARATOR ","»
			"«feature.name»"
			«ENDFOR»
		};
		
		static «CGeneratorConstants::STRING_TYPE» state_identifier[] = {
			"<nostate>",
			«FOR state : flow.states SEPARATOR ","»
			"«state.name.removePrefix»"
			«ENDFOR»
		};
		'''
	}
	
	def protected removePrefix(String s){
		return s.substring(s.indexOf(".")+1)
	}
}