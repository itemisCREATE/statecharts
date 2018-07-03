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

import org.eclipse.gmf.runtime.common.ui.preferences.ComboFieldEditor;
import org.eclipse.gmf.runtime.common.ui.preferences.FontFieldEditor;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartAppearancePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public StatechartAppearancePreferencePage() {
		super(GRID);
		setDescription("Change the default diagram appearance");
	}

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		addFields(parent);
	}

	protected void addFields(Composite parent) {
		Composite main = createPageLayout(parent);
		createColorsLineStyleFontEditors(main);
		createMiscellaneousEditors(main);
	}

	protected void createColorsLineStyleFontEditors(Composite main) {
		Composite composite = createGroupComposite(main, "Colors, line style, and font");

		// Colors:
		addField(new ColorFieldEditor(StatechartPreferenceConstants.PREF_REGION_BACKGROUND, "Region background color:",
				composite));
		addField(new ColorFieldEditor(StatechartPreferenceConstants.PREF_REGION_LINE, "Region line color:", composite));
		addField(new ColorFieldEditor(StatechartPreferenceConstants.PREF_STATE_BACKGROUND, "State background color:",
				composite));
		addField(new ColorFieldEditor(StatechartPreferenceConstants.PREF_STATE_LINE, "State line color:", composite));

		// Line style:
		ComboFieldEditor lineStyleFieldEditor = new ComboFieldEditor(IPreferenceConstants.PREF_LINE_STYLE,
				"Routing style:", composite, ComboFieldEditor.INT_TYPE, false, 0, 0, true);
		Combo lineStyleCombo = lineStyleFieldEditor.getComboControl();
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		lineStyleCombo.setLayoutData(gridData);
		addField(lineStyleFieldEditor);
		lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Manual_text);
		lineStyleCombo.add(DiagramUIMessages.ConnectionsPreferencePage_ConnectionView_Rectilinear_text);

		// Font:
		FontFieldEditor editor = new FontFieldEditor(IPreferenceConstants.PREF_DEFAULT_FONT, "Font: ", composite);
		addField(editor);
	}

	protected void createMiscellaneousEditors(Composite main) {
		Composite composite = createGroupComposite(main, "Miscellaneous");

		// Syntax coloring:
		BooleanFieldEditor syntaxColoringEditor = new BooleanFieldEditor(
				StatechartPreferenceConstants.PREF_SYNTAX_COLORING, "Enable syntax coloring", composite);
		addField(syntaxColoringEditor);

		// Priority labels:
		BooleanFieldEditor priorityLabelsEditor = new BooleanFieldEditor(
				StatechartPreferenceConstants.PREF_PRIORITY_LABELS, "Show transition and region priority", composite);
		addField(priorityLabelsEditor);

		// Live validation:
		BooleanFieldEditor liveValidationEditor = new BooleanFieldEditor(
				StatechartPreferenceConstants.PREF_LIVE_VALIDATION, "Enable live validation", composite);
		addField(liveValidationEditor);
	}

	protected Composite createPageLayout(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		return main;
	}

	protected Composite createGroupComposite(Composite parent, String title) {
		final int COLUMNS = 3;
		Group group = new Group(parent, SWT.NONE);
		group.setText(title);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(COLUMNS, false));
		Composite composite = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(COLUMNS, false);
		composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = COLUMNS;
		composite.setLayoutData(gridData);
		return composite;
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(DiagramActivator.getDefault().getPreferenceStore());
	}
}
