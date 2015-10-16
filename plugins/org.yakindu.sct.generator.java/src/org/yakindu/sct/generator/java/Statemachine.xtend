/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
  	Andreas Muelder - Added generation of constants
*/
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.eclipse.xtext.util.Strings.*

class Statemachine {
	
	@Inject protected extension Naming
	@Inject protected extension GenmodelEntries
	@Inject protected extension Navigation
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension ITypeSystem
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	
	@Inject Beautifier beautifier
	
	def generateStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineClassName.java
		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}
	
	def protected content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«flow.createImports(entry)»
		
		public class «flow.statemachineClassName» implements «flow.statemachineInterfaceName» {
			
			«flow.createFieldDeclarations(entry)»
			
			«flow.createConstructor»
			
			«flow.initFunction»
			
			«flow.enterFunction»
			
			«flow.exitFunction»
			
			«flow.activeFunction»
			
			«flow.finalFunction»
			
			«flow.clearInEventsFunction»
			
			«flow.clearOutEventsFunction»
			
			«flow.stateActiveFunction»
			
			«flow.timingFunctions»
			
			«flow.interfaceAccessors»
			
			«flow.internalScopeFunctions»
			
			«flow.defaultInterfaceFunctions(entry)»
			
			«flow.functionImplementations»
			
			«flow.runCycleFunction»
		}
	'''
	
	def protected createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
			import java.util.LinkedList;
			import java.util.List;
		«ENDIF»
		«IF flow.timed»
			import «entry.getBasePackageName()».ITimer;
		«ENDIF»
	'''
	
	def protected createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR scope : flow.interfaceScopes»
			«scope.toImplementation(entry)»
			
			protected «scope.interfaceImplName» «scope.interfaceName.asEscapedIdentifier»;
			
			
		«ENDFOR»
		private boolean initialized=false;

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
		
		«IF flow.timed»
		private ITimer timer;
		
		private final boolean[] timeEvents = new boolean[«flow.timeEvents.size»];
		«ENDIF»
		
		«FOR event : flow.internalScopeEvents»
			private boolean «event.symbol»;
			
			«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
				private «event.type.targetLanguageName» «event.valueIdentifier»;
				
			«ENDIF»
		«ENDFOR»
		
		«FOR variable : flow.internalScopeVariables SEPARATOR newLine AFTER newLine»
			«IF !variable.const»
				«variable.fieldDeclaration»
				
				protected void «variable.setter»(«variable.type.targetLanguageName» value) {
					«variable.symbol» = value;
				}
				
			«ENDIF»
			protected «variable.type.targetLanguageName» «variable.getter» {
				return «variable.symbol»;
			}
			
			«IF variable.needsAssignMethod»
				protected «variable.type.targetLanguageName» «variable.assign»(«variable.type.targetLanguageName» value) {
					return this.«variable.symbol» = value;
				}
			«ENDIF»
		«ENDFOR»
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations()»
				private «internal.getInternalOperationCallbackName()» operationCallback;
			«ENDIF»
		«ENDFOR»
	'''
	//reused by interfaces
	def protected fieldDeclaration(VariableDefinition variable) {
		'''private «variable.type.targetLanguageName» «variable.symbol»;'''
	}
	
	def protected createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceName.asEscapedIdentifier» = new «scope.getInterfaceImplName()»();
			«ENDFOR»
		}
	'''
	
	def protected initFunction(ExecutionFlow flow) '''
		public void init() {
			this.initialized=true;
			«IF flow.timed»
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			«ENDIF»
			for (int i = 0; i < «flow.stateVector.size»; i++) {
				stateVector[i] = State.$NullState$;
			}
			
			«IF flow.hasHistory»
			for (int i = 0; i < «flow.historyVector.size»; i++) {
				historyVector[i] = State.$NullState$;
			}
			«ENDIF»
			clearEvents();
			clearOutEvents();
			
			«flow.initSequence.code»
		}
	'''
	
	def protected clearInEventsFunction(ExecutionFlow flow) '''
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
					«event.symbol» = false;
				«ENDFOR»
			«ENDFOR»
			
			«IF flow.timed»
			for (int i=0; i<timeEvents.length; i++) {
				timeEvents[i] = false;
			}
			«ENDIF»
		}
	'''
	
	def protected clearOutEventsFunction(ExecutionFlow flow) '''
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
	
	def protected isStateActiveFunction(ExecutionFlow flow) '''
		/**
		* Returns true if the given state is currently active otherwise false.
		*/
		public boolean isStateActive(State state){
			switch (state) {
				«FOR s : flow.states»
				case «s.stateName.asEscapedIdentifier» : 
					return «IF s.leaf»stateVector[«s.stateVector.offset»] == State.«s.stateName.asEscapedIdentifier»
					«ELSE»stateVector[«s.stateVector.offset»].ordinal() >= State.«s.stateName.asEscapedIdentifier».ordinal()
						&& stateVector[«s.stateVector.offset»].ordinal() <= State.«s.subStates.last.stateName.asEscapedIdentifier».ordinal()«ENDIF»;
				«ENDFOR»
				default: return false;
			}
		}
	'''
	
	def protected isActiveFunction(ExecutionFlow flow) '''
		/**
		 * @see IStatemachine#isActive()
		 */
		public boolean isActive(){
			
			return 
				«FOR i : 0 ..< flow.stateVector.size SEPARATOR '||'»
				stateVector[«i»] != State.«nullStateName» 
				«ENDFOR»;
		}
	'''

	def protected isFinalFunction(ExecutionFlow flow) {
		val finalStateImpactVector = flow.finalStateImpactVector

		'''
			/** 
			«IF !finalStateImpactVector.isCompletelyCovered»
			 * Always returns 'false' since this state machine can never become final.
			 *
			«ENDIF»
			 * @see IStatemachine#isFinal() 
			 */
			public boolean isFinal(){
		''' +
		
		// only if the impact vector is completely covered by final states the state machine 
		// can become final
		{if (finalStateImpactVector.isCompletelyCovered) {'''
			return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»
				(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '» 
					stateVector[«i»] == «
					IF fs.stateVector.offset == i
						»State.«fs.stateName.asEscapedIdentifier»«
					ELSE
						»State.«nullStateName»«
					ENDIF»«
				ENDFOR»)
			«ENDFOR»;
		'''} else {'''
			return false;
		'''} }
		
		+ '''}'''
	}
	
	
	def protected timingFunctions(ExecutionFlow flow) '''
		«IF flow.timed»
			/**
			* Set the {@link ITimer} for the state machine. It must be set
			* externally on a timed state machine before a run cycle can be correct
			* executed.
			* 
			* @param timer
			*/
			public void setTimer(ITimer timer) {
				this.timer = timer;
			}
			
			/**
			* Returns the currently used timer.
			* 
			* @return {@link ITimer}
			*/
			public ITimer getTimer() {
				return timer;
			}
			
			public void timeElapsed(int eventID) {
				timeEvents[eventID] = true;
			}
		«ENDIF»
	'''
	
	def protected interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.toFirstLower()»;
			}
		«ENDFOR»
	'''
	
	def protected toImplementation(InterfaceScope scope, GeneratorEntry entry) '''
		protected class «scope.getInterfaceImplName» implements «scope.getInterfaceName» {
		
		«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			«scope.generateListeners»
		«ENDIF»
		
		«IF scope.hasOperations»
			«scope.generateOperationCallback»
		«ENDIF»
		
		«FOR event : scope.eventDefinitions BEFORE newLine SEPARATOR newLine»
			«generateEventDefinition(event, entry, scope)»
		«ENDFOR»
		
		«FOR variable : scope.variableDefinitions BEFORE newLine SEPARATOR newLine»
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
	
	protected def generateClearOutEvents(InterfaceScope scope) '''
		protected void clearOutEvents() {
		«FOR event : scope.eventDefinitions»
			«IF event.direction == Direction::OUT»
				«event.symbol» = false;
			«ENDIF»
		«ENDFOR»
		}
	'''
	
	
	protected def generateClearEvents(InterfaceScope scope) '''
		protected void clearEvents() {
		«FOR event : scope.eventDefinitions»
			«IF event.direction != Direction::OUT»
			«event.symbol» = false;
			«ENDIF»
		«ENDFOR»
		}
	'''
	
	protected def generateVariableDefinition(VariableDefinition variable) '''
		«IF !variable.const»
			«variable.fieldDeclaration»
			
		«ENDIF»
		public «variable.type.targetLanguageName» «variable.getter» {
			return «variable.symbol»;
		}
		
		«IF !variable.const»
			«IF variable.readonly»protected«ELSE»public«ENDIF» void «variable.setter»(«variable.type.targetLanguageName» value) {
				this.«variable.symbol» = value;
			}
			
		«ENDIF»
		
		«IF variable.needsAssignMethod»
			protected «variable.type.targetLanguageName» «variable.assign»(«variable.type.targetLanguageName» value) {
				return this.«variable.symbol» = value;
			}
		«ENDIF»
	'''
	
	protected def generateEventDefinition(EventDefinition event, GeneratorEntry entry, InterfaceScope scope) '''
		private boolean «event.symbol»;
		
		«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			private «event.type.targetLanguageName» «event.valueIdentifier»;
		«ENDIF»
		
		«IF event.direction == Direction::IN»
			«event.generateInEventDefinition»
		«ENDIF»
		
		«IF event.direction == Direction::OUT»
			«event.generateOutEventDefinition(entry, scope)»
		«ENDIF»
	'''
			
	protected def generateOutEventDefinition(EventDefinition event, GeneratorEntry entry, InterfaceScope scope) '''
		
		public boolean isRaised«event.name.asName»() {
			return «event.symbol»;
		}
		
		«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			protected void raise«event.name.asName»(«event.type.targetLanguageName» value) {
				«event.symbol» = true;
				«event.valueIdentifier» = value;
				«IF entry.createInterfaceObserver»
				for («scope.interfaceListenerName» listener : listeners) {
					listener.on«event.name.asEscapedName»Raised(value);
				}
				«ENDIF»
			}
			
			public «event.type.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}
		«ELSE»
			protected void raise«event.name.asName»() {
				«event.symbol» = true;
				«IF entry.createInterfaceObserver»
					for («scope.interfaceListenerName» listener : listeners) {
						listener.on«event.name.asEscapedName»Raised();
					}
				«ENDIF»
			}
		«ENDIF»
	'''

	protected def generateInEventDefinition(EventDefinition event) '''
		«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
				«event.symbol» = true;
				«event.valueIdentifier» = value;
			}
			
			protected «event.type.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}
			
		«ELSE»
			public void raise«event.name.asName»() {
				«event.symbol» = true;
			}
			
		«ENDIF»
	'''
	
	protected def generateOperationCallback(InterfaceScope scope) '''
		private «scope.getInterfaceOperationCallbackName()» operationCallback;
		
		public void set«scope.getInterfaceOperationCallbackName»(
				«scope.getInterfaceOperationCallbackName» operationCallback) {
			this.operationCallback = operationCallback;
		}
	'''
	
	
	protected def generateListeners(InterfaceScope scope) '''
		private List<«scope.getInterfaceListenerName»> listeners = new LinkedList<«scope.getInterfaceListenerName»>();
		
		public List<«scope.getInterfaceListenerName»> getListeners() {
			return listeners;
		}
	'''

	
	def protected getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value acces. Event «name.asEscapedName» is not raised!");
	'''
	
	def protected internalScopeFunctions (ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»
			«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
				private void raise«event.name.asEscapedName»(«event.type.targetLanguageName» value) {
					«event.valueIdentifier» = value;
					«event.symbol» = true;
				}
				
				private «event.type.targetLanguageName» get«event.name.asEscapedName»Value() {
					«event.getIllegalAccessValidation()»
					return «event.valueIdentifier»;
				}
			«ELSE»
			
				private void raise«event.name.asEscapedName»() {
					«event.symbol» = true;
				}
				
			«ENDIF»
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
	
	def protected defaultInterfaceFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.defaultScope != null»
			«var InterfaceScope scope = flow.defaultScope»
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::IN»
					«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»(value);
					}
					«ELSE»
					public void raise«event.name.asName»() {
						«scope.interfaceName.asEscapedIdentifier».raise«event.name.asName»();
					}
					«ENDIF»
				«ENDIF»
				«IF event.direction ==  Direction::OUT»
					public boolean isRaised«event.name.asName»() {
						return «scope.interfaceName.asEscapedIdentifier».isRaised«event.name.asName»();
					}
					«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
						public «event.type.targetLanguageName» get«event.name.asName»Value() {
							return «scope.interfaceName.asEscapedIdentifier».get«event.name.asName»Value();
						}
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			
			«FOR variable : scope.variableDefinitions»
					public «variable.type.targetLanguageName» «variable.getter()» {
						return «scope.interfaceName.asEscapedIdentifier».«variable.getter()»;
					}
					
					«IF !variable.const && !variable.readonly»
						public void «variable.setter»(«variable.type.targetLanguageName» value) {
						«scope.interfaceName.asEscapedIdentifier».«variable.setter»(value);
						}	
					«ENDIF»
			«ENDFOR»
		«ENDIF»
		
	'''
	
	def protected runCycleFunction(ExecutionFlow flow) '''
		public void runCycle() {
			if(!initialized)
				throw new IllegalStateException("The statemachine needs to be initialized first by calling the init() function.");
			
			clearOutEvents();
			
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				
				switch (stateVector[nextStateIndex]) {
				«FOR state : flow.states»
					«IF state.reactSequence!=null»
						case «state.stateName.asEscapedIdentifier»:
							«state.reactSequence.functionName»();
							break;
					«ENDIF»
				«ENDFOR»
				default:
					// «getNullStateName()»
				}
			}
			
			clearEvents();
		}
	'''
	
	def protected enterFunction(ExecutionFlow it) '''
		public void enter() {
			if(!initialized)
				throw new IllegalStateException("The statemachine needs to be initialized first by calling the init() function.");
			
			«IF timed»
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			«ENDIF»
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def protected exitFunction(ExecutionFlow it) '''
		public void exit(){
			«exitSequence.code»
		}
	'''
	
	def protected functionImplementations(ExecutionFlow it) '''
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.toImplementation»
	'''
	
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		private boolean «functionName»() {
			return «code»;
		}
		
	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		private void «functionName»() {
			«code»
		}
		
	'''
}