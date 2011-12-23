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
package org.yakindu.sct.simulation.ui.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.yakindu.sct.simulation.ui.DeclarationImages;
import org.yakindu.sct.simulation.ui.SimulationActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HideTimeEventsAction extends Action {

	public static final String HIDE_KEY = "HideTimeEvents";

	public HideTimeEventsAction(boolean show) {
		super("Hide TimeEvents");
		setToolTipText("Show TimeEvents");
		setImageDescriptor(DeclarationImages.TIMEEVENT.imageDescriptor());
		setChecked(getStore().getBoolean(HIDE_KEY));
	}

	@Override
	public void run() {
		boolean hide = getStore().getBoolean(HIDE_KEY);
		getStore().setValue(HIDE_KEY, !hide);
	}

	private IPreferenceStore getStore() {
		return SimulationActivator.getDefault().getPreferenceStore();
	}
}
