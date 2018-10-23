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

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CHILD_FIRST_ANNOTATION;
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CYCLE_BASED_ANNOTATION;
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.PARENT_FIRST_ANNOTATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.validation.ExpressionsJavaValidator;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Direction;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.extensions.STextExtensions;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.model.stext.scoping.ImportedResourceCache;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.ArgumentedAnnotation;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Several validations for nonsensical expressions.
 *
 * @author muehlbrandt
 * @author muelder
 *
 */
@ComposedChecks(validators = { SGraphJavaValidator.class, ExpressionsJavaValidator.class,
		STextNamesAreUniqueValidator.class })
public class STextJavaValidator extends AbstractSTextJavaValidator implements STextValidationMessages {

	private static final String KEYWORD_ONCYCLE = "oncycle";
	private static final String KEYWORD_ALWAYS = "always";
	
	@Inject
	private ITypeSystemInferrer typeInferrer;
	@Inject
	private STextGrammarAccess grammarAccess;
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	@Inject(optional = true)
	@Named(DomainRegistry.DOMAIN_ID)
	private String domainID = BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
	@Inject(optional = true)
	private IPackageImport2URIMapper mapper;
	@Inject
	protected STextExtensions utils;
	@Inject
	private ImportedResourceCache resourceDescriptionCache;

	@Check(CheckType.FAST)
	public void checkExpression(VariableDefinition expression) {
		if (expression.getType() == null || expression.getType().eIsProxy())
			return;
		typeInferrer.infer(expression, this);
	}

	@Check(CheckType.FAST)
	public void checkExpression(TimeEventSpec expression) {
		typeInferrer.infer(expression, this);
	}

	@Check(CheckType.FAST)
	public void checkExpression(Guard expression) {
		typeInferrer.infer(expression, this);
	}

	@Check(CheckType.FAST)
	public void checkNoAssignmentInGuard(Guard guard) {
		TreeIterator<EObject> eAllContents = guard.eAllContents();
		while (eAllContents.hasNext()) {
			EObject e = eAllContents.next();
			if (e instanceof AssignmentExpression) {
				error(GUARD_CONTAINS_ASSIGNMENT, guard, null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void transitionsWithNoTrigger(Transition trans) {

		if (trans.getSource() instanceof Entry || trans.getSource() instanceof Choice
				|| trans.getSource() instanceof Synchronization || (trans.getTarget() instanceof Synchronization
						&& (trans.getTarget().getIncomingTransitions().size() > 1))) {
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
	public void checkAlwaysTransitionHasLowestPriority(RegularState state) {
		Iterator<Transition> iterator = state.getOutgoingTransitions().iterator();
		Transition deadTransition = null;
		while (iterator.hasNext()) {
			Transition transition = iterator.next();
			Trigger trigger = transition.getTrigger();
			if (deadTransition != null) {
				warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1);
			}
			// check default/else trigger
			if (trigger instanceof DefaultTrigger && iterator.hasNext()) {
				warning(String.format(ALWAYS_TRUE_TRANSITION_USED, transition.getSpecification()), transition, null,
						-1);
				if(deadTransition == null) {
					deadTransition = transition;
				}
			}
			// check always/oncycle trigger
			else if (trigger instanceof ReactionTrigger) {
				ReactionTrigger reactTrigger = (ReactionTrigger) trigger;
				EList<EventSpec> triggers = reactTrigger.getTriggers();
				if (triggers.size() == 1 && reactTrigger.getGuard() == null) {
					EventSpec eventSpec = triggers.get(0);
					if (eventSpec instanceof AlwaysEvent && iterator.hasNext()) {
						warning(String.format(ALWAYS_TRUE_TRANSITION_USED, getTransitionDeclaration(transition)),
								transition, null, -1);
						if(deadTransition == null) {
							deadTransition = transition;
						}
					}
				}
			}
		}
	}

	protected String getTransitionDeclaration(Transition transition) {
		String specification = transition.getSpecification();
		
		if (KEYWORD_ALWAYS.contains(specification)) {
			return KEYWORD_ALWAYS;
		} else if (KEYWORD_ONCYCLE.contains(specification)) {
			return KEYWORD_ONCYCLE;
		}
		return specification;
	}
	
	@Check(CheckType.FAST)
	public void checkAlwaysAndDefaultTransitionInChoices(Choice choice) {
		Transition deadTransition = null;
		EList<Transition> outgoingTransitions = choice.getOutgoingTransitions();
		int size = outgoingTransitions.size();
		int deadTransitionIndex = 0;
		for (int i = 0; i < size; i++) {
			Transition transition = outgoingTransitions.get(i);
			if (deadTransition != null) {
				warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1);
			}
			Trigger trigger = transition.getTrigger();
			if (trigger instanceof ReactionTrigger) {
				ReactionTrigger reactTrigger = (ReactionTrigger) trigger;
				EList<EventSpec> triggers = reactTrigger.getTriggers();
				if (triggers.size() == 1 && reactTrigger.getGuard() == null) {
					if (triggers.get(0) instanceof AlwaysEvent) {
						if(i != size-1) {
							warning(String.format(ALWAYS_TRUE_TRANSITION_USED, transition.getSpecification()), transition,
									null, -1);
						}
						if (deadTransition == null) {
							deadTransition = transition;
							deadTransitionIndex = i;
						}
					}
				}
			}
		}
		
		// if we got a dead transition, we need to re-check if a default was used before
		if(deadTransition != null) {
			for(int i = 0; i < deadTransitionIndex; i++) {
				Transition transition = outgoingTransitions.get(i);
				Trigger trigger = transition.getTrigger();
				if(trigger instanceof DefaultTrigger || trigger ==null) {
					warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1);
				}
			}
		}
	}
	
	@Check(CheckType.FAST)
	public void checkOnlyOneDefaultTransitionUsed(Choice choice){
		Iterator<Transition> iterator = choice.getOutgoingTransitions().iterator();
		List<Transition> defaultTransitions = new ArrayList<>();
		while(iterator.hasNext()) {
			Transition transition = iterator.next();
			Trigger trigger = transition.getTrigger();
			if(trigger instanceof DefaultTrigger || trigger ==null) {
				defaultTransitions.add(transition);
			}
		}
		int size = defaultTransitions.size();
		if (size > 1) {
			Iterator<Transition> iterator2 = defaultTransitions.iterator();
			while (iterator2.hasNext()) {
				warning(String.format(ONLY_ONE_DEFAULT_SHOULD_BE_USED, size), iterator2.next(), null, -1);
			}
		}
	}
	
	@Check(CheckType.FAST)
	public void checkUnusedEntry(final Entry entry) {
		if (entry.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& entry.getIncomingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) entry.getParentRegion()
					.getComposite();
			if (!entry.isDefault()) {
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
	public void checkValueDefinitionExpression(VariableDefinition definition) {
		// applies only to constants
		if (!definition.isConst())
			return;
		Expression initialValue = definition.getInitialValue();
		if (initialValue == null) {
			error(CONST_MUST_HAVE_VALUE_MSG, definition, null, CONST_MUST_HAVE_VALUE_CODE);
			return;
		}
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
	public void checkConstAndReadOnlyDefinitionExpression(VariableDefinition definition) {
		// applies only for readonly const definitions
		if (!definition.isReadonly() && !definition.isConst())
			return;
		ICompositeNode definitionNode = NodeModelUtils.getNode(definition);
		String tokenText = NodeModelUtils.getTokenText(definitionNode);

		if (tokenText == null || tokenText.isEmpty())
			return;
		if (tokenText.contains(TypesPackage.Literals.PROPERTY__READONLY.getName())
				&& tokenText.contains(TypesPackage.Literals.PROPERTY__CONST.getName())) {
			warning(String.format(STextValidationMessages.DECLARATION_WITH_READONLY,
					TypesPackage.Literals.PROPERTY__READONLY.getName(),
					TypesPackage.Literals.PROPERTY__CONST.getName()), definition,
					TypesPackage.Literals.PROPERTY__READONLY);
		}
	}

	@Check(CheckType.FAST)
	public void checkUnusedVariablesInInternalScope(InternalScope internalScope) {
		EList<Declaration> internalScopeDeclarations = internalScope.getDeclarations();

		EObject rootContainer = EcoreUtil.getRootContainer(internalScope);
		Resource rootRes = getResource(rootContainer);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(rootRes.getContents(),
				SGraphPackage.Literals.STATECHART);
		if (statechart == null)
			return;
		List<ElementReferenceExpression> allUsedElementReferences = EcoreUtil2.getAllContentsOfType(statechart,
				ElementReferenceExpression.class);

		if (statechart.getSpecification() != null) {
			for (Declaration internalDeclaration : internalScopeDeclarations) {
				boolean internalDeclarationUsed = false;
				for (ElementReferenceExpression elementReference : allUsedElementReferences) {
					if (elementReference.getReference().eContainer() instanceof InternalScope) {
						if (elementReference.getReference() instanceof VariableDefinition) {
							if (((VariableDefinition) elementReference.getReference()).getName()
									.equals(internalDeclaration.getName())
									&& internalDeclaration instanceof VariableDefinition) {
								internalDeclarationUsed = true;
								break;
							}
						} else if (elementReference.getReference() instanceof EventDefinition) {
							if (((EventDefinition) elementReference.getReference()).getName().equals(
									internalDeclaration.getName()) && internalDeclaration instanceof EventDefinition) {
								internalDeclarationUsed = true;
								break;
							}
						} else if (elementReference.getReference() instanceof OperationDefinition) {
							if (((OperationDefinition) elementReference.getReference()).getName()
									.equals(internalDeclaration.getName())
									&& internalDeclaration instanceof OperationDefinition) {
								internalDeclarationUsed = true;
								break;
							}
						}
					}
				}
				if (!internalDeclarationUsed) {
					if (internalDeclaration instanceof VariableDefinition
							|| internalDeclaration instanceof EventDefinition
							|| internalDeclaration instanceof OperationDefinition)
						warning(INTERNAL_DECLARATION_UNUSED, internalDeclaration, null, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkValueOfNoEvent(EventValueReferenceExpression exp) {

		Expression eventExpr = exp.getValue();

		EObject element = null;
		if (eventExpr instanceof ElementReferenceExpression) {
			element = ((ElementReferenceExpression) eventExpr).getReference();
		} else if (eventExpr instanceof FeatureCall) {
			element = ((FeatureCall) eventExpr).getFeature();
		}

		if (element != null && (!(element instanceof Event))) {
			String elementName = "";
			if (element instanceof NamedElement) {
				elementName = "'" + ((NamedElement) element).getName() + "' ";
			}
			error(elementName + "is no event.", StextPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION__VALUE, 0,
					VALUE_OF_REQUIRES_EVENT);
		}
	}

	@Check(CheckType.NORMAL)
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

	@Check(CheckType.NORMAL)
	public void checkUnusedExit(final Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& exit.getOutgoingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) exit.getParentRegion()
					.getComposite();

			if (!exit.isDefault()) {
				boolean hasOutgoingTransition = false;
				boolean equalsOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					Transition transition = transitionIt.next();
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transition)
							|| STextValidationModelUtils.isNamedExitTransition(transition, exit.getName());

				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1);
				}
				for (Transition transition : state.getOutgoingTransitions()) {
					for (ReactionProperty property : transition.getProperties()) {
						if (property instanceof ExitPointSpec) {
							String exitpoint = ((ExitPointSpec) property).getExitpoint();
							if (exitpoint.equals(exit.getName())) {
								equalsOutgoingTransition = true;
							}
						}
					}
				}
				if (!equalsOutgoingTransition) {
					warning(EXIT_NEVER_USED + "'" + exit.getName() + "'", exit, null, -1);
				}

			} else {
				boolean hasOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transitionIt.next());
				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1);
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
							if (transition != t && STextValidationModelUtils.isNamedExitTransition(t,
									exitPointSpec.getExitpoint())) {
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
	public void checkAnnotations(final Statechart statechart) {
		Annotation eventDriven = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION);
		Annotation cycleBased = statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION);

		if (eventDriven != null && cycleBased != null) {
			String errorMsg = String.format(CONTRADICTORY_ANNOTATIONS,
					String.join(", ", eventDriven.getType().toString(), cycleBased.getType().toString()));
			error(errorMsg, cycleBased, null, -1);
		}

		Annotation parentFirst = statechart.getAnnotationOfType(PARENT_FIRST_ANNOTATION);
		Annotation childFirst = statechart.getAnnotationOfType(CHILD_FIRST_ANNOTATION);

		if (parentFirst != null && childFirst != null) {
			String errorMsg = String.format(CONTRADICTORY_ANNOTATIONS,
					String.join(", ", parentFirst.getType().toString(), childFirst.getType().toString()));
			error(errorMsg, parentFirst, null, -1);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkUnboundEntryPoints(final org.yakindu.sct.model.sgraph.State state) {
		if (state.isComposite()) {
			final List<Transition>[] transitions = STextValidationModelUtils
					.getEntrySpecSortedTransitions(state.getIncomingTransitions());
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
							boolean usingEntry = false;
							for (Region region : state.getRegions()) {
								EList<Vertex> vertices = region.getVertices();
								for (Vertex vertice : vertices) {
									if (vertice instanceof Entry) {
										if (spec.getEntrypoint().equals(vertice.getName())) {
											usingEntry = true;
										}
									}
								}
							}
							if (!usingEntry) {
								warning(ENTRY_NOT_EXIST + specName, transition, null, -1);
							}
						}
					}
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkTopLeveEntryIsDefaultEntry(final Entry entry) {
		Region parentRegion = entry.getParentRegion();
		// 1. check if is toplevel
		if (isTopLevelRegion(parentRegion)) {
			// 2. check if is default entry
			if (!entry.isDefault()) {
				Map<Region, List<Entry>> regionsWithoutDefaultEntry = STextValidationModelUtils
						.getRegionsWithoutDefaultEntry(Lists.newArrayList(parentRegion));
				List<Entry> list = regionsWithoutDefaultEntry.get(parentRegion);
				if (list != null)
					error(TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY, entry, SGraphPackage.Literals.ENTRY__KIND,
							-1);
				else
					warning(TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY, entry,
							SGraphPackage.Literals.ENTRY__KIND, -1);
			}
		}
	}

	protected boolean isTopLevelRegion(final Region region) {
		return region.eContainer() instanceof Statechart;
	}

	@Check(CheckType.NORMAL)
	public void checkTopLevelRegionHasEntry(final Region region) {
		if (isTopLevelRegion(region)) {
			if (!STextValidationModelUtils.getRegionsWithoutDefaultEntry(Collections.singletonList(region)).isEmpty()) {
				error(REGION_UNBOUND_DEFAULT_ENTRY_POINT, region, null, -1);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkAnnotationArguments(ArgumentedAnnotation annotation) {
		if (annotation.getType() != null
				&& annotation.getExpressions().size() != annotation.getType().getProperties().size()) {
			error(String.format(ERROR_WRONG_NUMBER_OF_ARGUMENTS_MSG, annotation.getType().getProperties()), null,
					ERROR_WRONG_NUMBER_OF_ARGUMENTS_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void checkAssignmentExpression(final AssignmentExpression exp) {
		final String name = getVariableName(exp);
		List<AssignmentExpression> contents = EcoreUtil2.eAllOfType(exp, AssignmentExpression.class);
		contents.remove(exp);
		Iterable<AssignmentExpression> filter = Iterables.filter(contents, new Predicate<AssignmentExpression>() {
			@Override
			public boolean apply(final AssignmentExpression ex) {
				String variableName = getVariableName(ex);
				return variableName.equals(name);

			}
		});
		if (Iterables.size(filter) > 0) {
			error(ASSIGNMENT_EXPRESSION, null);
		}
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(FeatureCall call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getFeature() instanceof Scope) {
			error("A variable, event or operation is required.", ExpressionsPackage.Literals.FEATURE_CALL__FEATURE,
					INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(ElementReferenceExpression call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getReference() instanceof Scope) {
			error("A variable, event or operation is required.",
					ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
					FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent || eventSpec instanceof ExitEvent)) {
				error("Entry and exit events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS, INSIGNIFICANT_INDEX,
						ENTRY_EXIT_TRIGGER_NOT_ALLOWED);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTriggerRegularEvent(ReactionTrigger reactionTrigger) {
		for (int i = 0; i < reactionTrigger.getTriggers().size(); i++) {
			EventSpec eventSpec = reactionTrigger.getTriggers().get(i);
			if (eventSpec instanceof RegularEventSpec) {
				EObject element = unwrap(((RegularEventSpec) eventSpec).getEvent());
				if (element != null && (!(element instanceof Event))) {
					String elementName = "";
					if (element instanceof NamedElement) {
						elementName = "'" + ((NamedElement) element).getName() + "' ";
					}
					error("Trigger " + elementName + "is no event.", StextPackage.Literals.REACTION_TRIGGER__TRIGGERS,
							i, TRIGGER_IS_NO_EVENT);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkRaisingExpressionEvent(EventRaisingExpression expression) {
		EObject element = unwrap(expression.getEvent());
		if (element != null && (!(element instanceof Event))) {
			String elementName = "";
			if (element instanceof NamedElement) {
				elementName = ((NamedElement) element).getName();
			}
			error(String.format("'%s' is not an event.", elementName),
					StextPackage.Literals.EVENT_RAISING_EXPRESSION__EVENT, -1);
		}
	}

	protected EObject unwrap(Expression eventExpression) {
		EObject element = null;
		if (eventExpression instanceof ElementReferenceExpression) {
			element = ((ElementReferenceExpression) eventExpression).getReference();
		} else if (eventExpression instanceof FeatureCall) {
			element = ((FeatureCall) eventExpression).getFeature();
		}
		return element;
	}

	@Check(CheckType.FAST)
	public void checkSyncNoTriggersOnOutgoingTransition(Synchronization synchronization) {
		List<Transition> outgoing = synchronization.getOutgoingTransitions();
		for (Transition transition : outgoing) {
			if (transition.getTrigger() != null) {
				warning(SYNC_OUTGOING_TRIGGER, transition, null);
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

			if (!(exp instanceof AssignmentExpression) && !(exp instanceof EventRaisingExpression)
					&& !(exp instanceof PostFixUnaryExpression)) {

				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((FeatureCall) exp);
				} else if (exp instanceof ElementReferenceExpression) {
					checkElementReferenceEffect((ElementReferenceExpression) exp);
				} else {
					error("Action has no effect.", StextPackage.Literals.REACTION_EFFECT__ACTIONS,
							effect.getActions().indexOf(exp), FEATURE_CALL_HAS_NO_EFFECT);
				}

			}
		}
	}

	protected void checkFeatureCallEffect(FeatureCall call) {
		if (call.getFeature() != null && call.getFeature() instanceof Declaration
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
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope && event.getDirection() == Direction.LOCAL) {
			error(LOCAL_DECLARATIONS, TypesPackage.Literals.EVENT__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope && event.getDirection() != Direction.LOCAL) {
			error(IN_OUT_DECLARATIONS, TypesPackage.Literals.EVENT__DIRECTION);
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
		List<InterfaceScope> defaultInterfaces = new LinkedList<>();

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

	@Check(CheckType.FAST)
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

	@Check
	public void checkDuplicateImport(ImportScope importScope) {
		EList<Scope> allScopes = EcoreUtil2.getContainerOfType(importScope, ScopedElement.class).getScopes();

		nextImportOfCurrentScope: for (String importToCheck : importScope.getImports()) {
			Set<String> allImports = Sets.newHashSet();
			for (Scope scope : allScopes) {
				if (!(scope instanceof ImportScope))
					continue;// exclude internal & interface scopes
				for (String anImport : ((ImportScope) scope).getImports()) {
					if (anImport.equals(importToCheck) && !allImports.add(anImport)) {
						warning(String.format(DUPLICATE_IMPORT, importToCheck), importScope,
								StextPackage.Literals.IMPORT_SCOPE__IMPORTS,
								importScope.getImports().indexOf(importToCheck));
						continue nextImportOfCurrentScope;
					}
				}
			}
		}
	}

	@Check
	public void checkImportsValid(ImportScope scope) {
		EList<String> imports = scope.getImports();
		for (String packageImport : imports) {
			Optional<PackageImport> pkImport = mapper.findPackageImport(scope.eResource(), packageImport);
			if (!pkImport.isPresent() || !getResource(scope).getResourceSet().getURIConverter()
					.exists(pkImport.get().getUri().trimQuery(), null)) {
				error(String.format(IMPORT_NOT_RESOLVED_MSG, packageImport), scope,
						StextPackage.Literals.IMPORT_SCOPE__IMPORTS, imports.indexOf(packageImport));
			}
			else {
				IResourceDescription iResourceDescription = resourceDescriptionCache.get(pkImport.get().getUri());
				if (iResourceDescription instanceof DefaultResourceDescription) {
					Resource resource = ((DefaultResourceDescription) iResourceDescription).getResource();
					if (!(resource.getWarnings().isEmpty() && resource.getErrors().isEmpty())) {
						StringBuilder b = new StringBuilder("The resource contains errors.\n");
						for (Diagnostic e : resource.getErrors()) {
							b.append("\nError: ").append(e.getMessage());
						}
						for (Diagnostic e : resource.getWarnings()) {
							b.append("\nWarning: ").append(e.getMessage());
						}
						error(b.toString(), scope, StextPackage.Literals.IMPORT_SCOPE__IMPORTS,
								imports.indexOf(packageImport));
					}
				}
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

	protected boolean isDefault(Trigger trigger) {
		return trigger == null || trigger instanceof DefaultTrigger
				|| ((trigger instanceof ReactionTrigger) && ((ReactionTrigger) trigger).getTriggers().size() == 0
				&& ((ReactionTrigger) trigger).getGuard() == null);
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

	protected Resource getResource(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
				ContextElementAdapter.class);
		if (provider == null) {
			return context.eResource();
		} else {
			return provider.getElement().eResource();
		}
	}

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		boolean isResponsible = super.isResponsible(context, eObject);
		if (!isResponsible)
			return false;
		Statechart statechart = utils.getStatechart(eObject);
		if ((statechart != null) && !domainID.equals(statechart.getDomainID())) {
			return false;
		}
		return true;
	}

	@Check(CheckType.FAST)
	public void checkOnlyOneEntryPointSpecIsUsed(Transition transition) {
		EList<ReactionProperty> properties = transition.getProperties();
		int countEntryPointSpecs = 0;
		for (ReactionProperty property : properties) {
			if (property instanceof EntryPointSpec) {
				countEntryPointSpecs++;
			}
			if (countEntryPointSpecs > 1) {
				warning(ONLY_FIRST_ENTRY_POINT_WILL_BE_USED, transition, null, -1);
				break;
			}
		}
	}

}
