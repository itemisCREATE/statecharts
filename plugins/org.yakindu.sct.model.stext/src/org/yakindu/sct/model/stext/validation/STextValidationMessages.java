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
package org.yakindu.sct.model.stext.validation;

/**
 *
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public interface STextValidationMessages {

	public static final String CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION = "A choice should have one outgoing default transition.";
	public static final String FEATURE_CALL_HAS_NO_EFFECT = "FeatureCall has no effect.";
	public static final String ENTRY_EXIT_TRIGGER_NOT_ALLOWED = "Entry/Exit trigger not allowed.";
	public static final String ONLY_FIRST_ENTRY_POINT_WILL_BE_USED = "Remove multiple entry points. Only the first will be used.";
	public static final String LOCAL_REACTIONS_NOT_ALLOWED = "Local reactions not allowed.";
	public static final String FEATURE_CALL_TO_SCOPE = "FEATURE_CALL_TO_SCOPE.";
	public static final String ONLY_ONE_INTERFACE = "Only one default/unnamed interface is allowed.";
	public static final String IN_OUT_DECLARATIONS = "In/Out declarations are not allowed in internal scope.";
	public static final String LOCAL_DECLARATIONS = "Local declarations are not allowed in interface scope.";
	public static final String TIME_EXPRESSION = "The evaluation result of a time expression must be of type integer.";
	public static final String GUARD_EXPRESSION = "The evaluation result of a guard expression must be of type boolean.";
	public static final String GUARD_CONTAINS_ASSIGNMENT = "A guard must not contain assignments.";
	public static final String ASSIGNMENT_EXPRESSION = "No nested assignment of the same variable allowed (different behavior in various programming languages).";
	public static final String TRANSITION_ENTRY_SPEC_NOT_COMPOSITE = "Target state isn't composite.";
	public static final String TRANSITION_EXIT_SPEC_NOT_COMPOSITE = "Source state isn't composite.";
	public static final String TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT = "Target state has regions without 'default' entries.";
	public static final String TRANSITION_UNBOUND_NAMED_ENTRY_POINT = "Target state has regions without named entries: ";
	public static final String TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT = "Source state needs at least one region with the named exit point.";
	public static final String TRIGGER_IS_NO_EVENT = "Trigger is no event.";
	public static final String TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY = "Entry of top level region have to be a default entry.";
	public static final String REGION_UNBOUND_DEFAULT_ENTRY_POINT = "Region must have a 'default' entry.";
	public static final String REGION_UNBOUND_NAMED_ENTRY_POINT = "Region should have a named entry to support transitions entry specification: ";
	public static final String ENTRY_UNUSED = "The named entry is not used by incoming transitions.";
	public static final String ENTRY_NOT_EXIST = "The named entry does not exist: ";
	public static final String EXIT_UNUSED = "This exit is not connected to any outgoing transitions.";
	public static final String EXIT_NEVER_USED = "The named exit is not used: ";
	public static final String TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS = "ExitPointSpec can't be used on transition siblings.";
	public static final String ISSUE_TRANSITION_WITHOUT_TRIGGER = "Missing trigger. Transition is never taken. Use 'oncycle' or 'always' instead.";
	public static final String EXITPOINTSPEC_WITH_TRIGGER = "Transitions with an exit point spec does not have a trigger or guard.";
	public static final String REFERENCE_CONSTANT_BEFORE_DEFINED = "Cannot reference a constant from different scope or before it is defined.";
	public static final String INTERNAL_DECLARATION_UNUSED = "Internal declaration is not used in statechart.";
	public static final String VALUE_OF_REQUIRES_EVENT = "valueof() expression requires event as argument.";
	public static final String IMPORT_NOT_RESOLVED_MSG = "Import '%s' cannot be resolved.";
	public static final String IMPORT_NOT_RESOLVED_CODE = "ImportNotResolved";
	public static final String DUPLICATE_IMPORT = "Duplicate import '%s'.";
	public static final String CONTRADICTORY_ANNOTATIONS = "Some annotations (%s) have contradictory effects.";
	public static final String BAD_EVENT_NAMES = "'%s' is already used as name of an internal event.";
	public static final String SYNC_OUTGOING_TRIGGER = "Triggers and guards on a synchronization's outgoing transitions will be ignored.";
	public static final String ALWAYS_TRUE_TRANSITION_USED = "Transition with '%s' should be evaluate as the last transition of the state as following transitions won't be evaluated. Change the transition order (in the Properties view).";
	public static final String DEAD_TRANSITION = "Dead transition. This transition can not be taken due to previous transition with '%s' trigger.";
	public static final String USE_DEFAULT_TRIGGER_IN_CHOICES = "Transition with '%s' effect blocking other transitions. Use 'default' or 'else' instead.";
	public static final String ONLY_ONE_DEFAULT_SHOULD_BE_USED = "Only one default or else transition should be used. Currently used default and/or else transitions: %d.";
	public static final String DEFAULT_AND_ELSE_TRANSITION_ON_REGULAR_STATE = "'Default' and 'else' transitions should only be used for choices. Use 'always' or 'oncycle' instead.";
}