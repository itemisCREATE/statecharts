package org.yakindu.sct.generator.cpp.test.generator;

import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createEventDefinition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createInterfaceScope;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createReactionEffect;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createReactionTrigger;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegion;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createRegularEventSpec;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createState;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createStatechart;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createTransition;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createValue;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createVariableAssignment;
import static org.yakindu.sct.model.sexec.transformation.test.SCTTestUtil._createVariableDefinition;

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
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static org.junit.Assert.*;


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
		
		assertNotNull(((RegularEventSpec) ((ReactionTrigger) statechart.getRegions().get(0).getVertices().get(0).getOutgoingTransitions().get(0).getTrigger()).getTriggers().get(0)).getEvent());
		assertNotNull(((ElementReferenceExpression) ((If) executionFlow.getStates().get(0).getCycle().getSteps().get(0)).getCheck().getCondition()).getValue());
	}

	
	
	@Test public void testSimpleModel() throws Exception {

		IProject project = super.createTestProject("CPPGeneratorTest_2", true);

		
		Statechart sc = _createStatechart("test");
		InterfaceScope s_scope = _createInterfaceScope("Interface", sc);
		EventDefinition e1 = _createEventDefinition("e1", s_scope);
		EventDefinition e2 = _createEventDefinition("e2", s_scope);
		EventDefinition e3 = _createEventDefinition("e3", s_scope);
		Region r = _createRegion("main", sc);
		State s1 = _createState("S1", r);
		State s2 = _createState("S2", r);
		State s3 = _createState("S3", r);
		Transition t = _createTransition(s1, s2);
		ReactionTrigger tr1 = _createReactionTrigger(t);
		_createRegularEventSpec(e1, tr1);
		
		Transition t2 = _createTransition(s1, s3);
		ReactionTrigger tr2 = _createReactionTrigger(t2);
		_createRegularEventSpec(e2, tr2);
		_createRegularEventSpec(e3, tr2);

		VariableDefinition v1 = _createVariableDefinition("v1", Type.INTEGER, s_scope);
		ReactionEffect effect = _createReactionEffect(t2);
		Assignment assign = _createVariableAssignment(v1, AssignmentOperator.ASSIGN, _createValue("42"), effect); 

		ExecutionFlow flow = sequencer.transform(sc);


		String templatePath = "org::yakindu::sct::generator::cpp::templates::Main::main";

		GeneratorBaseUtil.generate(flow, templatePath, project,
				"src-gen");
		
		
		assertNotNull(((ElementReferenceExpression) ((If) flow.getStates().get(0).getCycle().getSteps().get(0)).getCheck().getCondition()).getValue());

	}

}
