package org.yakindu.sct.generator.java.plain.test.generator;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth
 * 
 */
public class JavaGeneratorTest extends AbstractGeneratorTest {

	@Before
	public void setup() {
		Injector injector = Guice.createInjector(new SequencerModule());
		injector.injectMembers(this);
	}

	
	@Test
	public void testExecuteGenerator() throws Exception {

//		IProject project = super.createTestProject("JavaGeneratorTest", true);
//		final IFile target = project.getFile("example.sct");
//		URL entry = Platform.getBundle("org.yakindu.sct.generator.java.plain.test")
//				.getEntry("resources/example.sct");
//		copyUrlFileToIFile(entry, target);
//
//		URI uri = URI.createPlatformResourceURI(
//				target.getFullPath().toString(), true);
//
//		String templatePath = "org::yakindu::sct::generator::java::plain::templates::Main::main";
//		Statechart statechart = GeneratorBaseUtil.loadStatechart(uri);
//		ExecutionFlow executionFlow = GeneratorBaseUtil
//				.createExecutionFlowModel(statechart);
//		
//		String targetFolder = "src-gen";
//		
//		String absoluteTargetFolder = ResourcesPlugin.getWorkspace().getRoot()
//				.getLocation().toOSString()
//				+ File.separator
//				+ project.getFullPath().toOSString()
//				+ File.separator + targetFolder;
//		
//		GeneratorBaseUtil.generate(executionFlow, templatePath, project,
//				absoluteTargetFolder);
		
//		assertNotNull(((RegularEventSpec) ((ReactionTrigger) statechart.getRegions().get(0).getVertices().get(0).getOutgoingTransitions().get(0).getTrigger()).getTriggers().get(0)).getEvent());
//		assertNotNull(((ElementReferenceExpression) ((If) executionFlow.getStates().get(0).getCycle().getSteps().get(0)).getCheck().getCondition()).getValue());
	}
}
