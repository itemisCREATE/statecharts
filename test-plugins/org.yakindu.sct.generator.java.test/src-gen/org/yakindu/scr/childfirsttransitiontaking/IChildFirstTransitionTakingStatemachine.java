package org.yakindu.scr.childfirsttransitiontaking;

import org.yakindu.scr.IStatemachine;

public interface IChildFirstTransitionTakingStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseE();
		
		public void raiseGo();
		
		public long getCLocalReaction();
		
		public void setCLocalReaction(long value);
		
		public long getCaLocalReaction();
		
		public void setCaLocalReaction(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
