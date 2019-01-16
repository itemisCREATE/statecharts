/** 
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.model.stext.validation

import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import java.util.Iterator
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Optional
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Setting
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.DefaultResourceDescription
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.ComposedChecks
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.yakindu.base.base.BasePackage
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsPackage
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.validation.ExpressionsValidator
import org.yakindu.base.types.Annotation
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesPackage
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.sct.domain.^extension.DomainRegistry
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.ReactionProperty
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.SGraphPackage
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.ScopedElement
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator
import org.yakindu.sct.model.stext.extensions.STextExtensions
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport
import org.yakindu.sct.model.stext.scoping.ImportedResourceCache
import org.yakindu.sct.model.stext.services.STextGrammarAccess
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.DefaultTrigger
import org.yakindu.sct.model.stext.stext.EntryEvent
import org.yakindu.sct.model.stext.stext.EntryPointSpec
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.ExitEvent
import org.yakindu.sct.model.stext.stext.ExitPointSpec
import org.yakindu.sct.model.stext.stext.Guard
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.LocalReaction
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.StatechartSpecification
import org.yakindu.sct.model.stext.stext.StextPackage
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CHILD_FIRST_ANNOTATION
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CYCLE_BASED_ANNOTATION
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.PARENT_FIRST_ANNOTATION
import org.eclipse.emf.ecore.resource.Resource.Diagnostic

/** 
 * Several validations for nonsensical expressions.
 * @author muehlbrandt
 * @author muelder
 */
@ComposedChecks(validators=#[SGraphJavaValidator, ExpressionsValidator, STextNamesAreUniqueValidator])

class STextValidator extends AbstractSTextValidator implements STextValidationMessages{

	static final String KEYWORD_ONCYCLE="oncycle"
	static final String KEYWORD_ALWAYS="always"

	@Inject 
	ITypeSystemInferrer typeInferrer
	@Inject 
	STextGrammarAccess grammarAccess
	@Inject 
	extension IQualifiedNameProvider nameProvider
	@Inject(optional=true)
	@Named(DomainRegistry.DOMAIN_ID)
	String domainID=BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral()
	@Inject(optional=true)
	IPackageImport2URIMapper mapper
	@Inject 
	protected STextExtensions utils
	@Inject
	private ImportedResourceCache resourceDescriptionCache;
	
	@Check(CheckType.FAST)
	def void checkExpression(TimeEventSpec expression) {
		typeInferrer.infer(expression, this) 
	}

	@Check(CheckType.FAST)
	def void checkExpression(Guard expression) {
		typeInferrer.infer(expression, this) 
	}

	@Check(CheckType.FAST)
	def void checkNoAssignmentInGuard(Guard guard) {
		if(!guard.eAllContents.filter(AssignmentExpression).empty || !guard.eAllContents.filter(PostFixUnaryExpression).empty){
			error(GUARD_CONTAINS_ASSIGNMENT, guard, null) 
		}
	}

	@Check(CheckType.FAST)
	def void transitionsWithNoTrigger(Transition trans) {
		if (trans.source instanceof Entry || trans.source instanceof Choice || trans.source instanceof Synchronization || 
			(trans.target instanceof Synchronization && (trans.target.incomingTransitions.size() > 1))) {
			return;
		}
		if (trans.source instanceof org.yakindu.sct.model.sgraph.State) {
			var org.yakindu.sct.model.sgraph.State state=(trans.source as org.yakindu.sct.model.sgraph.State) 
			if (state.isComposite()) {
				for (Region r : state.regions) {
					for (Vertex v : r.vertices) {
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
		if (trans.trigger === null) {
			warning(ISSUE_TRANSITION_WITHOUT_TRIGGER, trans, null, -1) 
		}
	}
	@Check(CheckType.FAST)
	def void checkAlwaysTransitionHasLowestPriority(RegularState state) {
		var Iterator<Transition> iterator=state.outgoingTransitions.iterator() 
		var Transition deadTransition=null 
		while (iterator.hasNext()) {
			var Transition transition=iterator.next() 
			var Trigger trigger=transition.trigger 
			if (deadTransition !== null) {
				warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1) 
			}
			// check default/else trigger
			if (trigger instanceof DefaultTrigger && iterator.hasNext()) {
				warning(String.format(ALWAYS_TRUE_TRANSITION_USED, transition.getSpecification()), transition, null, -1) 
				if (deadTransition === null) {
					deadTransition=transition 
				}
			} else // check always/oncycle trigger
			if (trigger instanceof ReactionTrigger) {
				var ReactionTrigger reactTrigger=(trigger as ReactionTrigger) 
				var EList<EventSpec> triggers=reactTrigger.triggers
				if (triggers.size() === 1 && reactTrigger.guard === null) {
					var EventSpec eventSpec=triggers.get(0) 
					if (eventSpec instanceof AlwaysEvent && iterator.hasNext()) {
						warning(String.format(ALWAYS_TRUE_TRANSITION_USED, getTransitionDeclaration(transition)), transition, null, -1) 
						if (deadTransition === null) {
							deadTransition=transition 
						}
					}
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkDefaultAndElseIsNotUsedOnRegularState(RegularState state) {
		var EList<Transition> outgoingTransitions=state.outgoingTransitions 
		for (Transition transition : outgoingTransitions) {
			var Trigger trigger=transition.trigger 
			if (trigger instanceof DefaultTrigger) {
				warning(DEFAULT_AND_ELSE_TRANSITION_ON_REGULAR_STATE, transition, null, -1) 
			}
		}
	}
	def protected String getTransitionDeclaration(Transition transition) {
		var String specification=transition.getSpecification() 
		if (KEYWORD_ALWAYS.contains(specification)) {
			return KEYWORD_ALWAYS 
		} else if (KEYWORD_ONCYCLE.contains(specification)) {
			return KEYWORD_ONCYCLE 
		}
		return specification 
	}
	@Check(CheckType.FAST)
	def void checkAlwaysAndDefaultTransitionInChoices(Choice choice) {
		var Transition deadTransition=null 
		var EList<Transition> outgoingTransitions=choice.outgoingTransitions 
		var int size=outgoingTransitions.size() 
		var int deadTransitionIndex=0 
		for (var int i=0; i < size; i++) {
			var Transition transition=outgoingTransitions.get(i) 
			if (deadTransition !== null) {
				warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1) 
			}
			var Trigger trigger=transition.trigger 
			if (trigger instanceof ReactionTrigger) {
				var ReactionTrigger reactTrigger=(trigger as ReactionTrigger) 
				var EList<EventSpec> triggers=reactTrigger.triggers
				if (triggers.size() === 1 && reactTrigger.guard === null) {
					if (triggers.get(0) instanceof AlwaysEvent) {
						if (i !== size - 1) {
							warning(String.format(ALWAYS_TRUE_TRANSITION_USED, transition.getSpecification()), transition, null, -1) 
						}
						if (deadTransition === null) {
							deadTransition=transition 
							deadTransitionIndex=i 
						}
					}
				}
			}
		}
		// if we got a dead transition, we need to re-check if a default was used before
		if (deadTransition !== null) {
			for (var int i=0; i < deadTransitionIndex; i++) {
				var Transition transition=outgoingTransitions.get(i) 
				var Trigger trigger=transition.trigger 
				if (trigger instanceof DefaultTrigger || trigger === null) {
					warning(String.format(DEAD_TRANSITION, getTransitionDeclaration(deadTransition)), transition, null, -1) 
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkOnlyOneDefaultTransitionUsed(Choice choice) {
		var Iterator<Transition> iterator=choice.outgoingTransitions.iterator() 
		var List<Transition> defaultTransitions=new ArrayList<Transition>() 
		while (iterator.hasNext()) {
			var Transition transition=iterator.next() 
			var Trigger trigger=transition.trigger 
			if (trigger instanceof DefaultTrigger || trigger === null) {
				defaultTransitions.add(transition) 
			}
		}
		var int size=defaultTransitions.size() 
		if (size > 1) {
			var Iterator<Transition> iterator2=defaultTransitions.iterator() 
			while (iterator2.hasNext()) {
				warning(String.format(ONLY_ONE_DEFAULT_SHOULD_BE_USED, size), iterator2.next(), null, -1) 
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkUnusedEntry(Entry entry) {
		if (entry.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State && entry.incomingTransitions.isEmpty()) {
			var org.yakindu.sct.model.sgraph.State state=(entry.getParentRegion().getComposite() as org.yakindu.sct.model.sgraph.State) 
			if (!entry.isDefault()) {
				var boolean hasIncomingTransition=false 
				var Iterator<Transition> transitionIt=state.incomingTransitions.iterator() 
				while (transitionIt.hasNext() && !hasIncomingTransition) {
					var Iterator<ReactionProperty> propertyIt=transitionIt.next().getProperties().iterator() 
					while (propertyIt.hasNext() && !hasIncomingTransition) {
						var ReactionProperty property=propertyIt.next() 
						if (property instanceof EntryPointSpec) {
							hasIncomingTransition=entry.getName().equals(((property as EntryPointSpec)).getEntrypoint()) 
						}
					}
				}
				if (!hasIncomingTransition) {
					warning(ENTRY_UNUSED, entry, null, -1) 
				}
			}
		}
	}
	
	@Check(CheckType.FAST)
	def void checkNotRaisedOutEvent(EventDefinition event) {
		if (event.direction != Direction.OUT) {
			return;
		}
		var Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(event, event.eResource().getResourceSet());
		var isRaised = usages.exists[setting | setting.getEObject().eContainer instanceof EventRaisingExpression]
		if (!isRaised) {
			usages.filter[ setting |
				setting.EObject instanceof ElementReferenceExpression || setting.EObject instanceof FeatureCall
			].forEach[ setting |
				warning(String.format(OUT_EVENT_NEVER_RAISED, event.fullyQualifiedName), setting.EObject, null, -1)
			]
		}
	}
	
	@Check(CheckType.FAST)
	def void checkUnusedVariablesInInternalScope(InternalScope internalScope) {
		var EList<Declaration> internalScopeDeclarations=internalScope.getDeclarations() 
		var EObject rootContainer=EcoreUtil.getRootContainer(internalScope) 
		var Resource rootRes=getResource(rootContainer) 
		var Statechart statechart=(EcoreUtil.getObjectByType(rootRes.getContents(), SGraphPackage.Literals.STATECHART) as Statechart) 
		if (statechart === null) return;
		var List<ElementReferenceExpression> allUsedElementReferences=EcoreUtil2.getAllContentsOfType(statechart, ElementReferenceExpression) 
		if (statechart.getSpecification() !== null) {
			for (Declaration internalDeclaration : internalScopeDeclarations) {
				var boolean internalDeclarationUsed=false 
				for (ElementReferenceExpression elementReference : allUsedElementReferences) {
					if (elementReference.getReference().eContainer() instanceof InternalScope) {
						if (elementReference.getReference() instanceof Property) {
							if (((elementReference.getReference() as Property)).getName().equals(internalDeclaration.getName()) && internalDeclaration instanceof Property) {
								internalDeclarationUsed=true 
								//TODO end loop
							}
						} else if (elementReference.getReference() instanceof EventDefinition) {
							if (((elementReference.getReference() as EventDefinition)).getName().equals(internalDeclaration.getName()) && internalDeclaration instanceof EventDefinition) {
								internalDeclarationUsed=true 
								//TODO end loop
							}
						} else if (elementReference.getReference() instanceof OperationDefinition) {
							if (((elementReference.getReference() as OperationDefinition)).getName().equals(internalDeclaration.getName()) && internalDeclaration instanceof OperationDefinition) {
								internalDeclarationUsed=true 
								//TODO end loop
							}
						}
					}
				}
				if (!internalDeclarationUsed) {
					if (internalDeclaration instanceof VariableDefinition || internalDeclaration instanceof EventDefinition || internalDeclaration instanceof OperationDefinition) warning(INTERNAL_DECLARATION_UNUSED, internalDeclaration, null, -1) 
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkValueOfNoEvent(EventValueReferenceExpression exp) {
		var Expression eventExpr=exp.getValue() 
		var EObject element=null 
		if (eventExpr instanceof ElementReferenceExpression) {
			element=((eventExpr as ElementReferenceExpression)).getReference() 
		} else if (eventExpr instanceof FeatureCall) {
			element=((eventExpr as FeatureCall)).getFeature() 
		}
		if (element !== null && (!(element instanceof Event))) {
			var String msg="Could not find event declaration." 
			if (element instanceof NamedElement) {
				msg=''''«»«((element as NamedElement)).getName()»' is no event.''' 
			}
			error(msg, StextPackage.Literals.EVENT_VALUE_REFERENCE_EXPRESSION__VALUE, 0, VALUE_OF_REQUIRES_EVENT) 
		}
	}
	@Check(CheckType.NORMAL)
	def void checkValueReferenedBeforeDefined(Scope scope) {
		var EList<Declaration> declarations=scope.getDeclarations() 
		var Set<QualifiedName> defined=Sets.newHashSet() 
		for (Declaration declaration : declarations) {
			if (declaration instanceof VariableDefinition) {
				var VariableDefinition definition=(declaration as VariableDefinition) 
				if (!definition.isConst()) return;
				var Expression initialValue=definition.getInitialValue() 
				var List<Expression> toCheck=Lists.newArrayList(initialValue) 
				var TreeIterator<EObject> eAllContents=initialValue.eAllContents() 
				while (eAllContents.hasNext()) {
					var EObject next=eAllContents.next() 
					if (next instanceof Expression) toCheck.add((next as Expression)) 
				}
				for (Expression expression : toCheck) {
					var EObject referencedObject=null 
					if (expression instanceof FeatureCall) referencedObject=((expression as FeatureCall)).getFeature()  else if (expression instanceof ElementReferenceExpression) referencedObject=((expression as ElementReferenceExpression)).getReference() 
					if (referencedObject instanceof VariableDefinition) {
						if (!defined.contains(nameProvider.getFullyQualifiedName(referencedObject))) error(REFERENCE_CONSTANT_BEFORE_DEFINED, definition, TypesPackage.Literals.PROPERTY__INITIAL_VALUE) 
					}
				}
				defined.add(nameProvider.getFullyQualifiedName(definition)) 
			}
		}
	}
	@Check(CheckType.NORMAL)
	def void checkUnusedExit(Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State && exit.outgoingTransitions.isEmpty()) {
			var org.yakindu.sct.model.sgraph.State state=(exit.getParentRegion().getComposite() as org.yakindu.sct.model.sgraph.State) 
			if (!exit.isDefault()) {
				var boolean hasOutgoingTransition=false 
				var boolean equalsOutgoingTransition=false 
				var Iterator<Transition> transitionIt=state.outgoingTransitions.iterator() 
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					var Transition transition=transitionIt.next() 
					hasOutgoingTransition=STextValidationModelUtils.isDefaultExitTransition(transition) || STextValidationModelUtils.isNamedExitTransition(transition, exit.getName()) 
				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1) 
				}
				for (Transition transition : state.outgoingTransitions) {
					for (ReactionProperty property : transition.getProperties()) {
						if (property instanceof ExitPointSpec) {
							var String exitpoint=((property as ExitPointSpec)).getExitpoint() 
							if (exitpoint.equals(exit.getName())) {
								equalsOutgoingTransition=true 
							}
						}
					}
				}
				if (!equalsOutgoingTransition) {
					warning('''«EXIT_NEVER_USED»'«»«exit.getName()»'«»''', exit, null, -1) 
				}
			} else {
				var boolean hasOutgoingTransition=false 
				var Iterator<Transition> transitionIt=state.outgoingTransitions.iterator() 
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					hasOutgoingTransition=STextValidationModelUtils.isDefaultExitTransition(transitionIt.next()) 
				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1) 
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkTransitionPropertySpec(Transition transition) {
		for (ReactionProperty property : transition.getProperties()) {
			if (property instanceof EntryPointSpec) {
				if (transition.target instanceof org.yakindu.sct.model.sgraph.State) {
					var org.yakindu.sct.model.sgraph.State state=(transition.target as org.yakindu.sct.model.sgraph.State) 
					if (!state.isComposite()) {
						warning(TRANSITION_ENTRY_SPEC_NOT_COMPOSITE, transition, null, -1) 
					}
				}
			} else if (property instanceof ExitPointSpec) {
				val ExitPointSpec exitPointSpec=(property as ExitPointSpec) 
				if (transition.source instanceof org.yakindu.sct.model.sgraph.State) {
					var org.yakindu.sct.model.sgraph.State state=(transition.source as org.yakindu.sct.model.sgraph.State) 
					if (!state.isComposite()) {
						warning(TRANSITION_EXIT_SPEC_NOT_COMPOSITE, transition, null, -1) 
					} else {
						// Validate an exit point is continued on one transition
						// only.
						for (Transition t : state.outgoingTransitions) {
							if (transition !== t && STextValidationModelUtils.isNamedExitTransition(t, exitPointSpec.getExitpoint())) {
								warning(TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS, transition, null, -1) 
							}
						}
						// Validate the state has minimally one named exit
						// region
						var boolean hasExit=false 
						var Iterator<Region> regionIter=state.regions.iterator() 
						while (regionIter.hasNext() && !hasExit) {
							var Iterator<Exit> exitIter=STextValidationModelUtils.getExits(regionIter.next().eContents()).iterator() 
							while (exitIter.hasNext() && !hasExit) {
								var Exit exit=exitIter.next() 
								hasExit=exitPointSpec.getExitpoint().equals(exit.getName()) 
							}
						}
						if (!hasExit) {
							error(TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT, transition, null, -1) 
						}
					}
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkAnnotations(StatechartSpecification statechart) {
		var Annotation eventDriven=statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION) 
		var Annotation cycleBased=statechart.getAnnotationOfType(CYCLE_BASED_ANNOTATION) 
		if (eventDriven !== null && cycleBased !== null) {
			var String errorMsg=String.format(CONTRADICTORY_ANNOTATIONS, String.join(", ", eventDriven.getType().toString(), cycleBased.getType().toString())) 
			error(errorMsg, cycleBased, null, -1) 
		}
		var Annotation parentFirst=statechart.getAnnotationOfType(PARENT_FIRST_ANNOTATION) 
		var Annotation childFirst=statechart.getAnnotationOfType(CHILD_FIRST_ANNOTATION) 
		if (parentFirst !== null && childFirst !== null) {
			var String errorMsg=String.format(CONTRADICTORY_ANNOTATIONS, String.join(", ", parentFirst.getType().toString(), childFirst.getType().toString())) 
			error(errorMsg, parentFirst, null, -1) 
		}
	}
	@Check(CheckType.NORMAL)
	def void checkUnboundEntryPoints(org.yakindu.sct.model.sgraph.State state) {
		if (state.isComposite()) {
			val List<Transition>[] transitions=STextValidationModelUtils.getEntrySpecSortedTransitions(state.incomingTransitions) 
			var Map<Region, List<Entry>> regions=null 
			// first list contains Transitions without entry spec
			if (!transitions.get(0).isEmpty()) {
				regions=STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.regions) 
				if (!regions.isEmpty()) {
					for (Transition transition : transitions.get(0)) {
						error(TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT, transition, null, -1) 
					}
					for (Region region : regions.keySet()) {
						error(REGION_UNBOUND_DEFAULT_ENTRY_POINT, region, null, -1) 
					}
				}
			}
			// second list contains Transitions with entry spec
			if (!transitions.get(1).isEmpty()) {
				if (regions === null) {
					regions=STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.regions) 
				}
				for (Transition transition : transitions.get(1)) {
					var boolean hasTargetEntry=true 
					for (ReactionProperty property : transition.getProperties()) {
						if (property instanceof EntryPointSpec) {
							var EntryPointSpec spec=(property as EntryPointSpec) 
							var String specName=''''«»«spec.getEntrypoint()»'«»''' 
							for (Region region : regions.keySet()) {
								var boolean hasEntry=false 
								for (Entry entry : regions.get(region)) {
									if (entry.getName().equals(spec.getEntrypoint())) {
										hasEntry=true 
										//TODO cancel here
									}
								}
								if (!hasEntry) {
									error(REGION_UNBOUND_NAMED_ENTRY_POINT + specName, region, null, -1) 
									hasTargetEntry=false 
								}
							}
							if (!hasTargetEntry) {
								error(TRANSITION_UNBOUND_NAMED_ENTRY_POINT + specName, transition, null, -1) 
							}
							var boolean usingEntry=false 
							for (Region region : state.regions) {
								var EList<Vertex> vertices=region.vertices 
								for (Vertex vertice : vertices) {
									if (vertice instanceof Entry) {
										if (spec.getEntrypoint().equals(vertice.getName())) {
											usingEntry=true 
										}
									}
								}
							}
							if (!usingEntry) {
								warning(ENTRY_NOT_EXIST + specName, transition, null, -1) 
							}
						}
					}
				}
			}
		}
	}
	@Check(CheckType.NORMAL)
	def void checkTopLeveEntryIsDefaultEntry(Entry entry) {
		var Region parentRegion=entry.getParentRegion() 
		// 1. check if is toplevel
		if (isTopLevelRegion(parentRegion)) {
			// 2. check if is default entry
			if (!entry.isDefault()) {
				var Map<Region, List<Entry>> regionsWithoutDefaultEntry=STextValidationModelUtils.getRegionsWithoutDefaultEntry(Lists.newArrayList(parentRegion)) 
				var List<Entry> list=regionsWithoutDefaultEntry.get(parentRegion) 
				if (list !== null) error(TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY, entry, SGraphPackage.Literals.ENTRY__KIND, -1)  else warning(TOP_LEVEL_REGION_ENTRY_HAVE_TO_BE_A_DEFAULT_ENTRY, entry, SGraphPackage.Literals.ENTRY__KIND, -1) 
			}
		}
	}
	def protected boolean isTopLevelRegion(Region region) {
		return region.eContainer() instanceof Statechart 
	}
	@Check(CheckType.NORMAL)
	def void checkTopLevelRegionHasEntry(Region region) {
		if (isTopLevelRegion(region)) {
			if (!STextValidationModelUtils.getRegionsWithoutDefaultEntry(Collections.singletonList(region)).isEmpty()) {
				error(REGION_UNBOUND_DEFAULT_ENTRY_POINT, region, null, -1) 
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkAssignmentExpression(AssignmentExpression exp) {
		val String name=getVariableName(exp) 
		var List<AssignmentExpression> contents=EcoreUtil2.eAllOfType(exp, AssignmentExpression) 
		contents.remove(exp) 
		var Iterable<AssignmentExpression> filter=Iterables.filter(contents, [AssignmentExpression ex|var String variableName=getVariableName(ex) return variableName.equals(name) ]) 
		if (Iterables.size(filter) > 0) {
			error(ASSIGNMENT_EXPRESSION, null) 
		}
	}
	@Check(CheckType.FAST)
	def void checkFeatureCall(FeatureCall call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getFeature() instanceof Scope) {
			error("A variable, event or operation is required.", ExpressionsPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE) 
		}
	}
	@Check(CheckType.FAST)
	def void checkFeatureCall(ElementReferenceExpression call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getReference() instanceof Scope) {
			error("A variable, event or operation is required.", ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE) 
		}
	}
	@Check(CheckType.FAST)
	def void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {
			if (!(reactionTrigger.eContainer() instanceof LocalReaction) && (eventSpec instanceof EntryEvent || eventSpec instanceof ExitEvent)) {
				error("Entry and exit events are allowed as local reactions only.", StextPackage.Literals.REACTION_TRIGGER__TRIGGERS, INSIGNIFICANT_INDEX, ENTRY_EXIT_TRIGGER_NOT_ALLOWED) 
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkReactionTriggerRegularEvent(ReactionTrigger reactionTrigger) {
		for (var int i=0; i < reactionTrigger.getTriggers().size(); i++) {
			var EventSpec eventSpec=reactionTrigger.getTriggers().get(i) 
			if (eventSpec instanceof RegularEventSpec) {
				var EObject element=unwrap(((eventSpec as RegularEventSpec)).getEvent()) 
				if (element !== null && (!(element instanceof Event))) {
					var String elementName="" 
					if (element instanceof NamedElement) {
						elementName=''''«»«((element as NamedElement)).getName()»' ''' 
					}
					error('''Trigger «elementName»is no event.''', StextPackage.Literals.REACTION_TRIGGER__TRIGGERS, i, TRIGGER_IS_NO_EVENT) 
				}
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkRaisingExpressionEvent(EventRaisingExpression expression) {
		var EObject element=unwrap(expression.getEvent()) 
		if (element !== null && (!(element instanceof Event))) {
			var String elementName="" 
			if (element instanceof NamedElement) {
				elementName=((element as NamedElement)).getName() 
			}
			error(String.format("'%s' is not an event.", elementName), StextPackage.Literals.EVENT_RAISING_EXPRESSION__EVENT, -1) 
		}
	}
	def protected EObject unwrap(Expression eventExpression) {
		var EObject element=null 
		if (eventExpression instanceof ElementReferenceExpression) {
			element=((eventExpression as ElementReferenceExpression)).getReference() 
		} else if (eventExpression instanceof FeatureCall) {
			element=((eventExpression as FeatureCall)).getFeature() 
		}
		return element 
	}
	@Check(CheckType.FAST)
	def void checkSyncNoTriggersOnOutgoingTransition(Synchronization synchronization) {
		var List<Transition> outgoing=synchronization.outgoingTransitions 
		for (Transition transition : outgoing) {
			if (transition.trigger !== null) {
				warning(SYNC_OUTGOING_TRIGGER, transition, null) 
			}
		}
	}
	/** 
	 * Only Expressions that produce an effect should be used as actions.
	 * @param effect
	 */
	@Check(CheckType.FAST)
	def void checkReactionEffectActions(ReactionEffect effect) {
		for (Expression exp : effect.getActions()) {
			if (!(exp instanceof AssignmentExpression) && !(exp instanceof EventRaisingExpression) && !(exp instanceof PostFixUnaryExpression)) {
				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((exp as FeatureCall)) 
				} else if (exp instanceof ElementReferenceExpression) {
					checkElementReferenceEffect((exp as ElementReferenceExpression)) 
				} else {
					error("Action has no effect.", StextPackage.Literals.REACTION_EFFECT__ACTIONS, effect.getActions().indexOf(exp), FEATURE_CALL_HAS_NO_EFFECT) 
				}
			}
		}
	}
	def protected void checkFeatureCallEffect(FeatureCall call) {
		if (call.getFeature() !== null && call.getFeature() instanceof Declaration && !(call.getFeature() instanceof Operation)) {
			if (call.getFeature() instanceof Property) {
				error('''Access to property '«»«nameProvider.getFullyQualifiedName(call.getFeature())»' has no effect.''', call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			} else if (call.getFeature() instanceof Event) {
				error('''Access to event '«»«nameProvider.getFullyQualifiedName(call.getFeature())»' has no effect.''', call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			} else {
				error('''Access to feature '«»«nameProvider.getFullyQualifiedName(call.getFeature())»' has no effect.''', call, ExpressionsPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			}
		}
	}
	def protected String getVariableName(AssignmentExpression exp) {
		var Expression varRef=exp.getVarRef() 
		if (varRef instanceof ElementReferenceExpression && ((varRef as ElementReferenceExpression)).getReference() instanceof Property) {
			var Property reference=(((varRef as ElementReferenceExpression)).getReference() as Property) 
			return reference.getName() 
		} else if (varRef instanceof FeatureCall && ((varRef as FeatureCall)).getFeature() instanceof Property) {
			var Property reference=(((varRef as FeatureCall)).getFeature() as Property) 
			return reference.getName() 
		}
		return null 
	}
	@Check(CheckType.FAST)
	def void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope && event.getDirection() === Direction.LOCAL) {
			error(LOCAL_DECLARATIONS, TypesPackage.Literals.EVENT__DIRECTION) 
		}
		if (event.eContainer() instanceof InternalScope && event.getDirection() !== Direction.LOCAL) {
			error(IN_OUT_DECLARATIONS, TypesPackage.Literals.EVENT__DIRECTION) 
		}
	}
	@Check(CheckType.FAST)
	def void checkExitPointSpecWithTrigger(Transition t) {
		if (!STextValidationModelUtils.getExitPointSpecs(t.getProperties()).isEmpty() && t.trigger !== null && t.source instanceof org.yakindu.sct.model.sgraph.State) {
			error(EXITPOINTSPEC_WITH_TRIGGER, t, null, -1) 
		}
	}
	@Check(CheckType.FAST)
	def void checkInterfaceScope(ScopedElement statechart) {
		var List<InterfaceScope> defaultInterfaces=new LinkedList() 
		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope && ((scope as InterfaceScope)).getName() === null) {
				defaultInterfaces.add((scope as InterfaceScope)) 
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error(ONLY_ONE_INTERFACE, scope, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1(), ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ONLY_ONE_INTERFACE) 
			}
		}
	}
	@Check(CheckType.FAST)
	def void checkChoiceWithoutDefaultTransition(Choice choice) {
		var boolean found=false 
		for (Transition transition : choice.outgoingTransitions) {
			var Trigger trigger=transition.trigger 
			if (isDefault(trigger)) {
				found=true 
			}
		}
		if (!found) warning(CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS) 
	}
	@Check 
	def void checkDuplicateImport(ImportScope importScope) {
		var allScopes = EcoreUtil2.getContainerOfType(importScope, ScopedElement).getScopes().filter(ImportScope)
		for (String importToCheck : importScope.getImports()) {
			var Set<String> allImports=Sets.newHashSet() 
			for (scope : allScopes) {
				for (anImport : scope.getImports()) {
					if (anImport.equals(importToCheck) && !allImports.add(anImport)) {
						warning(String.format(DUPLICATE_IMPORT, importToCheck), importScope, StextPackage.Literals.IMPORT_SCOPE__IMPORTS, importScope.getImports().indexOf(importToCheck)) 
					}
				}
			}
		}
	}
	@Check 
	def void checkImportsValid(ImportScope scope) {
		var EList<String> imports=scope.getImports() 
		for (String packageImport : imports) {
			var Optional<PackageImport> pkImport=mapper.findPackageImport(scope.eResource(), packageImport) 
			if (!pkImport.isPresent() || !getResource(scope).getResourceSet().getURIConverter().exists(pkImport.get().getUri().trimQuery(), null)) {
				error(String.format(IMPORT_NOT_RESOLVED_MSG, packageImport), scope, StextPackage.Literals.IMPORT_SCOPE__IMPORTS, imports.indexOf(packageImport)) 
			}
			else {
				val iResourceDescription = resourceDescriptionCache.get(pkImport.get().getUri())
				if (iResourceDescription instanceof DefaultResourceDescription) {
					val resource = iResourceDescription.getResource()
					if (!resource.getErrors().isEmpty()) {
						val sb = new StringBuilder()
						sb.append("The resource contains errors.\n")
						for (Diagnostic e : resource.getErrors()) {
							sb.append("\nError: ").append(e.getMessage());
						}
						error(sb.toString(), scope, StextPackage.Literals.IMPORT_SCOPE__IMPORTS,
								imports.indexOf(packageImport))
					}
					if (!resource.getWarnings().isEmpty()) {
						val sb = new StringBuilder()
						sb.append("The resource contains warnings.\n")
						for (Diagnostic e : resource.getWarnings()) {
							sb.append("\nWarning: ").append(e.getMessage());
						}
						warning(sb.toString(), scope, StextPackage.Literals.IMPORT_SCOPE__IMPORTS,
								imports.indexOf(packageImport))
					}
				}
			}
		}
	}
	
	@Check(CheckType.FAST)
	def void checkOnlyOneEntryPointSpecIsUsed(Transition transition) {
		if(transition.properties.filter(EntryPointSpec).size > 1){
				warning(ONLY_FIRST_ENTRY_POINT_WILL_BE_USED, transition, null, -1) 
		}
	}
	
	def protected void checkElementReferenceEffect(ElementReferenceExpression refExp) {
		if (!(refExp.getReference() instanceof Operation)) {
			if (refExp.getReference() instanceof Property) {
				error('''Access to property '«»«nameProvider.getFullyQualifiedName(refExp.getReference())»' has no effect.''', refExp, ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			} else if (refExp.getReference() instanceof Event) {
				error('''Access to event '«»«nameProvider.getFullyQualifiedName(refExp.getReference())»' has no effect.''', refExp, ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			} else {
				error('''Access to feature '«»«nameProvider.getFullyQualifiedName(refExp.getReference())»' has no effect.''', refExp, ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT) 
			}
		}
	}
	def protected boolean isDefault(Trigger trigger) {
		return trigger === null || trigger instanceof DefaultTrigger || ((trigger instanceof ReactionTrigger) && ((trigger as ReactionTrigger)).getTriggers().size() === 0 && ((trigger as ReactionTrigger)).guard === null) 
	}
	override protected String getCurrentLanguage(Map<Object, Object> context, EObject eObject) {
		var Resource eResource=eObject.eResource() 
		if (eResource instanceof XtextResource) {
			return super.getCurrentLanguage(context, eObject) 
		} else if (eResource instanceof AbstractSCTResource) {
			return ((eResource as AbstractSCTResource)).getLanguageName() 
		}
		return "" 
	}
	def protected void error(String message, EObject source, Keyword keyword, int index, String code) {
		val String[] issueData=null 
		var ICompositeNode rootNode=NodeModelUtils.findActualNodeFor(source) 
		if (rootNode !== null) {
			var INode child=findNode(source, false, rootNode, keyword, #[index]) 
			if (child !== null) {
				var int offset=child.getTotalOffset() 
				var int length=child.getTotalLength() 
				getMessageAcceptor().acceptError(message, source, offset, length, code, issueData) 
				return;
			}
		}
		error(message, source, (null as EStructuralFeature), ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code) 
	}
	def protected INode findNode(EObject source, boolean sourceFound_finalParam_, INode root, Keyword keyword, int[] index) {
		var  sourceFound=sourceFound_finalParam_ 
		if (sourceFound && root.getSemanticElement() !== source) {
			return null 
		}
		if (root.getSemanticElement() === source) {
			sourceFound=true 
		}
		var EObject grammarElement=root.getGrammarElement() 
		// .equals or == does not work because sub grammars use their own
		// Modules with custom
		// grammarAccess instance and .equals is not overwritten.
		if (grammarElement instanceof Keyword && keyword.getValue().equals(((grammarElement as Keyword)).getValue())) {
			if (index.get(0) !== INSIGNIFICANT_INDEX) {
				{ var _postIndx_index=0 var  _postVal_index={val _rdIndx_index=_postIndx_index index.get(_rdIndx_index)}{ val _wrVal_index=index val _wrIndx_index=_postIndx_index _wrVal_index.set(_wrIndx_index,_postVal_index - 1)} } 
			}
			if (index.get(0) === 0 || index.get(0) === INSIGNIFICANT_INDEX) {
				return root 
			}
		}
		if (root instanceof ICompositeNode) {
			var ICompositeNode node=(root as ICompositeNode) 
			for (INode child : node.getChildren()) {
				var INode result=findNode(source, sourceFound, child, keyword, index) 
				if (result !== null) {
					return result 
				}
			}
		}
		return null 
	}
	override protected List<EPackage> getEPackages() {
		var List<EPackage> result=super.getEPackages() 
		result.add(ExpressionsPackage.eINSTANCE) 
		return result 
	}
	def protected Resource getResource(EObject context) {
		val ContextElementAdapter provider=(EcoreUtil.getExistingAdapter(context.eResource(), ContextElementAdapter) as ContextElementAdapter) 
		if (provider === null) {
			return context.eResource() 
		} else {
			return provider.getElement().eResource() 
		}
	}
	override protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		var boolean isResponsible=super.isResponsible(context, eObject) 
		if (!isResponsible) return false 
		var Statechart statechart=utils.getStatechart(eObject) 
		if ((statechart !== null) && !domainID.equals(statechart.getDomainID())) {
			return false 
		}
		return true 
	}
}
