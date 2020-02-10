/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.base.gmf.runtime.highlighting.HighlightingParameters;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - Additions
 * 
 */
public class DefaultDynamicNotationHandler extends AbstractDynamicNotationHandler {

	private ExecutionContextVisualizer visualizer = new ExecutionContextVisualizer(NULL_SUPPORT);
	private ExecutionContextExtensions contextExtensions = new ExecutionContextExtensions();

	protected ExecutionContext currentContext;

	public void display(ExecutionContext context) {
		if (this.currentContext != null)
			this.currentContext.eAdapters().remove(visualizer);
		this.currentContext = context;
		restoreNotationState(this.currentContext);
		this.currentContext.eAdapters().add(visualizer);
	}

	/**
	 * highlights the whole execution context, only executed once at the beginning.
	 */
	protected void restoreNotationState(ExecutionContext context) {
		List<IHighlightingSupport.Action> actions = new ArrayList<IHighlightingSupport.Action>();
		actions.add(new IHighlightingSupport.Highlight(contextExtensions.getAllActiveStates(context),
				HighlightingParameters.DEFAULT));
		actions.add(new IHighlightingSupport.Highlight(context.getExecutedElements(), HighlightingParameters.DEFAULT));
		actions.add(new IHighlightingSupport.Highlight(context.getSuspendedElements(), SUSPENDED_PARAMS));
		getHighlightingSupport().executeAsync(actions);
	}

	@Override
	public void terminate() {
		if (this.currentContext != null)
			this.currentContext.eAdapters().remove(visualizer);
		IHighlightingSupport support = visualizer.getHighlightingSupport();
		if (support.isLocked())
			support.releaseEditor();
		visualizer.setHighlightingSupport(NULL_SUPPORT);
	}

	@Override
	public void setHighlightingSupport(IHighlightingSupport support) {
		super.setHighlightingSupport(support);
		visualizer.setHighlightingSupport(support);
	}
}
