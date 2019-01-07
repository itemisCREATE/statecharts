package org.yakindu.scr.constonlyinternalscope;

import org.yakindu.scr.IStatemachine;

public interface IConstOnlyInternalScopeStatemachine extends IStatemachine {
	public static final long b = 1;
	
	public static final long c = 2;
	
	public interface SCInterface {
	
		public void raiseE(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
