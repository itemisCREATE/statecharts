/**
  Copyright (c) 2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
*/

package org.yakindu.sct.generator.java

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

/**
 * Generates the runnable wrapper for the state machine. This wrapper implies event based execution semantics. 
 */
class CycleBasedSynchronizedWrapper {

	@Inject protected extension GenmodelEntries
	@Inject protected extension CycleBasedWrapperFeature

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
		 * Subclass of «flow.statemachineClassName». This wrapper provides a thread-safe instance of the state machine.
		 * 
		 * Please report bugs and issues... 
		 */
		
		public class «flow.cycleWrapperClassName(entry)» extends «flow.statemachineClassName» {
			
			«flow.createFieldDeclarations(entry)»
			«flow.interfaceAccessors»
			«flow.timingFunctions(entry)»
			
			/**
			 * init() will be delegated thread-safely to the wrapped state machine. 
			 */ 
			public synchronized void init() {
				statemachine.init();
			}
			
			/**
			 * enter() will be delegated thread-safely to the wrapped state machine.  
			 */ 
			public synchronized void enter() {
				statemachine.enter();
			}
			
			/**
			 * exit() will be delegated thread-safely to the wrapped state machine.  
			 */ 
			public synchronized void exit() {
				statemachine.exit();
			}
			
			/**
			 * isActive() will be delegated thread-safely to the wrapped state machine.  
			 */ 
			public synchronized boolean isActive() {
				return statemachine.isActive();
			}
			
			/**
			 * isFinal() will be delegated thread-safely to the wrapped state machine.  
			 */ 
			public synchronized boolean isFinal() {
				return statemachine.isFinal();
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
		 *
		 * Lock to provide thread save access.
		 *
		 */
		protected ReentrantLock lock = new ReentrantLock(true);
		
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
						lock.lock();
						statemachine.get«scope.interfaceName»().raise«event.name.asName»(value);
						lock.unlock();
					}
					
				«ELSE»
					public void raise«event.name.asName»() {
						lock.lock();
						statemachine.get«scope.interfaceName»().raise«event.name.asName»();
						lock.unlock();
					}
					
				«ENDIF»
			«ENDIF»
			«IF event.direction == Direction::OUT»
				public boolean isRaised«event.name.asName»() {
						lo
						return statemachine.get«scope.interfaceName»().isRaised«event.name.asName»();
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
			public synchronized «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.asEscapedIdentifier»;
			}
		«ENDFOR»
	'''


	def protected timingFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.timed»
			/**
			 * Set the {@link ITimer} for the state machine. It must be set
			 * externally on a timed state machine before a run cycle can be correct
			 * executed.
			 * 
			 * @param timer
			 */
			public synchronized void setTimer(ITimer timer) {
				super.setTimer(timerProxy);
			}
			
			/**
			* Returns the currently used timer.
			* 
			* @return {@link ITimer}
			*/
			public synchronized ITimer getTimer() {
				return externalTimer;
			}
			
			public synchronized void timeElapsed(int eventID) {
				super.timeElapsed(eventID);
			}
		«ENDIF»
	'''
	
}