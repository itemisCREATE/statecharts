package org.yakindu.sct.simulation.ui.model.presenter;

import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.model.sexec.Trace;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractDynamicNotationHandler implements
		IDynamicNotationHandler {

	protected abstract void visualizeStep(Trace trace);

	private IHighlightingSupport support;

	public IHighlightingSupport getHighlightingSupport() {
		return support;
	}

	public void setHighlightingSupport(IHighlightingSupport support) {
		this.support = support;
	}

	public final void traceStepExecuted(final Trace trace) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				visualizeStep(trace);
			}
		});
	}
}
