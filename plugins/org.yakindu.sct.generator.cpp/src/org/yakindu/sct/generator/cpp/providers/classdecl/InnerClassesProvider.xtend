package org.yakindu.sct.generator.cpp.providers.classdecl

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
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
import org.yakindu.sct.model.stext.stext.InternalScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.StatemachineClassDeclaration

@GeneratorContribution(StatemachineClassDeclaration.CLASS_INNER_TARGET)
class InnerClassesProvider implements ISourceFragment {
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
	
}