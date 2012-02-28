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
package org.yakindu.sct.model.stext.resource.factory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.Constants;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.resource.SGraphInjectMembersResource;
import org.yakindu.sct.model.stext.resource.services.StateInjectionService;
import org.yakindu.sct.model.stext.resource.services.StatechartInjectionService;
import org.yakindu.sct.model.stext.resource.services.TransitionInjectionService;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;

/**
 * ResourceFactory for the {@link InjectMembersResource} with services for the
 * statechart model.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersResourceFactory extends XMIResourceFactoryImpl {

	@Inject
	private TransitionInjectionService transitionService;
	@Inject
	private StateInjectionService stateService;
	@Inject
	private StatechartInjectionService statechartService;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	Injector injector;

	@Override
	public Resource createResource(URI uri) {
		final InjectMembersResource resource = new SGraphInjectMembersResource(
				uri);
		injector.injectMembers(resource);
		resource.getServices().add(transitionService);
		resource.getServices().add(stateService);
		resource.getServices().add(statechartService);
		resource.setLanguageName(languageName);
		resource.eAdapters().add(
				new ContextElementAdapter(new IContextElementProvider() {
					public EObject getContextObject() {
						return (EObject) EcoreUtil.getObjectByType(
								resource.getContents(),
								SGraphPackage.Literals.STATECHART);
					}
				}));
		return resource;
	}
}
