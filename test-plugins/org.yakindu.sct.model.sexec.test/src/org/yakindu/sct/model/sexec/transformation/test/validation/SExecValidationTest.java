package org.yakindu.sct.model.sexec.transformation.test.validation;


import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;
import static org.yakindu.sct.model.sexec.validation.SExecValidationMessages.*;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.validation.STextJavaValidatorTest;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class SExecValidationTest extends STextJavaValidatorTest {

	@Test
	public void checkInternalEventRaisedOutsideOfDownstreamScope() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "InternalEventRaisedOutsideOfDownstreamScope.sct");
		doValidateAllContents(Statechart.class);
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, EVENT_NOT_VISIBLE_DOWNSTREAM);
	}
	
	@Test
	public void checkInternalEventRaisedInsideOfDownstreamScope() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "InternalEventRaisedInsideOfDownstreamScope.sct");
		doValidateAllContents(Statechart.class);
		assertIssueCount(diagnostics, 0);
	}
	
}
