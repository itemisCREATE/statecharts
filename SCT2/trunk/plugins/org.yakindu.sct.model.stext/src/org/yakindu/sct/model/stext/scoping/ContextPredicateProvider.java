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
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.SHIFT_EXPRESSION;
import static org.yakindu.base.types.TypesPackage.Literals.TYPED_ELEMENT__TYPE;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_RAISING_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_RAISING_EXPRESSION__VALUE;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOCAL_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REACTION_EFFECT;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REGULAR_EVENT_SPEC;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_SPECIFICATION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.VARIABLE_DEFINITION;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.yakindu.base.types.TypesPackage;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions to predicates
 * 
 */
public class ContextPredicateProvider {

	static class TypePredicate implements Predicate<IEObjectDescription> {
		public boolean apply(IEObjectDescription input) {
			return TypesPackage.Literals.TYPE.isSuperTypeOf(input.getEClass())
					&& !TypesPackage.Literals.TYPE_PARAMETER.isSuperTypeOf(input.getEClass());
		}
	}

	static class FeaturedTypePredicate implements Predicate<IEObjectDescription> {
		public boolean apply(IEObjectDescription input) {
			return TypesPackage.Literals.TYPE.isSuperTypeOf(input.getEClass())
					&& TypesPackage.Literals.FEATURE.isSuperTypeOf(input.getEClass());
		}
	}

	static class EventPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			// TODO: Check if the propertys type is of type ComplexType
			return TypesPackage.Literals.EVENT.isSuperTypeOf(input.getEClass())
					|| TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass());
		}
	}

	static class VariablePredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass());
		}

	};

	static class VariableOperationPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return (TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass()) || TypesPackage.Literals.OPERATION
					.isSuperTypeOf(input.getEClass()));
		}
	}

	static class VariableOperationEventEnumeratorPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return (TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass())
					|| TypesPackage.Literals.OPERATION.isSuperTypeOf(input.getEClass())
					|| TypesPackage.Literals.EVENT.isSuperTypeOf(input.getEClass()) || TypesPackage.Literals.ENUMERATOR
						.isSuperTypeOf(input.getEClass()));
		}
	}

	static class EmptyPredicate implements Predicate<IEObjectDescription> {

		public boolean apply(IEObjectDescription input) {
			return true;
		}

	}

	private static final EmptyPredicate EMPTY_PREDICATE = new EmptyPredicate();
	private static final VariablePredicate VARIABLES = new VariablePredicate();
	private static final EventPredicate EVENTS = new EventPredicate();
	private static final VariableOperationPredicate VARIABLES_AND_OPERATIONS = new VariableOperationPredicate();
	private static final VariableOperationEventEnumeratorPredicate VARIABLES_OPERATIONS_EVENTS_ENUMERATORS = new VariableOperationEventEnumeratorPredicate();
	private static final TypePredicate TYPES = new TypePredicate();
	private static final Predicate<IEObjectDescription> ALL = Predicates.<IEObjectDescription> alwaysTrue();

	private final Map<Pair<EClass, EReference>, Predicate<IEObjectDescription>> filter;

	public ContextPredicateProvider() {
		filter = new HashMap<Pair<EClass, EReference>, Predicate<IEObjectDescription>>();
		initMap();
	}

	private Pair<EClass, EReference> key(EClass eClass) {
		return Tuples.create(eClass, null);
	}

	private Pair<EClass, EReference> key(EClass eClass, EReference ref) {
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
		filter.put(key(LOCAL_REACTION), VARIABLES_AND_OPERATIONS);
		filter.put(key(TRANSITION_REACTION), VARIABLES_AND_OPERATIONS);
		filter.put(key(VARIABLE_DEFINITION, TYPED_ELEMENT__TYPE), TYPES);
	}

	public Predicate<IEObjectDescription> getPredicate(EClass clazz, EReference reference) {
		Predicate<IEObjectDescription> predicate = filter.get(key(clazz, reference));
		if (predicate == null) {
			predicate = filter.get(key(clazz, null));
			if (predicate == null) {
				return EMPTY_PREDICATE;
			}
		}
		return predicate;
	}
}
