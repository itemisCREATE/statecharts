/** 
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.refactoring.refactor.quickfix;

import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.ui.quickfix.EventTriggerCreationCommand;
import org.yakindu.sct.model.stext.validation.STextValidator;
import org.yakindu.sct.refactoring.refactor.RefactoringTest;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class AbstractSTextQuickfixTest extends RefactoringTest {

	@Inject
	protected STextValidator validator;

	protected Statechart initial;
	protected Statechart expected;

	protected class TestIssueImpl extends IssueImpl {
		public TestIssueImpl(String elementName) {
			this.setData(new String[] { "dummyUri", elementName });
		}
	}

	protected void execQuickfix(EventTriggerCreationCommand quickfix) {
		AbstractSCTResource initialRes = (AbstractSCTResource) initial.eResource();
		initialRes.setSerializerEnabled(true);
		assertTrue(quickfix.testExec().getStatus().isOK());
		initialRes.setSerializerEnabled(false);

		compareStatecharts(initial, expected);
	}
}
