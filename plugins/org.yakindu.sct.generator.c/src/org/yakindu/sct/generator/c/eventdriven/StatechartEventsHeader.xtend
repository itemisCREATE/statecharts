package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.Naming
import org.yakindu.sct.generator.c.Navigation
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry

class StatechartEventsHeader implements IContentTemplate {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	
	@Inject extension
	IGenArtifactConfigurations defaultConfigs
	
	@Inject extension EventNaming eventNaming
	
	protected GeneratorEntry entry
	
	protected static final int BUFFER_SIZE = 20
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		this.entry = entry
		'''
		#ifndef «generateHeaderDefineGuard»
		#define «generateHeaderDefineGuard»
		
		#include "«(typesModule.h).relativeTo(module.h)»"
		
		#ifndef «bufferSize»
		#define «bufferSize» «BUFFER_SIZE»
		#endif
		
		«generateEventsEnum»
		
		«generateEventValueUnion»
		
		«generateEventStruct»
		
		«generateEventQueue»
		
		«eventFunctionPrototypes»
		
		«eventQueueFunctionPrototypes»

		#endif /* «generateHeaderDefineGuard» */
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		'''
		/*
		 * Enum of event names in the statechart.
		 */
		typedef enum  {
			invalid_event,
			«FOR e : getAllEvents SEPARATOR ","»
				«eventEnumMemberName(e)»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateEventValueUnion(ExecutionFlow it) {
		'''
		/*
		 * Union of all possible event value types.
		 */
		typedef union {
			«FOR e : getAllEvents.filter[hasValue && direction != Direction::OUT]»
			«e.typeSpecifier.targetLanguageName» «eventEnumMemberName(e)»_value;
			«ENDFOR»
		} «eventValueUnionName»;
		'''
	}
	
	def generateEventStruct(ExecutionFlow it) {
		'''
		/*
		 * Struct that represents a single event.
		 */
		typedef struct {
			«eventEnumName» name;
			sc_boolean has_value;
			«eventValueUnionName» value;
		} «eventStructTypeName»;
		'''
	}

	def generateEventQueue(ExecutionFlow it) {
		'''
		/*
		 * Queue that holds the raised events.
		 */
		typedef struct «eventQueueTypeName»_s {
			«eventStructTypeName» events[«bufferSize»];
			sc_integer pop_index;
			sc_integer push_index;
			sc_integer size;
		} «eventQueueTypeName»;
		'''
	}
	
	def eventFunctionPrototypes(ExecutionFlow it) {
		'''
		void «eventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name);

		void «eventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name, void * value);
		'''
	}
	
	def eventQueueFunctionPrototypes(ExecutionFlow it) {
		'''
		void «eventQueueInitFunction»(«eventQueueTypeName» * eq);
		
		sc_integer «eventQueueSizeFunction»(«eventQueueTypeName» * eq);
		
		«eventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq);
		
		sc_boolean «eventQueuePushFunction»(«eventQueueTypeName» * eq, «eventStructTypeName» ev);
		'''
	}
	
	def generateHeaderDefineGuard(ExecutionFlow it) {
		'''SCT_EVENTS_«name.toUpperCase»_H'''
	}
}