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
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions

class StatemachineHeader extends org.yakindu.sct.generator.c.files.StatemachineHeader {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	@Inject protected extension IncludeProvider
	@Inject protected extension StatechartExtensions

	protected GeneratorEntry entry

	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		val namespace = statechartNamespace
		'''
			«entry.licenseText»
			
			#ifndef «module().define»_H_
			#define «module().define»_H_
			
			
			«includes(artifactConfigs)»
			
			/*! \file Header of the state machine '«name»'.
			*/
			
			«IF !namespace.nullOrEmpty»
			«FOR ns : namespace»
			namespace «ns» {
			«ENDFOR»
			«ENDIF»

			«preStatechartDeclarations»
			
			/*! Define indices of states in the StateConfVector */
			«FOR state : states»
				#define «state.stateVectorDefine» «state.stateVector.offset»
			«ENDFOR»
			
			«generateClass(artifactConfigs)»
			
			«IF !entry.useStaticOPC»
				«scopes.filter(typeof(StatechartScope)).map[createInlineOCB_Destructor].filterNullOrEmptyAndJoin»
			«ENDIF»
			
			«postStatechartDeclarations»
			
			«IF !namespace.nullOrEmpty»
			«FOR ns : namespace»
			}
			«ENDFOR»
			«ENDIF»
			
			#endif /* «module().define»_H_ */
		'''
	}
	
	def statesEnumDecl(ExecutionFlow it) '''
		/*! Enumeration of all states */ 
		typedef enum
		{
			«null_state»,
			«FOR state : states SEPARATOR ","»
				«state.stateName»
			«ENDFOR»
		} «statesEnumType»;
	'''
	
	def final includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR i : getIncludes(newArrayList, artifactConfigs)»
		  «i»
		«ENDFOR»
		'''
	}
	
	def preStatechartDeclarations(ExecutionFlow it) ''''''

	def postStatechartDeclarations(ExecutionFlow it) ''''''
	
	def protected generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
			class «module» : «interfaceExtensions»
			{
				public:
					«generatePublicClassmembers»
				protected:
					«generateProtectedClassmembers»
				private:
					«generatePrivateClassmembers»
			};
		'''
	}

	def protected generatePublicClassmembers(ExecutionFlow it) {
		'''
			«module»();
			
			~«module»();
			
			«statesEnumDecl»
			
			«FOR s : it.scopes»«s.createPublicScope»«ENDFOR»
			
			«publicFunctionPrototypes»
			
			/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
			sc_boolean «stateActiveFctID»(«statesEnumType» state) const;
			
			«IF timed»
				//! number of time events used by the state machine.
				static const sc_integer «timeEventsCountConst» = «timeEvents.size»;
				
				//! number of time events that can be active at once.
				static const sc_integer «timeEventsCountparallelConst» = «(it.sourceElement as Statechart).maxNumberOfParallelTimeEvents»;
			«ENDIF»
			«IF entry.innerClassVisibility == "public"»
			
			«generateInnerClasses»
			«ENDIF»
		'''
	}
	
	def protected generateProtectedClassmembers(ExecutionFlow it) {
		'''
			«IF entry.innerClassVisibility == "protected"»
			«generateInnerClasses»
			«ENDIF»
		'''
	}

	def protected generateInnerClasses(ExecutionFlow it) {
		'''
			«IF (timed || hasOperationCallbacks)»
			«copyConstructorDecl»
			«assignmentOperatorDecl»
			«ENDIF»
			
			«FOR s : scopes.filter(typeof(InternalScope))»«s.createInterface»«ENDFOR»
			
			«statemachineTypeDecl»
			
			«prototypes»
		'''
	}
	
	
	def protected copyConstructorDecl(ExecutionFlow it) {
		'''
			«module»(const «module» &rhs);
		'''
	}
	
	def protected assignmentOperatorDecl(ExecutionFlow it) {
		'''
			«module»& operator=(const «module»&);
		'''
	}
	
	def protected generatePrivateClassmembers(ExecutionFlow it) {
		'''
			«IF entry.innerClassVisibility == "private"»
			«generateInnerClasses»
			«ENDIF»
		'''
	}

	def protected getInterfaceExtensions(ExecutionFlow flow) {

		var String interfaces = "";

		if (flow.timed) {
			interfaces = interfaces + "public " + timedStatemachineInterface + ", "
		}

		interfaces = interfaces + "public " + statemachineInterface

		return interfaces;
	}

	def protected CharSequence createInlineOCB_Destructor(StatechartScope it) {
		if (hasOperations) {
			return '''inline «flow.module»::«interfaceOCBName»::~«interfaceOCBName»() {}'''
		}
		return ''''''
	}

	def protected createPublicScope(Scope scope) {
		switch scope {
			InterfaceScope: scope.createPublicScope
			InternalScope: scope.createPublicScope
		}
	}

	def protected createPublicScope(InterfaceScope scope) '''
		«scope.createInterface»
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

	def protected createInterface(StatechartScope scope) '''
		//! Inner class for «scope.simpleName» interface scope.
		class «scope.interfaceName»
		{
			
			public:
				«FOR d : scope.declarations»
					«d.functionPrototypes»
				«ENDFOR»
				
			«entry.innerClassVisibility»:
				«protectedInnerClassMembers(scope)»
		};
	'''
	
	protected def CharSequence protectedInnerClassMembers(StatechartScope scope)
		'''
			friend class «scope.execution_flow.module()»;
			«FOR d : scope.declarations»
				«d.privateFunctionPrototypes»
				«d.scopeTypeDeclMember»
			«ENDFOR»
		'''
	

	def dispatch privateFunctionPrototypes(Declaration it) {
		''''''	
	}
	
	def dispatch privateFunctionPrototypes(EventDefinition it) {
		''''''	
	}
	
	def createOCBInterface(StatechartScope scope) {
		'''
			«IF scope.hasOperations»
				//! Inner class for «scope.simpleName» interface scope operation callbacks.
				class «scope.interfaceOCBName»
				{
					public:
						«IF !entry.useStaticOPC»
							virtual ~«scope.interfaceOCBName»() = 0;
							
						«ENDIF»
						«FOR operation : scope.operations SEPARATOR StringConcatenation.DEFAULT_LINE_DELIMITER»
							«IF entry.useStaticOPC»static«ELSE»virtual«ENDIF» «operation.signature»«IF !entry.useStaticOPC» = 0«ENDIF»;
						«ENDFOR»
				};
				«IF !entry.useStaticOPC»
					
					/*! Set the working instance of the operation callback interface '«scope.interfaceOCBName»'. */
					«scope.OCB_InterfaceSetterDeclaration(false)»;
				«ENDIF»
			«ENDIF»
		'''
	}

	def statemachineTypeDecl(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_ushort «orthogonalStatesConst» = «stateVector.size»;
		«IF hasHistory»
		//! dimension of the state configuration vector for history states
		static const sc_ushort «historyStatesConst» = «historyVector.size»;«ENDIF»
		
		«IF timed»
			«timerInterface»* «timerInstance»;
			sc_boolean «timeEventsInstance»[«timeEventsCountConst»];
		«ENDIF»
		
		«statesEnumType» stateConfVector[«orthogonalStatesConst»];
		
		«IF hasHistory»«statesEnumType» historyVector[«historyStatesConst»];«ENDIF»
		sc_ushort stateConfVectorPosition;
		
		«FOR s : getInterfaces»
			«s.interfaceName» «s.instance»;
			«IF s.hasOperations && !entry.useStaticOPC»«s.interfaceOCBName»* «s.OCB_Instance»;«ENDIF»
		«ENDFOR»
	'''
	
	def protected publicFunctionPrototypes(ExecutionFlow it) '''
		«IStatemachineFunctions»
		
		«IF timed»
			«timedStatemachineFunctions»
		«ENDIF»
	'''

	def protected IStatemachineFunctions() '''
		/*
		 * Functions inherited from StatemachineInterface
		 */
		virtual «IF entry.checkUnimplementedOCBs»sc_errorCode«ELSE»void«ENDIF» init();
		
		virtual void enter();
		
		virtual void exit();
		
		virtual void runCycle();
		
		/*!
		* Checks if the state machine is active (until 2.4.1 this method was used for states).
		* A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
		*/
		virtual sc_boolean isActive() const;
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		*/
		virtual sc_boolean isFinal() const;
	'''

	def timedStatemachineFunctions(ExecutionFlow it) '''
		/*
		 * Functions inherited from TimedStatemachineInterface
		 */
		virtual void setTimer(«timerInterface»* timerInterface);
		
		virtual «timerInterface»* getTimer();
		
		virtual void «raiseTimeEventFctID»(sc_eventid event);
	'''

	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void «asRaiser»(«valueParams»);
			
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */
			sc_boolean «asRaised»() const;
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */
				«typeSpecifier.targetLanguageName» «asGetter»() const;
				
			«ENDIF»
		«ELSEIF direction == Direction::IN»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void «asRaiser»(«valueParams»);
			
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */
			sc_boolean «asRaised»() const;
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */
				«typeSpecifier.targetLanguageName» «asGetter»() const;
				
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */
		«IF const»const «ENDIF»«typeSpecifier.targetLanguageName» «it.asGetter»() const;
		
		«IF !readonly && !const»
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */
			void «asSetter»(«typeSpecifier.targetLanguageName» value);
			
		«ENDIF»
	'''
	
	def dispatch functionPrototypes(Declaration it) ''''''

	/* ===================================================================================
	 * Handling declaration of function prototypes
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
