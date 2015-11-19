/**
  Copyright (c) 2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Axel Terfloth - Initial contribution and API
*/

package org.yakindu.sct.generator.csharp

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

/**
 * Generates the runnable wrapper for the statemachine. This wrapper implies event based execution semantics. 
 */
class RunnableWrapper {

	@Inject protected extension GenmodelEntries
	@Inject protected extension RunnableFeature

	@Inject protected extension Naming
	@Inject protected extension Navigation
	@Inject protected extension ITypeSystem
	@Inject protected extension ICodegenTypeSystemAccess
	
	
	@Inject Beautifier beautifier
	
	
	def generateRunnableWrapper(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		
		var filename = flow.getImplementationPackagePath(entry) + '/' + flow.runnableWrapperClassName(entry).csharp
		var content = content(flow, entry)
//		var content = beautifier.format(filename, content(flow, entry))
		fsa.generateFile(filename, content)
	}
	
	
	def protected content(ExecutionFlow flow, GeneratorEntry entry) '''
		«entry.licenseText»
		«flow.createImports(entry)»
		
		/**
		 * ThreadStart wrapper of «flow.statemachineClassName». This wrapper provides a thread safe, runnable instance of the statemachine.
		 * The wrapper implements the {@link ThreadStart} interface and can be started in a thread by the client code. 
		 * The run method then starts the main event processing loop for this statemachine.
		 * 
		 * This feature is in beta state. Currently not supported are
		 * - interface observer
		 * - operation callbacks
		 * 
		 * Please report bugs and issues... 
		 */
		
		namespace «entry.getNamespaceName()»
		{
		
			public class «flow.runnableWrapperClassName(entry)» : «flow.statemachineInterfaceName» {
				
				«flow.createFieldDeclarations(entry)»
				«flow.interfaceAccessors»
				«flow.timingFunctions(entry)»
				private readonly Object syncLock = new Object();
				
				/**
				 * init() will be delegated thread safe to the wrapped statemachine. 
				 */ 
				public void init() {
					lock(syncLock) {
						statemachine.init();
					}
				}
				
				/**
				 * enter() will be delegated thread safe to the wrapped statemachine.  
				 */ 
				public void enter() {
					lock(syncLock) {
						statemachine.enter();
					}
				}
				
				/**
				 * exit() will be delegated thread safe to the wrapped statemachine.  
				 */ 
				public void exit() {
					lock(syncLock) {
						statemachine.exit();
					}
				}
				
				/**
				 * isActive() will be delegated thread safe to the wrapped statemachine.  
				 */ 
				public boolean isActive() {
					lock(syncLock) {
						return statemachine.isActive();
					}
				}
				
				/**
				 * isFinal() will be delegated thread safe to the wrapped statemachine.  
				 */ 
				public boolean isFinal() {
					lock(syncLock) {
						return statemachine.isFinal();
					}
				}
				
				
				/**
				 * runCycle() will be delegated thread safe to the wrapped statemachine.  
				 */ 
				@Override
				public void runCycle() {
					lock(syncLock) {
						statemachine.runCycle();
					}
				}
	
				/**
				 * This method will start the main execution loop for the statemachine. 
				 * First it will init and enter the statemachine implicitly and then will start processing events 
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
		}
	'''
	
	def protected createImports(ExecutionFlow flow, GeneratorEntry entry) '''
		//import java.util.concurrent.BlockingQueue;
		//import java.util.concurrent.LinkedBlockingQueue;

		«IF entry.createInterfaceObserver && flow.hasOutgoingEvents»
		using System.Collections.Generic;
		using System.Collections.Concurrent;
		«ENDIF»
		«IF flow.timed»
			// import «/*entry.getBasePackageName()*/».ITimer;
			// import «/*entry.getBasePackageName()*/».ITimerCallback;
		«ENDIF»
	'''
	
	def protected createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		
		/** 
		 * The events are queued using a blocking queue without capacity restriction. This queue holds
		 * Runnable instances that process the events. 
		 */
		protected BlockingCollection<Runnable> eventQueue = new BlockingCollection<Runnable>();

		/**
		 * The core statemachine is simply wrapped and the event processing will be delegated to that statemachine instance.
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
					public void raise«event.name.asName»(«event.type.targetLanguageName» value) {
						
						eventQueue.Add( new Runnable() {
							
							public override void run() {
								lock (statemachine) {
									statemachine.get«scope.interfaceName»().raise«event.name.asName»(value);
									statemachine.runCycle();
								}
							}
						});
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						eventQueue.Add( new Runnable() {
							
							public override void run() {
								lock (statemachine) {
									statemachine.get«scope.interfaceName»().raise«event.name.asName»();
									statemachine.runCycle();
								}
							}
						});
					}
					
				«ENDIF»
			«ENDIF»
			«IF event.direction == Direction::OUT»
				public bool isRaised«event.name.asName»() {
					lock(statemachine) {
						return statemachine.get«scope.interfaceName»().isRaised«event.name.asName»();
					}
				}
				
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public «event.type.targetLanguageName» get«event.name.asName»Value() {
						lock(statemachine) {
							return statemachine.get«scope.interfaceName»().get«event.name.asName»Value();
						}
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		«FOR variable : scope.variableDefinitions»
			public «variable.type.targetLanguageName» «variable.getter» {
				lock(statemachine) {
					return statemachine.get«scope.interfaceName»().«variable.getter»;
				}
			}
			
			«IF !variable.readonly && !variable.const»
				public void «variable.setter»(«variable.type.targetLanguageName» value) {
					lock(statemachine) {
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
				public override void setTimer(ITimerCallback callback, int eventID, long time,
						bool isPeriodic) {
					externalTimer.setTimer(«flow.runnableWrapperClassName(entry)».this, eventID, time, isPeriodic);
				}
				
				public override void unsetTimer(ITimerCallback callback, int eventID) {
					externalTimer.unsetTimer(«flow.runnableWrapperClassName(entry)».this, eventID);
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
				lock(statemachine) {
					this.externalTimer = timer;
					/* the wrapped statemachine uses timer proxy as timer */
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
				eventQueue.Add(new Runnable() {

					public override void run() {
						lock (statemachine) {
							statemachine.timeElapsed(eventID);
							statemachine.runCycle();
						}
					}
				});
			}
			
		«ENDIF»
	'''
	
}