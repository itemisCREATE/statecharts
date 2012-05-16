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
package org.yakindu.sct.ui.editor.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.ui.editor.DiagramActivator;

public class StatechartAppearancePreferencePage extends
		FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public StatechartAppearancePreferencePage() {
		super(GRID);
		setDescription("Preference page for statechart editor colors");
	}
	
	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_REGION_BACKGROUND,
				"Region background color:", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_REGION_LINE,
				"Region line color:", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_STATE_BACKGROUND,
				"State background color:", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_STATE_LINE,
				"State line color:", getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
		new PreferenceInitializer().initializeDefaultPreferences();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return DiagramActivator.getDefault().getPreferenceStore();
	}
}
