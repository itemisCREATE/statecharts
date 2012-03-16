package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.generator.genmodel.ui.wizard.XpandGeneratorWizardPage1.KeyListenerAdapter;
import org.yakindu.sct.generator.genmodel.ui.wizard.XpandGeneratorWizardPage1.SelectionListenerAdapter;

public class GeneratorComposite extends Composite {

	// (ID::)+ID
	private static final String GENERATOR_ID_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*::)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$
	private static final String GENERATOR_CLASS_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$

	public static interface ValidateCallback {
		void validate();

		public static final ValidateCallback NULL = new ValidateCallback() {
			public void validate() {
			}
		};
	}

	private Button cbGenerator;
	private Group generatorGroup;
	private Text txtGeneratorId;
	private Text txtGeneratorName;
	private Text txtGeneratorClass;
	private Text txtGeneratorDesc;
	private Button cbLibrary;

	private final ValidateCallback callback;

	private final KeyListenerAdapter textBoxListener = new KeyListenerAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			callback.validate();
		}
	};
	private Label lblGeneratorClass;

	public GeneratorComposite(Composite parent, int style,
			ValidateCallback callback) {
		super(parent, style);
		if (callback != null)
			this.callback = callback;
		else
			this.callback = ValidateCallback.NULL;

		Composite generatorCheckboxGroup = this;
		generatorCheckboxGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false, 1, 1));
		generatorCheckboxGroup.setLayout(new GridLayout(2, false));

		Label lblGeneratorCheckBox = new Label(generatorCheckboxGroup, SWT.WRAP);
		lblGeneratorCheckBox.setText("Configure for Plugin Export");
		cbGenerator = new Button(generatorCheckboxGroup, SWT.CHECK);
		cbGenerator.addSelectionListener(new SelectionListenerAdapter() {

			public void widgetSelected(SelectionEvent e) {
				setGroupEnabled(cbGenerator.getSelection());
				GeneratorComposite.this.callback.validate();
			}
		});

		generatorGroup = new Group(parent, SWT.NONE);
		generatorGroup.setLayout(new GridLayout(2, false));
		generatorGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		Label lblGeneratorId = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorId.setText("Generator Id:");

		txtGeneratorId = new Text(generatorGroup, SWT.SINGLE | SWT.BORDER);
		txtGeneratorId.setText("custom::sctGenerator");
		txtGeneratorId.addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(txtGeneratorId);

		Label lblGeneratorName = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorName.setText("Generator name:");

		setTxtGeneratorName(new Text(generatorGroup, SWT.SINGLE | SWT.BORDER));
		getTxtGeneratorName().addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(getTxtGeneratorName());

		lblGeneratorClass = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorClass.setText("Generator class:");

		setTxtGeneratorClass(new Text(generatorGroup, SWT.SINGLE | SWT.BORDER));
		getTxtGeneratorClass().addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(getTxtGeneratorClass());

		Label lblGeneratorDesc = new Label(generatorGroup, SWT.WRAP);
		lblGeneratorDesc.setText("Generator description:");

		setTxtGeneratorDesc(new Text(generatorGroup, SWT.SINGLE | SWT.BORDER));
		getTxtGeneratorDesc().addKeyListener(textBoxListener);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(getTxtGeneratorDesc());

		Label lblLibraryCheckBox = new Label(generatorGroup, SWT.WRAP);
		lblLibraryCheckBox.setText("Create Feature Library");

		cbLibrary = new Button(generatorGroup, SWT.CHECK);

	}

	public void disableGeneratorClass() {
		lblGeneratorClass.setVisible(false);
		txtGeneratorClass.setVisible(false);
	}

	public void setGroupEnabled(boolean enabled) {
		generatorGroup.setEnabled(enabled);
		txtGeneratorId.setEnabled(enabled);
		getTxtGeneratorName().setEnabled(enabled);
		getTxtGeneratorDesc().setEnabled(enabled);
		getTxtGeneratorClass().setEnabled(enabled);
		cbLibrary.setEnabled(enabled);
	}

	public boolean isGenerateLibrary() {
		return cbLibrary.getSelection();
	}

	public boolean isGeneratePlugin() {
		return cbGenerator.getSelection();
	}

	public Text getTxtGeneratorId() {
		return txtGeneratorId;
	}

	public void setTxtGeneratorId(Text txtGeneratorId) {
		this.txtGeneratorId = txtGeneratorId;
	}

	public Text getTxtGeneratorName() {
		return txtGeneratorName;
	}

	public void setTxtGeneratorName(Text txtGeneratorName) {
		this.txtGeneratorName = txtGeneratorName;
	}

	public Text getTxtGeneratorClass() {
		return txtGeneratorClass;
	}

	public void setTxtGeneratorClass(Text txtGeneratorClass) {
		this.txtGeneratorClass = txtGeneratorClass;
	}

	public Text getTxtGeneratorDesc() {
		return txtGeneratorDesc;
	}

	public void setTxtGeneratorDesc(Text txtGeneratorDesc) {
		this.txtGeneratorDesc = txtGeneratorDesc;
	}

	/**
	 * 
	 * @return the error message or null, if no error occur.
	 */
	public String validate() {
		if (isGeneratePlugin()) {
			if (getTxtGeneratorId().getText().isEmpty()) {
				return "Generator Id must be set";
			}
			if (!getTxtGeneratorId().getText().matches(GENERATOR_ID_REGEX)) {
				return "Invalid Generator Id";
			}
			if (getTxtGeneratorName().getText().isEmpty()) {
				return "Generator name must be set";
			}
			if (txtGeneratorClass.isVisible()) {
				if (getTxtGeneratorClass().getText().isEmpty()) {
					return "Generator class must be set";
				}
				if (!getTxtGeneratorClass().getText().matches(
							GENERATOR_CLASS_REGEX)) {
					return "Generator class must be a full qualified java identifier";
				}
			}
		}
		return null;
	}
}
