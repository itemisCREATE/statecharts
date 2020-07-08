package org.yakindu.sct.generator.java.test;

import org.yakindu.sct.ITracingListener;

public class TracingImpl<T> implements ITracingListener<T>{

	private boolean entered = false;
	private boolean exited = false;

	public boolean isEntered() {
		return entered;
	}

	public boolean isExited() {
		return exited;
	}


	@Override
	public void onStateEntered(T state) {
		entered = true;
	}

	@Override
	public void onStateExited(T state) {
		exited = true;
	}

}
