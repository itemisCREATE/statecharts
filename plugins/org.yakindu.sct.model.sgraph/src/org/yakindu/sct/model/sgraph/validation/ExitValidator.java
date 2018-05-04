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


	private static final String EXIT_AT_LEAST_ONE_IN_TRANSITION_MSG = "Exit node should have at least one incoming transition.";
	public static final String EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE = "exit.in.transition";

	private static final String EXIT_NO_OUTGOING_TRANSITION_MSG = "Exit node should have no outgoing transition.";
	public static final String EXIT_NO_OUTGOING_TRANSITION_CODE = "exit.out.transition";

	private static final String EXIT_NO_TOPLEVEL_REGION_MSG = "Exit node in top level region not supported - use final states instead.";
	public static final String EXIT_NO_TOPLEVEL_REGION_CODE = "exit.not.toplevel";

	
	
	@Check(CheckType.FAST)
	public void exitWithoutIncomingTransition(Exit exit) {
		if (exit.getIncomingTransitions().size() == 0) {
			warning(EXIT_AT_LEAST_ONE_IN_TRANSITION_MSG, exit, null, -1, EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void exitWithOutgoingTransition(Exit exit) {
		if (exit.getOutgoingTransitions().size() > 0) {
			error(EXIT_NO_OUTGOING_TRANSITION_MSG, exit, null, -1, EXIT_NO_OUTGOING_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void exitOnStatechart(Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof Statechart) {
			error(EXIT_NO_TOPLEVEL_REGION_MSG, exit, null, -1, EXIT_NO_TOPLEVEL_REGION_CODE);
		}
	}

}
