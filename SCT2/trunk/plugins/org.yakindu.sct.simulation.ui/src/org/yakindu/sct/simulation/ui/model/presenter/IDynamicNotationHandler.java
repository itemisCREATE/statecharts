package org.yakindu.sct.simulation.ui.model.presenter;

import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionTraceListener;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDynamicNotationHandler extends IExecutionTraceListener {

	public void restoreNotationState(IExecutionContext context);

	/**
	 * {@see IExecutionTraceListener#traceStepExecuted(Trace)}
	 */
	public void traceStepExecuted(Trace trace);

	public void setHighlightingSupport(IHighlightingSupport support);

	public IHighlightingSupport getHighlightingSupport();

}
