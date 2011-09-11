package org.yakindu.sct.generator.cpp.test.generator;

import static org.junit.Assert.*;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.generator.base.util.GeneratorBaseUtil;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth
 * 
 */
public class CPPGeneratorTest extends AbstractGeneratorTest {

	@Inject
	private ModelSequencer sequencer;

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new SequencerModule());
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
		Statechart statechart = GeneratorBaseUtil.loadStatechart(uri);
		ExecutionFlow executionFlow = GeneratorBaseUtil
				.createExecutionFlowModel(statechart);
		GeneratorBaseUtil.generate(executionFlow, templatePath, project,
				"src-gen");
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
		assertTrue(((LogicalOrExpression) s).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) s).getRightOperand() instanceof ElementReferenceExpression);
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
		assertTrue(((LogicalOrExpression) s.getCondition()).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) s.getCondition()).getRightOperand() instanceof ElementReferenceExpression);

		assertEquals(e1.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) s.getCondition()).getLeftOperand()).getValue().getName());
		assertEquals(e2.getName(),
				((ElementReferenceExpression)((LogicalOrExpression) s.getCondition()).getRightOperand()).getValue().getName());
	}

	
	@Test
	public void testCopyScope() {

		EventDefinition e1 = _createEventDefinition("e1");
		EventDefinition e2 = _createEventDefinition("e2");
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER);
		
		InterfaceScope s_scope = StextFactory.eINSTANCE.createInterfaceScope();
		s_scope.getDeclarations().add(e1);
		s_scope.getDeclarations().add(e2);
		s_scope.getDeclarations().add(v1);
		
		Scope r_scope = sequencer.copy(s_scope);

		assertTrue(r_scope instanceof InterfaceScope);
		assertEquals(3, r_scope.getDeclarations().size());
		
		
		for ( int i =0; i<r_scope.getDeclarations().size(); i++) {			
			Declaration s_decl = s_scope.getDeclarations().get(i);
			Declaration r_decl = r_scope.getDeclarations().get(i);
			
			assertNotSame(s_decl, r_decl);	
			assertEquals(s_decl.getName(), r_decl.getName());	
			assertEquals(s_decl.getClass(), r_decl.getClass());	
		}
	}
	
	
	protected EventDefinition _createEventDefinition(String name) {
		EventDefinition e = StextFactory.eINSTANCE.createEventDefinition();
		e.setName(name);
		return e;
	}

	protected VariableDefinition _createVariableDefinition(String name, Type type) {
		VariableDefinition v = StextFactory.eINSTANCE.createVariableDefinition();
		v.setName(name);
		v.setType(type);
		return v;
	}

	protected RegularEventSpec _createRegularEventSpec(EventDefinition e1) {
		RegularEventSpec e1Spec = StextFactory.eINSTANCE
				.createRegularEventSpec();
		e1Spec.setEvent(e1);
		return e1Spec;
	}

}
