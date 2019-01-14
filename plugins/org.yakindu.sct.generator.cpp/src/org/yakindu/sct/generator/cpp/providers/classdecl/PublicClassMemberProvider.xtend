package org.yakindu.sct.generator.cpp.providers.classdecl

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.generator.cpp.providers.StatemachineClassDeclaration
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.generator.cpp.submodules.InternalFunctions
import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.generator.cpp.submodules.TracingFunctions
import org.yakindu.sct.generator.cpp.submodules.lifecycle.LifecycleFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

@GeneratorContribution(StatemachineClassDeclaration.CLASS_PUBLIC_TARGET)   
class PublicClassMemberProvider implements ISourceFragment {
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
		'''
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
			static const «INT_TYPE» «timeEventsCountparallelConst» = «statechart.maxNumberOfParallelTimeEvents»;
		«ENDIF»
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