/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.preferences;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.examples.wizard.ExampleActivator;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExamplesPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	protected static class StorageLocationFieldEditor extends DirectoryFieldEditor {

		public StorageLocationFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
			setEmptyStringAllowed(false);
			setErrorMessage("Storage location must not be empty.");
		}

		/**
		 * Checks only if the input text is not empty, but not if the directory
		 * exists as in that case it will be created by the example wizard.
		 */
		@Override
		protected boolean doCheckState() {
			String fileName = getTextControl().getText();
			fileName = fileName.trim();
			if (fileName.length() == 0 && !isEmptyStringAllowed()) {
				return false;
			}
			return true;
		}

	};

	public ExamplesPreferencePage() {
		super(GRID);
		setDescription("Examples Preference Page");
	}

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		addFields(parent);
	}

	protected void addFields(Composite main) {
		addField(new StorageLocationFieldEditor(ExamplesPreferenceConstants.STORAGE_LOCATION, "Storage Location:",
				main));
		separator();
		StringFieldEditor remoteLocationEditor = new StringFieldEditor(ExamplesPreferenceConstants.REMOTE_LOCATION,
				"Remote Location", main);
		remoteLocationEditor.getTextControl(main).setEditable(false);
		addField(remoteLocationEditor);
		separator();
		StringFieldEditor remoteBranchEditor = new StringFieldEditor(ExamplesPreferenceConstants.REMOTE_BRANCH,
				"Remote Branch:", main);
		addField(remoteBranchEditor);
	}

	private void separator() {
		Label label = new Label(getFieldEditorParent(), SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(ExampleActivator.getDefault().getPreferenceStore());
	}

}
