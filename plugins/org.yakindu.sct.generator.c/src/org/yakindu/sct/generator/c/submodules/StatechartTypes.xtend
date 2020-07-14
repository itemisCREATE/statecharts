/**
 * Copyright (c) 2018-2020 committers of YAKINDU and others.
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
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.concepts.ShadowMemberScope
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.c.extensions.EventNaming

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
	@Inject protected extension EventNaming
	
	@Inject protected extension GeneratorEntry entry
	@Inject extension GeneratorPredicate
	@Inject protected extension GenmodelEntries
	
	@Inject protected extension ShadowMemberScope
	
	def forwardDeclarations(ExecutionFlow it) {
		'''
		/*!
		* Forward declaration for the «type» state machine.
		*/
		typedef struct «type» «type»;
		«FOR scope : scopes.filter[s | !s.typeRelevantDeclarations.nullOrEmpty]»
			
			/*!
			* Forward declaration of the data structure for the «scope.type» interface scope.
			*/
			typedef struct «scope.type» «scope.type»;
		«ENDFOR»
		'''
	}
	
	def statemachineStruct(ExecutionFlow it) {
		'''
		/*! 
		 * Type declaration of the data structure for the «type» state machine.
		 * This data structure has to be allocated by the client code. 
		 */
		struct «type»
		{
			«statemachineStructContent»
		};
		'''
	}
	
	def statemachineStructContent(ExecutionFlow it) {
		'''
		«statesEnumType» «STATEVECTOR»[«maxOrthogonalStates»];
		«IF hasHistory»«statesEnumType» «HISTORYVECTOR»[«maxHistoryStates»];«ENDIF»
		«USHORT_TYPE» «STATEVECTOR_POS»; 
		«FOR iScope : scopes.filter[!typeRelevantDeclarations.empty]»
			«iScope.type» «iScope.instance»;
		«ENDFOR»
		«IF entry.tracingGeneric»
		«TRACE_HANDLER_TYPE» *«TRACE_HANDLER»;
		«ENDIF»
		«FOR v : it.features.filter(Property)»
			«v.structMember»
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
			/*! Type declaration of the data structure for the «scope.type» interface scope. */
			struct «scope.type»
			{
				«FOR d : typeRelevantDeclarations»
					«d.scopeTypeDeclMember»
				«ENDFOR»
				«IF scope instanceof InternalScope && scope.isShadowMemberScope»
					«FOR d : shadowEvents»
						«d.scopeShadowEventMember»
					«ENDFOR»
				«ENDIF»
			};
			
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
				Event: true
				VariableDefinition: !it.const
				default: false
			}
		]
	}
	
	def constDeclarations(Scope scope){
		return scope.declarations.filter(typeof(VariableDefinition)).filter[const]
	}
	
	/** TODO complex type should be contained in ExecutionFLow */
	def typeDeclaration(ComplexType type, ExecutionFlow flow) '''
		typedef struct «type.cType» «type.cType»;
	'''
	
	/** TODO complex type should be contained in ExecutionFLow */
	def structDeclaration(ComplexType type, ExecutionFlow flow) '''
		struct «type.cType» {
			«FOR f : type.features»
				«f.structMember»
			«ENDFOR»
		};
		
	'''
	
	def dispatch structMember(Event it) {
		'''
		«IF useOutEventObservables && direction == Direction.OUT»
			«OBSERVABLE_TYPE»«eventType» «eventName»;
		«ENDIF»
		«IF (useOutEventGetters && direction == Direction.OUT) || direction == Direction.IN || direction == Direction.LOCAL»
			«BOOL_TYPE» «eventRaisedFlag»;
			«IF type !== null && type.name != 'void'»«typeSpecifier.targetLanguageName» «eventValueVariable»;«ENDIF»
		«ENDIF»
		'''
	}
	
	def dispatch structMember(TimeEvent it) '''
		«BOOL_TYPE» «timeEventRaisedFlag»;
	'''

	def dispatch structMember(Property it) '''
		«type.cType» «variable»;
	'''
	
	def dispatch structMember(Declaration it) ''''''
}