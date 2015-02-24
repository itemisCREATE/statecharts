/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.inferrer;

import static org.yakindu.base.types.typesystem.DefaultTypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.VOID;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TypeAliasDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextTypeInferrer extends ExpressionsTypeInferrer {

	public static final String VARIABLE_DEFINITION = "Cannot assign a value of type %s to a variable of type %s.";
	public static final String EVENT_DEFINITION = "Cannot assign a value of type %s to an event of type %s.";
	public static final String GUARD = "The evaluation result of a guard expression must be of type boolean";
	public static final String TIME_SPEC = "The evaluation result of a time expression must be of type integer";
	public static final String MISSING_VALUE = "Need to assign a value to an event of type %s.";

	public Object infer(VariableDefinition e) {
		Type type = inferTypeDispatch(e.getType());
		assertNotType(type, VARIABLE_VOID_TYPE, getType(VOID));
		if (e.getInitialValue() == null)
			return inferTypeDispatch(type);
		Type type2 = inferTypeDispatch(e.getInitialValue());
		assertAssignable(type, type2, String.format(VARIABLE_DEFINITION, type2, type));
		return inferTypeDispatch(type);
	}

	public Object infer(Event e) {
		// if an event is used within an expression, the type is boolean and the
		// value indicates if the event is raised or not
		return getType(BOOLEAN);
	}

	public Object infer(Guard e) {
		Type type = inferTypeDispatch(e.getExpression());
		assertSame(type, getType(BOOLEAN), GUARD);
		return inferTypeDispatch(type);
	}

	public Object infer(TimeEventSpec e) {
		Type type = inferTypeDispatch(e.getValue());
		assertCompatible(type, getType(INTEGER), TIME_SPEC);
		return inferTypeDispatch(type);
	}

	public Object infer(Scope scope) {
		return getType(VOID);
	}

	public Object infer(EventValueReferenceExpression e) {
		EventDefinition definition = deresolve(e.getValue());
		if (definition != null)
			return inferTypeDispatch(definition.getType() != null ? definition.getType() : getType(VOID));
		return inferTypeDispatch(e.getValue());
	}

	public Object infer(EventRaisingExpression e) {
		Type type1 = deresolve(e.getEvent()).getType();
		type1 = type1 != null ? type1 : getType(VOID);
		if (e.getValue() == null) {
			assertSame(type1, getType(VOID), String.format(MISSING_VALUE, type1));
			return getType(VOID);
		}
		Type type2 = inferTypeDispatch(e.getValue());
		assertAssignable(type1, type2, String.format(EVENT_DEFINITION, type2, type1));
		return inferTypeDispatch(e.getValue());

	}

	protected EventDefinition deresolve(Expression e) {
		// TODO This is ugly -> reuse the TypeTrace to determine the context in
		// infer(EventDefinition)
		if (e instanceof ElementReferenceExpression) {
			EObject reference = ((ElementReferenceExpression) e).getReference();
			if (reference instanceof EventDefinition) {
				return (EventDefinition) reference;
			}
		}
		if (e instanceof FeatureCall) {
			EObject reference = ((FeatureCall) e).getFeature();
			if (reference instanceof EventDefinition) {
				return (EventDefinition) reference;
			}
		}
		return null;
	}

	public Object infer(ActiveStateReferenceExpression e) {
		return getType(BOOLEAN);
	}

}
