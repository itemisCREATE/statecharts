/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.test.util.SGraphTestInjectorProvider;
import org.yakindu.sct.model.stext.stext.StextFactory;

/**
 * Abstract base class for all Validator Tests
 *
 */
@SuppressWarnings("deprecation")
@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public abstract class AbstractSGraphValidatorTest {

	public static final String VALIDATION_TESTMODEL_DIR = "org.yakindu.sct.model.sgraph.test/testmodels/";

	protected SGraphFactory factory;
	protected StextFactory sTextFactory;

	@Before
	public void setUp() throws Exception {
		factory = SGraphFactory.eINSTANCE;
		sTextFactory = StextFactory.eINSTANCE;
	}

	protected State createState() {
		Region region = factory.createRegion();
		Statechart statechart = factory.createStatechart();
		statechart.getRegions().add(region);
		State state = factory.createState();
		region.getVertices().add(state);
		return state;
	}

	protected Transition createTransition(Vertex source, Vertex target) {
		Transition trans = factory.createTransition();
		trans.setSource(source);
		trans.setTarget(target);
		source.getOutgoingTransitions().add(trans);
		target.getIncomingTransitions().add(trans);
		return trans;
	}

	protected Statechart loadStatechart(String path) {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createPlatformPluginURI(VALIDATION_TESTMODEL_DIR + path, true),
				true);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(resource.getContents(),
				SGraphPackage.Literals.STATECHART);
		return statechart;
	}
}
