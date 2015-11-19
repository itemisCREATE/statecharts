/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.csharp;

import org.eclipse.core.resources.IMarker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.yakindu.sct.generator.csharp.util.AbstractCSharpGeneratorTest;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

/**
 * These tests only check for compile errors, they don't check the behaviour of
 * the generated Statemachine!
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(Parameterized.class)
public class CSharpSCTGeneratorTest extends AbstractCSharpGeneratorTest {

	private Statechart statechart;

	@Before
	public void setup() {
		new TestModelInjectorProvider().getInjector().injectMembers(this);
	}

	public CSharpSCTGeneratorTest(Statechart statechart) {
		this.statechart = statechart;
	}

	@Parameters
	public static Iterable<Object[]> testData() throws Exception {
		return SCTUnitTestModels.parameterizedTestData();
	}

	@Test
	public void testCompileStatechart() throws Exception {
		IMarker[] marker = generateAndCompile(statechart);
		for (IMarker diagnostic : marker) {
			int severity = (Integer) diagnostic.getAttribute("severity");
			if (severity == IMarker.SEVERITY_ERROR) {
				Assert.fail("Unable to compile '" + statechart.getName() + "': "
						+ diagnostic.getAttribute(IMarker.MESSAGE, ""));
			}
		}

	}
}
