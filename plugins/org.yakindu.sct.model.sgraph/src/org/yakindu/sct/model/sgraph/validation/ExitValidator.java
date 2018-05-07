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
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * All validation contraints for the meta model elements {@link Exit}
 *
 */
public class ExitValidator extends AbstractSGraphValidator {
	
	
	private static final String EXIT_TRANSITIONS_MUST_HAVE_N_IN_MSG  = "Exit node should have at least one incoming transition.";
	public static final String  EXIT_TRANSITIONS_MUST_HAVE_N_IN_CODE = "exit.transitions.MustHaveNIn";
	
	/**
	 * TODO: severity error?
	 * @param exit
	 */
	@Check(CheckType.FAST)
	public void checkExitTransitionsMustHaveNIn(Exit exit) {
		if (exit.getIncomingTransitions().size() == 0) {
			warning(EXIT_TRANSITIONS_MUST_HAVE_N_IN_MSG, exit, null, -1, EXIT_TRANSITIONS_MUST_HAVE_N_IN_CODE);
		}
	}

	
	
	private static final String EXIT_TRANSITIONS_NO_OUT_MSG  = "Exit node must not have outgoing transitions.";
	public static final String  EXIT_TRANSITIONS_NO_OUT_CODE = "exit.transitions.NoOut";

	@Check(CheckType.FAST)
	public void checkExtitTransitionsNoOut(Exit exit) {
		if (exit.getOutgoingTransitions().size() > 0) {
			error(EXIT_TRANSITIONS_NO_OUT_MSG, exit, null, -1, EXIT_TRANSITIONS_NO_OUT_CODE);
		}
	}

	

}
