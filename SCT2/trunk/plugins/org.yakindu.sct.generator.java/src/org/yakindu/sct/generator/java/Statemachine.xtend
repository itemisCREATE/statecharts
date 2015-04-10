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
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class Statemachine {
	
	@Inject extension Naming
	@Inject extension GenmodelEntries
	@Inject extension Navigation
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension ITypeSystem
	@Inject extension FlowCode
	
	@Inject Beautifier beautifier
	
	def generateStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.statemachineClassName.java
		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}
	
	def private content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«flow.createImports(entry)»
		
		public class «flow.statemachineClassName» implements «flow.statemachineInterfaceName» {
			«flow.createFieldDeclarations(entry)»
		
				
			«flow.createConstructor»
			
			«flow.initFunction»
			
			«flow.enterFunction»
			
			«flow.exitFunction»
			
			«flow.clearInEventsFunction»
			
			«flow.clearOutEventsFunction»
			
			«flow.activeFunction»
			
			«flow.timingFunctions»
			
			«flow.interfaceAccessors»
			
			«flow.internalScopeFunctions»
			
			«flow.defaultInterfaceFunctions(entry)»
			
			«flow.functionImplementations»
			
			«flow.runCycleFunction»
		}
	'''
	
	def private createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
		import java.util.LinkedList;
		import java.util.List;
		«ENDIF»
		«IF flow.timed»
			import «entry.getBasePackageName()».ITimer;
		«ENDIF»
	'''
	
	def private createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		«FOR event : flow.internalScopeEvents»
		private boolean «event.symbol»;
		
		«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			private «event.type.targetLanguageName» «event.valueIdentifier»;
		«ENDIF»
		«ENDFOR»
		«IF flow.timed»
			private final boolean[] timeEvents = new boolean[«flow.timeEvents.size»];
		«ENDIF»
	
		«FOR scope : flow.interfaceScopes»
			«scope.toImplementation(entry)»
			
			private «scope.interfaceImplName» «scope.interfaceName.asEscapedIdentifier»;
		«ENDFOR»
	
		public enum State {
			«FOR state : flow.states»
				«state.stateName.asEscapedIdentifier»,
			«ENDFOR»
			«getNullStateName()»
		};
		
		«FOR variable : flow.internalScopeVariables»
			«IF !variable.const»
				«variable.writeableFieldDeclaration»
			«ENDIF»
		«ENDFOR»
		
		«IF flow.hasHistory»
		private State[] historyVector = new State[«flow.historyVector.size»];
		«ENDIF»
		private final State[] stateVector = new State[«flow.stateVector.size»];
		
		private int nextStateIndex;
		
		«IF flow.timed»
		private ITimer timer;
		«ENDIF»
		
		«FOR internal : flow.internalScopes»
		«IF internal.hasOperations()»
			private «internal.getInternalOperationCallbackName()» operationCallback;
		«ENDIF»
		«ENDFOR»
	'''
	
	def private writeableFieldDeclaration(VariableDefinition variable){
		'''private «variable.type.targetLanguageName» «variable.symbol»;'''
	}
	
	
	
	def private createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceName.asEscapedIdentifier» = new «scope.getInterfaceImplName()»();
			«ENDFOR»
		}
	'''
	
	def private initFunction(ExecutionFlow flow) '''
		public void init() {
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
	
	def private clearInEventsFunction(ExecutionFlow flow) '''
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
	
	def private clearOutEventsFunction(ExecutionFlow flow) '''
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
	
	def private isActiveFunction(ExecutionFlow flow) '''
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
	
	def private timingFunctions(ExecutionFlow flow) '''
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
	
	def private interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.toFirstLower()»;
			}
		«ENDFOR»
	'''
	
	def private toImplementation(InterfaceScope scope, GeneratorEntry entry) '''
		private final class «scope.getInterfaceImplName» implements «scope.getInterfaceName» {
		
		«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			private List<«scope.getInterfaceListenerName»> listeners = new LinkedList<«scope.getInterfaceListenerName»>();
			
			public List<«scope.getInterfaceListenerName»> getListeners() {
				return listeners;
			}
		«ENDIF»
		
		«IF scope.hasOperations»
			private «scope.getInterfaceOperationCallbackName()» operationCallback;
			
			public void set«scope.getInterfaceOperationCallbackName»(
					«scope.getInterfaceOperationCallbackName» operationCallback) {
				this.operationCallback = operationCallback;
			}
		«ENDIF»
		
		«FOR event : scope.eventDefinitions»
			
			private boolean «event.symbol»;
			
			«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
				private «event.type.targetLanguageName» «event.valueIdentifier»;
			«ENDIF»
			
			«IF event.direction == Direction::IN»
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						«event.symbol» = true;
						«event.valueIdentifier» = value;
					}
					
					private «event.type.targetLanguageName» get«event.name.asName»Value() {
						«event.getIllegalAccessValidation()»
						return «event.valueIdentifier»;
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						«event.symbol» = true;
					}
					
				«ENDIF»
			«ENDIF»
			
			«IF event.direction == Direction::OUT»
				
				public boolean isRaised«event.name.asName»() {
					return «event.symbol»;
				}
				
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					private void raise«event.name.asName»(«event.type.targetLanguageName» value) {
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
					private void raise«event.name.asName»() {
						«event.symbol» = true;
						«IF entry.createInterfaceObserver»
							for («scope.interfaceListenerName» listener : listeners) {
								listener.on«event.name.asEscapedName»Raised();
							}
						«ENDIF»
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		«FOR variable : scope.variableDefinitions»
				
				«IF !variable.const»
					«variable.writeableFieldDeclaration»
				«ENDIF»
				public «variable.type.targetLanguageName» «variable.getter» {
					return «variable.symbol»;
				}
				
				«IF !variable.readonly && !variable.const»
					public void «variable.setter»(«variable.type.targetLanguageName» value) {
						this.«variable.symbol» = value;
					}
				«ENDIF»
		«ENDFOR»
		
		«IF scope.hasEvents»
			public void clearEvents() {
			«FOR event : scope.eventDefinitions»
				«IF event.direction != Direction::OUT»
				«event.symbol» = false;
				«ENDIF»
			«ENDFOR»
			}
			
		«ENDIF»
		
		«IF scope.hasOutgoingEvents()»
			public void clearOutEvents() {
			«FOR event : scope.eventDefinitions»
				«IF event.direction == Direction::OUT»
					«event.symbol» = false;
				«ENDIF»
			«ENDFOR»
			}
		«ENDIF»
		}
	'''
	
	def private getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value acces. Event «name.asEscapedName» is not raised!");
	'''
	
	def private internalScopeFunctions (ExecutionFlow flow) '''
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
	
	def private defaultInterfaceFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
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
	
	def private runCycleFunction(ExecutionFlow flow) '''
		public void runCycle() {
			
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
	
	def private enterFunction(ExecutionFlow it) '''
		public void enter() {
			«IF timed»
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			«ENDIF»
			«enterSequences.defaultSequence.code»
		}
	'''
	
	def private exitFunction(ExecutionFlow it) '''
		public void exit(){
			«exitSequence.code»
		}
	'''
	
	def private functionImplementations(ExecutionFlow it) '''
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