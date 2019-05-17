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

import static com.google.common.base.Predicates.or;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_AND_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_OR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.EVENT_RAISING_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.EVENT_RAISING_EXPRESSION__VALUE;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.LOGICAL_RELATION_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.NUMERICAL_UNARY_EXPRESSION;
import static org.yakindu.base.expressions.expressions.ExpressionsPackage.Literals.SHIFT_EXPRESSION;
import static org.yakindu.base.types.TypesPackage.Literals.*;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOCAL_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REACTION_EFFECT;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REGULAR_EVENT_SPEC;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.STATE_SPECIFICATION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_SPECIFICATION;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Singleton;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions to predicates
 *
 */
@Singleton
public class ContextPredicateProvider {

	public static final Predicate<IEObjectDescription> EMPTY_PREDICATE = Predicates.alwaysTrue();

	protected static final Predicate<IEObjectDescription> FEATURE = input -> (SGraphPackage.Literals.SCOPE
			.isSuperTypeOf(input.getEClass()));

	protected static final Predicate<IEObjectDescription> VARIABLES = or(FEATURE,
			input -> TypesPackage.Literals.PROPERTY.isSuperTypeOf(input.getEClass()));

	protected static final Predicate<IEObjectDescription> EVENTS = or(FEATURE,
			input -> TypesPackage.Literals.EVENT.isSuperTypeOf(input.getEClass())
					|| (TypesPackage.Literals.DECLARATION.isSuperTypeOf(input.getEClass())));

	protected static final Predicate<IEObjectDescription> OPERATIONS = or(FEATURE,
			input -> TypesPackage.Literals.OPERATION.isSuperTypeOf(input.getEClass()));

	protected static final Predicate<IEObjectDescription> ENUMERATIONS = or(FEATURE,
			input -> (TypesPackage.Literals.ENUMERATOR.isSuperTypeOf(input.getEClass())
					|| TypesPackage.Literals.ENUMERATION_TYPE.isSuperTypeOf(input.getEClass())));

	protected static final Predicate<IEObjectDescription> TYPES = input -> TypesPackage.Literals.TYPE
			.isSuperTypeOf(input.getEClass()) && !TypesPackage.Literals.TYPE_PARAMETER.isSuperTypeOf(input.getEClass());

	protected static final Predicate<IEObjectDescription> ALL = Predicates.alwaysTrue();

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

	@SuppressWarnings("unchecked")
	protected void initMap() {
		filter.put(key(ASSIGNMENT_EXPRESSION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(ASSIGNMENT_EXPRESSION, ASSIGNMENT_EXPRESSION__EXPRESSION), ALL);
		filter.put(key(CONDITIONAL_EXPRESSION), or(VARIABLES, OPERATIONS));
		filter.put(key(LOGICAL_OR_EXPRESSION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(LOGICAL_AND_EXPRESSION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(LOGICAL_NOT_EXPRESSION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(BITWISE_XOR_EXPRESSION), VARIABLES);
		filter.put(key(BITWISE_OR_EXPRESSION), VARIABLES);
		filter.put(key(BITWISE_AND_EXPRESSION), VARIABLES);
		filter.put(key(SHIFT_EXPRESSION), VARIABLES);
		filter.put(key(LOGICAL_RELATION_EXPRESSION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(NUMERICAL_ADD_SUBTRACT_EXPRESSION), or(VARIABLES, OPERATIONS));
		filter.put(key(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION), or(VARIABLES, OPERATIONS));
		filter.put(key(NUMERICAL_UNARY_EXPRESSION), or(VARIABLES, OPERATIONS));
		filter.put(key(EVENT_RAISING_EXPRESSION), EVENTS);
		filter.put(key(EVENT_RAISING_EXPRESSION, EVENT_RAISING_EXPRESSION__VALUE),
				or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(REGULAR_EVENT_SPEC), EVENTS);
		filter.put(key(EVENT_VALUE_REFERENCE_EXPRESSION), EVENTS);
		filter.put(key(REACTION_EFFECT), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(TRANSITION_SPECIFICATION), EVENTS);
		filter.put(key(LOCAL_REACTION), or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(TRANSITION_REACTION), or(VARIABLES, OPERATIONS));
		filter.put(key(PROPERTY, TYPE_SPECIFIER__TYPE), TYPES);
		filter.put(key(PROPERTY, ELEMENT_REFERENCE_EXPRESSION__REFERENCE),
				or(VARIABLES, OPERATIONS, EVENTS, ENUMERATIONS));
		filter.put(key(STATE_SPECIFICATION), EVENTS);
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
