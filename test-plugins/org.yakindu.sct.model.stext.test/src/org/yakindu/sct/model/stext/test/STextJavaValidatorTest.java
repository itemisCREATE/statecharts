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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.ENTRY_UNUSED;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.EXIT_DEFAULT_UNUSED;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.EXIT_UNUSED;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.FEATURE_CALL_HAS_NO_EFFECT;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.FEATURE_CALL_TO_SCOPE;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.IN_OUT_DECLARATIONS;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.LOCAL_DECLARATIONS;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.LOCAL_REACTIONS_NOT_ALLOWED;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.ONLY_ONE_INTERFACE;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.REGION_UNBOUND_DEFAULT_ENTRY_POINT;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.TRANSITION_ENTRY_SPEC_NOT_COMPOSITE;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.TRANSITION_EXIT_SPEC_NOT_COMPOSITE;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT;
import static org.yakindu.sct.model.stext.validation.STextJavaValidator.TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.impl.StextFactoryImpl;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author andreas muelder - Initial contribution and APIimport
 *         org.yakindu.sct.model.sgraph.test.util.SGraphTestModelUtil;
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
	 * @see STextJavaValidator#checkVariableDefinition(org.yakindu.sct.model.stext.stext.VariableDefinition)
	 */
	@Test
	public void checkVariableDefinition() {
		Scope context = (Scope) parseExpression("interface if : var i : void", null,
				InterfaceScope.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(context);
		validationResult.assertErrorContains(STextJavaValidator.VARIABLE_VOID_TYPE);
	}

	/**
	 * @see STextJavaValidator#checkAssignmentExpression(org.yakindu.sct.model.stext.stext.AssignmentExpression)
	 */
	@Test
	public void checkAssignmentExpression() {

		Scope context = (Scope) parseExpression("interface: var i : integer = 42 var j : integer =23", null,
				InterfaceScope.class.getSimpleName());

		EObject expression = super.parseExpression("i += (i+=3) +4", context, Expression.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.ASSIGNMENT_EXPRESSION);

		expression = super.parseExpression("i += (j+=3) +4", context, Expression.class.getSimpleName());
		validationResult = tester.validate(expression);
		validationResult.assertOK();
	}

	@Test
	public void checkTimeEventSpecValueExpression() {
		EObject expression = super.parseExpression("after true s", ReactionTrigger.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.TIME_EXPRESSION);
	}

	@Test
	public void checkReactionEffectActionExpression() {
		// covered by inferrer tests
	}

	/**
	 * @see STextJavaValidator#checkOperationArguments_FeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 */
	@Test
	public void checkOperationArguments_FeatureCall() {
		Scope scope = (Scope) parseExpression(
				"interface if : operation myOperation(param1 : integer, param2: boolean)", null,
				InterfaceScope.class.getSimpleName());
		EObject model = super.parseExpression("if.myOperation(5,true)", Expression.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkOperationArguments_TypedElementReferenceExpression(TypedElementReferenceExpression)
	 */
	@Test
	public void checkOperationArguments_TypedElementReferenceExpression() {
		Scope context = createInternalScope("internal: operation myOperation(param1 : integer, param2: boolean)");
		EObject model = super.parseExpression("myOperation(5,true)", context, Expression.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkGuardHasBooleanExpression(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkGuard() {
		EObject expression = super.parseExpression("[3 * 3]", ReactionTrigger.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.GUARD_EXPRESSION);

		Scope context = createInternalScope("internal: var myInt : integer var myBool : boolean = true)");
		expression = super.parseExpression("[myInt = 5]", context, ReactionTrigger.class.getSimpleName());
		validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.GUARD_EXPRESSION);

		expression = super.parseExpression("[myInt <= 5 || !myBool ]", context, ReactionTrigger.class.getSimpleName());
		validationResult = tester.validate(expression);
		validationResult.assertOK();

	}

	/**
	 * @see STextJavaValidator#checkFeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 * @see STextJavaValidator#checkFeatureCall(TypedElementReferenceExpression)
	 */
	@Test
	public void checkFeatureCall() {
		Scope context = (Scope) parseExpression("interface if : in event a : integer", null,
				InterfaceScope.class.getSimpleName());
		EObject model = super.parseExpression("if.a / raise if.a:1", context,
				TransitionSpecification.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("if / raise if.a:1", context, TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(FEATURE_CALL_TO_SCOPE);

		model = super.parseExpression("if.a / raise if", context, TransitionSpecification.class.getSimpleName());
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
		Scope context = (Scope) parseExpression("internal : event a : integer var myVar : integer", null,
				InternalScope.class.getSimpleName());
		EObject model = super.parseExpression("entry / myVar = 5", context,
				TransitionSpecification.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertError(LOCAL_REACTIONS_NOT_ALLOWED);

		model = super.parseExpression("exit / myVar = 5", context, TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(LOCAL_REACTIONS_NOT_ALLOWED);

		model = super.parseExpression("oncycle / myVar = 5", context, TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("always / myVar = 5", context, TransitionSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkReactionEffectActions(org.yakindu.sct.model.stext.stext.ReactionEffect)
	 */
	@Test
	public void checkReactionEffectActions() {
		Scope s1 = (InternalScope) parseExpression("internal : var a : integer event e operation o () : void", null,
				InternalScope.class.getSimpleName());
		Scope s2 = (InterfaceScope) parseExpression("interface if : var a : integer in event e operation o()", null,
				InterfaceScope.class.getSimpleName());

		EObject model = super.parseExpression("a", s1, ReactionEffect.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("1+3", s1, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(e)", s1, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("o()", s1, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertOK();

		model = super.parseExpression("if.a", s2, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(if.e)", s2, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("if.o", s2, ReactionEffect.class.getSimpleName());
		result = tester.validate(model);
		result.assertOK();

	}

	/**
	 * @see STextJavaValidator#checkEventDefinition(org.yakindu.sct.model.stext.stext.EventDefinition)
	 */
	@Test
	public void checkEventDefinition() {
		// No local declarations in interface scope
		EObject model = super.parseExpression("interface MyInterface: event Event1", null,
				InterfaceScope.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertErrorContains(LOCAL_DECLARATIONS);
		// No in declarations in internal scope
		model = super.parseExpression("internal: in event Event1", null, InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(STextJavaValidator.IN_OUT_DECLARATIONS);
		// No out declarations in internal scope
		model = super.parseExpression("internal: out event Event1", null, InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(IN_OUT_DECLARATIONS);
	}

	/**
	 * @see STextJavaValidator#checkInterfaceScope(Statechart)
	 */
	@Test
	public void checkInterfaceScope() {
		EObject model = super.parseExpression("interface: in event event1 interface: in event event2", null,
				StatechartSpecification.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertDiagnosticsCount(2);
		result.assertAll(errorCode(ONLY_ONE_INTERFACE), errorCode(ONLY_ONE_INTERFACE));
	}

	/**
	 * @see STextJavaValidator#checkChoiceWithoutDefaultTransition(org.yakindu.sct.model.sgraph.Choice)
	 */
	@Test
	public void checkChoiceWithoutDefaultTransition() {
		// TODO
	}

	/**
	 * @see STextJavaValidator#checkUnresolvableProxies(Statechart)
	 */
	@Test
	public void checkUnresolvableProxies() {
		// Nothing to do
	}

	/**
	 * @see STextJavaValidator#checkcheckSyntaxErrors(Statechart)
	 */
	@Test
	public void checkSyntaxErrors() {
		// Nothing to do
	}

	/**
	 * checks tht each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	@Test
	public void testAllChecksHaveTests() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(STextJavaValidator.class.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			Method testMethod = getClass().getMethod(checkMethod.getName());
			assertNotNull("Missing @Test Annotation for method " + checkMethod.getName(),
					testMethod.getAnnotation(Test.class));
		}
	}

	@Test
	public void checkUnusedEntry() {
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedEntryPoint.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Entry) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ENTRY_UNUSED);
	}

	@Test
	public void checkUnusedExit() {
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		Statechart statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedExitPoint.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Exit) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, EXIT_UNUSED);

		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedDefaultExitPoint.sct");
		iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Exit) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, EXIT_DEFAULT_UNUSED);
	}

	@Test
	public void checkTransitionPropertySpec() {
		// Test source state isn't composite
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		Statechart statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "TransitionEntrySpecNotComposite.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}
		// Test target state isn't composite
		assertIssueCount(diagnostics, 2);
		assertWarning(diagnostics, TRANSITION_ENTRY_SPEC_NOT_COMPOSITE);

		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "TransitionExitSpecNotComposite.sct");
		iter = statechart.eAllContents();

		// create and add triggers to all transitions to prevent to trigger
		// additional warnings
		// (see Check in SGrapJavaValidator transitionsWithNoGuard)
		Trigger trigger = StextFactoryImpl.init().createDefaultTrigger();

		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, TRANSITION_EXIT_SPEC_NOT_COMPOSITE);

		// Test exit spec is used on multiple transition siblings.
		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "TransitionExitSpecOnMultipleSiblings.sct");
		iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 4);
		assertWarning(diagnostics, TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS);

		// Test transition unbound named exit point spec.
		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "TransitionNotExistingNamedExitPoint.sct");
		iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT);
	}

	@Test
	public void checkUnboundEntryPoints() {
		BasicDiagnostic diagnostics = new BasicDiagnostic();
		Statechart statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR
				+ "UnboundDefaultEntryPoints.sct");
		Iterator<EObject> iter = statechart.eAllContents();

		// create and add triggers to all transitions to prevent to trigger
		// additional warnings
		// (see Check in SGrapJavaValidator transitionsWithNoGuard)
		Trigger trigger = StextFactoryImpl.init().createDefaultTrigger();

		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 4);
		assertError(diagnostics, TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT);
		assertError(diagnostics, REGION_UNBOUND_DEFAULT_ENTRY_POINT);

		diagnostics = new BasicDiagnostic();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnboundEntryPoints02.sct");
		iter = statechart.eAllContents();

		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}
		assertIssueCount(diagnostics, 4);
	}

	protected void assertError(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no error.", Diagnostic.ERROR, d.getSeverity());
	}

	protected void assertWarning(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no warning.", Diagnostic.WARNING, d.getSeverity());
	}

	protected void assertIssueCount(BasicDiagnostic diag, int count) {
		int c = diag.getChildren().size();
		assertEquals("expected " + count + " issue(s) but were " + c + " [" + diag.toString() + "]", count, c);
	}

	protected Diagnostic issueByName(BasicDiagnostic diag, String message) {
		for (Diagnostic issue : diag.getChildren()) {
			if (message.equals(issue.getMessage()))
				return issue;
		}
		return null;
	}
}
