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
package org.yakindu.sct.simulation.ui.sexec.launch.tabs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
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
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.simulation.core.sexec.launch.ISCTLaunchParameters;
import org.yakindu.sct.simulation.ui.SimulationImages;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartLaunchConfigurationTab extends JavaLaunchTab implements ISCTLaunchParameters {


	public static final String LAUNCH_TAB_ID = "org.yakindu.sct.simulation.sexec.launchTab";
	
	
	private Text modelfile;
	private Text cyclePeriod;
	private Text operationClass;
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
		propertyGroup.setLayout(new GridLayout(1, false));
		operationClass = new Text(propertyGroup, SWT.BORDER);
		operationClass.addListener(SWT.Modify, new UpdateListener());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(operationClass);
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
				ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(),
						getStatechartResources()) {
					@Override
					protected String adjustPattern() {
						String pattern = super.adjustPattern();
						if (pattern.equals("")) {
							return "*";
						}
						return pattern;
					}
				};
				dialog.setTitle("Select Statechart model");
				dialog.setMessage("Please select the YAKINDU statechart model file you want to execute.");
				if (dialog.open() == 0) {
					Object[] files = dialog.getResult();
					IFile file = (IFile) files[0];
					modelfile.setText((file.getFullPath().toString()));
				}
			}

			private IResource[] getStatechartResources() {
				final List<IResource> resources = new ArrayList<IResource>();
				try {
					ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceVisitor() {
						public boolean visit(IResource resource) throws CoreException {
							if ("sct".equalsIgnoreCase(resource.getFileExtension())) {
								resources.add(resource);
							}
							return true;
						}
					});
				} catch (CoreException e) {
					e.printStackTrace();
				}
				return resources.toArray(new IResource[0]);
			}
		});
		GridDataFactory.fillDefaults().applyTo(browse);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			modelfile.setText(configuration.getAttribute(FILE_NAME, DEFAULT_FILE_NAME));
			operationClass.setText(configuration.getAttribute(OPERATION_CLASS, DEFAULT_OPERATION_CLASS));
			cyclePeriod.setText(String.valueOf(configuration.getAttribute(CYCLE_PERIOD, DEFAULT_CYCLE_PERIOD)));
			btnCycle.setSelection(configuration.getAttribute(IS_CYCLE_BASED, DEFAULT_IS_CYCLE_BASED));
			btnEvent.setSelection(configuration.getAttribute(IS_EVENT_DRIVEN, DEFAULT_IS_EVENT_DRIVEN));
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

	protected Set<String> getOperationClasses() {
		String operationClasses = this.operationClass.getText();
		Set<String> result = new HashSet<String>();
		if (operationClasses.trim().length() > 0) {
			String[] split = operationClasses.split(",");
			for (String string : split) {
				result.add(string.trim());
			}
		}
		return result;
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
		Set<String> operationClasses = getOperationClasses();
		if (operationClasses.size() > 0) {
			for (String clazz : operationClasses) {
				// check if class exists
				IProject project = ResourcesPlugin.getWorkspace().getRoot().findMember(model).getProject();
				if (project != null) {
					ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(project, getClass()
							.getClassLoader());
					try {
						Class<?> loadClass = classLoader.loadClass(clazz);
						loadClass.newInstance();
					} catch (ClassNotFoundException e) {
						setErrorMessage("Class " + clazz + " not found in project " + project.getName() + "!");
						return false;
					} catch (InstantiationException e) {
						setErrorMessage("Could not instantiate class " + clazz
								+ "! (No default constructor available?) ");
						return false;
					} catch (IllegalAccessException e) {
						setErrorMessage("Could not access class constructor for class" + clazz + "!");
						return false;
					}
				}
			}
		}
		// check for default c'tor
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
	
	
	

	@Override
	public String getId() {
		return LAUNCH_TAB_ID;
	}




	private class EnableStateListener implements Listener {
		public void handleEvent(Event event) {
			cyclePeriod.setEnabled(btnCycle.getSelection());
		}
	}

	private class UpdateListener implements Listener {

		public void handleEvent(Event event) {
			StatechartLaunchConfigurationTab.this.updateLaunchConfigurationDialog();
		}

	}

}
