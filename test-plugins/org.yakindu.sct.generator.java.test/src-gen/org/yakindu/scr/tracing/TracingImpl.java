package org.yakindu.scr.tracing;

import org.yakindu.scr.ITracing;

public class TracingImpl<T> implements ITracing<T>{

	private boolean entered = false;
	private boolean exited = false;

	public boolean isEntered() {
		return entered;
	}

	public boolean isExited() {
		return exited;
	}


	@Override
	public void stateEntered(T state) {
		entered = true;
	}

	@Override
	public void stateExited(T state) {
		exited = true;
	}

}
