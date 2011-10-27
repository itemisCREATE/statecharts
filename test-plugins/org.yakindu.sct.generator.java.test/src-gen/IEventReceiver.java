
package org.yakindu.sct.runtime.java.base;

public interface IStatemachine {
	
	public void init();

	public void runCycle();
	
	public IDataRepository getEventRepository();
	
	public IDataRepository getVariableRepository();
	
	public void setTimerHandler(ITimerHandler timerHandler);
	
	public ITimerHandler getTimerHandler();
}
