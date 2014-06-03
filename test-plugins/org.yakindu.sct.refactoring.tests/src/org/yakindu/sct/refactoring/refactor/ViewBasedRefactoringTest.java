/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor;

import java.util.Collections;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.refactoring.utils.RefactoringHelper;


public abstract class ViewBasedRefactoringTest extends RefactoringTest {

	protected void testRefactoring(String pathToInitialSct, String pathToExpectedSct, String contextElementName) {
		Statechart initial = models
				.loadStatechartFromResource(pathToInitialSct);

		TransactionalEditingDomainImpl.FactoryImpl.INSTANCE.createEditingDomain(initial.eResource().getResourceSet());
		
		View contextView = getViewForState(initial, contextElementName);

		AbstractRefactoring<View> refactoring = getRefactoring();
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

	protected abstract AbstractRefactoring<View> getRefactoring();

	protected View getViewForState(Statechart initial, String stateName) {
		Diagram diagram = (Diagram) EcoreUtil.getObjectByType(initial.eResource().getContents(), NotationPackage.Literals.DIAGRAM);
		RefactoringHelper helper = new RefactoringHelper();
		return helper.getViewForSemanticElement(getStateByName(initial, stateName), diagram);
	}
}
