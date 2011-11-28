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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class XpandGeneratorWizardPage1 extends IProjectWzardPage {
	// (ID::)+ID
	private static final String GENERATOR_ID_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*::)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$
	private static final String GENERATOR_CLASS_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$
	// project will be an OSGI bundle, so there are some name restrictions
	private static final String PROJECT_REGEX = "[A-Za-z0-9\\._]+"; //$NON-NLS-1$
	private Group generatorGroup;
	private Text txtGeneratorDesc;
	private Text txtGeneratorId;
	private Button cbGenerator;
	private Text txtProjectName;
	private Button cbLibrary;
	private Text txtGeneratorName;
	private Text txtGeneratorClass;
	private final KeyListenerAdapter textBoxListener = new KeyListenerAdapter() {

		@Override
		public void keyReleased(KeyEvent e) {
			validate();
		}
	};

	protected XpandGeneratorWizardPage1(String pageName) {
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

		Composite generatorCheckboxGroup = new Composite(parent, SWT.NULL);
		generatorCheckboxGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false, 1, 1));
		generatorCheckboxGroup.setLayout(new GridLayout(2, false));

		Label lblGeneratorCheckBox = new Label(generatorCheckboxGroup, SWT.WRAP);
		lblGeneratorCheckBox.setText("Configure for Plugin Export");
		cbGenerator = new Button(generatorCheckboxGroup, SWT.CHECK);
		cbGenerator.addSelectionListener(new SelectionListenerAdapter() {

			public void widgetSelected(SelectionEvent e) {
				setGeneratorGroupEnabled(cbGenerator.getSelection());
				validate();
			}
		});

		generatorGroup = new Group(parent, SWT.NONE);
		generatorGroup.setLayout(new GridLayout(2, false));
		generatorGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		Label lblGeneratorId = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorId.setText("Generator Id:");

		txtGeneratorId = new Text(generatorGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorId.setText("custom::xpand");
		txtGeneratorId.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorId);

		Label lblGeneratorName = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorName.setText("Generator name:");

		txtGeneratorName = new Text(generatorGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorName.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorName);

		Label lblGeneratorClass = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorClass.setText("Generator class:");

		txtGeneratorClass = new Text(generatorGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorClass.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorClass);

		Label lblGeneratorDesc = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorDesc.setText("Generator description:");

		txtGeneratorDesc = new Text(generatorGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorDesc.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorDesc);

		Label lblLibraryCheckBox = new Label(generatorGroup, SWT.WRAP);
		lblLibraryCheckBox.setText("Create Feature Library");

		cbLibrary = new Button(generatorGroup, SWT.CHECK);

		setGeneratorGroupEnabled(false);
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
		if (generatorGroup.isEnabled()) {
			if (txtGeneratorId.getText().isEmpty()) {
				setErrorMessage("Generator Id must be set");
				return false;
			}
			if (!txtGeneratorId.getText().matches(GENERATOR_ID_REGEX)) {
				setErrorMessage("Invalid Generator Id");
				return false;
			}
			if (txtGeneratorName.getText().isEmpty()) {
				setErrorMessage("Generator name must be set");
				return false;
			}
			if (txtGeneratorClass.getText().isEmpty()) {
				setErrorMessage("Generator class must be set");
				return false;
			}
			if (!txtGeneratorClass.getText().matches(GENERATOR_CLASS_REGEX)) {
				setErrorMessage("Generator class must be a full qualified java identifier");
				return false;
			}
		}
		return true;
	}

	protected void setGeneratorGroupEnabled(boolean enabled) {
		generatorGroup.setEnabled(enabled);
		txtGeneratorId.setEnabled(enabled);
		txtGeneratorName.setEnabled(enabled);
		txtGeneratorDesc.setEnabled(enabled);
		txtGeneratorClass.setEnabled(enabled);
		cbLibrary.setEnabled(enabled);
	}

	@Override
	public ProjectData getProjectData() {
		ProjectData data = new ProjectData();
		data.generatorType = GeneratorType.Xpand;
		data.projectName = txtProjectName.getText().trim();
		data.generatorClass = txtGeneratorClass.getText().trim();
		data.generatorDescription = txtGeneratorDesc.getText().trim();
		data.generatorId = txtGeneratorId.getText().trim();
		data.generatorName = txtGeneratorName.getText().trim();
		data.pluginExport = cbGenerator.getSelection();
		data.typeLibrary = cbLibrary.getSelection();
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
