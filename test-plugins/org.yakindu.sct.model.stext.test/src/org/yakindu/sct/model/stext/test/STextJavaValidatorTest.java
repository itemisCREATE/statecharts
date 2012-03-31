/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.*;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.validation.Check;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;

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
@InjectWith(STextInjectorProvider.class)
public class STextJavaValidatorTest extends AbstractSTextTest {

	@Inject
	private STextJavaValidator validator;
	@Inject
	private Injector injector;

	private ValidatorTester<STextJavaValidator> tester;

	@Before
	public void setup() {
		tester = new ValidatorTester<STextJavaValidator>(validator, injector);
	}

	@After
	public void teardown() {
		tester = null;
	}

	/**
	 * @see STextJavaValidator#checkOperationArguments(org.yakindu.sct.model.stext.stext.FeatureCall)
	 */
	@Test
	public void checkOperationArguments() {
		Scope context = createContextScope("internal: operation myOperation(param1 : Integer, param2: Boolean)");
		EObject model = super.parseExpression("myOperation(5,true)", context,
				Expression.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * 
	 * @see STextJavaValidator#checkReactionTrigger(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkReactionTrigger() {
		fail("implement me");
	}

	/**
	 * @see STextJavaValidator#checkReactionEffectActions(org.yakindu.sct.model.stext.stext.ReactionEffect)
	 */
	@Test
	public void checkReactionEffectActions() {
		fail("Implement me");
	}

	/**
	 * @see STextJavaValidator#checkEventDefinition(org.yakindu.sct.model.stext.stext.EventDefinition)
	 */
	@Test
	public void checkEventDefinition() {
		// No local declarations in interface scope
		EObject model = super.parseExpression(
				"interface MyInterface: event Event1", null,
				InterfaceScope.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertErrorContains(LOCAL_DECLARATIONS);
		// No in declarations in internal scope
		model = super.parseExpression("internal: in event Event1", null,
				InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(STextJavaValidator.IN_OUT_DECLARATIONS);
		// No out declarations in internal scope
		model = super.parseExpression("internal: out event Event1", null,
				InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(IN_OUT_DECLARATIONS);
	}

	/**
	 * @see STextJavaValidator#checkLocalReaction(org.yakindu.sct.model.stext.stext.LocalReaction)
	 */
	@Test
	public void checkLocalReaction() {
		fail("Implement me");
	}

	/**
	 * @see STextJavaValidator#checkInterfaceScope(Statechart)
	 */
	@Test
	public void checkInterfaceScope() {
		EObject model = super.parseExpression(
				"interface: in event event1 interface: in event event2", null,
				StatechartSpecification.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(ONLY_ONE_INTERFACE);
	}

	/**
	 * @see STextJavaValidator#checkExpression(org.yakindu.sct.model.sgraph.Statement)
	 */
	@Test
	public void checkExpression() {
		// Nothing to do, checked by Typeanalyzer tests
	}

	@Test
	public void checkVariableDefinitionInitialValue() {
		// Success
		EObject model = super.parseExpression(
				"interface: var myBool : boolean = !true", null,
				StatechartSpecification.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertDiagnosticsCount(0);
		// Fail
		model = super.parseExpression("interface: var myBool : boolean = 5",
				null, StatechartSpecification.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains("Can not assign a value of type 'integer' to a variable of type 'boolean'");
	}

	/**
	 * checks tht each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	@Test
	public void testAllChecksHaveTests() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(STextJavaValidator.class
				.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			Method testMethod = getClass().getMethod(checkMethod.getName());
			assertNotNull(
					"Missing @Test Annotation for method "
							+ checkMethod.getName(),
					testMethod.getAnnotation(Test.class));
		}
	}

}
