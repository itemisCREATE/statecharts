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
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

/**
 * @author René Beckmann - Initial contribution and API
 */
class StatechartEvents implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension EventDrivenPredicate
	
	@Inject extension EventNaming eventNaming
	
	@Inject protected GeneratorEntry entry
	protected ExecutionFlow flow
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		content
	}
	
	def content(ExecutionFlow it) {
		if(!needsEventClasses) return ''''''
		'''
			#ifndef «generateHeaderDefineGuard»
			#define «generateHeaderDefineGuard»
			#ifndef «invalidEvent»
			#define «invalidEvent» 0
			#endif
			
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
			.flatten
			.filter[isQueued]
			.map[eventEnumMemberName] // generate enumMemberNames for each
			.toList
		if(timed) {
			enumMembers.add(timeEventEnumName)
		}
		
		'''
			typedef enum  {
				«invalidEventEnumName(it)» = «invalidEvent»,
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
			class «SCT_EVENT»
			{
				public:
					«SCT_EVENT»(«eventEnumName» name) : name(name){}
					virtual ~«SCT_EVENT»(){}
					const «eventEnumName» name;
					
			};
					
			template <typename T>
			class «TYPED_SCT_EVENT» : public «SCT_EVENT»
			{
				public:
					«TYPED_SCT_EVENT»(«eventEnumName» name, T value) :
						«SCT_EVENT»(name),
						value(value)
						{}
					virtual ~«TYPED_SCT_EVENT»(){}
					const T value;
			};
		'''
	}
	
	def generateEvents(ExecutionFlow it) {
		'''
			«FOR s : scopes»
				«FOR e : s.declarations.filter(EventDefinition).filter[isQueued]»
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
			class «eventClassName» : public «TYPED_SCT_EVENT»<«type»>
			{
				public:
					«eventClassName»(«flow.eventEnumName» name, «type» value) :
						«TYPED_SCT_EVENT»(name, value) {};
			};
		'''
	}
	
	def generateNormalEventClass(EventDefinition it, ExecutionFlow flow) {
		'''
			class «eventClassName» : public «SCT_EVENT»
			{
				public:
					«eventClassName»(«flow.eventEnumName» name) : «SCT_EVENT»(name){};
			};
		'''
	}
	
	def getBaseClass(EventDefinition it) {
		'''
			«IF hasValue»
				«TYPED_SCT_EVENT»
			«ELSE»
				«SCT_EVENT»
			«ENDIF»
		'''
	}
}
