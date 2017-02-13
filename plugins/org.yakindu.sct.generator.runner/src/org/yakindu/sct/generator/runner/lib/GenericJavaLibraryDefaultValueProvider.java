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
package org.yakindu.sct.generator.runner.lib;

import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_CLASS;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_PROJECT;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.LIBRARY_NAME;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.yakindu.sct.generator.core.filesystem.ISCTWorkspaceAccess;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

import com.google.inject.Inject;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class GenericJavaLibraryDefaultValueProvider extends AbstractDefaultFeatureValueProvider {

	private static final String GENERATOR_CLASS_DEFAULT = "org.yakindu.sct.generator.Generator";
	
	private static final String CLASS_FORMAT_ERROR = "Generator class must be a full qualified class name";
	private static final String CLASS_NOT_FOUND_ERROR = "Generator class %s could not be found. Please make sure the generator project lies on this project's build path.";
	private static final String PROJECT_NOT_FOUND_ERROR = "Project %s does not exist";

	@Inject
	protected ISCTWorkspaceAccess access;
	
	// (ID.)+ID
	private static final String GENERATOR_CLASS_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*"; //$NON-NLS-1$

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {
		String parameterName = parameterValue.getParameter().getName();
		if (GENERATOR_PROJECT.equals(parameterName)) {
			parameterValue.setValue(getProject(contextElement).getName());
		} else if (GENERATOR_CLASS.equals(parameterName)) {
			parameterValue.setValue(GENERATOR_CLASS_DEFAULT);
		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		String parameterName = parameterValue.getParameter().getName();
		
		if (GENERATOR_PROJECT.equals(parameterName)) {
			return validateGeneratorProject(parameterValue);
		}
		if (GENERATOR_CLASS.equals(parameterName)) {
			return validateGeneratorClass(parameterValue);
		}
		return Status.OK_STATUS;
	}
	
	private IStatus validateGeneratorProject(FeatureParameterValue parameterValue) {
		String value = parameterValue.getStringValue();
		if (!access.projectExists(value)) {
			return error(String.format(PROJECT_NOT_FOUND_ERROR, value));
		}
		return Status.OK_STATUS;
	}

	private IStatus validateGeneratorClass(FeatureParameterValue parameterValue) {
		String value = parameterValue.getStringValue();
		IJavaProject ijp = JavaCore.create(this.getProject(parameterValue));
		try {
			if (ijp.findType(value) == null) {
				return error(String.format(CLASS_NOT_FOUND_ERROR, value));
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (!value.matches(GENERATOR_CLASS_REGEX)) {
			return error(CLASS_FORMAT_ERROR);
		}
		return Status.OK_STATUS;
	}

	protected IProject getProject(EObject contextElement) {
		return WorkspaceSynchronizer.getFile(contextElement.eResource()).getProject();
	}
}