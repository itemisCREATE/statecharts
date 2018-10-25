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
import com.google.inject.Singleton
import java.util.List
import org.yakindu.sct.generator.c.ConstantInitializationResolver
import org.yakindu.sct.generator.c.FlowCode
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.ExecutionState
import static org.yakindu.sct.generator.c.CGeneratorConstants.TRUE;
import static org.yakindu.sct.generator.c.CGeneratorConstants.FALSE;
import static org.yakindu.sct.generator.c.CGeneratorConstants.BOOL_TYPE;

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class InternalFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension FlowCode
	@Inject protected extension ConstantInitializationResolver
	@Inject protected extension StateVectorExtensions
	@Inject protected extension ExpressionsChecker
	
	def clearInEventsFunction(ExecutionFlow it) '''
		static void «clearInEventsFctID»(«scHandleDecl»)
		{
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = «FALSE»;
				«ENDFOR»
			«ENDFOR»
			«IF hasInternalScope»
				«FOR event : internalScope.events»
				«event.access» = «FALSE»;
				«ENDFOR»
			«ENDIF»
			«IF timed»
				«FOR event : timeEventScope.events»
				«event.access» = «FALSE»;
				«ENDFOR»
			«ENDIF»
		}
	'''
	
	def clearOutEventsFunction(ExecutionFlow it) '''
		static void «clearOutEventsFctID»(«scHandleDecl»)
		{
			«FOR scope : it.scopes»
				«FOR event : scope.outgoingEvents»
				«event.access» = «FALSE»;
				«ENDFOR»
			«ENDFOR»
		}
	'''	
	
	def functionPrototypes(ExecutionFlow it) '''
		/* prototypes of all internal functions */
		«checkFunctions.toPrototypes»
		«effectFunctions.toPrototypes»
		«entryActionFunctions.toPrototypes»
		«exitActionFunctions.toPrototypes»
		«enterSequenceFunctions.toPrototypes»
		«exitSequenceFunctions.toPrototypes»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toPrototypes»
		«reactMethods.toDeclarations»
		static void «clearInEventsFctID»(«scHandleDecl»);
		static void «clearOutEventsFctID»(«scHandleDecl»);
	'''
	
	
	def toDeclarations(List<Method> steps) '''
		«FOR s : steps»
			«s.toPrototype»
		«ENDFOR»
	'''
	
	
	def toPrototype(Method it) '''
		static «typeSpecifier.targetLanguageName» «shortName»(«scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR»);
	'''
	
	
	def toPrototypes(List<Step> steps) '''
		«FOR s : steps»
			«s.functionPrototype»
		«ENDFOR»
	'''
	
	def dispatch functionPrototype(Check it) '''
		static «BOOL_TYPE» «shortName»(const «scHandleDecl»);
	'''
	
	def dispatch functionPrototype(Step it) '''
		static void «shortName»(«scHandleDecl»);
	'''	
	
	def functionImplementations(ExecutionFlow it) '''
		/* implementations of all internal functions */
		
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
	 	static «typeSpecifier.targetLanguageName» «shortName»(«scHandleDecl»«FOR p : parameters BEFORE ', ' SEPARATOR ', '»«IF p.varArgs»...«ELSE»const «p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
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
		static «BOOL_TYPE» «shortName»(const «scHandleDecl»)
		{
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		static void «shortName»(«scHandleDecl»)
		{
			«code»
		}
		
	'''
}