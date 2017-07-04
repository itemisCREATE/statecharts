package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.Naming
import org.yakindu.sct.generator.c.Navigation
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

class StatechartEventsHeader implements IContentTemplate {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	
	@Inject extension
	IGenArtifactConfigurations defaultConfigs
	
	@Inject extension EventNaming eventNaming
	
	protected GeneratorEntry entry
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		this.entry = entry
		'''
		#ifndef «generateHeaderDefineGuard»
		#define «generateHeaderDefineGuard»
		
		#include "«(typesModule.h).relativeTo(module.h)»"
		
		«generateEventsEnum»
		
		«generateEventStruct»
		
		«generateEventQueue»

		#endif /* «generateHeaderDefineGuard» */
		'''
	}
	
	def generateEventStruct(ExecutionFlow it) {
		'''
		typedef struct {
			«eventEnumName» name;
			boolean hasValue;
			void * value;
		} «eventStructTypeName»;
		'''
	}

	def generateEventQueue(ExecutionFlow it) {
		'''
		typedef struct «eventQueueTypeName»_s {
			«eventQueueTypeName»_s * next;
		} «eventQueueTypeName»;
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		'''
		typedef enum  {
			«FOR e : scopes.map[declarations.filter(EventDefinition)].reduce[i1, i2 | i1 + i2] SEPARATOR ","»
				«eventEnumMemberName(e)»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateHeaderDefineGuard(ExecutionFlow it) {
		'''SCT_EVENTS_«name.toUpperCase»_H'''
	}
}