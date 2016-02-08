/**
  Copyright (c) 2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Axel Terfloth - Initial contribution and API
*/

package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.features.EventBasedRunnableFeature

/**
 * Generates the runnable wrapper for the state machine. This wrapper implies event based execution semantics. 
 */
class EventBasedRunnableWrapper {

	@Inject protected extension GenmodelEntries
	@Inject protected extension EventBasedRunnableFeature

	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ITypeSystem
	@Inject protected extension ICodegenTypeSystemAccess
	
	def generateEventBasedRunnableWrapper(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.eventBasedWrapperClassName(entry).java
		var content = content(flow, entry)
		fsa.generateFile(filename, content)
	}
	
	
	def protected content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		package «flow.getImplementationPackageName(entry)»;
		«flow.createImports(entry)»
		
		/**
		 * Runnable wrapper of «flow.statemachineClassName». This wrapper provides a thread-safe, runnable instance of the state machine.
		 * The wrapper implements the {@link Runnable} interface and can be started in a thread by the client code. 
		 * The run method then starts the main event processing loop for this state machine.
		 * 
		 * This feature is in beta state. Currently not supported are
		 * - interface observer
		 * - operation callbacks
		 * 
		 * Please report bugs and issues... 
		 */
		
		public class «flow.eventBasedWrapperClassName(entry)» implements «flow.statemachineInterfaceName», Runnable {
			
			«flow.createFieldDeclarations(entry)»
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
			 * runCycle() will be delegated thread-safely to the wrapped state machine.  
			 */ 
			@Override
			public void runCycle() {
				synchronized (statemachine) {
					statemachine.runCycle();
				}
			}

			/**
			 * This method will start the main execution loop for the state machine. 
			 * First it will init and enter the state machine implicitly and then will start processing events 
			 * from the event queue until the thread is interrupted. 
			 */
			@Override
			public void run() {
			
				boolean terminate = false;
				
				while(!(terminate || Thread.currentThread().isInterrupted())) {
			
					try {
						
						Runnable eventProcessor = eventQueue.take();
						eventProcessor.run();
						
					} catch (InterruptedException e) {
						terminate = true;
					}
				}			
			}

			
		}
	'''
	
	def protected createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		import java.util.concurrent.BlockingQueue;
		import java.util.concurrent.LinkedBlockingQueue;

		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
		import java.util.LinkedList;
		import java.util.List;
		«ENDIF»
		«IF flow.timed»
			import «entry.getBasePackageName()».ITimer;
			import «entry.getBasePackageName()».ITimerCallback;
		«ENDIF»
	'''
	
	def protected createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		
		/** 
		 * The events are queued using a blocking queue without capacity restriction. This queue holds
		 * Runnable instances that process the events. 
		 */
		protected BlockingQueue<Runnable> eventQueue = new LinkedBlockingQueue<Runnable>();

		/**
		 * The core state machine is simply wrapped and the event processing will be delegated to that state machine instance.
		 * This instance will be created implicitly.
		 */
		protected «flow.statemachineClassName» statemachine = new «flow.statemachineClassName»();
		
		«FOR scope : flow.interfaceScopes»
		/**
		 * Interface object for «scope.interfaceName»
		 */		
		protected «scope.interfaceName» «scope.interfaceName.asEscapedIdentifier» = new «scope.interfaceName»() {
			«scope.toImplementation(entry)»
		};
		
		«ENDFOR»
		
	'''
	
	
	def protected toImplementation(InterfaceScope scope, GeneratorEntry entry) '''				
		«FOR event : scope.eventDefinitions»
			«IF event.direction == Direction::IN»
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public void raise«event.name.asName»(final «event.type.targetLanguageName» value) {
						
						eventQueue.add( new Runnable() {
							
							@Override
							public void run() {
								synchronized (statemachine) {
									statemachine.get«scope.interfaceName»().raise«event.name.asName»(value);
									statemachine.runCycle();
								}
							}
						});
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						eventQueue.add( new Runnable() {
							
							@Override
							public void run() {
								synchronized (statemachine) {
									statemachine.get«scope.interfaceName»().raise«event.name.asName»();
									statemachine.runCycle();
								}
							}
						});
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
					public «event.type.targetLanguageName» get«event.name.asName»Value() {
						synchronized(statemachine) {
							return statemachine.get«scope.interfaceName»().get«event.name.asName»Value();
						}
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		«FOR variable : scope.variableDefinitions»
			public «variable.type.targetLanguageName» «variable.getter» {
				synchronized(statemachine) {
					return statemachine.get«scope.interfaceName»().«variable.getter»;
				}
			}
			
			«IF !variable.readonly && !variable.const»
				public void «variable.setter»(final «variable.type.targetLanguageName» value) {
					synchronized(statemachine) {
						statemachine.get«scope.interfaceName»().«variable.setter»(value);
					}
				}
				
			«ENDIF»
		«ENDFOR»
	'''

	def protected interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.asEscapedIdentifier»;
			}
		«ENDFOR»
	'''


	def protected timingFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.timed»
			/*========== TIME EVENT HANDLING ================
			
			/** An external timer instance is required. */
			protected ITimer externalTimer;
			
			/** Internally we use a timer proxy that queues time events together with other input events. */
			protected ITimer timerProxy = new ITimer() {
				/** Simply delegate to external timer with a modified callback. */
				@Override
				public void setTimer(ITimerCallback callback, int eventID, long time,
						boolean isPeriodic) {
					externalTimer.setTimer(«flow.eventBasedWrapperClassName(entry)».this, eventID, time, isPeriodic);
				}
				
				@Override
				public void unsetTimer(ITimerCallback callback, int eventID) {
					externalTimer.unsetTimer(«flow.eventBasedWrapperClassName(entry)».this, eventID);
				}
			};
			
			/**
			 * Set the {@link ITimer} for the state machine. It must be set
			 * externally on a timed state machine before a run cycle can be correct
			 * executed.
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
				eventQueue.add(new Runnable() {

					@Override
					public void run() {
						synchronized (statemachine) {
							statemachine.timeElapsed(eventID);
							statemachine.runCycle();
						}
					}
				});
			}
			
		«ENDIF»
	'''
	
}