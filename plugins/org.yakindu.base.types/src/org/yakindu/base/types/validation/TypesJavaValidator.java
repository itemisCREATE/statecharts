/**
 * Copyright (c) 2014 - 2018 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	itemis AG - initial API and implementation
 *
 */
package org.yakindu.base.types.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Validation rules for types.ecore
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class TypesJavaValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Inject
	private ITypeSystem typeSystem;

	public static final String WARNING_IS_RAW_CODE = "WarningRaw";
	public static final String WARNING_IS_RAW_MSG = "%s is a raw type. References to generic type %s should be parameterized.";

	@Check
	public void checkIsRaw(TypeSpecifier typedElement) {
		Type type = typedElement.getType();
		if (!(type instanceof GenericElement))
			return;
		EList<TypeParameter> typeParameter = ((GenericElement) type).getTypeParameters();
		if (typedElement.getTypeArguments().size() == 0 && typeParameter.size() > 0) {
			String s1 = typedElement.getType().getName();
			String s2 = s1 + prettyPrintTypes(typeParameter);
			warning(String.format(WARNING_IS_RAW_MSG, s1, s2), typedElement, TypesPackage.Literals.TYPE_SPECIFIER__TYPE,
					WARNING_IS_RAW_CODE);
		}
	}

	public static final String ERROR_NOT_GENERIC_CODE = "TypeNotGeneric";
	public static final String ERROR_NOT_GENERIC_MSG = "The type %s is not generic; it cannot be parameterized with arguments %s.";

	@Check
	public void checkTypedElementNotGeneric(TypeSpecifier typedElement) {
		if (typedElement.getTypeArguments().size() > 0 && ((!(typedElement.getType() instanceof GenericElement))
				|| ((GenericElement) typedElement.getType()).getTypeParameters().size() == 0)) {
			String s1 = typedElement.getType().getName();
			String s2 = prettyPrintArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_NOT_GENERIC_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPE_SPECIFIER__TYPE, ERROR_NOT_GENERIC_CODE);
		}
	}

	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE = "IncorrectNrOfArguments";
	public static final String ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG = "Incorrect number of arguments for type %s; it cannot be parameterized with arguments %s.";

	@Check
	public void checkNofArguments(TypeSpecifier typedElement) {
		if (!(typedElement.getType() instanceof GenericElement)) {
			return;
		}
		GenericElement type = (GenericElement) typedElement.getType();
		EList<TypeParameter> typeParameter = type.getTypeParameters();
		if (typedElement.getTypeArguments().size() > 0
				&& (typedElement.getTypeArguments().size() != typeParameter.size()) && typeParameter.size() > 0) {
			String s1 = type.getName() + prettyPrintTypes(typeParameter);
			String s2 = prettyPrintArguments(typedElement.getTypeArguments());
			error(String.format(ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_MSG, s1, s2), typedElement,
					TypesPackage.Literals.TYPE_SPECIFIER__TYPE, ERROR_ARGUMENTED_SPECIFIER_INCORRECT_ARGUMENT_NR_CODE);
		}
	}

	public static final String ERROR_BOUND_MISSMATCH_CODE = "TypeParameterBoundMissmatch";
	public static final String ERROR_BOUND_MISSMATCH_MSG = "Bound mismatch: The type %s is not a valid substitute for the bounded parameter %s of the type %s.";

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

	public static final String ERROR_CYCLE_DETECTED_CODE = "TypeExtendsItself";
	public static final String ERROR_CYCLE_DETECTED_MSG = "Cycle detected: the type %s cannot extend itself.";

	@Check
	public void checkTypeNotExtendsItself(ComplexType type) {
		EList<TypeSpecifier> superTypes = type.getSuperTypes();
		for (TypeSpecifier superType : superTypes) {
			if (superType.getType().equals(type)) {
				error(String.format(ERROR_CYCLE_DETECTED_MSG, type.getName()), type,
						TypesPackage.Literals.TYPE__SUPER_TYPES, ERROR_CYCLE_DETECTED_CODE);
			}
		}
	}

	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_CODE = "DuplicateTypeParameter";
	public static final String ERROR_DUPLICATE_TYPE_PARAMETER_MSG = "Duplicate type parameter %s.";

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

	public static final String ERROR_VAR_ARGS_LAST_CODE = "VarArgsMustBeLast";
	public static final String ERROR_VAR_ARGS_LAST_MSG = "The variable argument type must be the last argument.";

	@Check(CheckType.FAST)
	public void checkVarArgParameterIsLast(Operation operation) {
		if (operation.isVariadic() && operation.getVarArgIndex() != operation.getParameters().size() - 1) {
			error(ERROR_VAR_ARGS_LAST_MSG, operation.getParameters().get(operation.getVarArgIndex()), null,
					ERROR_VAR_ARGS_LAST_CODE);
		}
	}

	public static final String ERROR_OPTIONAL_MUST_BE_LAST_CODE = "OptionalParametersLast";
	public static final String ERROR_OPTIONAL_MUST_BE_LAST_MSG = "Required parameters must not be defined after optional parameters.";

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

	protected String prettyPrintTypes(List<TypeParameter> typeParameters) {
		StringJoiner joiner = new StringJoiner(", ");
		for (TypeParameter typeParameter : typeParameters) {
			joiner.add(typeParameter.getName());
		}
		return "<" + joiner.toString() + ">";
	}

	protected String prettyPrintArguments(List<TypeSpecifier> specifiers) {
		StringJoiner joiner = new StringJoiner(", ");
		for (TypeSpecifier specifier : specifiers) {
			joiner.add(specifier.getType().getName());
		}
		return "<" + joiner.toString() + ">";
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.yakindu.org/base/types/2.0.0"));
		return result;
	}
}
