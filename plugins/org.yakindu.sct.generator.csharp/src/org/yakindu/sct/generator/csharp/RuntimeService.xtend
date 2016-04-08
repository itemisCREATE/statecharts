/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class RuntimeService {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateRuntimeService(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + runtimeServiceClass.csharp, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		
		using System.Threading;
		using System.Collections.Generic;
		
		namespace «entry.getNamespaceName()»
		{
		
			/**
			 * Runtime service for state machines to execute a run to completion step
			 * periodically.
			 * 
			 */
			public class RuntimeService {
	
				private static RuntimeService runtimeService;
	
				private Timer timer = null;
	
				private Dictionary<Long, StatemachineTimerTask> timerTasks = new Dictionary<Long, StatemachineTimerTask>();
	
				private class StatemachineTimerTask extends TimerTask {
	
					private List<IStatemachine> statemachineList = new List<IStatemachine>();
	
					private ReaderWriterLock lock = new ReaderWriterLock();
	
					private bool isPaused = false;
	
					public override void run() {
						lock.AcquireReaderLock(-1);
						if (!isPaused) {
							foreach( IStatemachine statemachine in statemachineList) {
								statemachine.runCycle();
							}
						}
						lock.ReleaseReaderLock();
					}
	
					/**
					 * Adds the given state machine to the TimerTask.
					 * 
					 * @param statemachine
					 * @return {@code true} if state machine is added properly.
					 */
					public bool addStatemachine(IStatemachine statemachine) {
						lock.AcquireWriterLock(-1);
						statemachineList.Add(statemachine);
						lock.ReleaseWriterLock();
						return true;
					}
	
					/**
					 * Removes the given state machine from the TimerTask.
					 * 
					 * @param statemachine
					 * @return {@code true} if state machine is removed properly.
					 */
					public boolean removeStatemachine(IStatemachine statemachine) {
						lock.AcquireWriterLock(-1);
						bool ret = statemachineList.Remove(statemachine);
						lock.ReleaseWriterLock(-1);
						return ret;
					}
	
					public void pause() {
						isPaused = true;
					}
	
					public void resume() {
						isPaused = false;
					}
				}
	
				private RuntimeService() {
					// Not intended to be instantiated.
				}
	
				/**
				 * Returns the {@code RuntimeService} instance as singleton.
				 * 
				 * @return The singleton {@code RuntimeService} instance
				 */
				public static RuntimeService getInstance() {
					if (runtimeService == null) {
						runtimeService = new RuntimeService();
					}
					return runtimeService;
				}
	
				/**
				 * Registers an {@link IStatemachine} for scheduled fixed rate execution
				 * 
				 * @param statemachine
				 *            - The statemachine to execute
				 * @param cyclePeriod
				 *            - the fixed rate cycle period for scheduling
				 * @return {@code true} if state machine is added properly.
				 */
				public boolean registerStatemachine(IStatemachine statemachine,
						long cyclePeriod) {
			
					if (timerTasks.containsKey(cyclePeriod)) {
						// TimerTask for cycle time already existing -> add statemachine
						return timerTasks.get(cyclePeriod).addStatemachine(statemachine);
					} else {
						// Create new TimerTask for cycle period and add statemachine
						StatemachineTimerTask timerTask = new StatemachineTimerTask();
						timerTasks.put(cyclePeriod, timerTask);
						boolean ret = timerTask.addStatemachine(statemachine);
						// Create a new Timer instance if runtime service was cancelled
						// before
						if (timer == null) {
							timer = new Timer();
						}
						timer.scheduleAtFixedRate(timerTask, 0, cyclePeriod);
						return ret;
					}
				}
	
				/**
				 * Removes the given state machine from runtime service.
				 * 
				 * @param statemachine
				 *            - the statemachine which should be removed
				 * @param cyclePeriod
				 *            - the scheduling cycle period of the statemachine
				 * @return {@code true} if state machine is removed properly.
				 */
				public boolean unregisterStatemachine(IStatemachine statemachine,
						long cyclePeriod) {
					if (timerTasks.containsKey(cyclePeriod)) {
						boolean ret = timerTasks.get(cyclePeriod).removeStatemachine(
								statemachine);
			
						return ret;
					}
					return false;
				}
	
				/**
				 * Cancels the execution of statemachines for the given cycle period. This
				 * stops the execution of statemachines which are registered for the given
				 * cycle period and cancels the executing {@link TimerTask}.
				 * 
				 * @return {@code true} if poperly cancelled
				 */
				public boolean cancelAll(long cyclePeriod) {
					if (timer != null && timerTasks.containsKey(cyclePeriod)) {
						TimerTask task = timerTasks.get(cyclePeriod);
						task.cancel();
						timer.purge();
						timerTasks.remove(cyclePeriod);
						return true;
					}
					return false;
				}
	
				/**
				 * Pauses the execution of all statemachines which are registered for the
				 * given cyclePeriod.
				 * 
				 * @param cyclePeriod
				 * @return {@code true} if properly paused
				 * 
				 */
				public boolean pauseAll(long cyclePeriod) {
					if (timerTasks.containsKey(cyclePeriod)) {
						timerTasks.get(cyclePeriod).pause();
						return true;
					}
					return false;
				}
	
				/**
				 * Resumes the execution of all statemachines which are registered for the
				 * given cyclePeriod.
				 * 
				 * @param cyclePeriod
				 * @return {@code true} if properly resumed
				 * 
				 */
				public boolean resumeAll(long cyclePeriod) {
					if (timerTasks.containsKey(cyclePeriod)) {
						timerTasks.get(cyclePeriod).resume();
						return true;
					}
					return false;
				}
	
				/**
				 * Cancels the execution of all registered statemachines. This cancels the
				 * executing {@link Timer} freeing all allocated resources and terminates
				 * all existing execution threads.
				 */
				public void cancelTimer() {
					if (timer != null) {
						timer.cancel();
						timer.purge();
						timerTasks.clear();
						timer = null;
					}
				}
			}
		}
		'''
	}
}