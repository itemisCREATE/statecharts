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
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
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

	
	
	/**
	 * The event refs used in the trigger condition must refer to the event declarations in the flow model and not the sc source model.
	 */
	@Test public void testTriggerEventDeclarationIntegrity() {

		Statechart sc = _createStatechart("test");
		InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		EventDefinition e1 = _createEventDefinition("e1", s_scope);
		Region r = _createRegion("main", sc);
		State s1 = _createState("S1", r);
		State s2 = _createState("S2", r);
		Transition t = _createTransition(s1, s2);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createRegularEventSpec(e1, tr1);

		ExecutionFlow flow = sequencer.transform(sc);

		EventDefinition _e1 = (EventDefinition) flow.getScopes().get(0).getDeclarations().get(0); 
		assertNotSame(e1, _e1);
		assertEquals(e1.getName(), _e1.getName());
		
		assertEquals(2, flow.getStates().size());
		assertEquals(s1.getName(), flow.getStates().get(0).getSimpleName());
		If _if = (If) flow.getStates().get(0).getCycle().getSteps().get(0);

		ElementReferenceExpression _ere = (ElementReferenceExpression) _if.getCondition();
		assertSame(_e1, _ere.getValue());
	}


	private ReactionTrigger _createReactionTrigger(Reaction reaction) {
		ReactionTrigger rt = StextFactory.eINSTANCE.createReactionTrigger();
		if (reaction != null) reaction.setTrigger(rt);
		return rt;
	}


	protected Statechart _createStatechart(String name) {
		Statechart sc = SGraphFactory.eINSTANCE.createStatechart();
		sc.setName(name);
		return sc;
	}
	

	protected InterfaceScope _createInterfaceScope(String name, ScopedElement owner) {
		InterfaceScope scope = StextFactory.eINSTANCE.createInterfaceScope();
		scope.setName(name);
		if (owner != null) owner.getScopes().add(scope);
		return scope;
	}
	

	protected Region _createRegion(String name, Statechart sc) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(name);
		if (sc != null ) sc.getRegions().add(region);
		return region;
	}
	
	protected State _createState(String name, Region r) {
		State state = SGraphFactory.eINSTANCE.createState();
		state.setName(name);
		if (r!=null) r.getVertices().add(state);
		return state;
	}
	
	protected Transition _createTransition(Vertex source, Vertex target) {
		Transition t = SGraphFactory.eINSTANCE.createTransition();
		t.setSource(source);
		t.setTarget(target);
		return t;
	}
	
	
	@Test
	public void testSingleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);

		Statement s = sequencer.buildCondition(tr1);

		assertTrue(s instanceof ElementReferenceExpression);
	}

	@Test
	public void testMultipleRegularEventTriggerCondition() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

		Statement s = sequencer.buildCondition(tr1);

		assertTrue(s instanceof LogicalOrExpression);
		assertTrue(((LogicalOrExpression) s).getLeftOperand() instanceof ElementReferenceExpression);
		assertTrue(((LogicalOrExpression) s).getRightOperand() instanceof ElementReferenceExpression);
	}

	
	@Test
	public void testTransitionSequence() {

		EventDefinition e1 = _createEventDefinition("e1", null);
		EventDefinition e2 = _createEventDefinition("e2", null);

		ReactionTrigger tr1 = _createReactionTrigger(null);
		_createRegularEventSpec(e1, tr1);
		_createRegularEventSpec(e2, tr1);

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

		InterfaceScope scope = _createInterfaceScope(null, null);
		EventDefinition e1 = _createEventDefinition("e1", scope);
		EventDefinition e2 = _createEventDefinition("e2", scope);
		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, scope);
		
		Scope _scope = sequencer.map(scope);

		assertTrue(_scope instanceof InterfaceScope);
		assertEquals(3, _scope.getDeclarations().size());
		
		
		for ( int i =0; i<_scope.getDeclarations().size(); i++) {			
			Declaration s_decl = scope.getDeclarations().get(i);
			Declaration r_decl = _scope.getDeclarations().get(i);
			
			assertNotSame(s_decl, r_decl);	
			assertEquals(s_decl.getName(), r_decl.getName());	
			assertEquals(s_decl.getClass(), r_decl.getClass());	
		}
	}
	
	
	protected EventDefinition _createEventDefinition(String name, Scope scope) {
		EventDefinition e = StextFactory.eINSTANCE.createEventDefinition();
		e.setName(name);
		if (scope!=null) scope.getDeclarations().add(e);
		return e;
	}

	protected VariableDefinition _createVariableDefinition(String name, Type type, Scope scope) {
		VariableDefinition v = StextFactory.eINSTANCE.createVariableDefinition();
		v.setName(name);
		v.setType(type);
		if (scope!=null) scope.getDeclarations().add(v);
		return v;
	}

	protected RegularEventSpec _createRegularEventSpec(EventDefinition e1, ReactionTrigger rt) {
		RegularEventSpec e1Spec = StextFactory.eINSTANCE.createRegularEventSpec();
		e1Spec.setEvent(e1);
		if (rt!=null) rt.getTriggers().add(e1Spec);
		return e1Spec;
	}

}
