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
package org.yakindu.sct.simulation.ui.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.yakindu.sct.simulation.ui.SimulationActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public SimulationPreferencePage() {
		super(GRID);
		setPreferenceStore(SimulationActivator.getDefault()
				.getPreferenceStore());
		setDescription("Preference Page for simulation preferences");
	}

	public void createFieldEditors() {
		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR,
				"&state highlighting foreground color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR,
				"&state highlighting background color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.VERTEX_FOREGROUND_TRANSIENT_COLOR,
				"&vertex transient foreground color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.VERTEX_BACKGROUND_TRANSIENT_COLOR,
				"&vertex transient background color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR,
				"&transition highlighting color", getFieldEditorParent()));
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(SimulationActivator.getDefault()
				.getPreferenceStore());
	}

}