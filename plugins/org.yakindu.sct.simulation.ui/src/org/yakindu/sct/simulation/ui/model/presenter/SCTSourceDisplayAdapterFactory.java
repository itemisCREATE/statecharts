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

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.ui.PlatformUI;

/**
 * Returns a singleton instance of the {@link SCTSourceDisplay}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplayAdapterFactory implements IAdapterFactory {

	private static SCTSourceDisplay display = null;

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		return getSourceDisplay();
	}

	private Object getSourceDisplay() {
		if (display == null) {
			display = new SCTSourceDisplay();
		}
		DebugPlugin.getDefault().addDebugEventListener(display);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(display);
		return display;
	}

	public Class<?>[] getAdapterList() {
		return new Class[] { SCTSourceDisplay.class };
	}

}
