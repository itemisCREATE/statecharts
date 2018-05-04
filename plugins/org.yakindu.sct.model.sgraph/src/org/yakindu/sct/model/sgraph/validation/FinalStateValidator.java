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
import org.yakindu.sct.model.sgraph.FinalState;

/**
 * 
 * All validation contraints for the meta model element {@link FinalState}
 * 
 */
public class FinalStateValidator extends AbstractSGraphValidator {

	private static final String FINAL_STATE_NO_OUT_TRANSITION_MSG = "A final state must not have outgoing transitions.";
	public static final String FINAL_STATE_NO_OUT_TRANSITION_CODE = "finalstate.NoOutTransitions";

	@Check(CheckType.FAST)
	public void checkNoOutTransitions(FinalState finalState) {
		if ((finalState.getOutgoingTransitions().size() > 0)) {
			warning(FINAL_STATE_NO_OUT_TRANSITION_MSG, finalState, null, -1, FINAL_STATE_NO_OUT_TRANSITION_CODE);
		}
	}

}
