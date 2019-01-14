package org.yakindu.scr.constonlynamedscope;

import org.yakindu.scr.IStatemachine;

public interface IConstOnlyNamedScopeStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseE(long value);
		
	}
	
	public SCInterface getSCInterface();
	
	public interface SCIA {
	
	public static final long b = 1;
	
	public static final long c = 2;
	
		public long getB();
		
		public long getC();
		
	}
	
	public SCIA getSCIA();
	
}
