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

import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.SynchronizationValidator;
import static org.yakindu.sct.model.sgraph.validation.SynchronizationValidator.*;
import static org.eclipse.xtext.junit4.validation.AssertableDiagnostics.*;
import com.google.inject.Inject;

/**
 *
 * Tests for {@link SynchronizationValidator}
 *
 */
public class SynchronizationValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<SynchronizationValidator> tester;

	@Test
	public void synchronizationTransitionCount() {
		Statechart statechart = loadStatechart("SynchronizationTransitionCount.sct");
		AssertableDiagnostics diagnostics = tester.validate(statechart);
		diagnostics.assertDiagnosticsCount(2);
		diagnostics.assertAny(errorCode(SYNCHRONIZATION_TRANSITION_COUNT_CODE));
	}

	@Test
	public void synchronizationOutgoingTransitionCount() {
		Statechart statechart = loadStatechart("SyncOutgoingTransition.sct");
		tester.validate(statechart).assertError(SYNCHRONIZATION_TRANSITION_OUTGOING_CODE);
	}

	@Test
	public void orthogonalSourceStates() {
		Statechart statechart = loadStatechart("OrthogonalRegion01.sct");
		tester.validate(statechart).assertOK();
	}

	@Test
	public void orthogonalTargetStates() {
		Statechart statechart = loadStatechart("OrthogonalRegion01.sct");
		tester.validate(statechart).assertOK();
	}

	@Test
	public void syncLocation_Issue58() {
		Statechart statechart = loadStatechart("SyncLocation_Issue58.sct");
		tester.validate(statechart).assertOK();
	}

	@Test
	public void orthogonalTargetStates_StateInParentStateRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion01.sct");
		AssertableDiagnostics diagnostics = tester.validate(statechart);
		diagnostics.assertDiagnosticsCount(2);
		diagnostics.assertAny(errorCode(SYNCHRONIZATION_SOURCE_ORTHOGONAL_CODE));
		diagnostics.assertAny(errorCode(SYNCHRONIZATION_TARGET_ORTHOGONAL_CODE));
	}

	@Test
	public void orthogonalTargetStates_StateInTopLevelRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion02.sct");
		AssertableDiagnostics diagnostics = tester.validate(statechart);
		diagnostics.assertDiagnosticsCount(2);
		diagnostics.assertAny(errorCode(SYNCHRONIZATION_SOURCE_ORTHOGONAL_CODE));
		diagnostics.assertAny(errorCode(SYNCHRONIZATION_TARGET_ORTHOGONAL_CODE));
	}

	@Test
	public void orthogonalSynchronizedTransition() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion03.sct");
		tester.validate(statechart).assertAny(errorCode(SYNCHRONIZATION_SOURCE_TARGET_PARENT_REGION_CODE));
	}

	protected Statechart loadStatechart(String modelName) {
		return super.loadStatechart("synchronization/" + modelName);
	}

}
