package org.yakindu.scr.statechartentryandexitactions;

import org.yakindu.scr.IStatemachine;

public interface IStatechartEntryAndExitActionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public long getX();
		
		public void setX(long value);
		
		public long getY();
		
		public void setY(long value);
		
		public boolean getB();
		
		public void setB(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
}
