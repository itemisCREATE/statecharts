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
package org.yakindu.sct.ui.simulation.launch.tabs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaLaunchTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartLaunchConfigurationTab extends JavaLaunchTab implements
		IStatechartLaunchParameters {

	private Image image;
	private Text modelfile;
	private Button btnYacopEnabled;
	private Text port;

	public StatechartLaunchConfigurationTab() {
		image = new Image(Display.getDefault(), getClass().getClassLoader()
				.getResourceAsStream("icons/yakindu.png"));
	}

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayout(new GridLayout(1, true));
		createFileSelectionGroup(comp);
		new Label(comp, SWT.NONE);
		createYacopGroup(comp);
	}

	private void createYacopGroup(Composite comp) {
		Group yacopGroup = new Group(comp, SWT.NONE);
		yacopGroup.setText("YAKINDU Communication Protocol:");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(yacopGroup);
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 15;
		yacopGroup.setLayout(layout);

		btnYacopEnabled = new Button(yacopGroup, SWT.CHECK);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0)
				.applyTo(btnYacopEnabled);
		btnYacopEnabled.setText("enable protocol");
		btnYacopEnabled.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				port.setEnabled(!port.getEnabled());
				updateLaunchConfigurationDialog();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}
		});

		Label label = new Label(yacopGroup, SWT.NONE);
		label.setText("socket server port: ");
		GridDataFactory.fillDefaults().grab(false, false).applyTo(label);

		port = new Text(yacopGroup, SWT.BORDER);
		port.addModifyListener(new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(port);

	}

	private void createFileSelectionGroup(Composite comp) {
		Group fileGroup = new Group(comp, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(fileGroup);
		fileGroup.setText("Model file:");
		fileGroup.setLayout(new GridLayout(2, false));

		modelfile = new Text(fileGroup, SWT.BORDER);
		modelfile.addModifyListener(new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(modelfile);

		Button browse = new Button(fileGroup, SWT.NONE);
		browse.setText("Search");
		browse.addSelectionListener(new SelectionListener() {

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

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}
		});

		GridDataFactory.fillDefaults().applyTo(browse);

	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(YACOP_ENABLED, DEFAULT_YACOP_ENABLED);
		configuration.setAttribute(YACOP_PORT, DEFAULT_YACOP_PORT);
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			modelfile.setText(configuration.getAttribute(FILE_NAME,
					DEFAULT_FILE_NAME));
			btnYacopEnabled.setSelection(configuration.getAttribute(
					YACOP_ENABLED, DEFAULT_YACOP_ENABLED));
			if (btnYacopEnabled.getSelection()) {
				port.setEnabled(true);
			} else {
				port.setEnabled(false);
			}
			port.setText(configuration.getAttribute(YACOP_PORT,
					DEFAULT_YACOP_PORT));

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(FILE_NAME, modelfile.getText());
		configuration.setAttribute(YACOP_PORT, port.getText());
		configuration.setAttribute(YACOP_ENABLED,
				btnYacopEnabled.getSelection());
	}

	@Override
	public void dispose() {
		image.dispose();
		super.dispose();
	}

	public String getName() {
		return "Main";
	}

	@Override
	public Image getImage() {
		return image;
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
		// TODO: Add validation for port

		return super.isValid(launchConfig);
	}

	private class UpdateListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			StatechartLaunchConfigurationTab.this
					.updateLaunchConfigurationDialog();
		}

	}

}
