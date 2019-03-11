/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.submodules.eventdriven

class RunnableExtension {
	def runnable() {
		'''
		@Override
		public void run() {
			init();
			enter();
			boolean terminate = false;
			
			while (!(terminate || Thread.currentThread().isInterrupted())) {
				try {
					Runnable task = inEventQueue.take();
					task.run();
				} catch (InterruptedException e) {
					terminate = true;
				}
			}
		}
		'''
	}
}