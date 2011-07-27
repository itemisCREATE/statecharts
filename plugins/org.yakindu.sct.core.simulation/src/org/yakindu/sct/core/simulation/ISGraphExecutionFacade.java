package org.yakindu.sct.core.simulation;

/**
 * 
 * @author andreas muelder
 * 
 */
public interface ISGraphExecutionFacade {

	public void enter();

	public void runCycle();
	
	public void raise(String eventName);

	public void addExecutionListener(ISGraphExecutionListener listener);

	public void removeExecutionListener(ISGraphExecutionListener listener);
}
