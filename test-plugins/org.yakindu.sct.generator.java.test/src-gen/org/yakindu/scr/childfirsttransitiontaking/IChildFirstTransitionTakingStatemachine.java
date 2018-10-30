package org.yakindu.scr.childfirsttransitiontaking;

import org.yakindu.scr.IStatemachine;

public interface IChildFirstTransitionTakingStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseE();
		
		public void raiseGo();
		
		public boolean getGuard();
		
		public void setGuard(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
}
