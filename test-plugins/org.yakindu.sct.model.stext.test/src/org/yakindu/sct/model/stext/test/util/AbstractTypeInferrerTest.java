/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */

package org.yakindu.sct.model.stext.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import junit.framework.TestCase;

public abstract class AbstractTypeInferrerTest extends AbstractSTextTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Inject
	protected ITypeSystem typeSystem;
	@Inject
	protected ITypeSystemInferrer typeInferrer;
	
	protected ListBasedValidationIssueAcceptor acceptor;
	

	protected Type inferType(String expression) {
		return inferTypeForExpression(expression, super.internalScope() + "\n" + super.interfaceScope());
	}
	
	protected Type inferType(String expression, String parserRule) {
		return inferType(expression, parserRule, super.internalScope() + "\n" + super.interfaceScope());
	}
	
	protected InferenceResult inferTypeResultForExpression(String expression, String scopes) {
		return inferTypeResult(expression, Expression.class.getSimpleName(), scopes);
	}

	protected Type inferTypeForExpression(String expression, String scopes) {
		return inferType(expression, Expression.class.getSimpleName(), scopes);
	}
	
	protected Type inferType(String expression, String parserRule, String scopes) {
		InferenceResult inferTypeResult = inferTypeResult(expression, parserRule, scopes);
		if(inferTypeResult == null)
			return null;
		return inferTypeResult.getType();
	}

	protected InferenceResult inferTypeResult(String expression, String parserRule, String scopes) {
		EObject parseResult = super.parseExpression(expression, parserRule, scopes);
		assertNotNull(parseResult);
		acceptor = new ListBasedValidationIssueAcceptor();
		return typeInferrer.infer(parseResult, acceptor);
	}

	protected boolean isType(Type type, String typeName) {
		return typeSystem.isSame(type, typeSystem.getType(typeName));
	}
	
	protected boolean isVoidType(Type type) {
		return isType(type, ITypeSystem.VOID);
	}
	
	protected boolean isIntegerType(Type type) {
		return isType(type, ITypeSystem.INTEGER);
	}
	
	protected boolean isRealType(Type type) {
		return isType(type, ITypeSystem.REAL);
	}
	
	protected boolean isBooleanType(Type type) {
		return isType(type, ITypeSystem.BOOLEAN);
	}
	
	protected boolean isStringType(Type type) {
		return isType(type, ITypeSystem.STRING);
	}

	protected boolean isAnyType(Type type) {
		return isType(type, ITypeSystem.ANY);
	}

	protected void expectIssue(Type object, String message) {
		if (acceptor.getTraces(
				org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity.ERROR).isEmpty()) {
			TestCase.fail("No issue detected.");
		}
		assertEquals(
				message,
				acceptor.getTraces(
						org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity.ERROR)
				.iterator().next().getMessage());
	}

	protected void expectNoErrors(EObject element) {
		ListBasedValidationIssueAcceptor diagnostics = validate(element);
		assertNoErrors(diagnostics);
	}

	protected void expectNoErrors(String expression, String scope) {
		ListBasedValidationIssueAcceptor diagnostics = validate(expression, scope);
		assertNoErrors(diagnostics);
	}

	protected void assertNoErrors(ListBasedValidationIssueAcceptor diagnostics) {
		List<ValidationIssue> errors = diagnostics.getTraces(Severity.ERROR);
		assertEquals(errors.toString(), 0, errors.size());
	}

	protected void expectWarning(EObject element, String code) {
		ListBasedValidationIssueAcceptor diagnostics = validate(element);
		assertWarning(diagnostics, code);
	}

	protected void expectWarning(String expression, String scope, String code) {
		ListBasedValidationIssueAcceptor diagnostics = validate(expression, scope);
		assertWarning(diagnostics, code);
	}
	
	protected void assertWarning(ListBasedValidationIssueAcceptor diagnostics, String code) {
		List<ValidationIssue> traces = diagnostics.getTraces(Severity.WARNING);
		List<ValidationIssue> issues = filterForIssueCode(traces, code);
		assertEquals(Arrays.toString(traces.toArray()), 1, issues.size());
	}
	
	protected void expectError(EObject element, String code) {
		ListBasedValidationIssueAcceptor diagnostics = validate(element);
		assertError(diagnostics, code);
	}

	protected void expectError(String expression, String scope, String code) {
		ListBasedValidationIssueAcceptor diagnostics = validate(expression, scope);
		assertError(diagnostics, code);
	}
	
	protected void assertError(ListBasedValidationIssueAcceptor diagnostics, String code) {
		List<ValidationIssue> traces = diagnostics.getTraces(Severity.ERROR);
		List<ValidationIssue> issues = filterForIssueCode(traces, code);
		assertEquals(Arrays.toString(traces.toArray()), 1, issues.size());
	}

	protected void expectErrors(EObject element, String code, int noOfErrors) {
		ListBasedValidationIssueAcceptor diagnostics = validate(element);
		assertErrors(diagnostics, code, noOfErrors);
	}

	protected void expectErrors(String expression, String scope, String code, int noOfErrors) {
		ListBasedValidationIssueAcceptor diagnostics = validate(expression, scope);
		assertErrors(diagnostics, code, noOfErrors);
	}
	
	protected void assertErrors(ListBasedValidationIssueAcceptor diagnostics, String code, int noOfErrors) {
		List<ValidationIssue> traces = diagnostics.getTraces(Severity.ERROR);
		List<ValidationIssue> issues = filterForIssueCode(traces, code);
		assertEquals(Arrays.toString(traces.toArray()), noOfErrors, issues.size());
	}

	protected List<ValidationIssue> filterForIssueCode(List<ValidationIssue> traces, final String code) {
		return Lists.newArrayList(Iterables.filter(traces, new Predicate<ValidationIssue>() {
			@Override
			public boolean apply(ValidationIssue input) {
				return input.getIssueCode().equals(code);
			}
		}));
	}

	protected ListBasedValidationIssueAcceptor validate(String expression, String scope) {
		EObject exp = parseExpression(expression, Expression.class.getSimpleName(), scope);
		return validate(exp);
	}

	protected ListBasedValidationIssueAcceptor validate(EObject element) {
		ListBasedValidationIssueAcceptor diagnostics = new ListBasedValidationIssueAcceptor();
		typeInferrer.infer(element, diagnostics);
		return diagnostics;
	}
}
