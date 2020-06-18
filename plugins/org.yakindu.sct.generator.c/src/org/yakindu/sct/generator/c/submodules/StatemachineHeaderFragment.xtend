/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import com.google.inject.Inject
import java.util.LinkedList
import java.util.Set
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IHeaderFragment
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.BufferEventExtensions
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author rbeckmann
 *
 */
class StatemachineHeaderFragment implements IHeaderFragment {
	
	@Inject protected Set<IncludeProvider> includeProviders
	
	@Inject protected extension Naming cNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntries
	@Inject protected extension INamingService
	@Inject protected extension StatechartExtensions
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension APIGenerator
	@Inject protected extension StatechartTypes
	@Inject protected extension EventCode
	@Inject protected extension GeneratorPredicate
	
	@Inject protected extension BufferEventExtensions
	
	@Inject protected extension GeneratorEntry entry
	
	@Inject
	IGenArtifactConfigurations defaultConfigs
	
	override defines(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
		/*! Define number of states in the state enum */
		
		#define «numStates» «states.size»
		
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
		«FOR state : states»
		#define «state.stateVectorDefine» «state.stateVector.offset»
		«ENDFOR»
		'''
	}
	
	override fileComment(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''«entry.licenseText»'''
	}
	
	override forwardDeclarations(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		forwardDeclarations
	}
	
	override functions(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		functions
	}
	
	override includes(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		includes(artifactConfigs)
	}
	
	override types(ExecutionFlow it, GeneratorEntry entry , IGenArtifactConfigurations artifactConfigs) {
		'''
		«statesEnumDecl»
				
		«featuresEnumDecl»
		
		«FOR s : it.scopes»
			«s.scopeTypeDecl»
			
			«s.scopeConstDecl»
			
		«ENDFOR»
		
		
		«FOR t : it.derivedComplexTypes»
			«t.typeDeclaration(flow)»
			«t.structDeclaration(flow)»
		«ENDFOR»
		
		«statemachineStruct»
		
		'''
	}
	
	def derivedComplexTypes(ExecutionFlow flow) {
		
		val types = new LinkedList<ComplexType> 
		flow.collectDerivedComplexTypes(types)
		return types
	}
	
	
	def LinkedList<ComplexType> collectDerivedComplexTypes(ComplexType it, LinkedList<ComplexType> types) {
		it.referencedComplexTypes.reverseView.forEach[ t | 
			if (!types.contains(t)) {
				types.push(t)
				t.collectDerivedComplexTypes(types)
			}
		]
		
		return types		
	} 
	
	def referencedComplexTypes(ComplexType it) {
		it	.features
			.filter(Property)
			.filter[typeSpecifier.type instanceof ComplexType]
			.map[typeSpecifier.type as ComplexType]
			.toList
	}
	
	protected def CharSequence functions(ExecutionFlow it)
		'''
		«IF entry.tracingGeneric»
		/*! Initializes the «type» state machine data structures. Must be called before first usage.*/
		extern «declareInitWithTracing»
		
		/*! Sets the trace handler. Can be called any time. */
		extern «declareSetTraceHandler»
		«ENDIF»
		
		/*! Initializes the «type» state machine data structures. Must be called before first usage.*/
		extern «declareInit»
		
		/*! Activates the state machine */
		extern «declareEnter»
		
		/*! Deactivates the state machine */
		extern «declareExit»
		
		/*! Performs a 'run to completion' step. */
		extern «declareRunCycle»
		
		«IF timed»
			/*! Raises a time event. */
			extern «declareRaiseTimeEvent»
		«ENDIF»
		
		«FOR s : it.scopes.filter( typeof(InterfaceScope) )»
			«s.scopeFunctionPrototypes»
		«ENDFOR»
		
		/*!
		 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
		 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
		 */
		extern «declareIsActive»
		
		/*!
		 * Checks if all active states are final. 
		 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		 */
		extern «declareIsFinal»
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
		extern «declareIsStateActive»
		
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
		«FOR provider : includeProviders»
			«FOR i : provider.getIncludes(it, artifactConfigs)»
				«i»
			«ENDFOR»
		«ENDFOR»
		'''
	}	
	
	def dispatch scopeFunctionPrototypes(StatechartScope it) '''
		«FOR d : declarations.filter[d | !(d instanceof Event) || !((d as Event).isBufferEvent)]»
			«d.functionPrototypes »
		«ENDFOR»
	'''

	def dispatch scopeFunctionPrototypes(Object it) ''''''

	def dispatch functionPrototypes(Declaration it) ''''''

	def dispatch functionPrototypes(EventDefinition it) '''
		«IF direction == Direction::IN»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */ 
			extern «eventRaiserSignature(flow, it)»;
		«ELSE»
			«IF useOutEventObservables»
				/*! Returns the observable for the out event '«name»' that is defined in the «scope.scopeDescription». */ 
				extern «eventObservableSignature(flow, it)»;
				
			«ENDIF»
			«IF useOutEventGetters»
				/*! Checks if the out event '«name»' that is defined in the «scope.scopeDescription» has been raised. */ 
				extern «eventGetterSignature(flow, it)»;
				
				«IF hasValue»
					/*! Gets the value of the out event '«name»' that is defined in the «scope.scopeDescription». */ 
					extern «eventValueGetterSignature(flow, it)»;
					
				«ENDIF»
			«ENDIF»
		«ENDIF»
	'''

	def dispatch functionPrototypes(VariableDefinition it) '''
		/*! Gets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
		extern «IF isConstString»const «ENDIF»«typeSpecifier.targetLanguageName» «asGetter»(const «scHandleDecl»);
		«IF !readonly && !const»
			/*! Sets the value of the variable '«name»' that is defined in the «scope.scopeDescription». */ 
			extern void «asSetter»(«scHandleDecl», «typeSpecifier.targetLanguageName» value);
		«ENDIF»
	'''
	
}