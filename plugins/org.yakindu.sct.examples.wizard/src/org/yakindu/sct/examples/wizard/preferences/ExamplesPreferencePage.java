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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.yakindu.sct.examples.wizard.ExampleActivator;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExamplesPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static class StorageLocationFieldEditor extends DirectoryFieldEditor {
		
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

	protected void addFields(Composite parent) {
		Composite main = createPageLayout(parent);
		createStorageLocationEditor(main);
	}

	private void createStorageLocationEditor(Composite main) {
		Composite composite = createGroupComposite(main, "Storage Location");
		addField(new StorageLocationFieldEditor(ExamplesPreferenceConstants.STORAGE_LOCATION,
				"Storage Location:", composite));
	}

	protected Composite createPageLayout(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		return main;
	}

	protected Composite createGroupComposite(Composite parent, String title) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(3, false));
		Composite composite = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		composite.setLayoutData(gridData);
		group.setText(title);
		return composite;
	}

	public void init(IWorkbench workbench) {
		new ExamplesPreferenceInitializer().initializeDefaultPreferences();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return ExampleActivator.getDefault().getPreferenceStore();
	}
}
