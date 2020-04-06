package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

class MetaSource implements IContentTemplate {
	@Inject extension GenmodelEntries
	@Inject extension Naming
	@Inject extension SExecExtensions
	
	override content(ExecutionFlow flow, GeneratorEntry entry, extension IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		#include "«(flow.metaModule.h).relativeTo(flow.metaModule.c)»"				
				
		«CGeneratorConstants::STRING_TYPE» «flow.name.toFirstUpper»Meta_feature_names[] = {
			"<nothing>",
			«FOR feature : flow.scopes.map[it | it.eventAndVariableDefinitions].flatten SEPARATOR ","»
			"«feature.name»"
			«ENDFOR»
		};
		
		«CGeneratorConstants::STRING_TYPE» «flow.name.toFirstUpper»Meta_state_names[] = {
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