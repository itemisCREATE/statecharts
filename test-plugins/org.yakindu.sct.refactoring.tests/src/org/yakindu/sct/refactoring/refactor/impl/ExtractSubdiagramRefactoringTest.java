package org.yakindu.sct.refactoring.refactor.impl;

import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.CREATE_SUBMACHINE;

import java.util.Collections;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.refactoring.refactor.RefactoringTest;
import org.yakindu.sct.refactoring.utils.RefactoringHelper;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class ExtractSubdiagramRefactoringTest extends RefactoringTest {

	@Test
	public void testTwoEntryPoints() {
		testRefactoring(
				CREATE_SUBMACHINE + "before_twoEntryPoints.sct", 
				CREATE_SUBMACHINE + "after_twoEntryPoints.sct", 
				"Composite");
	}
	
	@Test
	public void testTwoComposites() {
		testRefactoring(
				CREATE_SUBMACHINE + "before_twoComposites.sct", 
				CREATE_SUBMACHINE + "after_twoComposites.sct", 
				"Composite_Composite_A");
	}

	private void testRefactoring(String pathToInitialSct, String pathToExpectedSct, String contextElementName) {
		Statechart initial = models
				.loadStatechartFromResource(pathToInitialSct);

		TransactionalEditingDomainImpl.FactoryImpl.INSTANCE.createEditingDomain(initial.eResource().getResourceSet());
		
		View contextView = getViewForState(initial, contextElementName);

		ExtractSubdiagramRefactoring refactoring = new ExtractSubdiagramRefactoring();
		refactoring.setContextObjects(Collections.singletonList(contextView));
		
		AbstractSCTResource initialRes = (AbstractSCTResource) initial.eResource();
		initialRes.setSerializerEnabled(true);
		refactoring.execute();
		initialRes.setSerializerEnabled(false);
		initialRes.linkSpecificationElements();

		Statechart expected = models
				.loadStatechartFromResource(pathToExpectedSct);
		
		compareStatecharts(initial, expected);
	}

	private View getViewForState(Statechart initial, String stateName) {
		Diagram diagram = (Diagram) EcoreUtil.getObjectByType(initial.eResource().getContents(), NotationPackage.Literals.DIAGRAM);
		RefactoringHelper helper = new RefactoringHelper();
		return helper.getViewForSemanticElement(getStateByName(initial, stateName), diagram);
	}

}
