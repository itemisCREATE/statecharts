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

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Check;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.inferrer.IExpressionsTypeInferrer;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.InferenceIssue;
import org.yakindu.base.types.InferenceResult;
import org.yakindu.base.types.ParameterizedType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsJavaValidator extends org.yakindu.base.expressions.validation.AbstractExpressionsJavaValidator {

	public static final String WARNING_IS_RAW_CODE = "WarningRaw";
	public static final String WARNING_IS_RAW_MSG = "%s is a raw type. References to generic type %s should be parameterized";

	public static final String ERROR_NOT_GENERIC_CODE = "TypeNotGeneric";
	public static final String ERROR_NOT_GENERIC_MSG = "The type %s is not generic; it cannot be parameterized with arguments %s";

	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE = "IncorrectNrOfArguments";
	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG = "Incorrect number of arguments for type %s; it cannot be parameterized with arguments %s";

	public static final String ERROR_BOUND_MISSMATCH_CODE = "TypeParameterBoundMissmatch";
	public static final String ERROR_BOUND_MISSMATCH_MSG = "Bound mismatch: The type %s is not a valid substitute for the bounded parameter %s of the type %s";

	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_CODE = "DuplicateTypeParameter";
	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_MSG = "Duplicate Type Parameter %s";

	public static final String ERROR_CYCLE_DETECTED_CODE = "TypeExtendsItself";
	public static final String ERROR_CYCLE_DETECTED_MSG = "Cycle detected: the type %s cannot extend itself";

	@Inject
	private GenericsPrettyPrinter printer;

	@Inject
	private IExpressionsTypeInferrer typeInferrer;

	@Check
	public void checkIsRaw(TypedElement typedElement) {
		Type type = typedElement.getType();
		if (!(type instanceof ParameterizedType))
			return;
		EList<TypeParameter> typeParameter = ((ParameterizedType) type).getParameter();
		if (typedElement.getTypeArguments().size() == 0 && typeParameter.size() > 0) {
			String s1 = typedElement.getType().getName();
			String s2 = s1 + printer.concatTypeParameter(typeParameter);
			warning(String.format(WARNING_IS_RAW_MSG, s1, s2), typedElement, TypesPackage.Literals.TYPED_ELEMENT__TYPE,
					WARNING_IS_RAW_CODE);
		}
	}

	@Check
	public void checkTypedElementNotGeneric(TypedElement typedElement) {
		if (typedElement.getTypeArguments().size() > 0
				&& ((!(typedElement.getType() instanceof ParameterizedType)) || ((ParameterizedType) typedElement
						.getType()).getParameter().size() == 0)) {
			String s1 = typedElement.getType().getName();
			String s2 = printer.concatTypeArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_NOT_GENERIC_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPED_ELEMENT__TYPE, ERROR_NOT_GENERIC_CODE);
		}
	}

	@Check
	public void checkNofArguments(TypedElement typedElement) {
		if (!(typedElement.getType() instanceof ParameterizedType)) {
			return;
		}
		ParameterizedType type = (ParameterizedType) typedElement.getType();
		EList<TypeParameter> typeParameter = type.getParameter();
		if (typedElement.getTypeArguments().size() > 0
				&& (typedElement.getTypeArguments().size() != typeParameter.size()) && typeParameter.size() > 0) {
			String s1 = type.getName() + printer.concatTypeParameter(typeParameter);
			String s2 = printer.concatTypeArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPED_ELEMENT__TYPE, ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE);
		}
	}

	@Check
	public void checkDuplicateTypeParameter(ParameterizedType type) {
		Set<String> names = Sets.newHashSet();
		EList<TypeParameter> typeParameter = type.getParameter();
		for (TypeParameter param : typeParameter) {
			String name = param.getName();
			if (names.contains(name)) {
				error(String.format(ERROR_DUPLICATE_TYPE_PARAMETER_MSG, name), type,
						TypesPackage.Literals.PARAMETERIZED_TYPE__PARAMETER, ERROR_DUPLICATE_TYPE_PARAMETER_CODE);
			}
			names.add(name);
		}
	}

	@Check
	public void checkTypeParameterBounds(TypedElement typedElement) {
		if (!(typedElement.getType() instanceof ParameterizedType)) {
			return;
		}
		ParameterizedType type = (ParameterizedType) typedElement.getType();
		EList<TypeParameter> typeParameter = type.getParameter();
		if (typedElement.getTypeArguments().size() == 0
				|| (typedElement.getTypeArguments().size() != typeParameter.size()))
			return;
		for (int i = 0; i < typeParameter.size(); i++) {
			TypeParameter parameter = typeParameter.get(i);
			if (parameter.getBound() != null) {
				Type argument = typedElement.getTypeArguments().get(i);
				if (!isTypeCompatible(parameter.getBound(), argument)) {
					error(String.format(ERROR_BOUND_MISSMATCH_MSG, argument.getName(),
							(parameter.getBound()).getName(), type.getName()), typedElement,
							TypesPackage.Literals.TYPED_ELEMENT__TYPE_ARGUMENTS, i, ERROR_BOUND_MISSMATCH_CODE);
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
	public void checkExpressionIsTypeCompatible(Expression expression) {
		try {
			InferenceResult result = typeInferrer.inferType(expression);
			report(result, null);
		} catch (IllegalArgumentException e) {
			// ignore unknown literals here, as this also happens when a
			// linking problem occurred, which is handled in other locations
		}
	}
	
	protected void report(InferenceResult result, EStructuralFeature feature) {
		if (result.getIssues().isEmpty())
			return;
		InferenceIssue error = Iterables.getLast(result.getIssues());
		error(error.getMessage(), feature);
	}

	// TODO: USE ITypeSystem
	private boolean isTypeCompatible(Type bound, Type argument) {
		if (EcoreUtil.equals(bound, argument))
			return true;
		if (argument instanceof ComplexType && ((ComplexType) argument).getSuperTypes().size() > 0) {
			ComplexType superType = ((ComplexType) argument).getSuperTypes().get(0);
			return isTypeCompatible(bound, superType);
		}
		return false;
	}
}
