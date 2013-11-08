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
package org.yakindu.sct.simulation.ui.sexec.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.simulation.core.launch.ISCTLaunchConfigurationType;
import org.yakindu.sct.simulation.core.sexec.launch.ISCTLaunchParameters;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartLaunchShortcut implements ILaunchShortcut, ISCTLaunchConfigurationType, ISCTLaunchParameters {

	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			final Object object = structuredSelection.getFirstElement();
			if (object instanceof IAdaptable) {
				IFile file = (IFile) ((IAdaptable) object).getAdapter(IResource.class);
				launch(file, mode);
			}
		}
	}
	

	public void launch(IEditorPart editor, String mode) {
		IResource resource = (IResource) editor.getEditorInput().getAdapter(IResource.class);
		launch((IFile) resource, mode);
	}

	protected void launch(IFile file, String mode) {
		final ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType configType = launchManager.getLaunchConfigurationType(getConfigType());
		ILaunchConfiguration launchConfig = findLaunchConfiguration(configType, file);
		if (launchConfig != null) {
			DebugUITools.launch(launchConfig, mode);
		} else {
			ILaunchConfiguration launchConfiguration = createNewLaunchConfiguration(file);
			DebugUITools.launch(launchConfiguration, mode);
		}
	}

	protected String getConfigType() {
		return CONFIG_TYPE;
	}

	protected ILaunchConfiguration createNewLaunchConfiguration(IFile file) {
		final ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType configType = launchManager.getLaunchConfigurationType(getConfigType());
		try {
			ILaunchConfigurationWorkingCopy newConfig = configType.newInstance(null,
					launchManager.generateLaunchConfigurationName(file.getName()));

			newConfig.setAttribute(FILE_NAME, file.getFullPath().toString());
			return newConfig.doSave();

		} catch (CoreException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException();
	}

	protected ILaunchConfiguration findLaunchConfiguration(ILaunchConfigurationType configType, IFile file) {
		ILaunchConfiguration[] configs;
		try {
			configs = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations(configType);
			for (ILaunchConfiguration config : configs) {
				String attribute = config.getAttribute(FILE_NAME, "");
				if (attribute.equals(file.getFullPath().toString())) {
					return config;
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

}
