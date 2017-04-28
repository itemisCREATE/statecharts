/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.container;

import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.AnnotationDefinition;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.simulation.core.sexec.launch.ISCTLaunchParameters;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.SRuntimeFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultSimulationEngineFactory implements ISimulationEngineFactory {

	private static final int DEFAULT_CYCLE_PERIOD = 200;
	private static final String CYCLE_BASED_ANNOTATION = "CycleBased";
	private static final String EVENT_DRIVEN_ANNOTATION = "EventDriven";
	@Inject
	private Injector injector;
	@Inject
	private IStatementInterpreter interpreter;

	public ISimulationEngine createExecutionContainer(Statechart statechart, ILaunch launch) throws CoreException {
		ISimulationEngine controller = createController(statechart);
		injector.injectMembers(controller);

		// For restoring execution context
		String attribute = launch.getLaunchConfiguration().getAttribute(ISCTLaunchParameters.EXECUTION_CONTEXT, "");
		if (attribute != null && attribute.trim().length() > 0) {
			ExecutionContext context = restore(attribute, statechart);
			controller.setExecutionContext(context);
		}

		return controller;
	}

	protected ISimulationEngine createController(Statechart statechart) throws CoreException {
		AnnotationDefinition cycleBased = (AnnotationDefinition) statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION);
		AnnotationDefinition eventDriven = (AnnotationDefinition) statechart
				.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		if (cycleBased != null) {
			Long result = (Long) interpreter.evaluateStatement(cycleBased.getArgs().get(0),
					SRuntimeFactory.eINSTANCE.createExecutionContext());
			return new CycleBasedSimulationEngine(statechart, result);
		}
		if (eventDriven != null) {
			return new EventDrivenSimulationEngine(statechart);
		}
		return new CycleBasedSimulationEngine(statechart, DEFAULT_CYCLE_PERIOD);
	}

	protected ExecutionContext restore(String context, Statechart statechart) {
		try {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.createResource(URI.createURI("snapshot.xmi"));
			if (resource == null)
				return null;
			set.getResources().add(resource);
			resource.load(new URIConverter.ReadableInputStream(context, "UTF_8"), Collections.emptyMap());
			IDomain domain = DomainRegistry.getDomain(statechart);
			Injector injector = domain.getInjector(IDomain.FEATURE_SIMULATION);
			ITypeSystem typeSystem = injector.getInstance(ITypeSystem.class);
			if (typeSystem instanceof AbstractTypeSystem) {
				set.getResources().add(((AbstractTypeSystem) typeSystem).getResource());
			}
			EcoreUtil.resolveAll(resource);
			ExecutionContext result = (ExecutionContext) resource.getContents().get(0);
			result.setSnapshot(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
