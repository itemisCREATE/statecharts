/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.impl;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_PROJECT;

import java.io.File;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * abstract base class for all code generators using Xpand as the template
 * language.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractXpandBasedCodeGenerator extends
		AbstractSExecModelGenerator {

	public abstract String getTemplatePath();

	/**
	 * Invokes XPands template engine to generate resources
	 */
	@Override
	protected final void generate(ExecutionFlow flow, GeneratorEntry entry) {
		Output output = createOutput(entry);
		XpandExecutionContext context = createXpandContext(output);
		XpandFacade facade = XpandFacade.create(context);
		facade.evaluate(getTemplatePath(), flow, entry);
		// refresh the project to get external updates:
		IProject project = getTargetProject(entry);
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private IProject getTargetProject(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		String projectName = outletConfig.getParameterValue(
				OUTLET_FEATURE_TARGET_PROJECT).getValue();
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);
		if (!project.exists()) {
			createProject(project, entry);
		}
		return project;
	}

	/**
	 * The default implementation only creates a new default project. Clients
	 * may override if they want to contribute generatorspecific project setup
	 */
	protected void createProject(IProject project, GeneratorEntry entry) {
		try {
			NullProgressMonitor monitor = new NullProgressMonitor();
			project.create(monitor);
			project.open(monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected XpandExecutionContext createXpandContext(Output output) {
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null, Collections.<String, Variable> emptyMap(), null,
				null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { SGraphPackage.eINSTANCE,
						StextPackage.eINSTANCE, EcorePackage.eINSTANCE,
						SexecPackage.eINSTANCE, SGenPackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		return execCtx;
	}

	protected Output createOutput(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		FeatureParameterValue targetFolder = outletConfig
				.getParameterValue(OUTLET_FEATURE_TARGET_FOLDER);

		String absoluteTargetFolder = getTargetProject(entry).getLocation()
				.toOSString() + File.separator + targetFolder.getValue();
		Output output = new OutputImpl();
		Outlet outlet = new Outlet(absoluteTargetFolder);
		outlet.setOverwrite(true);
		output.addOutlet(outlet);
		return output;
	}

	protected FeatureConfiguration getOutletFeatureConfiguration(
			GeneratorEntry entry) {
		FeatureConfiguration outletConfig = entry
				.getFeatureConfiguration(OUTLET_FEATURE);
		return outletConfig;
	}
}
