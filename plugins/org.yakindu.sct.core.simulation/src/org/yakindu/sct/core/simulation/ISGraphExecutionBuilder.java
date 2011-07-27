package org.yakindu.sct.core.simulation;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder
 * 
 */
public interface ISGraphExecutionBuilder {

	public ISGraphExecutionFacade build(Statechart statechart);
}
