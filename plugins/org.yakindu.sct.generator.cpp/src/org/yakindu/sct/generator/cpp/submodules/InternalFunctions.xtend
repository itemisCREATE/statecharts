package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppExpressionsGenerator
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class InternalFunctions {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	
	def functionImplementations(ExecutionFlow it) '''
		// implementations of all internal functions
		
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toImplementation»
		«reactMethods.toDefinitions»
		
	'''
	
	 def toDefinitions(List<Method> methods) '''
	 	«FOR m : methods»
	 		«m.implementation»
	 		
	 	«ENDFOR»
	 '''
	 
	 def implementation(Method it) '''
	 	«typeSpecifier.targetLanguageName» «execution_flow.module»::«shortName»(«FOR p : parameters SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
	 		«body.code»
	 	}
	 '''
	 
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		«BOOL_TYPE» «execution_flow.module»::«shortName»()
		{
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		void «execution_flow.module»::«shortName»()
		{
			«code»
		}
		
	'''
	
	def clearInEventsFunction(ExecutionFlow it) '''
		void «module»::«clearInEventsFctID»()
		{
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
			«IF hasInternalScope»
				«FOR event : internalScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
				«event.access» = false; 
				«ENDFOR»
			«ENDIF»
		}
	'''
	
	def clearOutEventsFunction(ExecutionFlow it) '''
		void «module»::«clearOutEventsFctID»()
		{
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
		}
	'''
	
	def prototypes(ExecutionFlow it) '''
		// prototypes of all internal functions
		
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toPrototypes»
		«reactMethods.toDeclarations»
		void «clearInEventsFctID»();
		void «clearOutEventsFctID»();
		
	'''
	
	def toDeclarations(List<Method> steps) '''
		«FOR s : steps»
			«s.toPrototype»
		«ENDFOR»
	'''
	
	def toPrototype(Method it) '''
		«typeSpecifier.targetLanguageName» «shortName»(«FOR p : parameters SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR»);
	'''
	
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''

	def dispatch functionPrototype(Check it) '''
		«BOOL_TYPE» «shortName»();
	'''

	def dispatch functionPrototype(Step it) '''
		void «shortName»();
	'''
}