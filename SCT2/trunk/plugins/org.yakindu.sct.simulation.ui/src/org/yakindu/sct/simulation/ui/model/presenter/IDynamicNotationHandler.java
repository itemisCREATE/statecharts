package org.yakindu.sct.simulation.ui.model.presenter;

import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDynamicNotationHandler {

	public void updateExecutionContext(ExecutionContext context);

	public void setHighlightingSupport(IHighlightingSupport support);

	public IHighlightingSupport getHighlightingSupport();

}
