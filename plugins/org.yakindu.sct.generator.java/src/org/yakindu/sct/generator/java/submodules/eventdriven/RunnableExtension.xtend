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