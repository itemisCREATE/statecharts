package org.yakindu.scr;

/**
* Interface for state machines which use timed event triggers.
*/
public interface ITimerCallback {
	
	/**
	* Callback method if a time event occurred.
	* 
	* @param eventID
	* 			:The id of the occurred event.
	*/
	public void timeElapsed(int eventID);
}
