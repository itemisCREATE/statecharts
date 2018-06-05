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
import org.yakindu.sct.model.sgraph.Choice;

/**
 * 
 * All validation constraints for the meta model element {@link Choice}
 * 
 */
public class ChoiceValidator extends AbstractSGraphValidator {

	private static final String CHOICE_TRANSITIONS_REQUIRE_N_OUT_MSG = "A choice must have at least one outgoing transition.";
	public static final String CHOICE_TRANSITIONS_REQUIRE_N_OUT_CODE = "choice.transitions.RequireNOut";

	
	@Check(CheckType.FAST)
	public void checkChoiceTransitionsRequireNOut(Choice choice) {
		if (choice.getOutgoingTransitions().size() == 0) {
			error(CHOICE_TRANSITIONS_REQUIRE_N_OUT_MSG, choice, null, -1, CHOICE_TRANSITIONS_REQUIRE_N_OUT_CODE);
		}
	}

}
