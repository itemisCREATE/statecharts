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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * 
 */
public class STextJavaValidator extends AbstractSTextJavaValidator {

	@Inject
	private StaticTypeAnalyzer analyzer;

	@Check
	public void checkExpression(final Statement statement) {
		try {
			analyzer.check(statement);
		} catch (TypeCheckException e) {
			error(e.getMessage(), null);
		} catch (IllegalArgumentException e) {
			// This happens, when the expression is not completed for Unhandled
			// parameter types: [null]
			// We can safely ignore this exception
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {

			// Allow only entries, exit, oncycle and always as event for local
			// reactions.
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent
							|| eventSpec instanceof ExitEvent
							|| eventSpec instanceof OnCycleEvent || eventSpec instanceof AlwaysEvent)) {

				error("entry, exit, oncycle and always events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
			}

			// Context StatechartDefiniton
			if (isStatechartDefinitionChild(reactionTrigger)) {
				if (eventSpec instanceof EntryEvent) {
					error("Entry events are not allowed in statechart definition.",
							StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
				} else if (eventSpec instanceof ExitEvent) {
					error("Exit events are not allowed in statechart definition.",
							StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkVariable(VariableDefinition variable) {
		if (variable.eContainer() instanceof SimpleScope) {
			error("Variables can not be defined in states.", variable,
					SGraphPackage.Literals.NAMED_ELEMENT__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope
				&& event.getDirection() == Direction.LOCAL) {
			error("Local declarations are not allowed in interface scope.",
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope
				&& event.getDirection() != Direction.LOCAL) {
			error("In/Out declarations are not allowed in internal scope.",
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
	}

	@Check(CheckType.FAST)
	public void checkOperation(Operation operation) {
		if (operation.eContainer() instanceof SimpleScope) {
			error("Operations can not be defined in states.", operation,
					StextPackage.Literals.OPERATION__PARAM_TYPES,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkLocalReaction(LocalReaction localReaction) {
		if (localReaction.eContainer() instanceof InterfaceScope) {
			error("Local reactions are not allowed in interface scope.",
					localReaction,
					StextPackage.Literals.LOCAL_REACTION__PROPERTIES,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkInterfaceScope(Statechart statechart) {
		List<InterfaceScope> defaultInterfaces = new LinkedList<InterfaceScope>();

		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope
					&& ((InterfaceScope) scope).getName() == null) {
				defaultInterfaces.add((InterfaceScope) scope);
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error("It can only exist one default/unamed interface", scope,
						StextPackage.Literals.INTERFACE_SCOPE__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
			}
		}
	}

	private boolean isStatechartDefinitionChild(EObject element) {
		while (element.eContainer() != null) {
			if (element.eContainer() instanceof StatechartSpecification) {
				return true;
			}
			element = element.eContainer();
		}
		return false;
	}

	@Override
	protected String getCurrentLanguage(Map<Object, Object> context,
			EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof InjectMembersResource)
			return ((InjectMembersResource) resource).getLanguageName();
		return super.getCurrentLanguage(context, eObject);
	}
}
