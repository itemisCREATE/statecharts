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
import java.util.List
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

import static org.eclipse.xtext.util.Strings.*

@Singleton
class InternalFunctionsGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension FlowCode
	@Inject protected extension GenmodelEntries
	
	@Inject protected extension FieldDeclarationGenerator
	@Inject protected extension InterfaceFunctionsGenerator
	
	def clearInEvents(ExecutionFlow flow) '''
		/**
		* This method resets the incoming events (time events included).
		*/
		protected void clearEvents() {
			«FOR scope : flow.interfaceScopes»
				«IF scope.hasEvents»
					«scope.interfaceName.asEscapedIdentifier».clearEvents();
				«ENDIF»
			«ENDFOR»
			«FOR scope : flow.internalScopes»
				«FOR event : scope.eventDefinitions»
				«event.identifier» = false;
				«ENDFOR»
			«ENDFOR»
			«IF flow.timed»
			for (int i=0; i<timeEvents.length; i++) {
				timeEvents[i] = false;
			}
			«ENDIF»
		}

	'''
	def clearOutEvents(ExecutionFlow flow) '''
		/**
		* This method resets the outgoing events.
		*/
		protected void clearOutEvents() {
			«FOR scope : flow.interfaceScopes»
				«IF scope.hasOutgoingEvents»
					«scope.interfaceName.asEscapedIdentifier».clearOutEvents();
				«ENDIF»
			«ENDFOR»
		}

	'''
	
	def createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR scope : flow.interfaceScopes»
			«scope.toImplementation(entry)»
			protected «scope.interfaceImplName» «scope.interfaceName.asEscapedIdentifier»;
			
		«ENDFOR»
		private boolean initialized = false;

		public enum State {
			«FOR state : flow.states»
				«state.stateName.asEscapedIdentifier»,
			«ENDFOR»
			«getNullStateName()»
		};

		«IF flow.hasHistory»
			private State[] historyVector = new State[«flow.historyVector.size»];
		«ENDIF»
		private final State[] stateVector = new State[«flow.stateVector.size»];
		
		private int nextStateIndex;
		
		«IF tracingUsed(entry)»
			private List <«traceInterface»<State>> «traceInstances» = new LinkedList <«traceInterface»<State>>();
			
		«ENDIF»
		
		«IF flow.timed»
			private ITimer timer;
			
			private final boolean[] timeEvents = new boolean[«flow.timeEvents.size»];
		«ENDIF»
		«flow.internalEventFields»		
		«FOR variable : flow.internalScopeVariables SEPARATOR newLine AFTER newLine»
			«IF !variable.const»
				«variable.fieldDeclaration»
				protected void «variable.setter»(«variable.typeSpecifier.targetLanguageName» value) {
					«variable.identifier» = value;
				}

			«ENDIF»
			protected «variable.typeSpecifier.targetLanguageName» «variable.getter» {
				return «variable.identifier»;
			}
			«IF variable.needsAssignMethod»
				protected «variable.typeSpecifier.targetLanguageName» «variable.assign»(«variable.typeSpecifier.targetLanguageName» value) {
					return this.«variable.identifier» = value;
				}

			«ENDIF»
		«ENDFOR»
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations()»
				private «internal.getInternalOperationCallbackName()» operationCallback;
			«ENDIF»
		«ENDFOR»
	'''
	
	def internalEventFields(ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»

			«event.internalEventField»	
			«event.internalEventValueField»
		«ENDFOR»
	'''
	
	def internalEventField(EventDefinition it) '''
			private boolean «event.identifier»;
	'''
	
	def internalEventValueField(EventDefinition it) '''
		«IF hasValue»
			private «typeSpecifier.targetLanguageName» «valueIdentifier»;
		«ENDIF»
	'''
	
	def functionImplementations(ExecutionFlow it) '''
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
	 	private «typeSpecifier.targetLanguageName» «shortName»(«FOR p : parameters SEPARATOR ', '»«IF p.varArgs»...«ELSE»«p.typeSpecifier.targetLanguageName» «p.name.asIdentifier»«ENDIF»«ENDFOR») {
	 		«bodySequence.code»
	 	}
	 '''
	
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		private boolean «functionName»() {
			return «code.toString.trim»;
		}

	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		private void «functionName»() {
			«code.toString.trim»
		}

	'''
}