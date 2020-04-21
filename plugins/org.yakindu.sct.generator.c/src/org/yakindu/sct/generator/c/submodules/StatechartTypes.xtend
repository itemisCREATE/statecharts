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
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class StatechartTypes {
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	@Inject protected extension StatechartAnnotations
	@Inject extension ShadowEventExtensions
	
	@Inject protected extension GeneratorEntry entry
	@Inject protected extension GenmodelEntries
	
	def statemachineStruct(ExecutionFlow it) {
		'''
		/*! 
		 * Type definition of the data structure for the «type» state machine.
		 * This data structure has to be allocated by the client code. 
		 */
		typedef struct
		{
			«statemachineStructContent»
		} «type»;
		'''
	}
	
	def statemachineStructContent(ExecutionFlow it) {
		'''
		«statesEnumType» «STATEVECTOR»[«maxOrthogonalStates»];
		«IF hasHistory»«statesEnumType» «HISTORYVECTOR»[«maxHistoryStates»];«ENDIF»
		«USHORT_TYPE» «STATEVECTOR_POS»; 
		«IF statechart.isSuperStep»
		«BOOL_TYPE» «STATEVECTOR_CHANGED»;
		«ENDIF»
		«FOR iScope : scopes.filter[!typeRelevantDeclarations.empty]»
			«iScope.type» «iScope.instance»;
		«ENDFOR»
		«IF entry.tracingGeneric»
		«TRACE_HANDLER_TYPE» *«TRACE_HANDLER»;
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
	
	def featuresEnumDecl(ExecutionFlow it) {
		if ( entry.tracingGeneric ) {
			val featureEnumeratorNames = allEventAndVariables.map[ f | '''«featureNamingPrefix»«f.name»'''].toList
			featureEnumeratorNames.add(0, '''«it.name.toLowerCase»_no_feature = «NO_EVENT»''')
			
			'''
				/*! Enumeration of all features of the statechart */ 
				typedef enum
				{
					«FOR feature : featureEnumeratorNames SEPARATOR ","»
						«feature»
					«ENDFOR»
				} «featuresEnumType»;
			'''	
		}
		else ''''''
	}
	
	def scopeTypeDecl(Scope scope) '''
		«val typeRelevantDeclarations = scope.typeRelevantDeclarations.toList»
		«val shadowEvents = scope.flow.shadowEvents»
		«IF !typeRelevantDeclarations.empty»
			/*! Type definition of the data structure for the «scope.type» interface scope. */
			typedef struct
			{
				«FOR d : typeRelevantDeclarations»
					«d.scopeTypeDeclMember»
				«ENDFOR»
				«IF scope instanceof InternalScope && scope.flow.statechart.isEventDriven»
					«FOR d : shadowEvents»
						«d.scopeShadowEventMember»
					«ENDFOR»
				«ENDIF»
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
	
	def typeRelevantDeclarations(Scope scope){
		return scope.declarations.filter[
			switch it {
				EventDefinition: true
				TimeEvent: true
				VariableDefinition: !it.const
				default: false
			}
		]
	}
	
	def constDeclarations(Scope scope){
		return scope.declarations.filter(typeof(VariableDefinition)).filter[const]
	}
}