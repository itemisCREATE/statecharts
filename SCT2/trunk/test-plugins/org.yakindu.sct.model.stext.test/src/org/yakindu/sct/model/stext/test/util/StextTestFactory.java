/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.util;


import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.AssignmentOperator;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.stext.impl.StextFactoryImpl;

public class StextTestFactory extends StextFactoryImpl {
	StextTestFactory eINSTANCE = new StextTestFactory();

	public static EventDefinition _createEventDefinition(String name,
			Scope scope) {
		EventDefinition e = StextFactory.eINSTANCE.createEventDefinition();
		e.setName(name);
		if (scope != null)
			scope.getDeclarations().add(e);
		return e;
	}

	public static OperationDefinition _createOperation(String name, Scope scope) {
		OperationDefinition e = StextFactory.eINSTANCE
				.createOperationDefinition();
		e.setName(name);
		if (scope != null)
			scope.getDeclarations().add(e);
		return e;
	}

	public static VariableDefinition _createVariableDefinition(String name,
			Type type, Scope scope, Expression initialValue) {
		VariableDefinition definition = _createVariableDefinition(name, type,
				scope);
		definition.setInitialValue(initialValue);
		return definition;
	}

	public static VariableDefinition _createVariableDefinition(String name,
			Type type, Scope scope) {
		VariableDefinition v = StextFactory.eINSTANCE
				.createVariableDefinition();
		v.setName(name);
		v.setType(type);
		if (scope != null)
			scope.getDeclarations().add(v);
		return v;
	}
	
	public static Type _createIntegerType(String name) {
		Type t = TypesFactory.eINSTANCE.createPrimitiveType();
		t.setName(name);

		return t;
	}

	public static Type _createRealType(String name) {
		Type t = TypesFactory.eINSTANCE.createPrimitiveType();
		t.setName(name);
		return t;
	}
	
	public static Type _createBooleanType(String name) {
		Type t = TypesFactory.eINSTANCE.createPrimitiveType();
		t.setName(name);
		return t;
	}
	
	public static Type _createStringType(String name) {
		Type t = TypesFactory.eINSTANCE.createPrimitiveType();
		t.setName(name);
		return t;
	}
	
	public static Type _createVoidType(String name) {
		Type t = TypesFactory.eINSTANCE.createPrimitiveType();
		t.setName(name);
		return t;
	}

	public static RegularEventSpec _createRegularEventSpec(EventDefinition e1,
			ReactionTrigger rt) {
		RegularEventSpec e1Spec = StextFactory.eINSTANCE
				.createRegularEventSpec();
		e1Spec.setEvent(_createElementReferenceExpression(e1));
		if (rt != null)
			rt.getTriggers().add(e1Spec);
		return e1Spec;
	}

	public static ElementReferenceExpression _createElementReferenceExpression(
			NamedElement target) {
		ElementReferenceExpression referenceExpression = ExpressionsFactory.eINSTANCE
				.createElementReferenceExpression();
		referenceExpression.setReference(target);
		return referenceExpression;
	}

//	public static OnCycleEvent _createOncycleEventSpec(ReactionTrigger rt) {
//		OnCycleEvent oce = StextFactory.eINSTANCE.createOnCycleEvent();
//		if (rt != null)
//			rt.getTriggers().add(oce);
//		return oce;
//	}

	public static AlwaysEvent _createAlwaysEventSpec(ReactionTrigger rt) {
		AlwaysEvent always = StextFactory.eINSTANCE.createAlwaysEvent();
		if (rt != null)
			rt.getTriggers().add(always);
		return always;
	}

	public static ReactionTrigger _createReactionTrigger(Reaction reaction) {
		ReactionTrigger rt = StextFactory.eINSTANCE.createReactionTrigger();
		if (reaction != null)
			reaction.setTrigger(rt);
		return rt;
	}

	public static InterfaceScope _createInterfaceScope(String name,
			ScopedElement owner) {
		InterfaceScope scope = StextFactory.eINSTANCE.createInterfaceScope();
		scope.setName(name);
		if (owner != null)
			owner.getScopes().add(scope);
		return scope;
	}

	public static InternalScope _createInternalScope(ScopedElement owner) {
		InternalScope scope = StextFactory.eINSTANCE.createInternalScope();
		if (owner != null)
			owner.getScopes().add(scope);
		return scope;
	}

	public static ReactionEffect _createReactionEffect(Reaction reaction) {
		ReactionEffect effect = StextFactory.eINSTANCE.createReactionEffect();
		if (reaction != null)
			reaction.setEffect(effect);
		return effect;
	}

	public static TimeEventSpec _createTimeEventSpec(TimeEventType type,
			Expression value, TimeUnit unit, ReactionTrigger rt) {
		TimeEventSpec timeTrigger = StextFactory.eINSTANCE
				.createTimeEventSpec();
		timeTrigger.setType(type);
		timeTrigger.setValue(value);
		timeTrigger.setUnit(unit);

		if (rt != null)
			rt.getTriggers().add(timeTrigger);
		return timeTrigger;
	}

	public static LocalReaction _createEntryAction(State parent) {
		return _createLocalReaction(parent,
				StextFactory.eINSTANCE.createEntryEvent());
	}

	public static LocalReaction _createEntryAction(Statechart parent) {
		return _createLocalReaction(parent,
				StextFactory.eINSTANCE.createEntryEvent());
	}

	public static LocalReaction _createExitAction(State parent) {
		return _createLocalReaction(parent,
				StextFactory.eINSTANCE.createExitEvent());
	}

	public static LocalReaction _createExitAction(Statechart parent) {
		return _createLocalReaction(parent,
				StextFactory.eINSTANCE.createExitEvent());
	}
	
	public static Guard createGuardExpression(Expression expression) {
		Guard guard = StextFactory.eINSTANCE.createGuard();
		guard.setExpression(expression);
		return guard;
	}

	public static LocalReaction _createTimeTriggeredReaction(State parent,
			TimeEventType type, Expression value, TimeUnit unit) {
		// TimeEventSpec timeTrigger =
		// StextFactory.eINSTANCE.createTimeEventSpec();
		// timeTrigger.setType(type);
		// timeTrigger.setValue(value);
		// timeTrigger.setUnit(unit);
		return _createLocalReaction(parent,
				_createTimeEventSpec(type, value, unit, null));
	}

	public static LocalReaction _createLocalReaction(State parent,
			EventSpec triggerEvent) {
		LocalReaction reaction = _createLocalReaction(triggerEvent);

		Scope scope = getOrCreateSimpleScope(parent);

		scope.getDeclarations().add(reaction);

		return reaction;
	}

	public static LocalReaction _createLocalReaction(Statechart parent,
			EventSpec triggerEvent) {
		LocalReaction reaction = _createLocalReaction(triggerEvent);

		Scope scope = getOrCreateInternalScope(parent);

		scope.getDeclarations().add(reaction);

		return reaction;
	}

	public static SimpleScope getOrCreateSimpleScope(State state) {
		for (Scope scope : state.getScopes()) {
			if (scope instanceof SimpleScope) {
				return (SimpleScope) scope;
			}
		}
		SimpleScope scope = StextFactory.eINSTANCE.createSimpleScope();
		state.getScopes().add(scope);
		return scope;
	}

	public static InternalScope getOrCreateInternalScope(Statechart sc) {
		for (Scope scope : sc.getScopes()) {
			if (scope instanceof InternalScope) {
				return (InternalScope) scope;
			}
		}
		return _createInternalScope(sc);
	}

	public static LocalReaction _createLocalReaction(EventSpec triggerEvent) {
		LocalReaction reaction = StextFactory.eINSTANCE.createLocalReaction();
		ReactionTrigger trigger = StextFactory.eINSTANCE
				.createReactionTrigger();
		_createReactionEffect(reaction);

		if (triggerEvent != null)
			trigger.getTriggers().add(triggerEvent);
		reaction.setTrigger(trigger);

		return reaction;
	}

	public static void _createExitAssignment(VariableDefinition v1, State s1,
			int value) {
		LocalReaction exitAction = _createExitAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN,
				_createValue(value), (ReactionEffect) exitAction.getEffect());
	}

	public static void _createEntryAssignment(VariableDefinition v1, State s1,
			int value) {
		LocalReaction entryAction = _createEntryAction(s1);
		_createVariableAssignment(v1, AssignmentOperator.ASSIGN,
				_createValue(value), (ReactionEffect) entryAction.getEffect());
	}

	public static AssignmentExpression _createVariableAssignment(
			VariableDefinition v, AssignmentOperator op, Expression expression,
			ReactionEffect e) {
		AssignmentExpression assignment = ExpressionsFactory.eINSTANCE
				.createAssignmentExpression();
		assignment.setVarRef(_createElementReferenceExpression(v));
		assignment.setOperator(op);
		assignment.setExpression(expression);
		if (e != null)
			e.getActions().add(assignment);
		return assignment;
	}

	public static FeatureCall _createOperationCall(OperationDefinition o) {
		// TODO add owner as TypedElementExpression
		FeatureCall oc = ExpressionsFactory.eINSTANCE.createFeatureCall();
		oc.setFeature(o);
		oc.setOperationCall(true);
		return oc;
	}

	public static PrimitiveValueExpression _createValue(int i) {
		PrimitiveValueExpression assignment = ExpressionsFactory.eINSTANCE
				.createPrimitiveValueExpression();
		IntLiteral intLit = ExpressionsFactory.eINSTANCE.createIntLiteral();
		intLit.setValue(i);
		assignment.setValue(intLit);
		return assignment;
	}

	public static PrimitiveValueExpression _createValue(boolean b) {
		PrimitiveValueExpression pve = ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression();
		BoolLiteral boolLit = ExpressionsFactory.eINSTANCE.createBoolLiteral();
		boolLit.setValue(b);
		pve.setValue(boolLit);
		return pve;
	}

}
