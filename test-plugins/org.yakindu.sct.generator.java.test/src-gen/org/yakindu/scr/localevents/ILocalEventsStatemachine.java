package org.yakindu.scr.localevents;

import org.yakindu.scr.IStatemachine;

public interface ILocalEventsStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseBUTTON_ON();
		
	}
	
	public SCInterface getSCInterface();
	
}
