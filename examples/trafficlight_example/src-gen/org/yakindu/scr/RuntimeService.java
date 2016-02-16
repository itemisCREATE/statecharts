package org.yakindu.scr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Runtime service for state machines to execute a run to completion step
 * periodically.
 * 
 */
public class RuntimeService {

	private static RuntimeService runtimeService;

	private Timer timer = null;

	private Map<Long, StatemachineTimerTask> timerTasks = new HashMap<Long, StatemachineTimerTask>();

	private class StatemachineTimerTask extends TimerTask {

		private List<IStatemachine> statemachineList = new LinkedList<IStatemachine>();

		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		private boolean isPaused = false;

		@Override
		public void run() {
			lock.readLock().lock();
			if (!isPaused) {
				for (IStatemachine statemachine : statemachineList) {
					statemachine.runCycle();
				}
			}
			lock.readLock().unlock();
		}

		/**
		 * Adds the given state machine to the TimerTask.
		 * 
		 * @param statemachine
		 * @return {@code true} if state machine is added properly.
		 */
		public boolean addStatemachine(IStatemachine statemachine) {
			lock.writeLock().lock();
			boolean ret = statemachineList.add(statemachine);
			lock.writeLock().unlock();
			return ret;
		}

		/**
		 * Removes the given state machine from the TimerTask.
		 * 
		 * @param statemachine
		 * @return {@code true} if state machine is removed properly.
		 */
		public boolean removeStatemachine(IStatemachine statemachine) {
			lock.writeLock().lock();
			boolean ret = statemachineList.remove(statemachine);
			lock.writeLock().unlock();
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
