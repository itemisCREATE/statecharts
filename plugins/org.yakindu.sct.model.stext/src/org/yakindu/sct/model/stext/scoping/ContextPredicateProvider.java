/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.SHIFT_EXPRESSION;
import static org.yakindu.base.types.TypesPackage.Literals.TYPE_SPECIFIER__TYPE;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_RAISING_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_RAISING_EXPRESSION__VALUE;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOCAL_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REACTION_EFFECT;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REGULAR_EVENT_SPEC;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.STATE_SPECIFICATION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_SPECIFICATION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.VARIABLE_DEFINITION;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.resource.TypedResourceDescriptionStrategy;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions to predicates
 *
 */
public class ContextPredicateProvider {

	public static class TypePredicate implements Predicate<IEObjectDescription> {
		@Override
		public boolean apply(IEObjectDescription input) {
			EClass eClass = input.getEClass();
			return TypesPackage.Literals.TYPE.isSuperTypeOf(eClass)
					&& !TypesPackage.Literals.TYPE_PARAMETER.isSuperTypeOf(eClass);
		}
	}

	public static class FeaturedTypePredicate implements Predicate<IEObjectDescription> {
		@Override
		public boolean apply(IEObjectDescription input) {
			EClass eClass = input.getEClass();

			return (SGraphPackage.Literals.SCOPE.isSuperTypeOf(eClass));
		}
	}

	protected static EClass getVariableType(IEObjectDescription ieod) {
		EObject eObj = ieod.getEObjectOrProxy();
		if (eObj != null && (! eObj.eIsProxy()) ) {
			EObject eTS = (EObject) eObj.eGet(TypesPackage.Literals.TYPED_ELEMENT__TYPE_SPECIFIER, false);
			if (eTS != null && (! eTS.eIsProxy())) {
				EObject eT = (EObject) eObj.eGet(TypesPackage.Literals.TYPE_SPECIFIER__TYPE, false);
				if (eT != null) {
					return eT.eClass();
				}
			}
		}
		return TypesPackage.Literals.TYPE;
	}


	public static class EventPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return TypesPackage.Literals.EVENT.isSuperTypeOf(input.getEClass())	 || (TypesPackage.Literals.DECLARATION.isSuperTypeOf(input.getEClass()));
		}
	}

	public static class VariablePredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass());
		}

	};

	public static class VariableOperationPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			EClass eClass = input.getEClass();
			return (TypesPackage.Literals.PROPERTY.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.OPERATION.isSuperTypeOf(eClass));
		}
	}

	public static class VariableOperationEventEnumeratorPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			EClass eClass = input.getEClass();
			return (TypesPackage.Literals.PROPERTY.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.OPERATION.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.EVENT.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.ENUMERATOR.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.ENUMERATION_TYPE.isSuperTypeOf(eClass));
		}
	}

	public static class EmptyPredicate implements Predicate<IEObjectDescription> {

		@Override
		public boolean apply(IEObjectDescription input) {
			return true;
		}

	}

	protected static final EmptyPredicate EMPTY_PREDICATE = new EmptyPredicate();
	protected static final VariablePredicate VARIABLES = new VariablePredicate();
	protected static final EventPredicate EVENTS = new EventPredicate();
	protected static final VariableOperationPredicate VARIABLES_AND_OPERATIONS = new VariableOperationPredicate();
	protected static final VariableOperationEventEnumeratorPredicate VARIABLES_OPERATIONS_EVENTS_ENUMERATORS = new VariableOperationEventEnumeratorPredicate();
	protected static final TypePredicate TYPES = new TypePredicate();
	protected static final Predicate<IEObjectDescription> ALL = Predicates.<IEObjectDescription> alwaysTrue();

	protected final Map<Pair<EClass, EReference>, Predicate<IEObjectDescription>> filter;

	public ContextPredicateProvider() {
		filter = new HashMap<>();
		initMap();
	}

	protected Pair<EClass, EReference> key(EClass eClass) {
		return Tuples.create(eClass, null);
	}

	protected Pair<EClass, EReference> key(EClass eClass, EReference ref) {
		return Tuples.create(eClass, ref);
	}

	protected void initMap() {
		filter.put(key(ASSIGNMENT_EXPRESSION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(ASSIGNMENT_EXPRESSION, ASSIGNMENT_EXPRESSION__EXPRESSION), ALL);
		filter.put(key(CONDITIONAL_EXPRESSION), VARIABLES_AND_OPERATIONS);
		filter.put(key(LOGICAL_OR_EXPRESSION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(LOGICAL_AND_EXPRESSION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(LOGICAL_NOT_EXPRESSION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES);
		filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES);
		filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES);
		filter.put(key(SHIFT_EXPRESSION), VARIABLES);
		filter.put(key(LOGICAL_RELATION_EXPRESSION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION), VARIABLES_AND_OPERATIONS);
		filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION), VARIABLES_AND_OPERATIONS);
		filter.put(key(NUMERICAL_UNARY_EXPRESSION), VARIABLES_AND_OPERATIONS);
		filter.put(key(EVENT_RAISING_EXPRESSION), EVENTS);
		filter.put(key(EVENT_RAISING_EXPRESSION, EVENT_RAISING_EXPRESSION__VALUE),
				VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(REGULAR_EVENT_SPEC), EVENTS);
		filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS);
		filter.put(key(REACTION_EFFECT), VARIABLES_AND_OPERATIONS);
		filter.put(key(TRANSITION_SPECIFICATION), EVENTS);
		filter.put(key(LOCAL_REACTION), VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(TRANSITION_REACTION), VARIABLES_AND_OPERATIONS);
		filter.put(key(VARIABLE_DEFINITION, TYPE_SPECIFIER__TYPE), TYPES);
		filter.put(key(VARIABLE_DEFINITION, ELEMENT_REFERENCE_EXPRESSION__REFERENCE),
				VARIABLES_OPERATIONS_EVENTS_ENUMERATORS);
		filter.put(key(STATE_SPECIFICATION), EVENTS);
	}

	protected Predicate<IEObjectDescription> getPredicate(EClass clazz, EReference reference) {
		Predicate<IEObjectDescription> predicate = filter.get(key(clazz, reference));
		if (predicate == null) {
			predicate = filter.get(key(clazz, null));
			if (predicate == null) {
				return EMPTY_PREDICATE;
			}
		}
		return predicate;
	}

	protected static boolean hasComplexType(IEObjectDescription input) {
		String hasComplexType = input.getUserData(TypedResourceDescriptionStrategy.HAS_COMPLEX_TYPE);
		return hasComplexType != null && Boolean.valueOf(hasComplexType);
	}

}
