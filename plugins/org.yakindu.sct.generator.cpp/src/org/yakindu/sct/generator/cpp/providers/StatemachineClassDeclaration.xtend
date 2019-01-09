/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.files.StatemachineHeader
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.submodules.InternalFunctions
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.generator.cpp.submodules.TracingFunctions
import org.yakindu.sct.generator.cpp.submodules.lifecycle.LifecycleFunctions
import org.yakindu.sct.generator.cpp.templates.ClassDeclaration
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InternalScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

@GeneratorContribution(StatemachineHeader.HEADER_TARGET)
class StatemachineClassDeclaration implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension StatechartExtensions
	
	@Inject protected GeneratorEntry entry
	
	@Inject protected extension InternalFunctions
	@Inject protected extension InterfaceFunctions
	@Inject protected extension TimingFunctions
	@Inject protected extension TracingFunctions
	@Inject protected extension LifecycleFunctions
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		generateClass(it, artifactConfigs).generate
	}
	
	def generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		val classDecl = new ClassDeclaration
		classDecl.name(module)
		interfaceExtensions.forEach[classDecl.superType(it)]
		generatePublicClassmembers(it, classDecl)
		classDecl.member(entry.innerClassVisibility, generateInnerClasses)
		classDecl
	}
	
	def protected getInterfaceExtensions(ExecutionFlow flow) {

		var interfaces = newArrayList;

		if (flow.timed) {
			interfaces += "public " + timedStatemachineInterface
		}

		interfaces += "public " + statemachineInterface

		return interfaces;
	}
	
	def protected generatePublicClassmembers(ExecutionFlow it, ClassDeclaration classDecl) {
		classDecl
			.constructorDeclaration()
			.destructorDeclaration()
			.publicMember('''
			«statesEnumDecl»
			
			static const «INT_TYPE» «statesCountConst» = «states.size»;
			
			«FOR s : it.scopes»«s.createPublicScope»«ENDFOR»
			
			«publicFunctionPrototypes»
			
			/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
			«BOOL_TYPE» «stateActiveFctID»(«statesEnumType» state) const;
			
			«IF timed»
				//! number of time events used by the state machine.
				static const «INT_TYPE» «timeEventsCountConst» = «timeEvents.size»;
				
				//! number of time events that can be active at once.
				static const «INT_TYPE» «timeEventsCountparallelConst» = «(it.sourceElement as Statechart).maxNumberOfParallelTimeEvents»;
			«ENDIF»
		''')
		
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
	
	def protected generateInnerClasses(ExecutionFlow it) {
		// TODO: Why is anything except the scopes generated in here? 
		'''
			«IF (timed || hasOperationCallbacks)»
				«copyConstructorDecl»
				«assignmentOperatorDecl»
			«ENDIF»
			
			«FOR s : scopes.filter(InternalScope)»«s.createInterface(new ClassDeclaration).generate»«ENDFOR»
			
			«statemachineFields»
			
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
	
	def statemachineFields(ExecutionFlow it) '''
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const «USHORT_TYPE» «orthogonalStatesConst» = «stateVector.size»;
		«IF hasHistory»
			//! dimension of the state configuration vector for history states
		static const «USHORT_TYPE» «historyStatesConst» = «historyVector.size»;«ENDIF»
		
		«IF timed»
			«timerInterface»* «timerInstance»;
			«BOOL_TYPE» «timeEventsInstance»[«timeEventsCountConst»];
		«ENDIF»
		
		«IF entry.tracingUsed»
			«YSCNamespace»::«traceObserverModule»<«statesEnumType»>* «tracingInstance»;
		«ENDIF»
		
		«statesEnumType» «STATEVECTOR»[«orthogonalStatesConst»];
		
		«IF hasHistory»«statesEnumType» «HISTORYVECTOR»[«historyStatesConst»];«ENDIF»
		«USHORT_TYPE» «STATEVECTOR_POS»;
		
		«FOR s : getInterfaces»
			«s.interfaceName» «s.instance»;
			«IF s.hasOperations && !entry.useStaticOPC»«s.interfaceOCBName»* «s.OCB_Instance»;«ENDIF»
		«ENDFOR»
	'''
	
	def protected publicFunctionPrototypes(ExecutionFlow it) '''
		«IStatemachineFunctions»
		
		«IF timed»
			«timedStatemachineFunctionPrototypes»
		«ENDIF»
		«IF entry.tracingUsed»
			«tracedStatemachineFunctions»
		«ENDIF»
	'''
}
