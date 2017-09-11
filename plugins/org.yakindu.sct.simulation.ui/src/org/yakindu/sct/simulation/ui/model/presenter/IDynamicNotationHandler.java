/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.model.presenter;

import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.model.sruntime.ExecutionContext;

/**
 * An IDynamicNotationHandler displays highlights the semantic elements using an
 * {@link IHighlightingSupport}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDynamicNotationHandler {
	/**
	 * This is called whenever the {@link ExecutionContext} changes, not
	 * everytime an element from the context changes. Implementations have to
	 * handle executionContext observing for value changes
	 */
	public void display(ExecutionContext context);

	/**
	 * Called when the simulation terminates, can be used for clean up
	 */
	public void terminate();

	public void setHighlightingSupport(IHighlightingSupport support);

	public IHighlightingSupport getHighlightingSupport();

}
