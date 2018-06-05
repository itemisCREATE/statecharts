/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Transition;

/**
 * 
 * All validation contraints for the meta model elements {@link Entry}
 *
 */
public class EntryValidator extends AbstractSGraphValidator {



	
	
	private static final String ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_MSG  = "Initial entry should have no incoming transition.";
	public static final String  ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_CODE = "entry.transitions.NoInIfInitial";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoInIfInitial(Entry entry) {
		if (entry.getIncomingTransitions().size() > 0 && entry.getKind().equals(EntryKind.INITIAL)) {
			warning(ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_CODE);
		}
	}


	private static final String ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_MSG  = "Initial entry must have an outgoing transition.";
	public static final String  ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_CODE = "entry.transitions.RequireOutIfInitial";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsRequireOneOutIfInitial(Entry entry) {
		if (entry.getKind().equals(EntryKind.INITIAL) && entry.getOutgoingTransitions().size() == 0 ) {
			error(ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_MSG, entry, null, -1, ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_CODE);
		}
	}

		
	private static final String ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_MSG  = "Entries must not have more than one outgoing transition.";
	public static final String  ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_CODE = "entry.transitions.NoMultipleOut";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoMultipleOut(Entry entry) {
		if (entry.getOutgoingTransitions().size() > 1) {
			error(ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_CODE);
		}
	}

	
	private static final String ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_MSG = "The outgoing transitions of an entry must not have a trigger or guard.";
	public static final String ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_CODE = "entry.transitions.NoTriggerOnOut";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoTriggerOnOut(Entry entry) {
		for (Transition transition : entry.getOutgoingTransitions()) {
			if (transition.getTrigger() != null) {
				error(ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_CODE);
			}
		}
	}


}
