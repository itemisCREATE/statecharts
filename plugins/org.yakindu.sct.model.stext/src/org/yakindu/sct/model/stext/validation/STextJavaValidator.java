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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.validation.ExpressionsJavaValidator;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.sgraph.validation.SCTResourceValidator;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.Import;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * s Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * @auhor muelder
 * 
 */
@ComposedChecks(validators = { SGraphJavaValidator.class, SCTResourceValidator.class, ExpressionsJavaValidator.class })
public class STextJavaValidator extends AbstractSTextJavaValidator implements STextValidationMessages {

	@Inject
	private ITypeSystemInferrer typeInferrer;
	@Inject
	private STextGrammarAccess grammarAccess;
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	@Inject
	private IContainer.Manager containerManager;
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	@Check
	public void checkExpression(VariableDefinition expression) {
		if (expression.getType() == null || expression.getType().eIsProxy())
			return;
		typeInferrer.inferType(expression, this);
	}

	@Check
	public void checkExpression(TimeEventSpec expression) {
		typeInferrer.inferType(expression, this);
	}

	@Check
	public void checkExpression(Guard expression) {
		typeInferrer.inferType(expression, this);
	}

	@Check(CheckType.FAST)
	public void transitionsWithNoTrigger(Transition trans) {
		if (trans.getSource() instanceof Entry || trans.getSource() instanceof Choice
				|| trans.getSource() instanceof Synchronization) {
			return;
		}
		if (trans.getSource() instanceof org.yakindu.sct.model.sgraph.State) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) trans.getSource();
			if (state.isComposite()) {
				for (Region r : state.getRegions()) {
					for (Vertex v : r.getVertices()) {
						if (v instanceof Exit) {
							return;
						}
					}
				}
			}
		}

		if (!STextValidationModelUtils.getExitPointSpecs(trans.getProperties()).isEmpty()) {
			return;
		}

		if (trans.getTrigger() == null) {
			warning(ISSUE_TRANSITION_WITHOUT_TRIGGER, trans, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void checkUnusedEntry(final Entry entry) {
		if (entry.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& entry.getIncomingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) entry.getParentRegion()
					.getComposite();
			if (!STextValidationModelUtils.isDefault(entry)) {
				boolean hasIncomingTransition = false;
				Iterator<Transition> transitionIt = state.getIncomingTransitions().iterator();
				while (transitionIt.hasNext() && !hasIncomingTransition) {
					Iterator<ReactionProperty> propertyIt = transitionIt.next().getProperties().iterator();
					while (propertyIt.hasNext() && !hasIncomingTransition) {
						ReactionProperty property = propertyIt.next();
						if (property instanceof EntryPointSpec) {
							hasIncomingTransition = entry.getName().equals(((EntryPointSpec) property).getEntrypoint());
						}
					}
				}
				if (!hasIncomingTransition) {
					warning(ENTRY_UNUSED, entry, null, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkLeftHandAssignment(final AssignmentExpression expression) {
		Expression varRef = expression.getVarRef();
		if (varRef instanceof FeatureCall) {
			EObject referencedObject = ((FeatureCall) varRef).getFeature();
			if (!(referencedObject instanceof Variable) && !(referencedObject instanceof Property)) {
				error(LEFT_HAND_ASSIGNMENT, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			}
		} else if (varRef instanceof ElementReferenceExpression) {
			EObject referencedObject = ((ElementReferenceExpression) varRef).getReference();
			if (!(referencedObject instanceof Variable) && !(referencedObject instanceof Property)) {
				error(LEFT_HAND_ASSIGNMENT, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			}

		} else {
			error(LEFT_HAND_ASSIGNMENT, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
		}
	}

	@Check(CheckType.FAST)
	public void checkAssignmentToFinalVariable(AssignmentExpression exp) {
		Expression varRef = exp.getVarRef();
		EObject referencedObject = null;
		if (varRef instanceof FeatureCall)
			referencedObject = ((FeatureCall) varRef).getFeature();
		else if (varRef instanceof ElementReferenceExpression)
			referencedObject = ((ElementReferenceExpression) varRef).getReference();
		if (referencedObject instanceof VariableDefinition) {
			if (((VariableDefinition) referencedObject).isConst()) {
				error(ASSIGNMENT_TO_VALUE, ExpressionsPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkValueDefinitionExpression(VariableDefinition definition) {
		// applies only to constants
		if (!definition.isConst())
			return;
		Expression initialValue = definition.getInitialValue();
		List<Expression> toCheck = Lists.newArrayList(initialValue);
		TreeIterator<EObject> eAllContents = initialValue.eAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			if (next instanceof Expression)
				toCheck.add((Expression) next);
		}
		for (Expression expression : toCheck) {
			EObject referencedObject = null;
			if (expression instanceof FeatureCall)
				referencedObject = ((FeatureCall) expression).getFeature();
			else if (expression instanceof ElementReferenceExpression)
				referencedObject = ((ElementReferenceExpression) expression).getReference();
			if (referencedObject instanceof VariableDefinition) {
				if (!((VariableDefinition) referencedObject).isConst()) {
					error(REFERENCE_TO_VARIABLE, StextPackage.Literals.VARIABLE_DEFINITION__INITIAL_VALUE);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkValueReferenedBeforeDefined(Scope scope) {
		EList<Declaration> declarations = scope.getDeclarations();
		Set<QualifiedName> defined = Sets.newHashSet();
		for (Declaration declaration : declarations) {
			if (declaration instanceof VariableDefinition) {
				VariableDefinition definition = (VariableDefinition) declaration;
				if (!definition.isConst())
					return;
				Expression initialValue = definition.getInitialValue();
				List<Expression> toCheck = Lists.newArrayList(initialValue);
				TreeIterator<EObject> eAllContents = initialValue.eAllContents();
				while (eAllContents.hasNext()) {
					EObject next = eAllContents.next();
					if (next instanceof Expression)
						toCheck.add((Expression) next);
				}
				for (Expression expression : toCheck) {
					EObject referencedObject = null;
					if (expression instanceof FeatureCall)
						referencedObject = ((FeatureCall) expression).getFeature();
					else if (expression instanceof ElementReferenceExpression)
						referencedObject = ((ElementReferenceExpression) expression).getReference();
					if (referencedObject instanceof VariableDefinition) {
						if (!defined.contains(nameProvider.getFullyQualifiedName(referencedObject)))
							error(REFERENCE_CONSTANT_BEFORE_DEFINED, definition,
									StextPackage.Literals.VARIABLE_DEFINITION__INITIAL_VALUE);
					}
				}
				defined.add(nameProvider.getFullyQualifiedName(definition));
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkUnusedExit(final Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& exit.getOutgoingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) exit.getParentRegion()
					.getComposite();

			if (!STextValidationModelUtils.isDefault(exit)) {
				boolean hasOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					Transition transition = transitionIt.next();
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transition) ? true
							: STextValidationModelUtils.isNamedExitTransition(transition, exit.getName());
				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1);
				}
			} else {
				boolean hasOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transitionIt.next());
				}
				if (!hasOutgoingTransition) {
					error(EXIT_DEFAULT_UNUSED, exit, null, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkTransitionPropertySpec(final Transition transition) {
		for (ReactionProperty property : transition.getProperties()) {
			if (property instanceof EntryPointSpec) {
				if (transition.getTarget() instanceof org.yakindu.sct.model.sgraph.State) {
					org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) transition
							.getTarget();
					if (!state.isComposite()) {
						warning(TRANSITION_ENTRY_SPEC_NOT_COMPOSITE, transition, null, -1);
					}
				}
			} else if (property instanceof ExitPointSpec) {
				final ExitPointSpec exitPointSpec = (ExitPointSpec) property;
				if (transition.getSource() instanceof org.yakindu.sct.model.sgraph.State) {
					org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) transition
							.getSource();
					if (!state.isComposite()) {
						warning(TRANSITION_EXIT_SPEC_NOT_COMPOSITE, transition, null, -1);
					} else {
						// Validate an exit point is continued on one transition
						// only.
						for (Transition t : state.getOutgoingTransitions()) {
							if (transition != t
									&& STextValidationModelUtils.isNamedExitTransition(t, exitPointSpec.getExitpoint())) {
								warning(TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS, transition, null, -1);
							}
						}

						// Validate the state has minimally one named exit
						// region

						boolean hasExit = false;
						Iterator<Region> regionIter = state.getRegions().iterator();
						while (regionIter.hasNext() && !hasExit) {

							Iterator<Exit> exitIter = STextValidationModelUtils.getExits(regionIter.next().eContents())
									.iterator();
							while (exitIter.hasNext() && !hasExit) {
								Exit exit = exitIter.next();
								hasExit = exitPointSpec.getExitpoint().equals(exit.getName());
							}
						}
						if (!hasExit) {
							error(TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT, transition, null, -1);
						}

					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkUnboundEntryPoints(final org.yakindu.sct.model.sgraph.State state) {
		if (state.isComposite()) {
			final List<Transition>[] transitions = STextValidationModelUtils.getEntrySpecSortedTransitions(state
					.getIncomingTransitions());
			Map<Region, List<Entry>> regions = null;

			// first list contains Transitions without entry spec
			if (!transitions[0].isEmpty()) {
				regions = STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.getRegions());
				if (!regions.isEmpty()) {
					for (Transition transition : transitions[0]) {
						error(TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT, transition, null, -1);
					}
					for (Region region : regions.keySet()) {
						error(REGION_UNBOUND_DEFAULT_ENTRY_POINT, region, null, -1);
					}
				}
			}

			// second list contains Transitions with entry spec
			if (!transitions[1].isEmpty()) {
				if (regions == null) {
					regions = STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.getRegions());
				}
				for (Transition transition : transitions[1]) {
					boolean hasTargetEntry = true;
					for (ReactionProperty property : transition.getProperties()) {
						if (property instanceof EntryPointSpec) {
							EntryPointSpec spec = (EntryPointSpec) property;
							String specName = "'" + spec.getEntrypoint() + "'";
							for (Region region : regions.keySet()) {
								boolean hasEntry = false;
								for (Entry entry : regions.get(region)) {
									if (entry.getName().equals(spec.getEntrypoint())) {
										hasEntry = true;
										break;
									}
								}
								if (!hasEntry) {
									error(REGION_UNBOUND_NAMED_ENTRY_POINT + specName, region, null, -1);
									hasTargetEntry = false;
								}
							}
							if (!hasTargetEntry) {
								error(TRANSITION_UNBOUND_NAMED_ENTRY_POINT + specName, transition, null, -1);
							}
						}
					}
				}
			}
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
	public void checkOperationArguments_TypedElementReferenceExpression(final ElementReferenceExpression call) {
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

		List<AssignmentExpression> contents = EcoreUtil2.eAllOfType(exp, AssignmentExpression.class);
		contents.remove(exp);

		Iterable<AssignmentExpression> filter = Iterables.filter(contents, new Predicate<AssignmentExpression>() {
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
		if (varRef instanceof ElementReferenceExpression
				&& ((ElementReferenceExpression) varRef).getReference() instanceof Property) {
			Property reference = (Property) ((ElementReferenceExpression) varRef).getReference();
			return reference.getName();
		} else if (varRef instanceof FeatureCall && ((FeatureCall) varRef).getFeature() instanceof Property) {
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
			error("A variable, event or operation is required", ExpressionsPackage.Literals.FEATURE_CALL__FEATURE,
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
					ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
					FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent || eventSpec instanceof ExitEvent)) {
				error("entry and exit events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS, INSIGNIFICANT_INDEX,
						LOCAL_REACTIONS_NOT_ALLOWED);
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

			if (!(exp instanceof AssignmentExpression) && !(exp instanceof EventRaisingExpression)) {

				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((FeatureCall) exp);
				} else if (exp instanceof ElementReferenceExpression) {
					checkElementReferenceEffect((ElementReferenceExpression) exp);
				} else {
					error("Action has no effect.", StextPackage.Literals.REACTION_EFFECT__ACTIONS, effect.getActions()
							.indexOf(exp), FEATURE_CALL_HAS_NO_EFFECT);
				}

			}
		}
	}

	protected void checkFeatureCallEffect(FeatureCall call) {
		if (call.getFeature() != null && call.getFeature() instanceof Feature
				&& !(call.getFeature() instanceof Operation)) {
			if (call.getFeature() instanceof Property) {
				error("Access to property '" + nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else if (call.getFeature() instanceof Event) {
				error("Access to event '" + nameProvider.getFullyQualifiedName(call.getFeature()) + "' has no effect.",
						call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '" + nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	protected void checkElementReferenceEffect(ElementReferenceExpression refExp) {
		if (!(refExp.getReference() instanceof Operation)) {
			if (refExp.getReference() instanceof Property) {
				error("Access to property '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp,
						ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			} else if (refExp.getReference() instanceof Event) {
				error("Access to event '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp,
						ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp,
						ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope && event.getDirection() == Direction.LOCAL) {
			error(LOCAL_DECLARATIONS, StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope && event.getDirection() != Direction.LOCAL) {
			error(IN_OUT_DECLARATIONS, StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
	}

	@Check(CheckType.FAST)
	public void checkExitPointSpecWithTrigger(Transition t) {
		if (!STextValidationModelUtils.getExitPointSpecs(t.getProperties()).isEmpty() && t.getTrigger() != null
				&& t.getSource() instanceof org.yakindu.sct.model.sgraph.State) {
			error(EXITPOINTSPEC_WITH_TRIGGER, t, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void checkInterfaceScope(ScopedElement statechart) {
		List<InterfaceScope> defaultInterfaces = new LinkedList<InterfaceScope>();

		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope && ((InterfaceScope) scope).getName() == null) {
				defaultInterfaces.add((InterfaceScope) scope);
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error(ONLY_ONE_INTERFACE, scope, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1(),
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ONLY_ONE_INTERFACE);
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
			warning(CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS);
	}

	protected boolean isDefault(Trigger trigger) {

		return trigger == null
				|| trigger instanceof DefaultTrigger
				|| ((trigger instanceof ReactionTrigger) && ((ReactionTrigger) trigger).getTriggers().size() == 0 && ((ReactionTrigger) trigger)
						.getGuard() == null);
	}

	@Override
	protected String getCurrentLanguage(Map<Object, Object> context, EObject eObject) {
		Resource eResource = eObject.eResource();
		if (eResource instanceof XtextResource) {
			return super.getCurrentLanguage(context, eObject);
		} else if (eResource instanceof AbstractSCTResource) {
			return ((AbstractSCTResource) eResource).getLanguageName();
		}
		return "";
	}

	protected void error(String message, EObject source, Keyword keyword, int index, String code) {
		final String[] issueData = null;
		ICompositeNode rootNode = NodeModelUtils.findActualNodeFor(source);
		if (rootNode != null) {
			INode child = findNode(source, false, rootNode, keyword, new int[] { index });
			if (child != null) {
				int offset = child.getTotalOffset();
				int length = child.getTotalLength();
				getMessageAcceptor().acceptError(message, source, offset, length, code, issueData);
				return;
			}
		}
		error(message, source, (EStructuralFeature) null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code);
	}

	private INode findNode(EObject source, boolean sourceFound, INode root, Keyword keyword, int[] index) {
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
		if (grammarElement instanceof Keyword && keyword.getValue().equals(((Keyword) grammarElement).getValue())) {
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
				INode result = findNode(source, sourceFound, child, keyword, index);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = super.getEPackages();
		result.add(ExpressionsPackage.eINSTANCE);
		return result;
	}

	@Check(CheckType.FAST)
	public void checkImportExists(Import importDef) {
		String importedNamespace = importDef.getImportedNamespace();
		if (!checkImportedNamespaceExists(importDef.getImportedNamespace(), getResource(importDef))) {
			error("The import " + importedNamespace + " cannot be resolved", importDef,
					StextPackage.Literals.IMPORT__IMPORTED_NAMESPACE, IMPORT_NOT_RESOLVED);
		}
	}

	protected boolean checkImportedNamespaceExists(String importedNamespace, Resource res) {
		if (importedNamespace.endsWith(".*")) {
			importedNamespace = importedNamespace.substring(0, importedNamespace.length() - 2); // remove
																								// wildcard
		}
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(res);
		URI uri = res.getURI();
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(uri);
		if (resourceDescription == null) {
			return false; // no resource description could be found, so package
							// cannot be resolved anyway
		}
		for (IContainer container : containerManager.getVisibleContainers(resourceDescription, resourceDescriptions)) {
			final Iterable<IResourceDescription> currentDescriptions = container.getResourceDescriptions();
			for (IResourceDescription resDesc : currentDescriptions) {
				Iterable<IEObjectDescription> visiblePackages = resDesc
						.getExportedObjectsByType(TypesPackage.Literals.PACKAGE);
				for (IEObjectDescription pkgDesc : visiblePackages) {
					if (pkgDesc.getName().toString().equals(importedNamespace)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private Resource getResource(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(
				context.eResource(), ContextElementAdapter.class);
		if (provider == null) {
			return context.eResource();
		} else {
			return provider.getElement().eResource();
		}
	}
}
