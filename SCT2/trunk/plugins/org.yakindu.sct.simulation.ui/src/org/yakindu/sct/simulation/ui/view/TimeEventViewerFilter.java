/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TimeEventViewerFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (hideTimeEvents()) {
			if (element instanceof CompositeSlot) {
				if ("time events".equals(((CompositeSlot) element).getName())) {
					return false;
				}
			}
		}
		return true;
	}

	private IPreferenceStore getStore() {
		return SimulationActivator.getDefault().getPreferenceStore();
	}

	private boolean hideTimeEvents() {
		return getStore().getBoolean(HideTimeEventsAction.HIDE_KEY);
	}

}
