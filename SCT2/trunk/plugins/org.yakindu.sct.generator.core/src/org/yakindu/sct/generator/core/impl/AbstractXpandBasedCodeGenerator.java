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

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.util.GeneratorUtils.getOutletFeatureConfiguration;
import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;
import static org.yakindu.sct.generator.core.util.GeneratorUtils.refreshTargetProject;

import java.io.File;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
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

	public static final String CONTEXT_INJECTOR_PROPERTY_NAME = "AbstractXpandBasedCodeGenerator.Injector";

	public abstract String getTemplatePath();

	/**
	 * Invokes XPands template engine to generate resources
	 */
	public final void runGenerator(Statechart statechart, GeneratorEntry entry) {
		Output output = createOutput(entry);

		String templatePath = getTemplatePath();

		writeToConsole("Executing Template " + templatePath);
		XpandExecutionContext context = createXpandContext(entry, output);
		XpandFacade facade = XpandFacade.create(context);

		// Check, if method exists
		boolean generatorFound = false;
		Type targetType = context.getTypeForName("sexec::ExecutionFlow");
		final Type[] paramTypes = new Type[1];
		paramTypes[0] = context.getType(entry);
		if (context.findDefinition(templatePath, targetType, paramTypes) != null) {
			generatorFound = true;
			ExecutionFlow flow = createExecutionFlow(statechart, entry);
			if (isDumpSexec(entry)) {
				dumpSexec(entry, flow, output);
			}
			facade.evaluate(templatePath, flow, entry);
		}

		targetType = context.getTypeForName("sgraph::Statechart");
		if (context.findDefinition(templatePath, targetType, paramTypes) != null) {
			generatorFound = true;
			facade.evaluate(templatePath, statechart, entry);
		}
		if (!generatorFound) {
			writeToConsole("!!! No matching define in Template found.");
		}

		// refresh the project to get external updates:
		refreshTargetProject(entry);
	}

	protected XpandExecutionContext createXpandContext(GeneratorEntry entry,
			Output output) {
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null, null, null, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { SGraphPackage.eINSTANCE,
						StextPackage.eINSTANCE, EcorePackage.eINSTANCE,
						SexecPackage.eINSTANCE, SGenPackage.eINSTANCE,
						TypesPackage.eINSTANCE, BasePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		execCtx.getGlobalVariables()
				.put(CONTEXT_INJECTOR_PROPERTY_NAME,
						new Variable(CONTEXT_INJECTOR_PROPERTY_NAME,
								getInjector(entry)));
		return execCtx;
	}

	protected Output createOutput(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		FeatureParameterValue targetFolder = outletConfig
				.getParameterValue(OUTLET_FEATURE_TARGET_FOLDER);

		String absoluteTargetFolder = getTargetProject(entry).getLocation()
				.toOSString() + File.separator + targetFolder.getExpression().toString();
		Output output = new OutputImpl();
		Outlet outlet = new Outlet(absoluteTargetFolder);
		for (PostProcessor postProcessor : getPostProcessors()) {
			outlet.addPostprocessor(postProcessor);
		}
		outlet.setOverwrite(true);
		output.addOutlet(outlet);
		return output;
	}

	/**
	 * Override this Method to add some {@link PostProcessor}s to the XPand
	 * outlet.
	 * 
	 * @return An empty {@link Set} for {@link PostProcessor}s
	 */
	protected Set<PostProcessor> getPostProcessors() {
		return Collections.emptySet();
	}

}
