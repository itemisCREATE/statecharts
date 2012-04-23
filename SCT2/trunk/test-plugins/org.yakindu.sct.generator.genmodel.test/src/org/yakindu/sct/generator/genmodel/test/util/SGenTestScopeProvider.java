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
package org.yakindu.sct.generator.genmodel.test.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.yakindu.sct.generator.genmodel.scoping.SGenScopeProvider;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Adds an example Statechart to scope
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenTestScopeProvider extends SGenScopeProvider {

	@Inject
	private XtextResource resource;

	@Override
	protected IScope scope_GeneratorEntry_elementRef(EObject context,
			EReference reference) {
		return Scopes.scopeFor(Lists.newArrayList(createDummyModel()));

	}

	private Statechart createDummyModel() {
		Statechart chart = SGraphFactory.eINSTANCE.createStatechart();
		chart.setName("Example");
		resource.getContents().add(chart);
		return chart;
	}

}
