package org.yakindu.scr.constonlydefaultscope;

import org.yakindu.scr.IStatemachine;

public interface IConstOnlyDefaultScopeStatemachine extends IStatemachine {
	public interface SCInterface {
		public static final long b = 1;
		
		public static final long c = 2;
		
		public long getB();
		
		public long getC();
		
	}
	
	public SCInterface getSCInterface();
	
	public interface SCIA {
		public void raiseE(long value);
		
	}
	
	public SCIA getSCIA();
	
}
