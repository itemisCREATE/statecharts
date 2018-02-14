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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.generator.builder.BuilderActivator;
import org.yakindu.sct.generator.core.GeneratorActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GeneratorRootPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public GeneratorRootPreferencePage() {
		setDescription("Change the behavior of the generator model");
	}

	@Override
	protected void createFieldEditors() {
		addField(new CheckBoxFieldEditor(GeneratorActivator.PREF_GENERATE_AUTOMATICALLY,
				"Execute generator model files (.sgen) automatically", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(BuilderActivator.getDefault().getPreferenceStore());
	}
}
