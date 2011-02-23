/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.statechart.diagram.DiagramActivator;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public StatechartPreferencePage() {
		super(GRID);
		setPreferenceStore(DiagramActivator.getDefault().getPreferenceStore());
		setDescription("YAKINDU Statechart Preferences");
	}

	public void createFieldEditors() {
		addField(new ColorFieldEditor(PreferenceConstants.REGION_COLOR,
				"&Region color:", getFieldEditorParent()));
		addField(new ColorFieldEditor(PreferenceConstants.STATE_COLOR,
				"&State color:", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench arg0) {
		// Nothing to do
	}

}