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
package org.yakindu.sct.simulation.ui.launch.tabs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaLaunchTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters;
import org.yakindu.sct.simulation.ui.SimulationImages;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartLaunchConfigurationTab extends JavaLaunchTab implements
		IStatechartLaunchParameters {

	private Text modelfile;
	private Text cyclePeriod;
	private Text operationClass;
	private Button btnSelect;
	private Button btnCycle;
	private Button btnEvent;

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayout(new GridLayout(1, true));
		createFileSelectionGroup(comp);
		new Label(comp, SWT.NONE);
	}

	private void createFileSelectionGroup(Composite comp) {
		createModelFileGroup(comp);
		createOperationClassGroup(comp);
		createExecutionTypeControls(comp);
		createCyclePeriodGroup(comp);
	}

	private void createOperationClassGroup(Composite parent) {
		Group propertyGroup = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(propertyGroup);
		propertyGroup.setText("Operation Class:");
		propertyGroup.setLayout(new GridLayout(2, false));
		operationClass = new Text(propertyGroup, SWT.BORDER);
		operationClass.addListener(SWT.Modify, new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(operationClass);
		btnSelect = new Button(propertyGroup, SWT.PUSH);
		btnSelect.setText("browse...");
		btnSelect.addListener(SWT.Selection, new UpdateListener());
	}

	private void createExecutionTypeControls(Composite parent) {
		Group propertyGroup = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(propertyGroup);
		propertyGroup.setText("Execution Type:");
		propertyGroup.setLayout(new GridLayout(1, true));
		btnCycle = new Button(propertyGroup, SWT.RADIO);
		btnCycle.setText("cycle based");
		btnCycle.addListener(SWT.Selection, new UpdateListener());
		btnCycle.addListener(SWT.Selection, new EnableStateListener());
		GridDataFactory.fillDefaults().applyTo(btnCycle);
		btnEvent = new Button(propertyGroup, SWT.RADIO);
		btnEvent.setText("event driven");
		btnEvent.addListener(SWT.Selection, new UpdateListener());
		btnCycle.addListener(SWT.Selection, new EnableStateListener());
		GridDataFactory.fillDefaults().applyTo(btnEvent);
	}

	private void createCyclePeriodGroup(Composite parent) {
		Group propertyGroup = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(propertyGroup);
		propertyGroup.setText("Cycle Period:");
		propertyGroup.setLayout(new GridLayout(2, false));
		cyclePeriod = new Text(propertyGroup, SWT.BORDER);
		cyclePeriod.addListener(SWT.Modify, new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(cyclePeriod);
		Label lblMs = new Label(propertyGroup, SWT.NONE);
		lblMs.setText("ms");
		GridDataFactory.fillDefaults().applyTo(lblMs);
	}

	private void createModelFileGroup(Composite comp) {
		Group fileGroup = new Group(comp, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(fileGroup);
		fileGroup.setText("Model file:");
		fileGroup.setLayout(new GridLayout(2, false));

		modelfile = new Text(fileGroup, SWT.BORDER);
		modelfile.addListener(SWT.Modify, new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(modelfile);

		Button browse = new Button(fileGroup, SWT.NONE);
		browse.setText("Search");
		browse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(
						getShell(), ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				dialog.setTitle("Select Statechart model");
				dialog.setMessage("Please select the YAKINDU statechart model file you want to execute.");
				if (dialog.open() == 0) {
					Object[] files = dialog.getResult();
					IFile file = (IFile) files[0];
					modelfile.setText((file.getFullPath().toString()));
				}
			}
		});
		GridDataFactory.fillDefaults().applyTo(browse);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			modelfile.setText(configuration.getAttribute(FILE_NAME,
					DEFAULT_FILE_NAME));
			cyclePeriod.setText(String.valueOf(configuration.getAttribute(
					CYCLE_PERIOD, DEFAULT_CYCLE_PERIOD)));
			btnCycle.setSelection(configuration.getAttribute(IS_CYCLE_BASED,
					DEFAULT_IS_CYCLE_BASED));
			btnEvent.setSelection(configuration.getAttribute(IS_EVENT_DRIVEN,
					DEFAULT_IS_EVENT_DRIVEN));
			cyclePeriod.setEnabled(btnCycle.getSelection());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(FILE_NAME, modelfile.getText());
		configuration.setAttribute(OPERATION_CLASS, operationClass.getText());
		if (isCyclePeriodValid()) {
			configuration.setAttribute(CYCLE_PERIOD, getCyclePeriod());
		}
		configuration.setAttribute(IS_CYCLE_BASED, btnCycle.getSelection());
		configuration.setAttribute(IS_EVENT_DRIVEN, btnEvent.getSelection());
	}

	private int getCyclePeriod() {
		return Integer.parseInt(cyclePeriod.getText());
	}

	public String getName() {
		return "Main";
	}

	@Override
	public Image getImage() {
		return SimulationImages.LAUNCHER_ICON.image();
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setMessage(null);
		setErrorMessage(null);
		String model = this.modelfile.getText().trim();
		if (model.length() > 0)
			if (ResourcesPlugin.getWorkspace().getRoot().findMember(model) == null) {
				setErrorMessage("file " + model + " does not exist!");
				return false;
			}
		String cyclePeriod = this.cyclePeriod.getText();
		if (cyclePeriod.length() == 0) {
			setErrorMessage("Empty cycle period!");
			return false;
		} else if (!isCyclePeriodValid()) {
			setErrorMessage("Cycle Period must be a number!");
			return false;
		}
		return super.isValid(launchConfig);
	}

	private boolean isCyclePeriodValid() {
		try {
			getCyclePeriod();
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	private class EnableStateListener implements Listener {
		public void handleEvent(Event event) {
			cyclePeriod.setEnabled(btnCycle.getSelection());
		}
	}

	private class UpdateListener implements Listener {

		public void handleEvent(Event event) {
			StatechartLaunchConfigurationTab.this
					.updateLaunchConfigurationDialog();
		}

	}

}
