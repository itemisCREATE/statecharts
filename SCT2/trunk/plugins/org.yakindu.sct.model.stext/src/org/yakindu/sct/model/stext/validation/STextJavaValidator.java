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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartDefinition;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * 
 */
public class STextJavaValidator extends AbstractSTextJavaValidator {

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
			// Context Transitions
			// if (reactionTrigger.eContainer() instanceof TransitionReaction) {
			// if (eventSpec instanceof RegularEventSpec) {
			// error("Regular event specs are not allowed for transitions.",
			// StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
			// }
			// }

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
	public void checkSimpleScope(SimpleScope simpleScope) {
		// Context State
		if (simpleScope.getVariables().size() > 0) {
			error("Variables can not be defined in states.",
					SGraphPackage.Literals.SCOPE__VARIABLES);
		}
	}

	@Check(CheckType.FAST)
	public void checkInterfaceScope(InterfaceScope interfaceScope) {
		for (Declaration declaration : interfaceScope.getDeclarations()) {
			if (declaration instanceof LocalReaction) {
				error("Local reactions are not allowed in interface scope.",
						SGraphPackage.Literals.SCOPE__DECLARATIONS);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkInternalScope(InternalScope internalScope) {
		for (Event event : internalScope.getEvents()) {
			if (event instanceof EventDefinition) {
				error("In/Out declarations are not allowed in internal scope.",
						SGraphPackage.Literals.SCOPE__EVENTS);
			}
		}
	}

	private boolean isStatechartDefinitionChild(EObject element) {
		while (element.eContainer() != null) {
			if (element.eContainer() instanceof StatechartDefinition) {
				return true;
			}
			element = element.eContainer();
		}
		return false;
	}
}
