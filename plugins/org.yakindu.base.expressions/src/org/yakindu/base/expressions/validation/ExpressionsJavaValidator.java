/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.base.expressions.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.yakindu.base.expressions.expressions.Argument;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;
import org.yakindu.base.types.validation.TypesJavaValidator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ComposedChecks(validators = { TypesJavaValidator.class })
public class ExpressionsJavaValidator extends org.yakindu.base.expressions.validation.AbstractExpressionsJavaValidator
		implements IValidationIssueAcceptor {

	@Inject
	private ITypeSystemInferrer typeInferrer;

	@Check
	public void checkExpression(Expression expression) {
		// Only infer root expressions since inferType infers the expression
		// containment hierarchy
		if (!(expression.eContainer() instanceof Expression))
			typeInferrer.infer(expression, this);
	}
	
	@Check(CheckType.FAST)
	public void checkExpression(Property expression) {
		if (expression.getType() == null || expression.getType().eIsProxy())
			return;
		typeInferrer.infer(expression, this);
	}

	public void accept(ValidationIssue issue) {
		switch (issue.getSeverity()) {
		case ERROR:
			error(issue.getMessage(), null, issue.getIssueCode());
			break;
		case WARNING:
			warning(issue.getMessage(), null, issue.getIssueCode());
			break;
		case INFO:
			break;
		}
	}

	public static final String POSTFIX_ONLY_ON_VARIABLES_CODE = "PostfixOnlyOnVariables";
	public static final String POSTFIX_ONLY_ON_VARIABLES_MSG = "Invalid argument to operator '++/--'";

	@Check
	public void checkPostFixOperatorOnlyOnVariables(PostFixUnaryExpression expression) {
		if (!(expression.getOperand() instanceof ElementReferenceExpression)
				&& !(expression.getOperand() instanceof FeatureCall)) {
			error(POSTFIX_ONLY_ON_VARIABLES_MSG, expression, null, POSTFIX_ONLY_ON_VARIABLES_CODE);
		}
	}

	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_CODE = "ErrorDuplicateParameterAssignment";
	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_MSG = "Duplicate assignment to parameter '%s'.";

	@Check
	public void checkDuplicateParameterAssignment(ArgumentExpression exp) {
		Set<Parameter> assignedParameters = new HashSet<>();
		EList<Argument> arguments = exp.getArguments();
		for (Argument argument : arguments) {
			if (argument.getParameter() != null) {
				if (assignedParameters.contains(argument.getParameter())) {
					error(String.format(ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_MSG, argument.getParameter().getName()),
							argument, null, ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_CODE);
					break;
				}
				assignedParameters.add(argument.getParameter());
			}
		}
	}

	public static final String ERROR_ASSIGNMENT_TO_CONST_CODE = "AssignmentToConst";
	public static final String ERROR_ASSIGNMENT_TO_CONST_MSG = "Assignment to constant not allowed.";

	@Check(CheckType.FAST)
	public void checkAssignmentToFinalVariable(AssignmentExpression exp) {
		Expression varRef = exp.getVarRef();
		EObject referencedObject = null;
		if (varRef instanceof FeatureCall)
			referencedObject = ((FeatureCall) varRef).getFeature();
		else if (varRef instanceof ElementReferenceExpression)
			referencedObject = ((ElementReferenceExpression) varRef).getReference();
		if (referencedObject instanceof Property) {
			if (((Property) referencedObject).isConst()) {
				error(ERROR_ASSIGNMENT_TO_CONST_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
						ERROR_ASSIGNMENT_TO_CONST_CODE);
			}
		}
	}

	public static final String ERROR_LEFT_HAND_ASSIGNMENT_CODE = "LeftHandAssignment";
	public static final String ERROR_LEFT_HAND_ASSIGNMENT_MSG = "The left-hand side of an assignment must be a variable.";

	@Check(CheckType.FAST)
	public void checkLeftHandAssignment(final AssignmentExpression expression) {
		Expression varRef = expression.getVarRef();
		if (varRef instanceof FeatureCall) {
			EObject referencedObject = ((FeatureCall) varRef).getFeature();
			if (!(referencedObject instanceof Property)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
						ERROR_LEFT_HAND_ASSIGNMENT_CODE);
			}
		} else if (varRef instanceof ElementReferenceExpression) {
			EObject referencedObject = ((ElementReferenceExpression) varRef).getReference();
			if (!(referencedObject instanceof Property) && !(referencedObject instanceof Parameter)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
						ERROR_LEFT_HAND_ASSIGNMENT_CODE);
			}

		} else {
			error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF,
					ERROR_LEFT_HAND_ASSIGNMENT_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_FeatureCall(final FeatureCall call) {
		if (call.getFeature() instanceof Operation) {
			Operation operation = (Operation) call.getFeature();
			assertOperationArguments(operation, call.getExpressions());
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_TypedElementReferenceExpression(final ElementReferenceExpression call) {
		if (call.getReference() instanceof Operation) {
			Operation operation = (Operation) call.getReference();
			assertOperationArguments(operation, call.getExpressions());
		}
	}

	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE = "WrongNrOfArgs";
	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG = "Wrong number of arguments, expected %s .";

	protected void assertOperationArguments(Operation operation, List<Expression> args) {
		EList<Parameter> parameters = operation.getParameters();
		List<Parameter> optionalParameters = filterOptionalParameters(parameters);
		if ((operation.isVariadic() && operation.getVarArgIndex() > args.size())
				|| (!operation.isVariadic() && !(args.size() <= parameters.size()
						&& args.size() >= parameters.size() - optionalParameters.size()))) {
			error(String.format(ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG, parameters), null,
					ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);
		}
	}

	protected List<Parameter> filterOptionalParameters(EList<Parameter> parameters) {
		List<Parameter> optionalParameters = new ArrayList<>();
		for (Parameter p : parameters) {
			if (p.isOptional()) {
				optionalParameters.add(p);
			}
		}
		return optionalParameters;
	}

	public static final String ERROR_WRONG_ANNOTATION_TARGET_CODE = "WrongAnnotationTarget";
	public static final String ERROR_WRONG_ANNOTATION_TARGET_MSG = "Annotation '%s' can not be applied on %s .";

	@Check(CheckType.FAST)
	public void checkAnnotationTarget(final AnnotatableElement element) {
		EList<Annotation> annotations = element.getAnnotations();
		for (Annotation annotation : annotations) {
			EList<EObject> targets = annotation.getType().getTargets();
			if (targets.isEmpty())
				continue;
			boolean found = Iterables.any(targets, new Predicate<EObject>() {
				@Override
				public boolean apply(EObject input) {
					return ((EClass) input).isInstance(element);
				}
			});
			if (!found) {
				error(String.format(ERROR_WRONG_ANNOTATION_TARGET_MSG, annotation.getType().getName(),
						element.eClass()), null, element.getAnnotations().indexOf(annotation),
						ERROR_WRONG_ANNOTATION_TARGET_CODE);
			}
		}
	}
	
	public static final String CONST_MUST_HAVE_VALUE_MSG = "A constant definition must specify an initial value.";
	public static final String CONST_MUST_HAVE_VALUE_CODE = "ConstMustHaveAValue";
	public static final String REFERENCE_TO_VARIABLE = "Cannot reference a variable in a constant initialization.";
	
	@Check(CheckType.FAST)
	public void checkValueDefinitionExpression(Property property) {
		// applies only to constants
		if (!property.isConst())
			return;
		Expression initialValue = property.getInitialValue();
		if (initialValue == null) {
			error(CONST_MUST_HAVE_VALUE_MSG, property, null, CONST_MUST_HAVE_VALUE_CODE);
			return;
		}
		List<Expression> toCheck = Lists.newArrayList(initialValue);
		TreeIterator<EObject> eAllContents = initialValue.eAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			if (next instanceof Expression)
				toCheck.add((Expression) next);
		}
		for (Expression expression : toCheck) {
			EObject referencedObject = null;
			if (expression instanceof FeatureCall)
				referencedObject = ((FeatureCall) expression).getFeature();
			else if (expression instanceof ElementReferenceExpression)
				referencedObject = ((ElementReferenceExpression) expression).getReference();
			if (referencedObject instanceof Property) {
				if (!((Property) referencedObject).isConst()) {
					error(REFERENCE_TO_VARIABLE, TypesPackage.Literals.PROPERTY__INITIAL_VALUE);
				}
			}
		}
	}
	
	public static final String DECLARATION_WITH_READONLY = "The keyword '%s' has no effect for '%s' definitions. Can be removed.";
	
	@Check(CheckType.FAST)
	public void checkConstAndReadOnlyDefinitionExpression(Property definition) {
		// applies only for readonly const definitions
		if (!definition.isReadonly() && !definition.isConst())
			return;
		ICompositeNode definitionNode = NodeModelUtils.getNode(definition);
		String tokenText = NodeModelUtils.getTokenText(definitionNode);

		if (tokenText == null || tokenText.isEmpty())
			return;
		if (tokenText.contains(TypesPackage.Literals.PROPERTY__READONLY.getName())
				&& tokenText.contains(TypesPackage.Literals.PROPERTY__CONST.getName())) {
			warning(String.format(DECLARATION_WITH_READONLY,
					TypesPackage.Literals.PROPERTY__READONLY.getName(),
					TypesPackage.Literals.PROPERTY__CONST.getName()), definition,
					TypesPackage.Literals.PROPERTY__READONLY);
		}
	}
}