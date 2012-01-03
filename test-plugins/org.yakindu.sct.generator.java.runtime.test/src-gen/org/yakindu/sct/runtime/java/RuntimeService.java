/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

	public RuntimeService(long cyclePeriod) {
		timer.scheduleAtFixedRate(timerTask, 0, cyclePeriod);
	}

	public boolean addStatemachine(IStatemachine statemachine) {
		lock.writeLock().lock();
		boolean ret = statemachineSet.add(statemachine);
		lock.writeLock().unlock();
		return ret;
	}

	public boolean removeStatemachine(IStatemachine statemachine) {
		lock.writeLock().lock();
		boolean ret = statemachineSet.remove(statemachine);
		lock.writeLock().unlock();
		return ret;
	}

	public void cancel() {
		timer.cancel();
	}
}
