package org.yakindu.scr.triggerexpressionprecedence;

import org.yakindu.scr.IStatemachine;

public interface ITriggerExpressionPrecedenceStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseE1();
		
		public void raiseE2();
		
		public boolean getC1();
		
		public void setC1(boolean value);
		
		public boolean getC2();
		
		public void setC2(boolean value);
		
		public boolean getE1_transition();
		
		public void setE1_transition(boolean value);
		
		public boolean getE2_transition();
		
		public void setE2_transition(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
}
