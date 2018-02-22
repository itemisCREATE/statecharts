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

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
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
		setDescription("Simulation preferences");
	}

	public void createFieldEditors() {
		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR,
				"&State highlighting foreground color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR,
				"&State highlighting background color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.VERTEX_FOREGROUND_TRANSIENT_COLOR,
				"&Vertex transient foreground color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.VERTEX_BACKGROUND_TRANSIENT_COLOR,
				"&Vertex transient background color:", getFieldEditorParent()));

		addField(new ColorFieldEditor(
				SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR,
				"&Transition highlighting color", getFieldEditorParent()));
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