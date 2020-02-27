package org.yakindu.sct.generator.c.files

import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.model.sexec.TimeEvent

class MetaHeader implements IContentTemplate {
	@Inject extension GenmodelEntries
	
	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		static «CGeneratorConstants::STRING_TYPE» feature_names[];
		
		static «CGeneratorConstants::STRING_TYPE» state_identifier[];
		'''
	}
	
	def protected removePrefix(String s){
		return s.substring(s.indexOf(".")+1)
	}
}