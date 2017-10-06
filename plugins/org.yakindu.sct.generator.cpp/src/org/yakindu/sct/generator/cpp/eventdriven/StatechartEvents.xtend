/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
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
/**
 * @author René Beckmann - Initial contribution and API
 */
class StatechartEvents {
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	
	@Inject extension EventNaming eventNaming
	
	protected GeneratorEntry entry
	protected ExecutionFlow flow
	
	def content(ExecutionFlow it) {
		'''
		#ifndef «generateHeaderDefineGuard»
		#define «generateHeaderDefineGuard»
		
		namespace «eventNamespaceName»
		{
		«generateEventsEnum»
		
		«generateEventBaseClasses»
		
		«generateEvents»
		
		}
		#endif /* «generateHeaderDefineGuard» */
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		val enumMembers = scopes
			.map[declarations.filter(EventDefinition)] // map list of declarations to scope
			.reduce[i1, i2 | i1 + i2] // reduce multiple lists of declarations into one
			.filter[direction == Direction::LOCAL]
			.map[eventEnumMemberName] // generate enumMemberNames for each
			.toList
		if(timed) {
			enumMembers.add(timeEventEnumName)
		}
		'''
		typedef enum  {
			«FOR e : enumMembers SEPARATOR ","»
				«e»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateHeaderDefineGuard(ExecutionFlow it) {
		'''SCT_EVENTS_«name.toUpperCase»_H'''
	}
	
	def generateEventBaseClasses(ExecutionFlow it) {
		'''
		class SctEvent
		{
			public:
				SctEvent(«eventEnumName» name) : name(name){}
				virtual ~SctEvent(){}
				const «eventEnumName» name;
				
		};
				
		template <typename T>
		class TypedSctEvent : public SctEvent
		{
			public:
				TypedSctEvent(«eventEnumName» name, T value) :
					SctEvent(name),
					value(value)
					{}
				virtual ~TypedSctEvent(){}
				const T value;
		};
		'''
	}
	
	def generateEvents(ExecutionFlow it) {
		'''
		«FOR s : scopes»
			«FOR e : s.declarations.filter(EventDefinition).filter[direction == Direction::LOCAL]»
				«generateEventClass(e, it)»
			«ENDFOR»
		«ENDFOR»
		'''
	}
	
	def generateEventClass(EventDefinition it, ExecutionFlow flow) {
		'''
		«IF hasValue»
		«generateTypedEventClass(flow)»
		«ELSE»
		«generateNormalEventClass(flow)»
		«ENDIF»
		'''
	}
	
	def generateTypedEventClass(EventDefinition it, ExecutionFlow flow) {
		val type = typeSpecifier.targetLanguageName
		'''
		class «eventClassName» : public TypedSctEvent<«type»>
		{
			public:
				«eventClassName»(«flow.eventEnumName» name, «type» value) :
					TypedSctEvent(name, value) {};
		};
		'''
	}
	
	def generateNormalEventClass(EventDefinition it, ExecutionFlow flow) {
		'''
		class «eventClassName» : public SctEvent
		{
			public:
				«eventClassName»(«flow.eventEnumName» name) : SctEvent(name){};
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