/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.generator.genmodel.ui.wizard.GeneratorComposite.ValidateCallback;
/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class WorkspaceGeneratorWizardPage1 extends IProjectWizardPage {
	private static final String GENERATOR_CLASS_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$
	// project will be an OSGI bundle, so there are some name restrictions
	private static final String PROJECT_REGEX = "[A-Za-z0-9\\._]+"; //$NON-NLS-1$
	private Text txtProjectName;
	private Text txtGeneratorClass;
	private Button cbXtend;
	private final KeyListenerAdapter textBoxListener = new KeyListenerAdapter() {

		@Override
		public void keyReleased(KeyEvent e) {
			validate();
		}
	};
	private GeneratorComposite generatorComposite;

	protected WorkspaceGeneratorWizardPage1(String pageName) {
		super(pageName);
	}

	public void createControl(Composite container) {
		Composite parent = new Composite(container, SWT.NULL);
		setControl(parent);
		parent.setLayout(new GridLayout(1, false));

		Composite projectNameGroup = new Composite(parent, SWT.NULL);
		projectNameGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));
		projectNameGroup.setLayout(new GridLayout(2, false));

		Label lblProjectName = new Label(projectNameGroup, SWT.WRAP);
		lblProjectName.setText("Project name:");
		txtProjectName = new Text(projectNameGroup, SWT.SINGLE | SWT.BORDER);
		txtProjectName.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtProjectName);

		Label lblGeneratorClass = new Label(projectNameGroup, SWT.WRAP);
		lblGeneratorClass.setText("Generator class:");

		txtGeneratorClass = new Text(projectNameGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorClass.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorClass);

		Composite generatorCheckboxGroup = new Composite(parent, SWT.NULL);
		generatorCheckboxGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false, 1, 1));
		generatorCheckboxGroup.setLayout(new GridLayout(2, false));

		cbXtend = new Button(generatorCheckboxGroup, SWT.CHECK);
		cbXtend.setText("Use Xtend");

		ValidateCallback callback = new ValidateCallback() {
			public void validate() {
				WorkspaceGeneratorWizardPage1.this.validate();
			}
		};
		generatorComposite = new GeneratorComposite(parent, SWT.NONE, callback);
		generatorComposite.disableGeneratorClass();

		generatorComposite.setGroupEnabled(false);

		setPageComplete(false);
	}

	protected final void validate() {
		setPageComplete(checkPageComplete());
	}

	protected boolean checkPageComplete() {
		boolean complete = checkProjectName() && checkGeneratorOptions();
		if (complete) {
			setErrorMessage(null);
		}
		return complete;
	}

	private boolean checkProjectName() {
		if (txtProjectName.getText().isEmpty()) {
			setErrorMessage("Project name must be set");
			return false;
		}
		if (!txtProjectName.getText().matches(PROJECT_REGEX)) {
			setErrorMessage("Invalid Project name");
			return false;
		}
		if (ResourcesPlugin.getWorkspace().getRoot()
				.getProject(txtProjectName.getText()).exists()) {
			setErrorMessage("Project already exists");
			return false;
		}
		return true;
	}

	private boolean checkGeneratorOptions() {
		if (txtGeneratorClass.getText().isEmpty()) {
			setErrorMessage("Generator class must be set");
			return false;
		}
		if (!txtGeneratorClass.getText().matches(GENERATOR_CLASS_REGEX)) {
			setErrorMessage("Generator class must be a full qualified java identifier");
			return false;
		}
		String message = generatorComposite.validate();
		if (message != null) {
			setErrorMessage(message);
			return false;
		}

		return true;
	}

	@Override
	public ProjectData getProjectData() {
		ProjectData data = new ProjectData();
		data.projectName = txtProjectName.getText().trim();
		data.generatorClass = txtGeneratorClass.getText().trim();
		data.generatorType = cbXtend.getSelection() ? GeneratorType.Xtend
				: GeneratorType.Java;
		data.generatorDescription = generatorComposite.getTxtGeneratorDesc()
				.getText().trim();
		data.generatorId = generatorComposite.getTxtGeneratorId().getText()
				.trim();
		data.generatorName = generatorComposite.getTxtGeneratorName().getText()
				.trim();
		data.pluginExport = generatorComposite.isGeneratePlugin();
		data.typeLibrary = generatorComposite.isGenerateLibrary();
		
		return data;
	}

	static abstract class SelectionListenerAdapter implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}
	}

	static abstract class KeyListenerAdapter implements KeyListener {

		public void keyPressed(KeyEvent e) {
			// empty
		}

		public void keyReleased(KeyEvent e) {
			// empty
		}

	}

}
