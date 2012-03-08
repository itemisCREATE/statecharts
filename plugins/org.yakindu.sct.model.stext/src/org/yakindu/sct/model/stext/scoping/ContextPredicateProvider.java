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

import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.ASSIGNMENT_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.BITWISE_AND_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.BITWISE_OR_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.BITWISE_XOR_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.CONDITIONAL_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_RAISING_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOCAL_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOGICAL_AND_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOGICAL_NOT_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOGICAL_OR_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.LOGICAL_RELATION_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.NUMERICAL_ADD_SUBTRACT_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.NUMERICAL_UNARY_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REACTION_EFFECT;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.REGULAR_EVENT_SPEC;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.SHIFT_EXPRESSION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_REACTION;
import static org.yakindu.sct.model.stext.stext.StextPackage.Literals.TRANSITION_SPECIFICATION;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.yakindu.base.types.TypesPackage;

import com.google.common.base.Predicate;


/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ContextPredicateProvider {

	static class FeaturedTypePredicate implements
			Predicate<IEObjectDescription> {
		public boolean apply(IEObjectDescription input) {
			return TypesPackage.Literals.TYPE.isSuperTypeOf(input.getEClass())
					&& TypesPackage.Literals.FEATURE.isSuperTypeOf(input
							.getEClass());
		}
	}

	static class EventPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return TypesPackage.Literals.EVENT.isSuperTypeOf(input.getEClass());
		}
	}

	static class VariablePredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return TypesPackage.Literals.PROPERTY.isSuperTypeOf(input
					.getEClass());
		}

	};

	static class VariableOperationPredicate extends FeaturedTypePredicate {
		@Override
		public boolean apply(IEObjectDescription input) {
			if (super.apply(input))
				return true;
			return (TypesPackage.Literals.PROPERTY.isSuperTypeOf(input
					.getEClass()) || TypesPackage.Literals.OPERATION
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

	private final Map<EClass, Predicate<IEObjectDescription>> filter;

	public ContextPredicateProvider() {
		filter = new HashMap<EClass, Predicate<IEObjectDescription>>();
		initMap();
	}

	protected void initMap() {
		filter.put(ASSIGNMENT_EXPRESSION, VARIABLES);
		filter.put(CONDITIONAL_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(LOGICAL_OR_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(LOGICAL_AND_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(LOGICAL_NOT_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(BITWISE_XOR_EXPRESSION, VARIABLES);
		filter.put(BITWISE_OR_EXPRESSION, VARIABLES);
		filter.put(BITWISE_AND_EXPRESSION, VARIABLES);
		filter.put(LOGICAL_RELATION_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(SHIFT_EXPRESSION, VARIABLES);
		filter.put(NUMERICAL_ADD_SUBTRACT_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION,
				VARIABLES_AND_OPERATIONS);
		filter.put(NUMERICAL_UNARY_EXPRESSION, VARIABLES_AND_OPERATIONS);
		filter.put(EVENT_RAISING_EXPRESSION, EVENTS);
		filter.put(REGULAR_EVENT_SPEC, EVENTS);
		filter.put(EVENT_VALUE_REFERENCE_EXPRESSION, EVENTS);
		filter.put(REACTION_EFFECT, VARIABLES_AND_OPERATIONS);
		filter.put(TRANSITION_REACTION, VARIABLES_AND_OPERATIONS);
		filter.put(TRANSITION_SPECIFICATION, EVENTS);
		filter.put(LOCAL_REACTION, VARIABLES_AND_OPERATIONS);
	}

	public Predicate<IEObjectDescription> getPredicate(EClass clazz) {
		Predicate<IEObjectDescription> predicate = filter.get(clazz);
		if (predicate == null) {
			return EMPTY_PREDICATE;
		}
		return predicate;
	}
}
