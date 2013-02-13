/**
 * Copyright (c) 2011 itemis AG and others.
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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.sgraph.validation.SCTResourceValidator;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem.BinaryOperators;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * s Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * @auhor muelder
 * 
 */
@ComposedChecks(validators = { SGraphJavaValidator.class,
		SCTResourceValidator.class })
public class STextJavaValidator extends AbstractSTextJavaValidator {

	public static final String CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION = "A choice should have one outgoing default transition";
	public static final String FEATURE_CALL_HAS_NO_EFFECT = "FeatureCall has no effect";
	public static final String ENTRY_EXIT_TRIGGER_NOT_ALLOWED = "Entry/Exit trigger not allowed";
	public static final String LOCAL_REACTIONS_NOT_ALLOWED = "Local reactions not allowed";
	public static final String FEATURE_CALL_TO_SCOPE = "FEATURE_CALL_TO_SCOPE";
	public static final String ONLY_ONE_INTERFACE = "Only one default/unnamed interface is allowed.";
	public static final String IN_OUT_DECLARATIONS = "In/Out declarations are not allowed in internal scope.";
	public static final String LOCAL_DECLARATIONS = "Local declarations are not allowed in interface scope.";
	public static final String GUARD_EXPRESSION = "The evaluation result of a guard expression must be of type boolean";
	public static final String ASSIGNMENT_EXPRESSION = "No nested assignment of the same variable allowed (different behavior in various programming languages)";
	public static final String VARIABLE_VOID_TYPE = "'void' is an invalid type for variables";

	@Inject
	private ISTextTypeInferrer typeInferrer;
	@Inject
	private ISTextTypeSystem typeSystem;

	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Check(CheckType.FAST)
	public void checkVariableType(final VariableDefinition definition) {
		if (typeSystem.isVoidType(new InferredType(definition.getType()))) {
			error(VARIABLE_VOID_TYPE, null);
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_FeatureCall(final FeatureCall call) {
		if (call.getFeature() instanceof Operation) {
			Operation operation = (Operation) call.getFeature();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = call.getArgs();
			if (parameters.size() != args.size()) {
				error("Wrong number of arguments, expected " + parameters, null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_TypedElementReferenceExpression(
			final ElementReferenceExpression call) {
		if (call.getReference() instanceof Operation) {
			Operation operation = (Operation) call.getReference();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = call.getArgs();
			if (parameters.size() != args.size()) {
				error("Wrong number of arguments, expected " + parameters, null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkAssignmentExpression(final AssignmentExpression exp) {

		final String name = getVariableName(exp);

		List<AssignmentExpression> contents = EcoreUtil2.eAllOfType(exp,
				AssignmentExpression.class);
		contents.remove(exp);

		Iterable<AssignmentExpression> filter = Iterables.filter(contents,
				new Predicate<AssignmentExpression>() {
					public boolean apply(final AssignmentExpression ex) {
						String variableName = getVariableName(ex);
						return variableName.equals(name);

					}
				});
		if (Iterables.size(filter) > 0) {
			error(ASSIGNMENT_EXPRESSION, null);
		}
	}

	private String getVariableName(AssignmentExpression exp) {
		Expression varRef = exp.getVarRef();
		if (varRef instanceof ElementReferenceExpression) {
			Property reference = (Property) ((ElementReferenceExpression) varRef)
					.getReference();
			return reference.getName();
		} else if (varRef instanceof FeatureCall
				&& ((FeatureCall) varRef).getFeature() instanceof Property) {
			Property reference = (Property) ((FeatureCall) varRef).getFeature();
			return reference.getName();
		}
		return null;
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(FeatureCall call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getFeature() instanceof Scope) {
			error("A variable, event or operation is required",
					StextPackage.Literals.FEATURE_CALL__FEATURE,
					INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(ElementReferenceExpression call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getReference() instanceof Scope) {
			error("A variable, event or operation is required",
					StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
					INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkGuardHasBooleanExpression(ReactionTrigger trigger) {
		if (trigger.getGuardExpression() == null) {
			return;
		}
		InferenceResult t = typeInferrer
				.inferType(trigger.getGuardExpression());
		if (t == null || t.getType() == null
				|| !typeSystem.isBooleanType(t.getType())) {
			error(GUARD_EXPRESSION,
					StextPackage.Literals.REACTION_TRIGGER__GUARD_EXPRESSION);
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent || eventSpec instanceof ExitEvent)) {
				error("entry and exit events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS,
						INSIGNIFICANT_INDEX, LOCAL_REACTIONS_NOT_ALLOWED);
			}
		}
	}

	/**
	 * Only Expressions that produce an effect should be used as actions.
	 * 
	 * @param effect
	 */
	@Check(CheckType.FAST)
	public void checkReactionEffectActions(ReactionEffect effect) {
		for (Expression exp : effect.getActions()) {

			if (!(exp instanceof AssignmentExpression)
					&& !(exp instanceof EventRaisingExpression)) {

				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((FeatureCall) exp);
				} else if (exp instanceof ElementReferenceExpression) {
					checkElementReferenceEffect((ElementReferenceExpression) exp);
				} else {
					error("Action has no effect.",
							StextPackage.Literals.REACTION_EFFECT__ACTIONS,
							effect.getActions().indexOf(exp),
							FEATURE_CALL_HAS_NO_EFFECT);
				}

			}
		}
	}

	protected void checkEventRaisingExpression(EventRaisingExpression e) {
		if (e.getEvent() != null) {
			InferenceResult eventType = typeInferrer.inferType(e.getEvent());
			if (e.getValue() != null) {
				// if there is a value, check the event has void type
				if (eventType == null || eventType.getType() == null) {
					throw new IllegalArgumentException(
							"Could not infer a type for event part of EventRaisingExpression"
									+ e);
				}
				if (!typeSystem.isVoidType(eventType.getType())) {
					error("Need to assign a value to an event of type "
							+ eventType, null);
				}
			} else {
				// check an assignment is possible.
				InferenceResult valueType = typeInferrer
						.inferType(e.getValue());
				if (valueType == null || valueType.getType() == null) {
					throw new IllegalArgumentException(
							"Could not infer a type for value part of EventRaisingExpression"
									+ e);
				}
				InferenceResult assignmentResult = typeSystem.inferType(
						eventType.getType(), valueType.getType(),
						BinaryOperators.ASSIGN);
				if (assignmentResult == null
						|| assignmentResult.getType() == null) {
					// TODO: could user the issues within result
					error("Can not assign a value of type " + valueType
							+ " to an event of type " + eventType, null);
				}
			}
		}
	}

	protected void checkFeatureCallEffect(FeatureCall call) {
		if (call.getFeature() != null && call.getFeature() instanceof Feature
				&& !(call.getFeature() instanceof Operation)) {
			if (call.getFeature() instanceof Property) {
				error("Access to property '"
						+ nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else if (call.getFeature() instanceof Event) {
				error("Access to event '"
						+ nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '"
						+ nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	protected void checkElementReferenceEffect(ElementReferenceExpression refExp) {
		if (!(refExp.getReference() instanceof Operation)) {
			if (refExp.getReference() instanceof Property) {
				error("Access to property '"
						+ nameProvider.getFullyQualifiedName(refExp
								.getReference()) + "' has no effect.",
						refExp,
						StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else if (refExp.getReference() instanceof Event) {
				error("Access to event '"
						+ nameProvider.getFullyQualifiedName(refExp
								.getReference()) + "' has no effect.",
						refExp,
						StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '"
						+ nameProvider.getFullyQualifiedName(refExp
								.getReference()) + "' has no effect.",
						refExp,
						StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope
				&& event.getDirection() == Direction.LOCAL) {
			error(LOCAL_DECLARATIONS,
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope
				&& event.getDirection() != Direction.LOCAL) {
			error(IN_OUT_DECLARATIONS,
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
	}

	@Inject
	STextGrammarAccess grammarAccess;

	@Check(CheckType.FAST)
	public void checkInterfaceScope(ScopedElement statechart) {
		List<InterfaceScope> defaultInterfaces = new LinkedList<InterfaceScope>();

		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope
					&& ((InterfaceScope) scope).getName() == null) {
				defaultInterfaces.add((InterfaceScope) scope);
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error(ONLY_ONE_INTERFACE, scope, grammarAccess
						.getInterfaceScopeAccess().getInterfaceKeyword_1(),
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						ONLY_ONE_INTERFACE);
			}
		}
	}

	protected void error(String message, EObject source, Keyword keyword,
			int index, String code) {
		final String[] issueData = null;
		ICompositeNode rootNode = NodeModelUtils.findActualNodeFor(source);
		if (rootNode != null) {
			INode child = findNode(source, false, rootNode, keyword,
					new int[] { index });
			if (child != null) {
				int offset = child.getTotalOffset();
				int length = child.getTotalLength();
				getMessageAcceptor().acceptError(message, source, offset,
						length, code, issueData);
				return;
			}
		}
		error(message, source, (EStructuralFeature) null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code);
	}

	// private void reportIssues(Collection<InferenceIssue> issues) {
	// int severity = IStatus.OK;
	// String message = "";
	// for (InferenceIssue issue : issues) {
	// if (issue.getSeverity() > severity) {
	// severity = issue.getSeverity();
	// }
	// if (message.length() > 0) {
	// message += "; ";
	// }
	// message += issue.getMessage();
	// }
	// if (severity == IStatus.ERROR) {
	// error(message, null);
	// } else if (severity == IStatus.WARNING) {
	// warning(message, null);
	// }
	// }
	@Check(CheckType.FAST)
	public void checkExpression(final Statement statement) {
		if (statement instanceof Expression) {
			InferenceResult inferType = typeInferrer
					.inferType((Expression) statement);
			if (!inferType.getIssues().isEmpty()) {
				// TODO: handle severity and multiple issues here
				error(inferType.getIssues().iterator().next().getMessage(),
						null);
			}
		}
	}

	@Check
	public void checkChoiceWithoutDefaultTransition(final Choice choice) {
		boolean found = false;
		for (Transition transition : choice.getOutgoingTransitions()) {
			Trigger trigger = transition.getTrigger();
			if (isDefault(trigger)) {
				found = true;
			}
		}
		if (!found)
			warning(CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION,
					SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS);
	}

	protected boolean isDefault(Trigger trigger) {

		return trigger == null
				|| trigger instanceof DefaultTrigger
				|| ((trigger instanceof ReactionTrigger)
						&& ((ReactionTrigger) trigger).getTriggers().size() == 0 && ((ReactionTrigger) trigger)
						.getGuardExpression() == null);
	}

	@Override
	protected String getCurrentLanguage(Map<Object, Object> context,
			EObject eObject) {
		Resource eResource = eObject.eResource();
		if (eResource instanceof XtextResource) {
			return super.getCurrentLanguage(context, eObject);
		} else if (eResource instanceof AbstractSCTResource) {
			return ((AbstractSCTResource) eResource).getLanguageName();
		}
		return "";

	}

	private INode findNode(EObject source, boolean sourceFound, INode root,
			Keyword keyword, int[] index) {
		if (sourceFound && root.getSemanticElement() != source) {
			return null;
		}
		if (root.getSemanticElement() == source) {
			sourceFound = true;
		}
		EObject grammarElement = root.getGrammarElement();
		// .equals or == does not work because sub grammars use their own
		// Modules with custom
		// grammarAccess instance and .equals is not overwritten.
		if (grammarElement instanceof Keyword
				&& keyword.getValue().equals(
						((Keyword) grammarElement).getValue())) {
			if (index[0] != INSIGNIFICANT_INDEX) {
				index[0]--;
			}
			if (index[0] == 0 || index[0] == INSIGNIFICANT_INDEX) {
				return root;
			}
		}
		if (root instanceof ICompositeNode) {
			ICompositeNode node = (ICompositeNode) root;
			for (INode child : node.getChildren()) {
				INode result = findNode(source, sourceFound, child, keyword,
						index);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}
}
