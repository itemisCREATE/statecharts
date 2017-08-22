/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.scheduling;

import org.yakindu.sct.simulation.core.sexec.scheduling.IWaitingStrategy.RealTime;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(RealTime.class)
public interface IWaitingStrategy {

	public void waitfor(long ms);

	public static class Instantly implements IWaitingStrategy {

		@Override
		public void waitfor(long ms) {
		}
	}

	public static class RealTime implements IWaitingStrategy {
		@Override
		public void waitfor(long ms) {
			if (ms > 0) {
				try {
					Thread.sleep(ms);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
