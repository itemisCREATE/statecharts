package org.yakindu.sct.ui.editor.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.ui.editor.DiagramActivator;

public class StatechartAppearancePreferencePage extends
		FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_REGION_BACKGROUND,
				"Region background color", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_REGION_LINE,
				"Region line color", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_STATE_BACKGROUND,
				"State background color", getFieldEditorParent()));
		addField(new ColorFieldEditor(
				StatechartPreferenceConstants.PREF_STATE_LINE,
				"State line color", getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
		new PreferenceInitializer().initializeDefaultPreferences();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return DiagramActivator.getDefault().getPreferenceStore();
	}
}
