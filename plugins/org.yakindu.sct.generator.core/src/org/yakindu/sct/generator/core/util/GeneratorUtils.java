/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.util;

import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.DEBUG_FEATURE;
import static org.yakindu.sct.generator.core.features.ISCTBaseFeatureConstants.DEBUG_FEATURE_DUMP_SEXEC;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public class GeneratorUtils {

	public static boolean getBoolValue(FeatureConfiguration conf, String param,
			boolean defaultValue) {
		if (conf != null && conf.getParameterValue(param) != null) {
			return conf.getParameterValue(param).getBooleanValue();
		}

		return defaultValue;
	}

	public static final void refreshTargetProject(GeneratorEntry entry) {
		try {
			IProject project = getTargetProject(entry);
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create an empty project if this project does not exist.
	 * 
	 * @param project
	 * @return true, if the project was created. false if it already exists.
	 */
	public static boolean createEmptyProject(IProject project) {
		if (!project.exists()) {
			try {
				NullProgressMonitor monitor = new NullProgressMonitor();
				project.create(monitor);
				project.open(monitor);
				return true;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Returns an IProject for the configured target project. The
	 * {@link IProject} is returned even if the project does not exist yet.
	 * 
	 * @param entry
	 * @return
	 */
	public static final IProject getTargetProject(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		String projectName = outletConfig.getParameterValue(
				OUTLET_FEATURE_TARGET_PROJECT).getStringValue();
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		return project;
	}

	/** Gets the target folder path as a File that includes the project location */
	public static File getTargetFolder(GeneratorEntry entry) {
		String targetFolder = getOutletFeatureConfiguration(entry)
				.getParameterValue(
						ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER)
				.getStringValue();
		return new File(getTargetProject(entry).getLocation().toFile()
				.getPath()
				+ File.separator + targetFolder);
	}

	public static FeatureConfiguration getOutletFeatureConfiguration(
			GeneratorEntry entry) {
		FeatureConfiguration outletConfig = entry
				.getFeatureConfiguration(OUTLET_FEATURE);
		return outletConfig;
	}

	public static boolean isDumpSexec(GeneratorEntry entry) {
		FeatureParameterValue dumpSexec = getFeatureParameter(entry,
				DEBUG_FEATURE, DEBUG_FEATURE_DUMP_SEXEC);
		if (dumpSexec == null) {
			return false;
		}
		return dumpSexec.getBooleanValue();
	}

	public static FeatureParameterValue getFeatureParameter(
			GeneratorEntry entry, String featureName, String paramName) {
		FeatureConfiguration feature = entry
				.getFeatureConfiguration(featureName);

		if (feature != null) {
			return feature.getParameterValue(paramName);
		}

		return null;
	}
}
