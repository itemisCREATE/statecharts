/**
  Copyright (c) 2015 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Axel Terfloth - Initial contribution and API
  	Markus Mühlbrandt - Additions
  	
*/

package org.yakindu.sct.generator.java.wrappers

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.base.types.Direction
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.java.features.CycleBasedWrapperFeature
import org.yakindu.sct.generator.java.features.EventBasedRunnableFeature
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Navigation

/**
 * Generates the runnable wrapper for the state machine. This wrapper implies event based execution semantics.
 */
class EventBasedRunnableWrapper {

	@Inject protected extension GenmodelEntries
	@Inject protected extension EventBasedRunnableFeature
	@Inject protected extension CycleBasedWrapperFeature

	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
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
		 * Runnable wrapper of «flow.statemachineClassName». This wrapper provides a
		 * thread-safe, runnable instance of the state machine. The wrapper implements
		 * the {@link Runnable} interface and can be started in a thread by the client
		 * code. The run method then starts the main event processing loop for this
		 * state machine.
		 *
		 * Please report bugs and issues...
		 */
		
		public class «flow.eventBasedWrapperClassName(entry)» extends «flow.cycleWrapperClassName(entry)» implements Runnable {
			
			«flow.createFieldDeclarations(entry)»
			«flow.timingFunctions(entry)»
			
			/**
			 * This method will start the main execution loop for the state machine.
			 * First it will init and enter the state machine implicitly and then will
			 * start processing events from the event queue until the thread is
			 * interrupted.
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
	'''
	
	def protected createFieldDeclarations(ExecutionFlow flow, GeneratorEntry entry) '''
		/**
		 * The events are queued using a blocking queue without capacity
		 * restriction. This queue holds Runnable instances that process the events.
		 */
		protected BlockingQueue<Runnable> eventQueue = new LinkedBlockingQueue<Runnable>();
		
		«FOR scope : flow.interfaceScopes»
		/**
		 * Interface object for «scope.interfaceName»
		 */		
		protected «scope.interfaceName» «scope.interfaceName.asEscapedIdentifier» = new «scope.wrapperInterfaceName(entry)»() {
			«scope.toImplementation(entry)»
		};
		
		«ENDFOR»
	'''
	
	def protected toImplementation(InterfaceScope scope, GeneratorEntry entry) '''				
		«FOR event : scope.eventDefinitions»
			«IF event.direction == Direction::IN»
				«IF event.type != null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
					public void raise«event.name.asName»(final «event.typeSpecifier.targetLanguageName» value) {
						
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
		«ENDFOR»
	'''

	def protected timingFunctions(ExecutionFlow flow, GeneratorEntry entry) '''
		«IF flow.timed»
			public void timeElapsed(final int eventID) {
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