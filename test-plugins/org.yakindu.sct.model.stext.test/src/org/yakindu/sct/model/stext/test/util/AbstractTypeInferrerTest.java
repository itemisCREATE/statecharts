package org.yakindu.sct.model.stext.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

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

	protected Type inferTypeForExpression(String expression, String scopes) {
		return inferType(expression, Expression.class.getSimpleName(), scopes);
	}

	protected Type inferType(String expression, String parserRule, String scopes) {
		EObject parseResult = super.parseExpression(expression, parserRule, scopes);
		assertNotNull(parseResult);
		acceptor = new ListBasedValidationIssueAcceptor();
		if (parseResult instanceof Expression) {
			return typeInferrer.inferType((Expression) parseResult, acceptor);
		} else if (parseResult instanceof EventDefinition) {
			return typeInferrer.inferType((EventDefinition) parseResult, acceptor);
		} else if (parseResult instanceof VariableDefinition) {
			return typeInferrer.inferType((VariableDefinition) parseResult, acceptor);
		} else {
			throw new IllegalArgumentException("Unsupported parse result.");
		}
	}
	
	protected boolean isType(Type type, String typeName) {
		return typeSystem.isSame(type, typeSystem.getType(typeName));
	}

	protected boolean isVoidType(Type type) {
		return isType(type, "void");
	}

	protected boolean isIntegerType(Type type) {
		return isType(type, "integer");
	}

	protected boolean isRealType(Type type) {
		return isType(type, "real");
	}

	protected boolean isBooleanType(Type type) {
		return isType(type, "boolean");
	}

	protected boolean isStringType(Type type) {
		return isType(type, "string");
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
	
	protected void expectNoErrors(String expression, String scope) {
		ListBasedValidationIssueAcceptor diagnostics = validate(expression, scope);
		List<ValidationIssue> errors = diagnostics.getTraces(Severity.ERROR);
		assertEquals(errors.toString(), 0, errors.size());
	}
	
	protected void expectWarning(String expression, String scope, String code) {
		List<ValidationIssue> traces = validate(expression, scope).getTraces(Severity.WARNING);
		List<ValidationIssue> issues = filterForIssueCode(traces, code);
		assertEquals(Arrays.toString(traces.toArray()), 1, issues.size());
	}
	
	protected void expectError(String expression, String scope, String code) {
		List<ValidationIssue> traces = validate(expression, scope).getTraces(Severity.ERROR);
		List<ValidationIssue> issues = filterForIssueCode(traces, code);
		assertEquals(Arrays.toString(traces.toArray()), 1, issues.size());
	}
	
	private List<ValidationIssue> filterForIssueCode(List<ValidationIssue> traces, final String code) {
		return Lists.newArrayList(Iterables.filter(traces, new Predicate<ValidationIssue>() {
			@Override
			public boolean apply(ValidationIssue input) {
				return input.getIssueCode().equals(code);
			}
		}));
	}
	
	protected ListBasedValidationIssueAcceptor validate(String expression, String scope) {
		EObject exp = parseExpression(expression, Expression.class.getSimpleName(), scope);
		ListBasedValidationIssueAcceptor diagnostics = new ListBasedValidationIssueAcceptor();
		typeInferrer.inferType(exp, diagnostics);
		return diagnostics;
	}
}
