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
package org.yakindu.sct.statechart.core.resource.factory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.statechart.core.resource.services.StateInjectionService;
import org.yakindu.sct.statechart.core.resource.services.StatechartInjectionService;
import org.yakindu.sct.statechart.core.resource.services.TransitionInjectionService;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * ResourceFactory for the {@link InjectMembersResource} with services for the
 * statechart model.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersResourceFactory extends XMIResourceFactoryImpl {

	@Inject
	TransitionInjectionService transitionService;
	@Inject
	StateInjectionService stateService;
	@Inject
	StatechartInjectionService statechartService;

	@Override
	public Resource createResource(URI uri) {
		InjectMembersResource resource = new InjectMembersResource(uri);
		resource.getServices().add(transitionService);
		resource.getServices().add(stateService);
		resource.getServices().add(statechartService);
		return resource;
	}
}
