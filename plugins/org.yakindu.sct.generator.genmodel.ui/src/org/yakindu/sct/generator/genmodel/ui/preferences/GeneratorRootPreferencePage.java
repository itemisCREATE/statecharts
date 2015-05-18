/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.preferences;

import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.generator.core.GeneratorActivator;

public class GeneratorRootPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public GeneratorRootPreferencePage() {
		setDescription("Change the behavior of the Generator model");
	}

	@Override
	protected void createFieldEditors() {
		addField(new CheckBoxFieldEditor(
				GeneratorActivator.PREF_GENERATE_AUTOMATICALLY,
				"Execute SGen Files automatically: ", getFieldEditorParent()));
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return GeneratorActivator.getDefault().getPreferenceStore();
	}

	@Override
	public void init(IWorkbench workbench) {
		new GenModelPreferenceInitializer().initializeDefaultPreferences();
	}
}
