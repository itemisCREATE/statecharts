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

	

}
