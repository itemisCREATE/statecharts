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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.base.expressions.expressions.Argument;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsJavaValidator extends org.yakindu.base.expressions.validation.AbstractExpressionsJavaValidator
		implements IValidationIssueAcceptor {

	public static final String WARNING_IS_RAW_CODE = "WarningRaw";
	public static final String WARNING_IS_RAW_MSG = "%s is a raw type. References to generic type %s should be parameterized.";

	public static final String ERROR_NOT_GENERIC_CODE = "TypeNotGeneric";
	public static final String ERROR_NOT_GENERIC_MSG = "The type %s is not generic; it cannot be parameterized with arguments %s.";

	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE = "IncorrectNrOfArguments";
	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG = "Incorrect number of arguments for type %s; it cannot be parameterized with arguments %s.";

	public static final String ERROR_BOUND_MISSMATCH_CODE = "TypeParameterBoundMissmatch";
	public static final String ERROR_BOUND_MISSMATCH_MSG = "Bound mismatch: The type %s is not a valid substitute for the bounded parameter %s of the type %s.";

	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_CODE = "DuplicateTypeParameter";
	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_MSG = "Duplicate Type Parameter %s.";

	public static final String ERROR_CYCLE_DETECTED_CODE = "TypeExtendsItself";
	public static final String ERROR_CYCLE_DETECTED_MSG = "Cycle detected: the type %s cannot extend itself.";

	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_CODE = "ErrorDuplicateParameterAssignment";
	public static final String ERROR_DUPLICATE_PARAMETER_ASSIGNMENT_MSG = "Duplicate assignment to parameter '%s'.";
	
	public static final String ERROR_ASSIGNMENT_TO_CONST_MSG = "Assignment to constant not allowed.";
	public static final String ERROR_ASSIGNMENT_TO_CONST_CODE = "AssignmentToConst";
	
	public static final String ERROR_LEFT_HAND_ASSIGNMENT_MSG = "The left-hand side of an assignment must be a variable.";
	public static final String ERROR_LEFT_HAND_ASSIGNMENT_CODE = "LeftHandAssignment";
	
	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG = "Wrong number of arguments, expected %s .";
	public static final String ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE = "WrongNrOfArgs";
	
	public static final String ERROR_VAR_ARGS_LAST_CODE = "VarArgsMustBeLast";
	public static final String ERROR_VAR_ARGS_LAST_MSG = "The variable argument type must be the last argument.";
	
	public static final String ERROR_WRONG_ANNOTATION_TARGET_CODE = "WrongAnnotationTarget";
	public static final String ERROR_WRONG_ANNOTATION_TARGET_MSG = "Annotation '%s' can not be applied on %s ";
	
	public static final String ERROR_OPTIONAL_MUST_BE_LAST_CODE = "OptionalParametersLast";
	public static final String ERROR_OPTIONAL_MUST_BE_LAST_MSG = "Required parameters must not be defined after optional parameters.";

	@Inject
	private GenericsPrettyPrinter printer;
	@Inject
	private ITypeSystemInferrer typeInferrer;
	@Inject
	private ITypeSystem typeSystem;

	@Check
	public void checkExpression(Expression expression) {
		// Only infer root expressions since inferType infers the expression
		// containment hierarchy
		if (!(expression.eContainer() instanceof Expression))
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

	@Check
	public void checkIsRaw(TypeSpecifier typedElement) {
		Type type = typedElement.getType();
		if (!(type instanceof GenericElement))
			return;
		EList<TypeParameter> typeParameter = ((GenericElement) type).getTypeParameters();
		if (typedElement.getTypeArguments().size() == 0 && typeParameter.size() > 0) {
			String s1 = typedElement.getType().getName();
			String s2 = s1 + printer.concatTypeParameter(typeParameter);
			warning(String.format(WARNING_IS_RAW_MSG, s1, s2), typedElement, TypesPackage.Literals.TYPE_SPECIFIER__TYPE,
					WARNING_IS_RAW_CODE);
		}
	}

	@Check
	public void checkTypedElementNotGeneric(TypeSpecifier typedElement) {
		if (typedElement.getTypeArguments().size() > 0 && ((!(typedElement.getType() instanceof GenericElement))
				|| ((GenericElement) typedElement.getType()).getTypeParameters().size() == 0)) {
			String s1 = typedElement.getType().getName();
			String s2 = printer.concatTypeArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_NOT_GENERIC_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPE_SPECIFIER__TYPE, ERROR_NOT_GENERIC_CODE);
		}
	}

	@Check
	public void checkNofArguments(TypeSpecifier typedElement) {
		if (!(typedElement.getType() instanceof GenericElement)) {
			return;
		}
		GenericElement type = (GenericElement) typedElement.getType();
		EList<TypeParameter> typeParameter = type.getTypeParameters();
		if (typedElement.getTypeArguments().size() > 0
				&& (typedElement.getTypeArguments().size() != typeParameter.size()) && typeParameter.size() > 0) {
			String s1 = type.getName() + printer.concatTypeParameter(typeParameter);
			String s2 = printer.concatTypeArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPE_SPECIFIER__TYPE, ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE);
		}
	}

	@Check
	public void checkDuplicateTypeParameter(GenericElement type) {
		Set<String> names = Sets.newHashSet();
		EList<TypeParameter> typeParameter = type.getTypeParameters();
		for (TypeParameter param : typeParameter) {
			String name = param.getName();
			if (names.contains(name)) {
				error(String.format(ERROR_DUPLICATE_TYPE_PARAMETER_MSG, name), type,
						TypesPackage.Literals.GENERIC_ELEMENT__TYPE_PARAMETERS, ERROR_DUPLICATE_TYPE_PARAMETER_CODE);
			}
			names.add(name);
		}
	}

	@Check
	public void checkTypeParameterBounds(TypeSpecifier typedElement) {
		if (!(typedElement.getType() instanceof GenericElement)) {
			return;
		}
		GenericElement type = (GenericElement) typedElement.getType();
		EList<TypeParameter> typeParameter = type.getTypeParameters();
		if (typedElement.getTypeArguments().size() == 0
				|| (typedElement.getTypeArguments().size() != typeParameter.size()))
			return;
		for (int i = 0; i < typeParameter.size(); i++) {
			TypeParameter parameter = typeParameter.get(i);
			if (parameter.getBound() != null) {
				Type argument = typedElement.getTypeArguments().get(i).getType();
				if (!typeSystem.isSuperType(argument, parameter.getBound())) {
					error(String.format(ERROR_BOUND_MISSMATCH_MSG, argument.getName(), (parameter.getBound()).getName(),
							type.getName()), typedElement, TypesPackage.Literals.TYPE_SPECIFIER__TYPE_ARGUMENTS, i,
							ERROR_BOUND_MISSMATCH_CODE);
				}
			}
		}
	}

	@Check
	public void checkTypeNotExtendsItself(ComplexType type) {
		EList<ComplexType> superTypes = type.getSuperTypes();
		for (ComplexType superType : superTypes) {
			if (superType.equals(type)) {
				error(String.format(ERROR_CYCLE_DETECTED_MSG, type.getName()), type,
						TypesPackage.Literals.COMPLEX_TYPE__SUPER_TYPES, ERROR_CYCLE_DETECTED_CODE);
			}
		}
	}

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
				error(ERROR_ASSIGNMENT_TO_CONST_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF, ERROR_ASSIGNMENT_TO_CONST_CODE);
			}
		}
	}
	
	@Check(CheckType.FAST)
	public void checkLeftHandAssignment(final AssignmentExpression expression) {
		Expression varRef = expression.getVarRef();
		if (varRef instanceof FeatureCall) {
			EObject referencedObject = ((FeatureCall) varRef).getFeature();
			if (!(referencedObject instanceof Property)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF, ERROR_LEFT_HAND_ASSIGNMENT_CODE);
			}
		} else if (varRef instanceof ElementReferenceExpression) {
			EObject referencedObject = ((ElementReferenceExpression) varRef).getReference();
			if (!(referencedObject instanceof Property)) {
				error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF, ERROR_LEFT_HAND_ASSIGNMENT_CODE);
			}

		} else {
			error(ERROR_LEFT_HAND_ASSIGNMENT_MSG, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF, ERROR_LEFT_HAND_ASSIGNMENT_CODE);
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

	protected void assertOperationArguments(Operation operation, List<Expression> args) {
		EList<Parameter> parameters = operation.getParameters();
		if ((operation.isVariadic() && operation.getVarArgIndex() > args.size())
				|| !operation.isVariadic() && parameters.size() != args.size()) {
			error(String.format(ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG, parameters), null, ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);
		}
	}
	
	@Check(CheckType.FAST)
	public void checkVarArgParameterIsLast(Operation operation) {
		if (operation.isVariadic() && operation.getVarArgIndex() != operation.getParameters().size() - 1) {
			error(ERROR_VAR_ARGS_LAST_MSG, operation.getParameters().get(operation.getVarArgIndex()), null,
					ERROR_VAR_ARGS_LAST_CODE);
		}
	}
	
	@Check(CheckType.FAST)
	public void checkAnnotationTarget(final AnnotatableElement element) {
		EList<Annotation> annotations = element.getAnnotations();
		for (Annotation annotation : annotations) {
			EList<EObject> targets = annotation.getType().getTargets();
			if(targets.isEmpty())
				continue;
			boolean found = Iterables.any(targets, new Predicate<EObject>() {
				@Override
				public boolean apply(EObject input) {
					return ((EClass) input).isInstance(element);
				}
			});
			if (!found) {
				error(String.format(ERROR_WRONG_ANNOTATION_TARGET_MSG, annotation.getType().getName(),
						element.eClass()), null,
						element.getAnnotations().indexOf(annotation), ERROR_WRONG_ANNOTATION_TARGET_CODE);
			}
		}
	}
	
	@Check(CheckType.FAST)
	public void checkOptionalArgumentsAreLast(Operation op) {
		boolean foundOptional = false;
		for (Parameter p : op.getParameters()) {
			if (foundOptional && !p.isOptional()) {
				error(ERROR_OPTIONAL_MUST_BE_LAST_MSG, p, null, ERROR_OPTIONAL_MUST_BE_LAST_CODE);
			}
			if (p.isOptional()) {
				foundOptional = true;
			}
		}
	}

}