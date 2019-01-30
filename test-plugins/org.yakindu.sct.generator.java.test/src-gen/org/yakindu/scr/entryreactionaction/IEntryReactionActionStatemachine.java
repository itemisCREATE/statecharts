package org.yakindu.scr.entryreactionaction;

import org.yakindu.scr.IStatemachine;

public interface IEntryReactionActionStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseB();
		
		public void raiseD();
		
		public boolean getEnteredR1();
		
		public void setEnteredR1(boolean value);
		
		public boolean getEnteredR2();
		
		public void setEnteredR2(boolean value);
		
		public boolean getEnteredBdefault();
		
		public void setEnteredBdefault(boolean value);
		
		public boolean getEnteredBother();
		
		public void setEnteredBother(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
}
