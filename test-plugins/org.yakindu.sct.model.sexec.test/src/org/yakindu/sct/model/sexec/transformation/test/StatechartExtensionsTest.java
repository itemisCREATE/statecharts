/**
 * Copyright (c) 2017-2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.ExtensionTestModels;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

import com.google.inject.Inject;

/**
 * @author rbeckmann
 * @author terfloth
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class StatechartExtensionsTest {
	@Inject protected StatechartExtensions statechartExtensions;
	
	@Test public void testmaxNumberOfParallelTimeEvents() {
		ExtensionTestModels models = new ExtensionTestModels();
		Statechart sc = ExtensionTestModels.loadStatechart(models.getModelDirectory() + ExtensionTestModels.PARALLEL_TIME_EVENTS);
		
		assertEquals(statechartExtensions.maxNumberOfParallelTimeEvents(sc), 6);
	}
	
	@Test public void testmaxNumberOfParallelTimeEvents_zero() {
		ExtensionTestModels models = new ExtensionTestModels();
		Statechart sc = ExtensionTestModels.loadStatechart(models.getModelDirectory() + ExtensionTestModels.NO_TIME_EVENTS);
		
		assertEquals(statechartExtensions.maxNumberOfParallelTimeEvents(sc), 0);
	}
	
	/**
	 * Regression test for issue #3086
	 */
	@Test public void testmaxNumberOfParallelTimeEvents_withRegionWithoutStates() {
		ExtensionTestModels models = new ExtensionTestModels();
		Statechart sc = ExtensionTestModels.loadStatechart(models.getModelDirectory() + ExtensionTestModels.REGION_WITHOUT_STATE);
		
		assertEquals(statechartExtensions.maxNumberOfParallelTimeEvents(sc), 0);
	}
}
