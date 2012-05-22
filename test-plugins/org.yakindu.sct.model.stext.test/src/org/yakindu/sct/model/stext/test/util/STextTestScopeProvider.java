/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.util;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.scoping.STextScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextTestScopeProvider extends STextScopeProvider {

	private static final SGraphFactory factory = SGraphFactory.eINSTANCE;

	@Inject
	private IQualifiedNameProvider qfnProvider;

	public IScope getScope(EObject context, EReference reference) {
		IScope parentScope = super.getScope(context, reference);

		State dummyState = createDummyModel();
		IEObjectDescription desc = new EObjectDescription(
				qfnProvider.getFullyQualifiedName(dummyState), dummyState,
				new HashMap<String, String>());
		List<IEObjectDescription> descriptions = Lists.newArrayList(parentScope
				.getAllElements());
		descriptions.add(desc);
		return new SimpleScope(descriptions);

	}

	private State createDummyModel() {
		Statechart statechart = factory.createStatechart();
		statechart.setName("chart");
		Region region = factory.createRegion();
		region.setName("r1");
		statechart.getRegions().add(region);
		State state = factory.createState();
		state.setName("A");
		region.getVertices().add(state);
		return state;
	}

}
