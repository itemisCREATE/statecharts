/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c.ide.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.mscript.codegen.c.ide.core.launch.CodegenLaunchConfigurationDelegate;
import org.eclipselabs.damos.mscript.codegen.c.ide.ui.CodegenCIDEUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class MainCodegenTab extends AbstractLaunchConfigurationTab {
	
	private static final String FILE_EXTENSION = "mscript";

	private Text filePathText;
	private Text functionNameText;
	private Text targetFunctionNameText;
	private Text templateArgumentsText;
	private Text inputParameterDataTypesText;
	private Text targetFolderPathText;
	private Text computationModelText;
	
	private final ModifyListener modifyListener = new ModifyListener() {
		
		public void modifyText(ModifyEvent event) {
			updateLaunchConfigurationDialog();
		}
		
	};
	
	/**
	 * 
	 */
	public MainCodegenTab() {
		setMessage("Create a configuration to launch an Mscript application.");
		setDirty(false);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		setControl(composite);
		
		new Label(composite, SWT.NONE).setText("Mscript file:");
		filePathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		filePathText.addModifyListener(modifyListener);
		filePathText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		Button browseButton = createPushButton(composite, "Browse...", null);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*." + FILE_EXTENSION);
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					filePathText.setText(((IFile) firstResult).getFullPath().toString());
				}
			}
		});
		
		new Label(composite, SWT.NONE).setText("Function:");
		functionNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		functionNameText.addModifyListener(modifyListener);
		functionNameText.setToolTipText("Qualified function name");
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		functionNameText.setLayoutData(gridData);

		new Label(composite, SWT.NONE).setText("Target function:");
		targetFunctionNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		targetFunctionNameText.addModifyListener(modifyListener);
		targetFunctionNameText.setToolTipText("Qualified target function name");
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		targetFunctionNameText.setLayoutData(gridData);

		new Label(composite, SWT.NONE).setText("Template arguments:");
		templateArgumentsText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		templateArgumentsText.addModifyListener(modifyListener);
		templateArgumentsText.setToolTipText("Comma-separated list of template arguments");
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		templateArgumentsText.setLayoutData(gridData);

		new Label(composite, SWT.NONE).setText("Input parameter data types:");
		inputParameterDataTypesText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		inputParameterDataTypesText.addModifyListener(modifyListener);
		inputParameterDataTypesText.setToolTipText("Comma-separated list of input parameter data types");
		gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.horizontalSpan = 2;
		inputParameterDataTypesText.setLayoutData(gridData);

		new Label(composite, SWT.NONE).setText("Target folder:");
		targetFolderPathText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		targetFolderPathText.addModifyListener(modifyListener);
		targetFolderPathText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		browseButton = createPushButton(composite, "Browse...", null);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog d = new ContainerSelectionDialog(
						composite.getShell(),
						ResourcesPlugin.getWorkspace().getRoot(),
						false,
						null);
				d.open();
				Object[] results = d.getResult();
				if (results != null && results.length > 0 && results[0] instanceof IPath) {
					targetFolderPathText.setText(((IPath) results[0]).toString()); 
				}
			}
		});

		new Label(composite, SWT.NONE).setText("Computation model:");
		computationModelText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		computationModelText.addModifyListener(modifyListener);
		computationModelText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		browseButton = createPushButton(composite, "Browse...", null);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						composite.getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*.computationmodel");
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					computationModelText.setText(((IFile) firstResult).getFullPath().toString());
				}
			}
		});
	}

	public String getName() {
		return "Main";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			filePathText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__FILE_PATH, ""));
			functionNameText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__FUNCTION_NAME, "Main"));
			targetFunctionNameText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FUNCTION_NAME, ""));
			inputParameterDataTypesText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES, ""));
			templateArgumentsText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TEMPLATE_ARGUMENTS, ""));
			targetFolderPathText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FOLDER_PATH, ""));
			computationModelText.setText(configuration.getAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__COMPUTATION_MODEL, ""));
		} catch (CoreException e) {
			CodegenCIDEUIPlugin.getDefault().getLog().log(e.getStatus());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String errorMessage = null;
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__FILE_PATH, filePathText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__FUNCTION_NAME, functionNameText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FUNCTION_NAME, targetFunctionNameText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES, inputParameterDataTypesText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TEMPLATE_ARGUMENTS, templateArgumentsText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FOLDER_PATH, targetFolderPathText.getText());
		configuration.setAttribute(CodegenLaunchConfigurationDelegate.ATTRIBUTE__COMPUTATION_MODEL, computationModelText.getText());
		setErrorMessage(errorMessage);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		IPath filePath = null;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = activePage.getActiveEditor();
		if (activeEditor != null) {
			IEditorInput editorInput = activeEditor.getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				IPath path = ((IFileEditorInput) editorInput).getFile().getFullPath();
				if (FILE_EXTENSION.equals(path.getFileExtension())) {
					filePath = path;
				}
			}
		}
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__FILE_PATH,
				filePath != null ? filePath.toString() : "");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__FUNCTION_NAME,
				"Main");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FUNCTION_NAME,
				"");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES,
				"");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__TEMPLATE_ARGUMENTS,
				"");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__TARGET_FOLDER_PATH,
				"");
		configuration.setAttribute(
				CodegenLaunchConfigurationDelegate.ATTRIBUTE__COMPUTATION_MODEL,
				"");
	}

}
