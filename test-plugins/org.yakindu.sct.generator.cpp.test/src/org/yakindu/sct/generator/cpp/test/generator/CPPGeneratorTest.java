package org.yakindu.sct.generator.cpp.test.generator;

import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static org.junit.Assert.*;
	

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CPPGeneratorTest extends AbstractGeneratorTest {

	@Inject
	private ModelSequencer sequencer;

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new TestModule());
		injector.injectMembers(this);
	}

	@Test
	public void testExecuteGenerator() throws Exception {

		IProject project = super.createTestProject("CPPGeneratorTest", true);
		final IFile target = project.getFile("example.sct");
		URL entry = Platform.getBundle("org.yakindu.sct.generator.cpp.test")
				.getEntry("resources/example.sct");
		copyUrlFileToIFile(entry, target);

		URI uri = URI.createPlatformResourceURI(
				target.getFullPath().toString(), true);

		String templatePath = "org::yakindu::sct::generator::cpp::templates::Main::main";

		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		resource.load(Collections.emptyMap());

		Statechart statechart = (Statechart) resource.getContents().get(0);
		Assert.isNotNull(statechart);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow);
		generate(flow, templatePath, project);

	}
	
	
	@Test
	public void testSingleRegularEventTriggerCondition() {
		
		EventDefinition e1 = _createEventDefinition("e1");

		ReactionTrigger tr1 = StextFactory.eINSTANCE.createReactionTrigger();
		tr1.getTriggers().add(_createRegularEventSpec(e1));
		
		Statement s = sequencer.buildCondition(tr1);
		
		assertTrue(s instanceof ElementReferenceExpression);
	}



	@Test
	public void testMultipleRegularEventTriggerCondition() {
		
		EventDefinition e1 = _createEventDefinition("e1");
		EventDefinition e2 = _createEventDefinition("e2");
		
		ReactionTrigger tr1 = StextFactory.eINSTANCE.createReactionTrigger();
		tr1.getTriggers().add(_createRegularEventSpec(e1));
		tr1.getTriggers().add(_createRegularEventSpec(e2));
		
		Statement s = sequencer.buildCondition(tr1);
		
		assertTrue(s instanceof LogicalOrExpression);
		assertTrue( ((LogicalOrExpression)s).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue( ((LogicalOrExpression)s).getRightOperand() instanceof ElementReferenceExpression);
	}


	@Test
	public void testTransitionSequence() {
		
		EventDefinition e1 = _createEventDefinition("e1");
		EventDefinition e2 = _createEventDefinition("e2");
		
		
		ReactionTrigger tr1 = StextFactory.eINSTANCE.createReactionTrigger();
		tr1.getTriggers().add(_createRegularEventSpec(e1));
		tr1.getTriggers().add(_createRegularEventSpec(e2));
		
		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setTrigger(tr1);
		
		If s = sequencer.buildTransitionSequence(t);
		
		assertTrue(s.getCondition() instanceof LogicalOrExpression);
		assertTrue( ((LogicalOrExpression)s.getCondition()).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue( ((LogicalOrExpression)s.getCondition()).getRightOperand() instanceof ElementReferenceExpression);
	}


	protected EventDefinition _createEventDefinition(String name) {
		EventDefinition e1 = StextFactory.eINSTANCE.createEventDefinition();
		e1.setName(name);
		return e1;
	}

	protected RegularEventSpec _createRegularEventSpec(EventDefinition e1) {
		RegularEventSpec e1Spec = StextFactory.eINSTANCE.createRegularEventSpec();
		e1Spec.setEvent(e1);
		return e1Spec;
	}

}
