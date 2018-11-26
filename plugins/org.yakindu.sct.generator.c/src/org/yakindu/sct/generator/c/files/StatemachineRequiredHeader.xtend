/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.files

import com.google.inject.Inject
import org.yakindu.base.types.Declaration
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class StatemachineRequiredHeader implements IContentTemplate {

	@Inject extension Naming cNaming
	@Inject extension SExecExtensions
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension GenmodelEntries
	@Inject extension INamingService
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) '''
		«entry.licenseText»
		
		#ifndef «module.client.define»_H_
		#define «module.client.define»_H_

		#include "«(typesModule.h).relativeTo(module.client.h)»"
		«IF timed || operations.size > 0 || entry.tracingUsed»
		#include "«(module.h).relativeTo(module.client.h)»"
		«ENDIF»

		#ifdef __cplusplus
		extern "C"
		{
		#endif 
		
		/*! \file This header defines prototypes for all functions that are required by the state machine implementation.
		
		«IF timed»
			This is a state machine uses time events which require access to a timing service. Thus the function prototypes:
				- «setTimerFctID» and
				- «unsetTimerFctID»
			are defined.
			
		«ENDIF»
		«IF operations.size > 0»
			This state machine makes use of operations declared in the state machines interface or internal scopes. Thus the function prototypes:
				«FOR o : operations»
				- «o.asFunction»
				«ENDFOR»
			are defined.
			
		«ENDIF»
		These functions will be called during a 'run to completion step' (runCycle) of the statechart. 
		There are some constraints that have to be considered for the implementation of these functions:
			- never call the statechart API functions from within these functions.
			- make sure that the execution time is as short as possible.
		 
		*/
		«FOR s : it.scopes »
		«s.scopeFunctionPrototypes»
		
		«ENDFOR»
		«IF timed»
		/*!
		 * This is a timed state machine that requires timer services
		 */ 
		
		/*! This function has to set up timers for the time events that are required by the state machine. */
		/*! 
			This function will be called for each time event that is relevant for a state when a state will be entered.
			\param evid An unique identifier of the event.
			\time_ms The time in milliseconds
			\periodic Indicates the the time event must be raised periodically until the timer is unset 
		*/
		extern void «setTimerFctID»(«scHandleDecl», const «EVENT_TYPE» evid, const «INT_TYPE» time_ms, const «BOOL_TYPE» periodic);

		/*! This function has to unset timers for the time events that are required by the state machine. */
		/*! 
			This function will be called for each time event that is relevant for a state when a state will be left.
			\param evid An unique identifier of the event.
		*/
		extern void «unsetTimerFctID»(«scHandleDecl», const «EVENT_TYPE» evid);
		«ENDIF»
		
		
		«IF entry.tracingUsed»
		/*!
		 * Tracing callback functions
		 */
		«IF entry.tracingEnterState»
			/*! This function is called when a state is entered. */
			extern void «enterStateTracingFctID»(«scHandleDecl», const «statesEnumType» state);
		«ENDIF»
		
		«IF entry.tracingExitState»
			/*! This function is called when a state is exited. */
			extern void «exitStateTracingFctID»(«scHandleDecl», const «statesEnumType» state);
		«ENDIF»
		«ENDIF»
		
		#ifdef __cplusplus
		}
		#endif 
		
		#endif /* «module.client.define»_H_ */
	'''
	
	
	def dispatch scopeFunctionPrototypes(StatechartScope it) '''
		«FOR d : declarations »
		«d.functionPrototypes »
		«ENDFOR»
	'''	

	def dispatch scopeFunctionPrototypes(Object it) ''''''	
	

	def dispatch functionPrototypes(Declaration it) ''''''

	def dispatch functionPrototypes(OperationDefinition it) '''
		extern «typeSpecifier.targetLanguageName» «asFunction»(const «scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR»);
	'''

}