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
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IHeaderContentFragment
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry

class EventDrivenStatemachineHeaderFragment implements IHeaderContentFragment {
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject extension EventNaming
	
	override defines(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		'''
		#ifndef «bufferSize»
		#define «bufferSize» «CGeneratorConstants.EVENT_QUEUE_BUFFER_SIZE»
		#endif
		#ifndef SC_INVALID_EVENT_VALUE
		#define SC_INVALID_EVENT_VALUE 0
		#endif
		'''
	}
	
	override fileComment(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override functions(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override includes(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override types(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF hasLocalEvents»
		«generateEventsEnum»
		
		«generateEventValueUnion»
		
		«generateEventStruct»
		
		«generateEventQueue»
		«ENDIF»
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		'''
		/*
		 * Enum of event names in the statechart.
		 */
		typedef enum  {
			«invalidEventEnumName(it)» = SC_INVALID_EVENT_VALUE,
			«FOR e : internalScope.getLocalEvents SEPARATOR ","»
				«eventEnumMemberName(e)»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateEventValueUnion(ExecutionFlow it) {
		if(!hasLocalEventsWithValue) {
			return ''''''
		}
		'''
		/*
		 * Union of all possible event value types.
		 */
		typedef union {
			«FOR e : internalScope.getLocalEvents.filter[hasValue]»
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
			«IF hasLocalEventsWithValue»
			sc_boolean has_value;
			«eventValueUnionName» value;
			«ENDIF»
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
	
}
