package org.yakindu.scr.exitsequence;

import org.yakindu.scr.IStatemachine;

public interface IExitSequenceStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseE();
		
		public boolean getGuard();
		
		public void setGuard(boolean value);
		
		public long getCanary();
		
		public void setCanary(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
