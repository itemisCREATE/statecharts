package org.yakindu.sct.runtime.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Runtime service for state machines to execute a run to completion step
 * periodically.
 * 
 */
public class RuntimeService {

	private Timer timer = new Timer();

	private List<IStatemachine> statemachineSet = new LinkedList<IStatemachine>();

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			lock.readLock().lock();
			for (IStatemachine statemachine : statemachineSet) {
				statemachine.runCycle();
			}
			lock.readLock().unlock();
		}
	};

	/**
	 * Create runtime service.
	 * 
	 * @param cyclePeriod
	 *            : The period with which the registered state machines run
	 *            cycle method is called.
	 */
	public RuntimeService(long cyclePeriod) {
		timer.scheduleAtFixedRate(timerTask, 0, cyclePeriod);
	}

	/**
	 * Adds the given state machine to runtime service.
	 * 
	 * @param statemachine
	 * @return {@code true} if state machine is added properly.
	 */
	public boolean addStatemachine(IStatemachine statemachine) {
		lock.writeLock().lock();
		boolean ret = statemachineSet.add(statemachine);
		lock.writeLock().unlock();
		return ret;
	}

	/**
	 * Removes the given state machine from runtime service.
	 * 
	 * @param statemachine
	 * @return {@code true} if state machine is removed properly.
	 */
	public boolean removeStatemachine(IStatemachine statemachine) {
		lock.writeLock().lock();
		boolean ret = statemachineSet.remove(statemachine);
		lock.writeLock().unlock();
		return ret;
	}

	/**
	 * Ends the runtime service.
	 */
	public void cancel() {
		timer.cancel();
	}
}
