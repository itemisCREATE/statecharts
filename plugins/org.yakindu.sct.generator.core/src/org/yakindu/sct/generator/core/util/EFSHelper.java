/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
import org.yakindu.sct.generator.core.library.OutletFeatureHelperImpl;
import org.yakindu.sct.model.sgen.GeneratorEntry;

//FIXME !!! integrate dependent classes with SCTFileSystemAccess?!
/**
 * NOTE : dependent classes are not useable in headless context
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class EFSHelper {

	public void refreshTargetProject(GeneratorEntry entry) {
		if (Platform.isRunning()) {

			try {
				IProject project = getTargetProject(entry);
				if (project != null && project.isAccessible())
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Returns an IProject for the configured target project. The
	 * {@link IProject} is returned even if the project does not exist yet.
	 * 
	 * @param entry
	 * @return
	 */
	public IProject getTargetProject(GeneratorEntry entry) {
		String stringValue = new OutletFeatureHelperImpl().getTargetProjectValue(entry).getStringValue();
		if (Platform.isRunning()) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(stringValue);
			return project;
		} else
			throw new IllegalStateException("The " + AbstractXpandBasedCodeGenerator.class.getSimpleName()
					+ " needs a running eclipse.Platform");
	}

}
