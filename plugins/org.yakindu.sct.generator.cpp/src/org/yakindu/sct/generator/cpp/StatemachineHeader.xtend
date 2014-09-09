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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.generator.c.Statemachine
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class StatemachineHeader extends Statemachine {
	
	@Inject extension Naming cNaming
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension GenmodelEntries
	@Inject extension INamingService
	
	def generateStatemachineHeader(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.module().h, flow.statemachineHContent(entry) )
	}
	
	override statemachineHContent(ExecutionFlow it,  GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «module().define»_H_
		#define «module().define»_H_

		#include "«typesModule.h»"
		#include "«statemachineInterface.h»"
		«IF timed»
			#include "«timedStatemachineInterface.h»"
		«ENDIF»

		/*! \file Header of the state machine '«name»'.
		*/
		
		class «module()» : «interfaceExtensions» {
			
			public:
				
				«flow.module()»();
				
				~«flow.module()»();
				
				«statesEnumDecl»
				
				«FOR s : it.scopes»«s.createPublicScope()»«ENDFOR»
				
				«publicFunctionPrototypes»
				
				/*! Checks if the specified state is active. */
				sc_boolean «activeFctID»(«statesEnumType» state);
			
			private:
			
				«FOR s : scopes.filter(typeof(InternalScope))»«s.createInterface»«ENDFOR»
			
				«statemachineTypeDecl»
				
				«prototypes»
		};
		
		«FOR s : it.scopes.filter(typeof(StatechartScope)) SEPARATOR StringConcatenation.DEFAULT_LINE_DELIMITER»
			«s.createInlineOCB_Destructor»
		«ENDFOR»
		#endif /* «module().define»_H_ */
	'''
	
	def protected getInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + "public " +timedStatemachineInterface+", "
		}

		interfaces = interfaces + "public " + statemachineInterface
		
		return interfaces;
	}
	
	def protected createInlineOCB_Destructor(StatechartScope it) {
		if (hasOperations) {
			return '''inline «flow.module»::«interfaceOCBName»::~«interfaceOCBName»() {}'''
		}
		return ''''''
	}
	
	def protected createPublicScope(Scope scope) {
		switch scope {
			InterfaceScope: scope.createPublicScope()
			InternalScope: scope.createPublicScope
		}
	}
	
	def protected createPublicScope(InterfaceScope scope)
	'''
		«scope.createInterface()»
«««		«scope.createListenerInterface(entry)»
		«scope.createOCBInterface»
		
		/*! Returns an instance of the interface class '«scope.interfaceName»'. */
		«scope.interfaceName»* get«scope.interfaceName»();
		
		«IF scope.defaultInterface»
			«FOR d : scope.declarations»
			«d.functionPrototypes»
			«ENDFOR»
		«ENDIF»
	'''
	
	def protected createPublicScope(InternalScope scope) {
		'''
			«scope.createOCBInterface»
		'''
	}
	
	def protected createInterface(StatechartScope scope)
	'''
		//! Inner class for «scope.simpleName» interface scope.
		class «scope.interfaceName» {
			
			public:
				«FOR d : scope.declarations»
					«d.functionPrototypes»
				«ENDFOR»
				
			private:
				friend class «scope.execution_flow.module()»;
				«FOR d : scope.declarations»
				 «d.structDeclaration»
				«ENDFOR»
		};
	'''
	
	def createOCBInterface(StatechartScope scope) {
		'''
		
		«IF scope.hasOperations»
			//! Inner class for «scope.simpleName» interface scope operation callbacks.
			class «scope.interfaceOCBName» {
				public:
					virtual ~«scope.interfaceOCBName»() = 0;
					
					«FOR operation : scope.operations SEPARATOR StringConcatenation.DEFAULT_LINE_DELIMITER»
						virtual «operation.signature» = 0;
					«ENDFOR»
			};
			
			/*! Set the working instance of the operation callback interface '«scope.interfaceOCBName»'. */
			«scope.OCB_InterfaceSetterDeclaration(false)»;
		«ENDIF»
		'''
	}

	override statemachineTypeDecl(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer «orthogonalStatesConst» = «stateVector.size»;
		«IF hasHistory»
		//! dimension of the state configuration vector for history states
		static const sc_integer «historyStatesConst» = «historyVector.size»;«ENDIF»
		
		«IF timed»
			«timerInterface»* «timerInstance»;
			sc_boolean «timeEventsInstance»[«timeEvents.size»];
		«ENDIF»
		
		«statesEnumType» stateConfVector[«orthogonalStatesConst»];
		
		«IF hasHistory»«statesEnumType» historyVector[«historyStatesConst»];«ENDIF»
		sc_ushort stateConfVectorPosition;
		
		«FOR s : scopes.filter(typeof(StatechartScope))»
			«s.interfaceName»* «s.instance»;
			«IF s.hasOperations»«s.interfaceOCBName»* «s.OCB_Instance»;«ENDIF»
		«ENDFOR»
	'''
	
	def protected publicFunctionPrototypes(ExecutionFlow it) '''
		«IStatemachineFunctions»
		
		«IF timed»
			«timedStatemachineFunctions»
		«ENDIF»
	'''
	
	def protected IStatemachineFunctions() '''
		void init();
		
		void enter();
		
		void exit();
		
		void runCycle();
	'''
	
	def timedStatemachineFunctions(ExecutionFlow it) '''
		void setTimer(«timerInterface»* timer);
		
		«timerInterface»* getTimer();
		
		void «raiseTimeEventFctID»(sc_eventid event);
	'''
	
	override dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
			void «asRaiser»(«valueParams»);
			
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			sc_boolean «asRaised»();
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				«type.targetLanguageName» «asGetter»();
				
			«ENDIF»
		«ELSEIF direction == Direction::IN»
		/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
		void «asRaiser»(«valueParams»);
		
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			sc_boolean «asRaised»();
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				«type.targetLanguageName» «asGetter»();
				
			«ENDIF»
		«ENDIF»
	'''

	override dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		«type.targetLanguageName» «it.asGetter»();

		«IF ! readonly »
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			void «asSetter»(«type.targetLanguageName» value);
			
		«ENDIF»
	'''
	
	/* ===================================================================================
	 * Handling decralartion of function prototypes
	 */
	 
	/** */
	def prototypes(ExecutionFlow it) '''
		// prototypes of all internal functions
		
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.toPrototypes»
		void clearInEvents();
		void clearOutEvents();
		
	'''
	
	
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''
	
	def dispatch functionPrototype(Check it) '''
		sc_boolean «shortName»();
	'''
	
	def dispatch functionPrototype(Step it) '''
		void «shortName»();
	'''	
}