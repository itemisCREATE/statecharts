/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.model.sgraph.test.validation.ChoiceValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.EntryExitValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.FinalStateNoOutTransitionsValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.StateValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.StatechartValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.SynchronizationValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.TransitionValidatorTest;
import org.yakindu.sct.model.sgraph.test.validation.VertexValidatorTest;

@RunWith(value = Suite.class)
@SuiteClasses(value = { StatechartValidatorTest.class, ChoiceValidatorTest.class, EntryExitValidatorTest.class,
		FinalStateNoOutTransitionsValidatorTest.class, StateValidatorTest.class, SynchronizationValidatorTest.class,
		TransitionValidatorTest.class, VertexValidatorTest.class })
public class AllTests {

}
