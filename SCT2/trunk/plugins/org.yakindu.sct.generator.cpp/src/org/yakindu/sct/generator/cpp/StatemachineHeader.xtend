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
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Parameter
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.generator.c.Statemachine
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import java.util.List
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.stext.stext.StatechartScope

class StatemachineHeader extends Statemachine {
	
	@Inject extension Naming cNaming
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension GenmodelEntries
	
	def generateStatemachineHeader(ExecutionFlow flow, Statechart sc, IFileSystemAccess fsa, GeneratorEntry entry) {
		 fsa.generateFile(flow.module().hpp, flow.statemachineHContent(entry) )
	}
	
	override statemachineHContent(ExecutionFlow it,  GeneratorEntry entry) '''
		«entry.licenseText»
		
		#ifndef «module().define»_H_
		#define «module().define»_H_

		#include "«typesModule.hpp»"
		#include "«statemachineInterface.hpp»"
		«IF timed»
			#include "«timedStatemachineInterface.hpp»"
		«ENDIF»

		/*! \file Header of the state machine '«name»'.
		*/
		
		class «module()» : «interfaceExtensions» {
			
			public:
				
				«flow.module()»();
				
				«statesEnumDecl»
				
				«FOR s : it.scopes»«s.createScope()»«ENDFOR»
				
				«publicFunctionPrototypes»
				
				/*! Checks if the specified state is active. */
				sc_boolean «nameOfIsActiveFunction»(«statesEnumType» state);
			
			private:
			
				«FOR s : scopes.filter(typeof(InternalScope))»«s.createInterface»«ENDFOR»
			
				«statemachineTypeDecl»
				
				«functionPrototypes»
		};
		
		#endif /* «module().define»_H_ */
	'''
	
	def private getInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + "public " +timedStatemachineInterface+", "
		}

		interfaces = interfaces + "public " + statemachineInterface
		
		return interfaces;
	}
	
	def private createScope(Scope scope) {
		switch scope {
			InterfaceScope: scope.createScope()
			InternalScope: scope.createPublicScope
		}
	}
	
	def private createScope(InterfaceScope scope)
	'''
		«scope.createInterface()»
«««		«scope.createListenerInterface(entry)»
		«scope.createOperationCallbackInterface»
		
		«scope.interfaceName»* get«scope.interfaceName»();
	'''
	
	def private createInterface(StatechartScope scope)
	'''
		//! Inner class for «scope.interfaceName» interface scope.
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
	
	def private createPublicScope(InternalScope scope) {
		'''
		«IF scope.hasOperations()»
			class «internalOperationCallbackName» {
				«FOR operation : scope.operations»
					virtual «operation.asFunction»() = 0;
				«ENDFOR»
			}
			
			void set«internalOperationCallbackName»(«internalOperationCallbackName»* operationCallback);
		«ENDIF»
		'''
	}
	
	def createOperationCallbackInterface(InterfaceScope scope) {
		'''
		«IF scope.hasOperations»
			
			public interface «scope.getInterfaceOperationCallbackName()» {
			«FOR operation : scope.operations»
				virtual «operation.signature» = 0;
			«ENDFOR»
			}
		«ENDIF»
		'''
	}
	
	def private signature(OperationDefinition it)
	'''
		«type.targetLanguageName» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«parameter.type.targetLanguageName» «parameter.identifier»«ENDFOR»)
	'''
	
	def private identifier(Parameter parameter) {
		if (parameter.name.isCKeyword()) {
			return parameter.name + "Arg"
		}
		else {
			parameter.name
		}
	}

	override statemachineTypeDecl(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer «orthogonalStatesConst» = «stateVector.size»;
		«IF hasHistory»
		//! dimension of the state configuration vector for history states
		static const sc_integer «historyStatesConst» = «historyVector.size»;«ENDIF»
		
		«IF timed»
			«timerServiceInterface»* «timerServiceInstance»;
			sc_boolean «timeEventsInstance»[«timeEvents.size»];
		«ENDIF»
		
		«statesEnumType» stateConfVector[«orthogonalStatesConst»];
		
		«IF hasHistory»«statesEnumType» historyVector[«historyStatesConst»];«ENDIF»
		sc_ushort stateConfVectorPosition;
		
		«FOR s : scopes.filter(typeof(StatechartScope))»
			«s.interfaceName»* «s.instance»;
		«ENDFOR»
	'''
	
	def publicFunctionPrototypes(ExecutionFlow it) '''
		«IStatemachineFunctions»
		
		«IF timed»
			«ITimedStatemachineFunctions»
		«ENDIF»
	'''
	
	def IStatemachineFunctions() '''
		void init();
		
		void enter();
		
		void exit();
		
		void runCycle();
	'''
	
	def ITimedStatemachineFunctions(ExecutionFlow it) '''
		void setTimerService(«timerServiceInterface»* timerService);
		
		«timerServiceInterface»* getTimerService();
		
		void «nameOfRaiseTimeEventFunction»(sc_eventid event);
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
	def dispatch functionPrototypes(ExecutionFlow it) '''
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
		sc_boolean «asCheckFunction»();
	'''
	
	def dispatch functionPrototype(Step it) '''
		void «functionName»();
	'''	
}