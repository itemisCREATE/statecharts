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
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

@Singleton
class InterfaceFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension GenmodelEntries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	
	@Inject protected extension JavaCommons
	@Inject protected extension EventCode
	
	def toImplementation(InterfaceScope scope, GeneratorEntry entry) '''
		protected class «scope.getInterfaceImplName» implements «scope.getInterfaceName» {

			«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			«scope.generateListenerSupport»
			«ENDIF»
			«IF scope.hasOperations»
			«scope.generateOperationCallback»
			«ENDIF»
			«FOR event : scope.eventDefinitions»
			«generateEventDefinition(event, entry, scope)»
			«ENDFOR»
			«FOR variable : scope.variableDefinitions»
			«generateVariableDefinition(variable)»
			«ENDFOR»
			«IF scope.hasEvents»
			«scope.generateClearEvents»
			«ENDIF»
			«IF scope.hasOutgoingEvents()»
			«generateClearOutEvents(scope)»
			«ENDIF»
		}

		'''
		
	protected def generateOperationCallback(InterfaceScope scope) '''
		private «scope.getInterfaceOperationCallbackName()» operationCallback;
		
		public void set«scope.getInterfaceOperationCallbackName»(
				«scope.getInterfaceOperationCallbackName» operationCallback) {
			this.operationCallback = operationCallback;
		}
	'''
	
	
	protected def generateListenerSupport(InterfaceScope scope) '''
		private List<«scope.getInterfaceListenerName»> listeners = new LinkedList<«scope.getInterfaceListenerName»>();
		
		public List<«scope.getInterfaceListenerName»> getListeners() {
			return listeners;
		}
	'''
	
	protected def generateVariableDefinition(VariableDefinition variable) '''
			«IF !variable.const»
				«variable.fieldDeclaration»
			«ENDIF»
			public «variable.typeSpecifier.targetLanguageName» «variable.getter» {
				return «variable.identifier»;
			}

			«IF !variable.const»
			«IF variable.readonly»protected«ELSE»public«ENDIF» void «variable.setter»(«variable.typeSpecifier.targetLanguageName» value) {
				this.«variable.identifier» = value;
			}

			«ENDIF»
			«IF variable.needsAssignMethod»
			protected «variable.typeSpecifier.targetLanguageName» «variable.assign»(«variable.typeSpecifier.targetLanguageName» value) {
				return this.«variable.identifier» = value;
			}

			«ENDIF»
		'''
	
	def internalEventRaiser(EventDefinition it) '''
		private void raise«name.asEscapedName»(«IF hasValue»«typeSpecifier.targetLanguageName» value«ENDIF») {
			«IF hasValue»«valueIdentifier» = value;«ENDIF»
			«identifier» = true;
		}
	'''

	def internalEventValueAccess(EventDefinition it) '''
		«IF hasValue»
			private «typeSpecifier.targetLanguageName» get«name.asEscapedName»Value() {
				«getIllegalAccessValidation()»
				return «valueIdentifier»;
			}
		«ENDIF»
	'''
	
	def internalScopeFunctions (ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»
			«event.internalEventRaiser»

			«event.internalEventValueAccess»

		«ENDFOR»
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations»
				public void set«internal.internalOperationCallbackName»(
						«internal.internalOperationCallbackName» operationCallback) {
					this.operationCallback = operationCallback;
				}

			«ENDIF»
		«ENDFOR»
	'''
	
	protected def generateClearOutEvents(InterfaceScope scope) '''
		protected void clearOutEvents() {

		«FOR event : scope.eventDefinitions»
			«IF event.direction == Direction::OUT»
				«event.identifier» = false;
			«ENDIF»
		«ENDFOR»
		}

	'''
	
	
	protected def generateClearEvents(InterfaceScope scope) '''
		protected void clearEvents() {
			«FOR event : scope.eventDefinitions»
				«IF event.direction != Direction::OUT»
				«event.identifier» = false;
				«ENDIF»
			«ENDFOR»
		}
	'''
}