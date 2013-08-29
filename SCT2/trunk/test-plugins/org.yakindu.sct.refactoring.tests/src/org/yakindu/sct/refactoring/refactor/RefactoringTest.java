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

import org.eclipse.xtext.parser.IParser;
import org.junit.Assert;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.refactoring.refactor.util.SctEqualityHelper;
import org.yakindu.sct.refactoring.test.models.RefactoringTestModels;

import com.google.inject.Inject;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class RefactoringTest {

	@Inject
	protected IParser parser;

	@Inject
	protected RefactoringTestModels models;

	protected void compareStatecharts(Statechart initial, Statechart expected) {
		SctEqualityHelper equalityHelper = new SctEqualityHelper();
		if (!equalityHelper.equals(initial, expected)) {
			Assert.fail("Equality check on statecharts failed!");
		}
	}
}