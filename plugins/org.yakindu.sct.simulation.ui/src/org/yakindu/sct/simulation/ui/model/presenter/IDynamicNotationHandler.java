package org.yakindu.sct.simulation.ui.model.presenter;

import org.yakindu.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDynamicNotationHandler {

	public void updateExecutionContext(ExecutionContext context);

	public void setHighlightingSupport(IHighlightingSupport support);

	public IHighlightingSupport getHighlightingSupport();

}
