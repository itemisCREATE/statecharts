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

import static org.eclipse.xtext.junit4.validation.AssertableDiagnostics.errorCode;
import static org.junit.Assert.assertNotNull;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.FEATURE_CALL_HAS_NO_EFFECT;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.FEATURE_CALL_TO_SCOPE;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.IN_OUT_DECLARATIONS;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.LOCAL_DECLARATIONS;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.LOCAL_REACTIONS_NOT_ALLOWED;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.ONLY_ONE_INTERFACE;

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
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
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
	 * @see STextJavaValidator#checkOperationArguments_FeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 */
	@Test
	public void checkOperationArguments_FeatureCall() {
		Scope context = (Scope) parseExpression(
				"interface if : operation myOperation(param1 : integer, param2: boolean)",
				null, InterfaceScope.class.getSimpleName());
		EObject model = super.parseExpression("if.myOperation(5,true)",
				context, Expression.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkOperationArguments_TypedElementReferenceExpression(TypedElementReferenceExpression)
	 */
	@Test
	public void checkOperationArguments_TypedElementReferenceExpression() {
		Scope context = createInternalScope("internal: operation myOperation(param1 : integer, param2: boolean)");
		EObject model = super.parseExpression("myOperation(5,true)", context,
				Expression.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkGuardHasBooleanExpression(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkGuardHasBooleanExpression() {
		EObject expression = super.parseExpression("[3 * 3]",
				ReactionTrigger.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult
				.assertErrorContains(STextJavaValidator.GUARD_EXPRESSION);

		Scope context = createInternalScope("internal: var myInt : integer var myBool : boolean = true)");
		expression = super.parseExpression("[myInt = 5]", context,
				ReactionTrigger.class.getSimpleName());
		validationResult = tester.validate(expression);
		validationResult
				.assertErrorContains(STextJavaValidator.GUARD_EXPRESSION);

		expression = super.parseExpression("[myInt <= 5 || !myBool ]", context,
				ReactionTrigger.class.getSimpleName());
		validationResult = tester.validate(expression);
		validationResult.assertOK();

	}

	/**
	 * @see STextJavaValidator#checkFeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 * @see STextJavaValidator#checkFeatureCall(TypedElementReferenceExpression)
	 */
	@Test
	public void checkFeatureCall() {
		Scope context = (Scope) parseExpression(
				"interface if : in event a : integer", null,
				InterfaceScope.class.getSimpleName());
		EObject model = super.parseExpression("if.a / raise if.a", context,
				TransitionSpecification.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("if / raise if.a", context,
				TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(FEATURE_CALL_TO_SCOPE);

		model = super.parseExpression("if.a / raise if", context,
				TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(FEATURE_CALL_TO_SCOPE);
	}

	/**
	 * 
	 * @see STextJavaValidator#checkReactionTrigger(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkReactionTrigger() {
		// ENTRY, EXIT not allowed in transitions
		Scope context = (Scope) parseExpression(
				"internal : event a : integer var myVar : integer", null,
				InternalScope.class.getSimpleName());
		EObject model = super.parseExpression("entry / myVar = 5", context,
				TransitionSpecification.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertError(LOCAL_REACTIONS_NOT_ALLOWED);

		model = super.parseExpression("exit / myVar = 5", context,
				TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(LOCAL_REACTIONS_NOT_ALLOWED);

		model = super.parseExpression("oncycle / myVar = 5", context,
				TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("always / myVar = 5", context,
				TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkReactionEffectActions(org.yakindu.sct.model.stext.stext.ReactionEffect)
	 */
	@Test
	public void checkReactionEffectActions() {
		Scope s1 = (InternalScope) parseExpression(
				"internal : var a : integer event e operation o () : void",
				null, InternalScope.class.getSimpleName());
		Scope s2 = (InterfaceScope) parseExpression(
				"interface if : var a : integer in event e operation o()",
				null, InterfaceScope.class.getSimpleName());

		EObject model = super.parseExpression("a", s1,
				ReactionEffect.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("1+3", s1,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(e)", s1,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("o()", s1,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertOK();

		model = super.parseExpression("if.a", s2,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(if.e)", s2,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("if.o", s2,
				ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertOK();

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
	 * @see STextJavaValidator#checkInterfaceScope(Statechart)
	 */
	@Test
	public void checkInterfaceScope() {
		EObject model = super.parseExpression(
				"interface: in event event1 interface: in event event2", null,
				StatechartSpecification.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertDiagnosticsCount(2);
		result.assertAll(errorCode(ONLY_ONE_INTERFACE),
				errorCode(ONLY_ONE_INTERFACE));
	}

	/**
	 * @see STextJavaValidator#checkExpression(org.yakindu.sct.model.sgraph.Statement)
	 */
	@Test
	public void checkExpression() {
		// Nothing to do, checked by Typeanalyzer tests
	}

	/**
	 * @see STextJavaValidator#checkVariableDefinitionInitialValue(org.yakindu.sct.model.stext.stext.VariableDefinition)
	 */
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
	 * @see STextJavaValidator#checkChoiceWithoutDefaultTransition(org.yakindu.sct.model.sgraph.Choice)
	 */
	@Test
	public void checkChoiceWithoutDefaultTransition() {
		// TODO
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
