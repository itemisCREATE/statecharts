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
package org.yakindu.sct.model.stext.test.validation;

import static org.eclipse.xtext.junit4.validation.AssertableDiagnostics.errorCode;
import static org.eclipse.xtext.junit4.validation.AssertableDiagnostics.errorMsg;
import static org.eclipse.xtext.junit4.validation.AssertableDiagnostics.warningMsg;
import static org.junit.Assert.assertEquals;
import static org.yakindu.base.expressions.validation.ExpressionsJavaValidator.ERROR_ASSIGNMENT_TO_CONST_MSG;
import static org.yakindu.base.expressions.validation.ExpressionsJavaValidator.ERROR_LEFT_HAND_ASSIGNMENT_MSG;
import static org.yakindu.base.expressions.validation.ExpressionsJavaValidator.ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE;
import static org.yakindu.base.types.validation.TypesJavaValidator.ERROR_OPTIONAL_MUST_BE_LAST_CODE;
import static org.yakindu.base.types.validation.TypesJavaValidator.ERROR_VAR_ARGS_LAST_CODE;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.validation.ExpressionsJavaValidator;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.impl.StextFactoryImpl;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.util.StextTestFactory;
import org.yakindu.sct.model.stext.test.util.TestCompletenessAssertions;
import org.yakindu.sct.model.stext.test.util.TypesTestFactory;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.model.stext.validation.STextValidationMessages;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class STextJavaValidatorTest extends AbstractSTextValidationTest implements STextValidationMessages {

	@Inject
	TestCompletenessAssertions checkAvailable;

	/**
	 * @see STextJavaValidator#checkVariableDefinition(org.yakindu.sct.model.stext.stext.VariableDefinition)
	 */
	@Test
	public void checkVariableDefinition() {
		Scope context = (Scope) parseExpression("interface if : var i : void", InterfaceScope.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(context);
		validationResult.assertErrorContains(STextTypeInferrer.VARIABLE_VOID_TYPE);
	}

	/**
	 *
	 * @see STextJavaValidator#checkAssignmentExpression(org.yakindu.sct.model.stext.stext.AssignmentExpression)
	 */
	@Test
	public void checkAssignmentExpression() {

		String context = "interface: var i : integer = 42 var j : integer =23";

		EObject expression = super.parseExpression("i += (i+=3) +4", Expression.class.getSimpleName(), context);
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.ASSIGNMENT_EXPRESSION);

		expression = super.parseExpression("i += (j+=3) +4", Expression.class.getSimpleName(), context);
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

	@Test
	public void checkLeftHandAssignment() {

		String scope = "interface if : operation myOperation() : boolean event Event1 : boolean var myVar : boolean";

		EObject model = super.parseExpression("3 = 3", Expression.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertErrorContains(ERROR_LEFT_HAND_ASSIGNMENT_MSG);

		// Check for referenced elements in interface
		model = super.parseExpression("if.myOperation() = true", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertErrorContains(ERROR_LEFT_HAND_ASSIGNMENT_MSG);

		model = super.parseExpression("if.Event1 = true", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertErrorContains(ERROR_LEFT_HAND_ASSIGNMENT_MSG);

		model = super.parseExpression("if.myVar = true", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();

		// check for internal referenced elements
		scope = "internal : operation myOperation() : integer event Event1 : integer var myVar : integer";

		model = super.parseExpression("myOperation() = 5", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertErrorContains(ERROR_LEFT_HAND_ASSIGNMENT_MSG);

		model = super.parseExpression("Event1 = true", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertErrorContains(ERROR_LEFT_HAND_ASSIGNMENT_MSG);

		model = super.parseExpression("myVar = 5", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();

	}

	/**
	 * @see STextJavaValidator#checkOperationArguments_FeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 */
	@Test
	public void checkOperationArguments_FeatureCall() {
		String scope = "interface if : operation myOperation(param1 : integer, param2: boolean";
		EObject model = super.parseExpression("if.myOperation(5,true)", Expression.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkOperationArguments_TypedElementReferenceExpression(TypedElementReferenceExpression)
	 */
	@Test
	public void checkOperationArguments_TypedElementReferenceExpression() {
		String scope = "internal: operation myOperation(param1 : integer, param2: boolean)";
		EObject model = super.parseExpression("myOperation(5,true)", Expression.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkVarArgParameterIsLast(Operation)
	 */
	@Test
	public void checkVarArgParameterIsLast() {
		String scope = "internal: operation myOperation(param1... : integer)"
				+ "operation myOperation2(param0 : string, param1 ... : integer)";
		EObject model = super.parseExpression(scope, InternalScope.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("myOperation()", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(5)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(5,5,5)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation2('')", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation2('',5)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation2('',5,5,5)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("myOperation2('','')", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertErrorContains("Incompatible types string and integer.");

		scope = "internal: operation myOperation(param1... : integer, param2...: integer)";
		model = super.parseExpression(scope, InternalScope.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(ERROR_VAR_ARGS_LAST_CODE);

		scope = "internal: operation myOperation2(param1 ... : integer, param0 : string)";
		model = super.parseExpression(scope, InternalScope.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertError(ERROR_VAR_ARGS_LAST_CODE);

	}

	@Test
	public void checkOperationNamedParameters() {
		String scope = "internal: operation myOperation(param1 : integer, param2 : boolean)";
		EObject model = super.parseExpression(scope, InternalScope.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("myOperation(5, true)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(5, param2 = true)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(param1 = 5, true)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(param1 = 5, param2 = true)", Expression.class.getSimpleName(),
				scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("myOperation(param2 = true, param1 = 5)", Expression.class.getSimpleName(),
				scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("myOperation(param2 = true)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);

		model = super.parseExpression("myOperation(param1 = 5)", Expression.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);

	}

	@Inject
	protected TypesTestFactory typesTestFactory = TypesTestFactory.INSTANCE;

	@Test
	public void checkOptionalArgumentsAreLast() {
		Scope scope = (Scope) super.parseExpression("internal: ", InternalScope.class.getSimpleName());
		OperationDefinition op = StextTestFactory._createOperation("op", scope);
		tester.validate(scope).assertOK();

		// optional parameter last => no error
		op.getParameters().add(typesTestFactory.createParameter("p1", ITypeSystem.INTEGER, false));
		op.getParameters().add(typesTestFactory.createParameter("p2", ITypeSystem.INTEGER, true));
		tester.validate(op).assertOK();

		// optional parameter not last anymore => error
		op.getParameters().add(typesTestFactory.createParameter("p3", ITypeSystem.INTEGER, false));
		tester.validate(op).assertError(ERROR_OPTIONAL_MUST_BE_LAST_CODE);
	}

	/**
	 * @see STextJavaValidator#checkAnnotationArguments(org.yakindu.sct.model.stext.stext.AnnotationDefinition)
	 */
	@Test
	public void checkAnnotationArguments() {
		String scope = "@CycleBased";
		EObject model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertError(STextJavaValidator.ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);
		;

		scope = "@EventDriven";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	/**
	 * @see STextJavaValidator#checkAnnotationTarget(org.yakindu.base.types.AnnotatableElement)
	 */
	@Test
	public void checkAnnotationTarget() {
		// TODO: Implement me when default annotation for target is available
	}

	@Test
	public void checkAnnotations() {
		String scope;
		StatechartSpecification model;
		AssertableDiagnostics validationResult;

		statechart.setName("Annotated");

		scope = "@EventDriven";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertOK();

		scope = "@CycleBased(200)";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().clear();
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertOK();

		scope = "@CycleBased(200)\n" + "@EventDriven";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().clear();
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertErrorContains(CONTRADICTORY_ANNOTATIONS.split("%s")[0]);

		scope = "@ParentFirstExecution";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().clear();
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertOK();

		scope = "@ChildFirstExecution";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().clear();
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertOK();

		scope = "@ParentFirstExecution\n" + "@ChildFirstExecution";
		model = (StatechartSpecification) super.parseExpression(scope, StatechartSpecification.class.getSimpleName());
		statechart.getAnnotations().clear();
		statechart.getAnnotations().addAll(model.getAnnotations());
		validationResult = tester.validate(statechart);
		validationResult.assertErrorContains(CONTRADICTORY_ANNOTATIONS.split("%s")[0]);
	}

	/**
	 * @see STextJavaValidator#checkGuardHasBooleanExpression(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkGuard() {
		EObject expression = super.parseExpression("[3 * 3]", ReactionTrigger.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.GUARD_EXPRESSION);

		String scope = "internal: var myInt : integer var myBool : boolean = true";
		expression = super.parseExpression("[myInt <= 5 || !myBool ]", ReactionTrigger.class.getSimpleName(), scope);
		validationResult = tester.validate(expression);
		validationResult.assertOK();
	}

	@Test
	public void checkNoAssignmentInGuard() {
		String scope = "internal: var myInt : integer var myBool : boolean = true";
		EObject expression = super.parseExpression("[myBool = false]", ReactionTrigger.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(expression);
		validationResult.assertErrorContains(STextJavaValidator.GUARD_CONTAINS_ASSIGNMENT);

		expression = super.parseExpression("[myInt = 5]", ReactionTrigger.class.getSimpleName(), scope);
		validationResult = tester.validate(expression);
		Iterator<Diagnostic> diag = validationResult.getAllDiagnostics().iterator();
		while (diag.hasNext()) {
			Diagnostic d = diag.next();
			if (d.getMessage().equals(GUARD_EXPRESSION)) {
				assertEquals(STextJavaValidator.GUARD_EXPRESSION, d.getMessage());
			} else {
				assertEquals(STextJavaValidator.GUARD_CONTAINS_ASSIGNMENT, d.getMessage());
			}
		}

	}

	/**
	 * @see STextJavaValidator#checkFeatureCall(org.yakindu.sct.model.stext.stext.FeatureCall)
	 * @see STextJavaValidator#checkFeatureCall(TypedElementReferenceExpression)
	 */
	@Test
	public void checkFeatureCall() {
		String scope = "interface if : in event a : integer";
		EObject model = super.parseExpression("if.a / raise if.a:1", TransitionSpecification.class.getSimpleName(),
				scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	@Test
	public void checkPostFixOperatorOnlyOnVariables() {
		EObject model = super.parseExpression("ABC.intVar++", Expression.class.getSimpleName(), interfaceScope());
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("intVar++", Expression.class.getSimpleName(), internalScope());
		validationResult = tester.validate(model);
		validationResult.assertOK();
		model = super.parseExpression("5++", Expression.class.getSimpleName(), interfaceScope());
		validationResult = tester.validate(model);
		validationResult.assertError(ExpressionsJavaValidator.POSTFIX_ONLY_ON_VARIABLES_CODE);

	}

	/**
	 *
	 * @see STextJavaValidator#checkReactionTrigger(org.yakindu.sct.model.stext.stext.ReactionTrigger)
	 */
	@Test
	public void checkReactionTrigger() {
		// ENTRY, EXIT not allowed in transitions
		String scope = "internal : event a : integer var myVar : integer";
		EObject model = super.parseExpression("entry / myVar = 5", TransitionSpecification.class.getSimpleName(),
				scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertError(ENTRY_EXIT_TRIGGER_NOT_ALLOWED);

		model = super.parseExpression("exit / myVar = 5", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(ENTRY_EXIT_TRIGGER_NOT_ALLOWED);

		model = super.parseExpression("oncycle / myVar = 5", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("always / myVar = 5", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertOK();
	}

	@Test
	public void checkReactionTriggerRegularEvent() {

		String scope = "interface : in event e  var x : integer  var y : integer  operation op():integer";

		EObject model = super.parseExpression("e", TransitionSpecification.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("x", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(TRIGGER_IS_NO_EVENT);

		model = super.parseExpression("e, x", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(TRIGGER_IS_NO_EVENT);

		model = super.parseExpression("op()", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertError(TRIGGER_IS_NO_EVENT);

		model = super.parseExpression("x, y", TransitionSpecification.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertAll(errorMsg("Trigger 'x' is no event."), errorMsg("Trigger 'y' is no event."));

	}

	@Test
	public void checkRaisingExpressionEvent() {

		String scope = "interface : in event e  var x : integer  var y : integer  operation op():integer";

		EObject model = super.parseExpression("raise e", ReactionEffect.class.getSimpleName(), scope);
		AssertableDiagnostics validationResult = tester.validate(model);
		validationResult.assertOK();

		model = super.parseExpression("raise y", ReactionEffect.class.getSimpleName(), scope);
		validationResult = tester.validate(model);
		validationResult.assertAll(errorMsg("'y' is not an event."));
	}

	/**
	 * @see STextJavaValidator#checkReactionEffectActions(org.yakindu.sct.model.stext.stext.ReactionEffect)
	 */
	@Test
	public void checkReactionEffectActions() {
		String s1 = "internal : var a : integer event e operation o () : void";
		String s2 = "interface if : var a : integer in event e operation o()";

		EObject model = super.parseExpression("a", ReactionEffect.class.getSimpleName(), s1);
		AssertableDiagnostics result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("1+3", ReactionEffect.class.getSimpleName(), s1);
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(e)", ReactionEffect.class.getSimpleName(), s1);
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("o()", ReactionEffect.class.getSimpleName(), s1);
		result = tester.validate(model);
		result.assertOK();

		model = super.parseExpression("if.a", ReactionEffect.class.getSimpleName(), s2);
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("valueof(if.e)", ReactionEffect.class.getSimpleName(), s2);
		result = tester.validate(model);
		result.assertError(FEATURE_CALL_HAS_NO_EFFECT);

		model = super.parseExpression("if.o", ReactionEffect.class.getSimpleName(), s2);
		result = tester.validate(model);
		result.assertOK();

	}

	/**
	 * @see STextJavaValidator#checkEventDefinition(org.yakindu.sct.model.stext.stext.EventDefinition)
	 */
	@Test
	public void checkEventDefinition() {
		// No local declarations in interface scope
		EObject model = super.parseExpression("interface MyInterface: event Event1",
				InterfaceScope.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertErrorContains(LOCAL_DECLARATIONS);
		// No in declarations in internal scope
		model = super.parseExpression("internal: in event Event1", InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(STextJavaValidator.IN_OUT_DECLARATIONS);
		// No out declarations in internal scope
		model = super.parseExpression("internal: out event Event1", InternalScope.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertErrorContains(IN_OUT_DECLARATIONS);
	}

	/**
	 * @see STextJavaValidator#checkInterfaceScope(Statechart)
	 */
	@Test
	public void checkInterfaceScope() {
		EObject model = super.parseExpression("interface: in event event1 interface: in event event2",
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

	@Test
	public void checkExpression() {
		// Nothing to do
	}

	@Test
	public void checkContextElement() {
		// Nothing to do -> this is covered by ContextPredicateProviderTest
	}

	@Test
	public void checkValueOfNoEvent() {
		String decl = "interface: in event e1:integer var x:integer operation op():integer interface i: in event e2:integer var y:integer";

		EObject model = super.parseExpression("valueof(e1)", Expression.class.getSimpleName(), decl);
		AssertableDiagnostics result = tester.validate(model);
		result.assertOK();

		model = super.parseExpression("valueof(i.e2)", Expression.class.getSimpleName(), decl);
		result = tester.validate(model);
		result.assertOK();

		model = super.parseExpression("valueof(x)", Expression.class.getSimpleName(), decl);
		result = tester.validate(model);
		result.assertError(VALUE_OF_REQUIRES_EVENT);

		model = super.parseExpression("valueof(i.y)", Expression.class.getSimpleName(), decl);
		result = tester.validate(model);
		result.assertError(VALUE_OF_REQUIRES_EVENT);

		model = super.parseExpression("valueof(op())", Expression.class.getSimpleName(), decl);
		result = tester.validate(model);
		result.assertError(VALUE_OF_REQUIRES_EVENT);

	}

	@Test
	public void checkConstAndReadOnlyDefinitionExpression() {
		String decl = "internal: const readonly v1:integer = 0";
		EObject model = super.parseExpression(decl, InternalScope.class.getSimpleName());
		AssertableDiagnostics result = tester.validate(model);
		result.assertDiagnosticsCount(1);
		result.assertWarningContains(String.format(STextJavaValidator.DECLARATION_WITH_READONLY, "readonly", "const"));
	}

	/**
	 * checks that each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	@Test
	public void testAllChecksHaveTests() throws Exception {
		checkAvailable.assertAllChecksHaveTests(STextJavaValidator.class, this.getClass());
	}

	@Test
	public void checkUnusedEntry() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedEntryPoint.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Entry) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ENTRY_UNUSED);
	}

	@Test
	public void checkTopLeveEntryIsDefaultEntry() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TopLevelEntryIsDefaultEntryError.sct");
		doValidateAllContents(Entry.class);

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY);
		resetDiagnostics();
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TopLevelEntryIsDefaultEntryWarn.sct");
		doValidateAllContents(Entry.class);

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY);
	}

	@Test
	public void checkTopLevelRegionHasEntry() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "TopLevelRegionNoEntryPoint.sct");
		doValidateAllContents(Region.class);
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, REGION_UNBOUND_DEFAULT_ENTRY_POINT);
	}

	@Test
	public void checkUnusedExit() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedExitPoint.sct");
		doValidateAllContents(Exit.class);

		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, EXIT_UNUSED);

		resetDiagnostics();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedDefaultExitPoint.sct");
		doValidateAllContents(Exit.class);

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, EXIT_UNUSED);
	}

	@Test
	public void checkNotRaisedOutEvent() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NeverRaisedOutEvent.sct");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 2);
		assertWarning(diagnostics, String.format(OUT_EVENT_NEVER_RAISED, "NameOfOutEvent"));
		assertWarning(diagnostics, String.format(OUT_EVENT_NEVER_RAISED, "booleanOutEvent"));
	}
	
	@Test
	public void checkTransitionPropertySpec() {
		// Test source state isn't composite
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionEntrySpecNotComposite.sct");
		doValidateAllContents(Transition.class);
		// Test target state isn't composite
		assertIssueCount(diagnostics, 2);
		assertWarning(diagnostics, TRANSITION_ENTRY_SPEC_NOT_COMPOSITE);

		resetDiagnostics();
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionExitSpecNotComposite.sct");
		assertAllTransitionsAreValid(Transition.class);

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, TRANSITION_EXIT_SPEC_NOT_COMPOSITE);

		// Test exit spec is used on multiple transition siblings.
		resetDiagnostics();
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionExitSpecOnMultipleSiblings.sct");
		assertAllTransitionsAreValid(Transition.class);

		assertIssueCount(diagnostics, 4);
		assertWarning(diagnostics, TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS);

		// Test transition unbound named exit point spec.
		resetDiagnostics();
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionNotExistingNamedExitPoint.sct");
		doValidateAllContents(Transition.class);

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT);
	}

	@Test
	public void checkUnboundEntryPoints() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnboundDefaultEntryPoints.sct");
		Iterator<EObject> iter = statechart.eAllContents();

		// create and add triggers to all transitions to prevent to trigger
		// additional warnings
		// (see Check in SGrapJavaValidator transitionsWithNoGuard)
		Trigger trigger = StextFactoryImpl.init().createDefaultTrigger();

		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				validator.validate(element, diagnostics, new HashMap<>());
			}
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}

		assertIssueCount(diagnostics, 4);
		assertError(diagnostics, TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT);
		assertError(diagnostics, REGION_UNBOUND_DEFAULT_ENTRY_POINT);

		resetDiagnostics();
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnboundEntryPoints02.sct");
		iter = statechart.eAllContents();

		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				((Transition) element).setTrigger(trigger);
				validator.validate(element, diagnostics, new HashMap<>());
			}
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 5);
	}

	@Test
	public void checkExitPointSpecWithTrigger() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "NoTriggerOnTransitionWithExitPointSpec.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}

		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, EXITPOINTSPEC_WITH_TRIGGER);
	}

	@Test
	public void checkExitTransitionExists() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NoExitTransition.sct");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, EXIT_UNUSED);
	}

	@Test
	public void checkExitTransitionExistsNoSync() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "NoExitTransitionToSync.sct");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, EXIT_UNUSED);
	}

	@Test
	public void checkAssignmentToFinalVariable() {
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "AssignmentToValue.sct");
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, ERROR_ASSIGNMENT_TO_CONST_MSG);
	}

	@Test
	public void checkSyncNoTriggersOnOutgoingTransition() {
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "SynchronizationExitTransition.sct");
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, SYNC_OUTGOING_TRIGGER);
	}

	@Test
	public void checkValueDefinitionExpression() {
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "ConstWithVariable.sct");
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 3); //
		assertError(diagnostics, ExpressionsJavaValidator.REFERENCE_TO_VARIABLE);
		assertError(diagnostics, ExpressionsJavaValidator.CONST_MUST_HAVE_VALUE_MSG);
	}

	@Test
	public void checkValueReferenedBeforeDefined() {
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "ReferenceBeforeDefined.sct");
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 2);
		assertError(diagnostics, REFERENCE_CONSTANT_BEFORE_DEFINED);
	}

	@Test
	public void checkUnusedVariablesInInternalScope() {
		Statechart statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedInternalDeclarations.sct");
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(statechart);
		assertIssueCount(diagnostics, 3);
		assertWarning(diagnostics, INTERNAL_DECLARATION_UNUSED);
	}

	@Test
	public void checkImportExists() {
		Scope context = (Scope) parseExpression("import: \"does.not.exist\"", ImportScope.class.getSimpleName());
		AssertableDiagnostics validationResult = tester.validate(context);
		validationResult
				.assertErrorContains(String.format(STextValidationMessages.IMPORT_NOT_RESOLVED_MSG, "does.not.exist"));
	}

	@Test
	public void checkDuplicateImport() {
		// Can't be checked here
	}

	@Test
	public void transitionsWithNoTrigger() {
		// TODO
	}

	@Test
	public void testOptionalParameter() {
		EObject model;
		String rule = Expression.class.getSimpleName();
		AssertableDiagnostics result;

		model = parseExpression("optOp1()", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp1(3)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp1(true)", rule);
		result = tester.validate(model);
		result.assertError(ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
	}

	@Test
	public void testMultipleOptionalParameters() {
		EObject model;
		String rule = Expression.class.getSimpleName();
		AssertableDiagnostics result;

		model = parseExpression("optOp2()", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp2(3)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp2(3, 4)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp2(true)", rule);
		result = tester.validate(model);
		result.assertError(ITypeSystemInferrer.NOT_COMPATIBLE_CODE);

		model = parseExpression("optOp2(true, 3, 4)", rule);
		result = tester.validate(model);
		result.assertAll(errorCode(ITypeSystemInferrer.NOT_COMPATIBLE_CODE),
				errorCode(ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE));
	}

	@Test
	public void testMixedOptionalParameters() {
		EObject model;
		String rule = Expression.class.getSimpleName();
		AssertableDiagnostics result;

		model = parseExpression("optOp3(3)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp3(3, 4)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp3(3, 4, true)", rule);
		result = tester.validate(model);
		result.assertError(ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);

		model = parseExpression("optOp3()", rule);
		result = tester.validate(model);
		result.assertError(ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);

		model = parseExpression("optOp3(3, true)", rule);
		result = tester.validate(model);
		result.assertError(ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
	}

	@Test
	@Ignore("Why should anyone do that anyways")
	public void testMixedOptionalAndVarArgsParameters() {
		EObject model;
		String rule = Expression.class.getSimpleName();
		AssertableDiagnostics result;

		model = parseExpression("optOp4(3)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp4(3, 4)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp4(3, 4, 5, 6)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp4(3, 4, true)", rule);
		result = tester.validate(model);
		result.assertOK();

		model = parseExpression("optOp4(true)", rule);
		result = tester.validate(model);
		result.assertError(ITypeSystemInferrer.NOT_COMPATIBLE_CODE);
	}

	@Test
	public void testDuplicateNames() {
		EObject model;
		AssertableDiagnostics result;
		String scope;

		scope = "interface: var x: integer var x: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertAll(errorMsg("Duplicate"), errorMsg("Duplicate"));

		scope = "interface: var x: integer internal: var x: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertAll(errorMsg("Duplicate"), errorMsg("Duplicate"));

		scope = "interface: var x: integer interface d: var x: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertOK();

		scope = "interface: var x: integer interface x: var d: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertAll(errorMsg("Duplicate"), errorMsg("Duplicate"));

		scope = "interface: var x: integer var X: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertAll(warningMsg("Duplicate"), warningMsg("Duplicate"));

		scope = "interface: var x: integer interface X: var d: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertOK();

		scope = "interface: " + "var X: integer " + "var x: integer " + "" + "var d: integer " + " " + "interface D: "
				+ "var x: integer " + " " + "interface x: " + "var i: integer";
		model = super.parseExpression(scope, StatechartSpecification.class.getSimpleName());

		result = tester.validate(model);
		result.assertAll(warningMsg("Duplicate"), warningMsg("Duplicate"), errorMsg("Duplicate"),
				errorMsg("Duplicate"));
	}

	@Test
	public void checkUnknownEntry() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnknownEntryPoint.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Vertex) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ENTRY_NOT_EXIST + "'doesNotExist'");
	}

	@Test
	public void checkNeverUsedExit() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "UnusedExitPoint2.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Exit) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, EXIT_NEVER_USED + "'unusedExitPoint'");
	}

	@Test

	public void checkAlwaysTransitionHasLowestPriority() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionBlockingAlwaysTrueStates.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof RegularState) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 8);
	}

	@Test
	public void checkOnlyOneEntryPointSpecIsUsed() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "OnlyOneEntryPointSpecIsUsed.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ONLY_FIRST_ENTRY_POINT_WILL_BE_USED);
	}

	@Test
	public void checkAlwaysAndDefaultTransitionInChoices() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "TransitionBlockingAlwaysTrueChoices.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Choice) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 7);
	}

	@Test
	public void checkOnlyOneDefaultTransitionUsed() {
		statechart = AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + "MultipleDefaultInChoices.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Choice) {
				validator.validate(element, diagnostics, new HashMap<>());
			}
		}
		assertIssueCount(diagnostics, 4);
	}

}
