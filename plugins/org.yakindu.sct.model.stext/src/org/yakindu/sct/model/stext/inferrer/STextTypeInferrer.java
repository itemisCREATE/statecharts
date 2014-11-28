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
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.VOID;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextTypeInferrer extends ExpressionsTypeInferrer {

	public static final String VARIABLE_DEFINITION = "Cannot assign a value of type %s to a variable of type %s.";
	public static final String EVENT_DEFINITION = "Cannot assign a value of type %s to an event of type %s.";

	public Object infer(VariableDefinition e) {
		Type type = e.getType();
		if (e.getInitialValue() == null)
			return inferType(type);
		Type type2 = inferType(e.getInitialValue());
		assertCompatibleType(type, type2, String.format(VARIABLE_DEFINITION, type2, type));
		return inferType(type);
	}

	public Object infer(EventDefinition e) {
		// if an event is used within an expression, the type is boolean and the
		// value indicates if the event is raised or not
		return getType(BOOLEAN);
	}

	public Object infer(EventValueReferenceExpression e) {
		EventDefinition definition = deresolve(e.getValue());
		if(definition != null)
			return inferType(definition.getType());
		return inferType(e.getValue());
	}

	public Object infer(OperationDefinition e) {
		return inferType(e.getType());
	}

	public Object infer(EventRaisingExpression e) {
		if (e.getValue() == null)
			return getType(VOID);
		Type type1 = inferType(deresolve(e.getEvent()).getType());
		Type type2 = inferType(e.getValue());
		assertIsSuperType(type1, type2, String.format(EVENT_DEFINITION, type2, type1));
		return inferType(e.getValue());

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
