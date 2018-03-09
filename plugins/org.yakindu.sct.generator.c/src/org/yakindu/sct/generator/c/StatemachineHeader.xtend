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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.extensions.Navigation
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
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

import static org.eclipse.xtext.util.Strings.*

class StatemachineHeader implements IContentTemplate {
	@Inject protected extension IncludeProvider
	@Inject protected extension Naming cNaming
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntries
	@Inject protected extension INamingService
	@Inject protected extension StatechartExtensions
	
	@Inject
	IGenArtifactConfigurations defaultConfigs
	
	override content(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		initializeNamingService
	'''
		«entry.licenseText»
		
		#ifndef «module.define»_H_
		#define «module.define»_H_
		
		«includes(artifactConfigs)»
				
		#ifdef __cplusplus
		extern "C" { 
		#endif 
		
		/*! \file Header of the state machine '«name»'.
		*/
		
		«preStatechartDeclarations»
		
		«statesEnumDecl»
		
		«FOR s : it.scopes»
			«s.scopeTypeDecl»
			«s.scopeConstDecl»
		«ENDFOR»
		
		«statemachineTypeDecl»
		
		«functions(it)»
		
		«postStatechartDeclarations»
		
		#ifdef __cplusplus
		}
		#endif 
		
		#endif /* «module.define»_H_ */
	'''
	}
	
	def preStatechartDeclarations(ExecutionFlow it) {
		/* To be implemented by child classes */
		''''''
	}
	
	def postStatechartDeclarations(ExecutionFlow it) {
		/* To be implemented by child classes */
		''''''
	}
	
	protected def CharSequence functions(ExecutionFlow it)
		'''
		
		/*! Initializes the «type» state machine data structures. Must be called before first usage.*/
		extern void «initFctID»(«scHandleDecl»);
		
		/*! Activates the state machine */
		extern void «enterFctID»(«scHandleDecl»);
		
		/*! Deactivates the state machine */
		extern void «exitFctID»(«scHandleDecl»);
		
		/*! Performs a 'run to completion' step. */
		extern void «runCycleFctID»(«scHandleDecl»);
		
		«IF timed»
			/*! Raises a time event. */
			extern void «raiseTimeEventFctID»(const «scHandleDecl», sc_eventid evid);
		«ENDIF»
		
		«FOR s : it.scopes.filter( typeof(InterfaceScope) )»
			«s.scopeFunctionPrototypes»
		«ENDFOR»
		
		/*!
		 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
		 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
		 */
		extern sc_boolean «isActiveFctID»(const «scHandleDecl»);
		
		/*!
		 * Checks if all active states are final. 
		 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		 */
		extern sc_boolean «isFinalFctID»(const «scHandleDecl»);
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
		extern sc_boolean «stateActiveFctID»(const «scHandleDecl», «statesEnumType» state);
		
		'''
	
	/**
	 * @Deprecated use {@link #includes(ExecutionFlow, ArtifactLocationProvider)} instead
	 */
	@Deprecated
	def includes(ExecutionFlow it) {
		includes(it, defaultConfigs)
	}

	def final includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR i : getIncludes(newArrayList, artifactConfigs)»
		  «i»
		«ENDFOR»
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

	def scopeTypeDecl(Scope scope) '''
		«val typeRelevantDeclarations = scope.typeRelevantDeclarations.toList»
		«IF !typeRelevantDeclarations.empty»
			/*! Type definition of the data structure for the «scope.type» interface scope. */
			typedef struct
			{
				«FOR d : typeRelevantDeclarations»
					«d.scopeTypeDeclMember»
				«ENDFOR»
			} «scope.type»;

		«ENDIF»
	'''
	
	def scopeConstDecl(Scope scope)'''
		«IF !(scope instanceof InternalScope) && !scope.constDeclarations.empty»
			/* Declaration of constants for scope «scope.type». */
			«FOR d : scope.constDeclarations AFTER newLine»
				«IF d.type.name != 'void'»extern const «d.typeSpecifier.targetLanguageName» «d.constantName»;«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	
	private def typeRelevantDeclarations(Scope scope){
		return scope.declarations.filter[
			switch it {
				EventDefinition: true
				TimeEvent: true
				VariableDefinition: !it.const
				default: false
			}
		]
	}
	
	private def constDeclarations(Scope scope){
		return scope.declarations.filter(typeof(VariableDefinition)).filter[const]
	}

	def statemachineTypeDecl(ExecutionFlow it) '''
		/*! Define dimension of the state configuration vector for orthogonal states. */
		#define «maxOrthogonalStates» «stateVector.size»
		«IF hasHistory»
		/*! Define dimension of the state configuration vector for history states. */
		#define «maxHistoryStates» «historyVector.size»«ENDIF»
		
		«IF timed»
		/*! Define maximum number of time events that can be active at once */
		#define «maxParallelTimeEvents» «(it.sourceElement as Statechart).maxNumberOfParallelTimeEvents»
		«ENDIF»
		
		/*! Define indices of states in the StateConfVector */
		«stateConfVectorDefines»
		
		/*! 
		 * Type definition of the data structure for the «type» state machine.
		 * This data structure has to be allocated by the client code. 
		 */
		typedef struct
		{
			«statemachineTypeStructContent»
		} «type»;
	'''
	
	def statemachineTypeStructContent(ExecutionFlow it) {
		'''
		«statesEnumType» stateConfVector[«type.toUpperCase»_MAX_ORTHOGONAL_STATES];
		«IF hasHistory»«statesEnumType» historyVector[«type.toUpperCase»_MAX_HISTORY_STATES];«ENDIF»
		sc_ushort stateConfVectorPosition; 
		
		«FOR iScope : scopes.filter[!typeRelevantDeclarations.empty]»
			«iScope.type» «iScope.instance»;
		«ENDFOR»
		'''
	}
	
	def stateConfVectorDefines(ExecutionFlow it) '''
		«FOR state : states»
		#define «state.stateVectorDefine» «state.stateVector.offset»
		«ENDFOR»
	'''

	def dispatch scopeFunctionPrototypes(StatechartScope it) '''
		«FOR d : declarations»
			«d.functionPrototypes »
		«ENDFOR»
	'''

	def dispatch scopeFunctionPrototypes(Object it) ''''''

	def dispatch functionPrototypes(Declaration it) ''''''

	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::IN»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
			extern void «asRaiser»(«scHandleDecl»«valueParams»);
			
		«ELSE»
			/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
			extern sc_boolean «asRaised»(const «scHandleDecl»);
			
			«IF hasValue»
				/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				extern «typeSpecifier.targetLanguageName» «asGetter»(const «scHandleDecl»);
				
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		extern «IF const»const «ENDIF»«typeSpecifier.targetLanguageName» «asGetter»(const «scHandleDecl»);
		«IF !readonly && !const»
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			extern void «asSetter»(«scHandleDecl», «typeSpecifier.targetLanguageName» value);
		«ENDIF»
	'''
}