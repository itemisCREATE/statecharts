/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test.validation;

import static org.yakindu.sct.model.sgraph.validation.ExitValidator.*;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.EntryValidator;
import org.yakindu.sct.model.sgraph.validation.ExitValidator;

import com.google.inject.Inject;

/**
 * 
 * Tests for {@link EntryValidator}
 *
 */
public class ExitValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<ExitValidator> tester;






	/**
	 * An exit node should have at leat one incoming transition.
	 */
	@Test
	public void exitWithoutIncomingTransition() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);

		tester.validate(exit).assertWarning(EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE);
	}

	/**
	 * An exit node must have no outgoing transitions.
	 */
	@Test
	public void exitWithOutgoingTransition() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);
		State s = factory.createState();
		subRegion.getVertices().add(s);
		createTransition(exit, s);
		createTransition(s, exit);

		tester.validate(exit).assertError(EXIT_NO_OUTGOING_TRANSITION_CODE);
	}

	/**
	 * An exit node must not be used in top level regions.
	 */
	@Test
	public void exitOnStatechart() {
		State state = createState();
		Region region = (Region) state.eContainer();
		Exit exit = factory.createExit();
		createTransition(state, exit);
		region.getVertices().add(exit);
		tester.validate(exit).assertError(EXIT_NO_TOPLEVEL_REGION_CODE);
	}

	/**
	 * Tests a scenario where no issues for an exit nodes exists.
	 */
	@Test
	public void cleanExit() {
		State state = createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);
		State s = factory.createState();
		subRegion.getVertices().add(s);
		Transition t = factory.createTransition();
		t.setTarget(exit);
		t.setSource(s);

		tester.validate(exit).assertOK();
	}
	
}
