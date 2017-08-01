/**
 *   Copyright (c) 2015 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Mühlbrandt - Initial contribution and API
 */

package org.yakindu.sct.generator.java.wrappers

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.features.CycleBasedWrapperFeature
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope

import static org.eclipse.xtext.util.Strings.*
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.Navigation

/**
 * Generates the cycle bases synchronized wrapper for the state machine.
 */
class CycleBasedSynchronizedWrapper {

	@Inject protected extension GenmodelEntries
	@Inject protected extension CycleBasedWrapperFeature

	@Inject protected extension JavaNamingService
	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ITypeSystem
	@Inject protected extension ICodegenTypeSystemAccess

	def generateCycleWrapper(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {

		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.cycleWrapperClassName(entry).java
		var content = content(flow, entry)
		fsa.generateFile(filename, content)
	}

	def protected content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«flow.createImports(entry)»
		
		/**
		 * Runnable wrapper of «flow.statemachineClassName». This wrapper provides a thread-safe
		 * instance of the state machine.
		 * 
		 * Please report bugs and issues...
		 */
		
		public class «flow.cycleWrapperClassName(entry)» implements «flow.statemachineInterfaceName» {
			
			«flow.createFieldDeclarations(entry)»
			
			public «flow.cycleWrapperClassName(entry)»() {
				«FOR scope : flow.interfaceScopes»
					«scope.interfaceName.asEscapedIdentifier» = new «scope.wrapperInterfaceName(entry)»();
				«ENDFOR»
			}
			
			«flow.interfaceAccessors»
			«flow.timingFunctions(entry)»
			
			/**
			 * init() will be delegated thread-safely to the wrapped state machine.
			 */
			public void init() {
				synchronized(statemachine) {
					statemachine.init();
				}
			}
			
			/**
			 * enter() will be delegated thread-safely to the wrapped state machine.
			 */
			public void enter() {
				synchronized(statemachine) {
					statemachine.enter();
				}
			}
			
			/**
			 * exit() will be delegated thread-safely to the wrapped state machine.
			 */
			public void exit() {
				synchronized(statemachine) {
					statemachine.exit();
				}
			}
			
			/**
			 * isActive() will be delegated thread-safely to the wrapped state machine.
			 */
			public boolean isActive() {
				synchronized(statemachine) {
					return statemachine.isActive();
				}
			}
			
			/**
			 * isFinal() will be delegated thread-safely to the wrapped state machine.
			 */
			public boolean isFinal() {
				synchronized(statemachine) {
					return statemachine.isFinal();
				}
			}
			
			/**
			 * isStateActive() will be delegated thread-safely to the wrapped state machine.
			 */
			public boolean isStateActive(State state) {
				synchronized(statemachine) {
					return statemachine.isStateActive(state);
				}
			}
			
			/**
			 * runCycle() will be delegated thread-safely to the wrapped state machine.
			 */ 
			@Override
			public void runCycle() {
				synchronized (statemachine) {
					statemachine.runCycle();
				}
			}
		}
	'''

	def protected createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
			import java.util.List;
			
		«ENDIF»
		«IF flow.timed»
			import «entry.getBasePackageName()».ITimer;
			import «entry.getBasePackageName()».ITimerCallback;
		«ENDIF»
		import «flow.getImplementationPackageName(entry)».«flow.statemachineClassName».State;
	'''

	def protected createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		/**
		 * The core state machine is simply wrapped and the event processing will be
		 * delegated to that state machine instance. This instance will be created
		 * implicitly.
		 */
		protected «flow.statemachineClassName» statemachine = new «flow.statemachineClassName»();
		
		«FOR scope : flow.interfaceScopes SEPARATOR newLine»
			/**
			 * Interface object for «scope.interfaceName»
			 */		
			protected class «scope.wrapperInterfaceName(entry)» implements «scope.interfaceName» {
				«scope.toImplementation(entry)»
			};
			
			protected «scope.interfaceName» «scope.interfaceName.asEscapedIdentifier»;
		«ENDFOR»
	'''

	def protected toImplementation(InterfaceScope scope, GeneratorEntry entry) '''
		
		«IF entry.createInterfaceObserver && scope.hasOutgoingEvents»
			«scope.generateListeners»
		«ENDIF»
		«IF scope.hasOperations»
			«scope.generateOperationCallback»
		«ENDIF»
		«FOR event : scope.eventDefinitions»
			«IF event.direction == Direction::IN»
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public void raise«event.name.asName»(final «event.typeSpecifier.targetLanguageName» value) {
						
						synchronized (statemachine) {
							statemachine.get«scope.interfaceName»().raise«event.name.asName»(value);
							statemachine.runCycle();
						}
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						
						synchronized (statemachine) {
							statemachine.get«scope.interfaceName»().raise«event.name.asName»();
							statemachine.runCycle();
						}
					}
					
				«ENDIF»
			«ENDIF»
			«IF event.direction == Direction::OUT»
				public boolean isRaised«event.name.asName»() {
					synchronized(statemachine) {
						return statemachine.get«scope.interfaceName»().isRaised«event.name.asName»();
					}
				}
				
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public «event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
						synchronized(statemachine) {
							return statemachine.get«scope.interfaceName»().get«event.name.asName»Value();
						}
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		«FOR variable : scope.variableDefinitions»
			public «variable.typeSpecifier.targetLanguageName» «variable.getter» {
				synchronized(statemachine) {
					return statemachine.get«scope.interfaceName»().«variable.getter»;
				}
			}
			
			«IF !variable.readonly && !variable.const»
				public void «variable.setter»(final «variable.typeSpecifier.targetLanguageName» value) {
					synchronized(statemachine) {
						statemachine.get«scope.interfaceName»().«variable.setter»(value);
					}
				}
				
			«ENDIF»
		«ENDFOR»
	'''
	
	protected def generateListeners(InterfaceScope scope) '''
		public List<«scope.getInterfaceListenerName»> getListeners() {
			synchronized(statemachine) {
				return statemachine.get«scope.interfaceName»().getListeners();
			}
		}
		
	'''
	
	protected def generateOperationCallback(InterfaceScope scope) '''
		public void set«scope.getInterfaceOperationCallbackName»(«scope.getInterfaceOperationCallbackName» operationCallback) {
			synchronized(statemachine) {
				statemachine.get«scope.interfaceName»().set«scope.getInterfaceOperationCallbackName»(operationCallback);
			}
		}
		
	'''
	
	def protected interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public synchronized «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.asEscapedIdentifier»;
			}
		«ENDFOR»
	'''

	def protected timingFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.timed»
			/*================ TIME EVENT HANDLING ================
			
			/** An external timer instance is required. */
			protected ITimer externalTimer;
			
			/** Internally we use a timer proxy that queues time events together with other input events. */
			protected ITimer timerProxy = new ITimer() {
				/** Simply delegate to external timer with a modified callback. */
				@Override
				public void setTimer(ITimerCallback callback, int eventID, long time,
						boolean isPeriodic) {
					externalTimer.setTimer(«flow.cycleWrapperClassName(entry)».this, eventID, time, isPeriodic);
				}
				
				@Override
				public void unsetTimer(ITimerCallback callback, int eventID) {
					externalTimer.unsetTimer(«flow.cycleWrapperClassName(entry)».this, eventID);
				}
			};
			
			/**
			 * Set the {@link ITimer} for the state machine. It must be set externally
			 * on a timed state machine before a run cycle can be correct executed.
			 * 
			 * @param timer
			 */
			public void setTimer(ITimer timer) {
				synchronized(statemachine) {
					this.externalTimer = timer;
					/* the wrapped state machine uses timer proxy as timer */
					statemachine.setTimer(timerProxy);
				}
			}
			
			/**
			* Returns the currently used timer.
			* 
			* @return {@link ITimer}
			*/
			public ITimer getTimer() {
				return externalTimer;
			}
			
			public void timeElapsed(int eventID) {
				synchronized (statemachine) {
					statemachine.timeElapsed(eventID);
				}
			}
		«ENDIF»
	'''

}