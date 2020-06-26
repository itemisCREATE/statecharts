/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Set
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GeneratorPredicate
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaExpressionsGenerator
import org.yakindu.sct.generator.java.JavaIncludeProvider
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.OutEventObservables
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope

@Singleton
class EventCode implements org.yakindu.sct.generator.core.submodules.lifecycle.EventCode {
	
	@Inject protected Set<JavaIncludeProvider> includeProviders
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension ITypeSystem
	@Inject protected extension Synchronized
	@Inject protected extension GeneratorPredicate
	@Inject protected extension OutEventObservables
	@Inject protected extension FieldDeclarationGenerator
	@Inject protected extension JavaExpressionsGenerator
	@Inject protected extension EventProcessing
	@Inject protected extension ExpressionBuilder
	
	def generateEventDefinition(Event event, GeneratorEntry entry, InterfaceScope scope) '''
		«event.fieldDeclaration»

		«IF event.direction == Direction::IN»
		
		«event.generateInEventDefinition»
		«ENDIF»
		«IF event.direction == Direction::OUT»
		
		«event.generateOutEventDefinition(entry, scope)»
		«ENDIF»
	'''
	
	def fieldDeclaration(Event event) {
		'''
		private boolean «event.identifier»;
		«IF event.hasValue»
		
		private «event.typeSpecifier.targetLanguageName» «event.valueIdentifier»;
		«ENDIF»
		'''
	}
			
	def generateOutEventDefinition(Event event, GeneratorEntry entry, InterfaceScope scope) '''
		«outEventRaiser(event, entry, scope)»
		«IF useOutEventGetters»
			public boolean isRaised«event.name.asName»() {
				«sync(scope.flow.statemachineClassName + ".this", '''return «event.identifier»;''')»
			}
			
			«IF event.hasValue»
				
				«eventValueGetter(event)»
			«ENDIF»
		«ENDIF»
		«IF useOutEventObservables»
		
		«eventObservableField(event)»
		
		«eventObservableGetter(event)»
		«ENDIF»
	'''

	def generateInEventDefinition(Event event) '''
		«inEventRaiser(event)»
		«IF event.hasValue»
			«eventValueGetter(event)»
		«ENDIF»
	'''
	
	def eventValueGetter(Event it) {
		'''
		«eventValueGetterVisibility» «typeSpecifier.targetLanguageName» get«name.asName»Value() {
			«sync(flow.statemachineClassName + ".this", '''
			«getIllegalAccessValidation»
			return «valueIdentifier»;
			''')»
		}
		'''
	}
	
	def protected eventObservableField(Event event) {
		'''
		private Observable<«event.eventType»> «event.observableName» = new Observable<«event.eventType»>();
		'''
	}
	
	def protected eventObservableGetter(Event event) {
		'''
		public Observable<«event.eventType»> «event.observableGetterName»() {
			return «event.observableName»;
		}
		'''
	}
	
	def protected eventValueGetterVisibility(Event it) {
		switch(event.direction) {
			case IN: {
				"protected"
			}
			case LOCAL: {
				"private"
			}
			case OUT: {
				"public"
			}
			
		}
	}
	
	def internalEventRaiser(Event it) {
		eventRaiser("private", null)
	}
	
	def inEventRaiser(Event it) {
		eventRaiser("public", null)
	}
	
	def outEventRaiser(Event it, GeneratorEntry entry, InterfaceScope scope) {
		if(entry.createInterfaceObserver) {
			eventRaiser("protected", scope.interfaceListenerName)
		} else {
			eventRaiser("protected", null)
		}
	}
	
	def protected eventRaiser(Event it, String visibility, String interfaceListenerName) {
		'''
			«IF hasValue»
				«visibility» void raise«name.asName»(«typeSpecifier.targetLanguageName» value) {
			«ELSE»
				«visibility» void raise«name.asName»() {
			«ENDIF»
				«sync(flow.statemachineClassName + ".this", '''
				«IF hasValue»
					«valueIdentifier» = value;
				«ENDIF»
				«identifier» = true;
				«IF !interfaceListenerName.nullOrEmpty»
					for («interfaceListenerName» listener : listeners) {
						listener.on«event.name.asEscapedName»Raised(«IF hasValue»value«ENDIF»);
					}
				«ENDIF»
				«IF needsObservable»
					«observableName».next(«IF hasValue»value«ELSE»null«ENDIF»);
				«ENDIF»
				''')»
			}
		''' 
	}
	
	def getIllegalAccessValidation(Event it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value access. Event «name.asEscapedName» is not raised!");
	'''
	
	def getNextEvent(ExecutionFlow it) {
		// nothing to do for cycle based statecharts
	}
	
	override eventClearCode(ExecutionFlow flow, Expression event) '''
		«event.code» = false;
	'''
	
	override eventMoveCode(ExecutionFlow flow, Expression source, Expression target) '''
		«target.code» = «source.code»;
		«IF source.event.hasValue»«target._meta(target.event.valueFeature).code» = «source._meta(source.event.valueFeature).code»;«ENDIF»
		«source.code» = false;
	'''
	
	override eventNextCode(ExecutionFlow flow) {
		throw new UnsupportedOperationException("Something went wrong - generating 'eventNext' not supported for cycle based statecharts.")
	}
	
}