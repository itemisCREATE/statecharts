/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.test;

import static junit.framework.Assert.fail;

import java.lang.reflect.Method;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.validation.Check;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.genmodel.test.util.AbstractSGenTest;
import org.yakindu.sct.generator.genmodel.test.util.SGenInjectorProvider;
import org.yakindu.sct.generator.genmodel.validation.SGenJavaValidator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(SGenInjectorProvider.class)
public class SGenJavaValidatorTest extends AbstractSGenTest {

	@Inject
	private SGenJavaValidator validator;
	@Inject
	private Injector injector;

	private ValidatorTester<SGenJavaValidator> tester;

	@Before
	public void setup() {
		tester = new ValidatorTester<SGenJavaValidator>(validator, injector);
	}

	@After
	public void teardown() {
		tester = null;
	}

	@Test
	public void checkContentType() {
		fail("Implement me");
	}

	@Test
	public void checkParameterValueType() {
		fail("Implement me");
	}

	@Test
	public void checkParameterValue() {
		fail("Implement me");
	}

	@Test
	public void checkGeneratorExists() {
		fail("Implement me");
	}

	@Test
	public void checkDuplicateGeneratorEntryFeature() {
		fail("Implement me");
	}

	@Test
	public void checkDuplicateFeatureParameter() {
		fail("Implement me");
	}

	@Test
	public void checkRequiredFeatures() {
		fail("Implement me");
	}

	@Test
	public void checkRequiredParameters() {
		fail("Implement me");
	}

	/**
	 * checks that each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	@Test
	public void testAllChecksHaveTests() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(SGenJavaValidator.class
				.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			try {
				getClass().getMethod(checkMethod.getName());
			} catch (NoSuchMethodException ex) {
				fail("Missing @Test Annotation for method "
						+ checkMethod.getName());
			}
		}
	}
}
