package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.Naming
import org.yakindu.sct.generator.cpp.Navigation
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

class StatechartEvents implements IContentTemplate {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	
	protected GeneratorEntry entry
	protected ExecutionFlow flow
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations locations) {
		this.entry = entry;
		this.flow = it;
		'''
		#ifndef «generateHeaderDefineGuard»
		#define «generateHeaderDefineGuard»
		
		#include "«(typesModule.h).relativeTo(module.h)»"
		
		«generateEventBaseClasses»
		
		«generateEvents»
		#endif /* «generateHeaderDefineGuard» */
		'''
	}
	
	def generateHeaderDefineGuard(ExecutionFlow it) {
		'''SCT_EVENTS_«name.toUpperCase»_H'''
	}
	
	def generateEventBaseClasses(ExecutionFlow it) {
		'''
		/* Guard for base classes */
		#ifndef SCT_EVENTS_BASE_CLASSES
		#define SCT_EVENTS_BASE_CLASSES
		
		class SctEvent
		{
			public:
				SctEvent(){}
				virtual ~SctEvent(){}
			private:
		};
				
		template <typename T>
		class TypedSctEvent : public SctEvent
		{
			public:
				TypedSctEvent(T value) :
					SctEvent(),
					value(value)
					{}
				virtual ~TypedSctEvent(){}
			private:
				T value;
		};
		
		#endif /* SCT_EVENTS_BASE_CLASSES */
		'''
	}
	
	def generateEvents(ExecutionFlow it) {
		'''
		«FOR s : scopes»
			«FOR e : s.declarations.filter(EventDefinition)»
				«generateEventClass(e)»
			«ENDFOR»
		«ENDFOR»
		'''
	}
	
	def generateEventClass(EventDefinition it) {
		'''
		«IF hasValue»
		«generateTypedEventClass»
		«ELSE»
		«generateNormalEventClass»
		«ENDIF»
		'''
	}
	
	def generateTypedEventClass(EventDefinition it) {
		val type = typeSpecifier.targetLanguageName
		'''
		class «eventClassName» : public TypedSctEvent<«type»>
		{
			public:
				«eventClassName»(«type» value) :
					TypedSctEvent(value) {};
		};
		'''
	}
	
	def generateNormalEventClass(EventDefinition it) {
		'''
		class «eventClassName» : public SctEvent
		{
			public:
				«eventClassName»(){};
		};
		'''
	}
	
	def getBaseClass(EventDefinition it) {
		'''
		«IF hasValue»
		TypedSctEvent
		«ELSE»
		SctEvent
		«ENDIF»
		'''
	}
}