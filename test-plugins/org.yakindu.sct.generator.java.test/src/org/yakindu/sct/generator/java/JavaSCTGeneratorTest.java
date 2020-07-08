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
package org.yakindu.sct.generator.java;

import org.eclipse.core.resources.IMarker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.java.types.JavaTypeSystemAccess;
import org.yakindu.sct.generator.java.util.AbstractJavaGeneratorTest;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * These tests only check for compile errors, they don't check the behaviour of
 * the generated state machine!
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(Parameterized.class)
public class JavaSCTGeneratorTest extends AbstractJavaGeneratorTest {

	private Statechart statechart;

	@Before
	public void setup() {
		
		GeneratorEntry entry = createGeneratorEntry(statechart.getName(), SRC_GEN);
		
		new TestModelInjectorProvider(new Module(){
			@Override
			public void configure(Binder binder) {
				binder.bind(ICodegenTypeSystemAccess.class).to(JavaTypeSystemAccess.class);
				binder.bind(INamingService.class).to(JavaNamingService.class).in(Scopes.SINGLETON);
				binder.bind(GeneratorEntry.class).toInstance(entry);
			}
		}).getInjector().injectMembers(this);
	} 

	public JavaSCTGeneratorTest(Statechart statechart) {
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
