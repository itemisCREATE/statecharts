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

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.FinalState;

/**
 * 
 * All validation contraints for the meta model element {@link State}
 * 
 */
public class StateValidator extends AbstractSGraphValidator {

	private static final String ISSUE_STATE_NAME_MSG = "A state must have a name.";
	public static final String ISSUE_STATE_NAME_CODE = "state.name";

	@Check(CheckType.FAST)
	public void nameIsNotEmpty(org.yakindu.sct.model.sgraph.State state) {
		if ((state.getName() == null || state.getName().trim().length() == 0) && !(state instanceof FinalState)) {
			error(ISSUE_STATE_NAME_MSG, state, null, -1, ISSUE_STATE_NAME_CODE,
					BasePackage.Literals.NAMED_ELEMENT__NAME.getName());
		}
	}
	
	@Override
	protected List<EPackage> getEPackages() {
		// TODO Auto-generated method stub
		return super.getEPackages();
	}
	
}
