package org.yakindu.sct.model.sexec.transformation.test;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.ExtensionTestModels;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

import com.google.inject.Inject;

import static org.junit.Assert.*;

@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class StatechartExtensionsTest {
	@Inject protected StatechartExtensions statechartExtensions;
	
	@Test
	public void testmaxNumberOfParallelTimeEvents() {
		ExtensionTestModels models = new ExtensionTestModels();
		Statechart sc = ExtensionTestModels.loadStatechart(models.getModelDirectory() + ExtensionTestModels.PARALLEL_TIME_EVENTS);
		
		assertEquals(statechartExtensions.maxNumberOfParallelTimeEvents(sc), 6);
	}
}
