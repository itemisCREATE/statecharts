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
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * All validation contraints for the meta model element {@link Statechart}
 * 
 */
public class StatechartValidator extends AbstractSGraphValidator {

	private static final String STATECHART_NAME_MUST_BE_IDENTIFIER_MSG = "%s is not a valid identifier!";
	public static final String STATECHART_NAME_MUST_BE_IDENTIFIER_CODE = "statechart.name.MustBeIdentifier";

	@Check
	public void checkStatechartNameMustBeIdentifier(Statechart statechart) {
		if (!isValidJavaIdentifier(statechart.getName())) {
			error(String.format(STATECHART_NAME_MUST_BE_IDENTIFIER_MSG, statechart.getName()), statechart,
					BasePackage.Literals.NAMED_ELEMENT__NAME, -1, STATECHART_NAME_MUST_BE_IDENTIFIER_CODE);

		}
	}

	protected boolean isValidJavaIdentifier(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		char[] c = s.toCharArray();
		if (!Character.isJavaIdentifierStart(c[0])) {
			return false;
		}
		for (int i = 1; i < c.length; i++) {
			if (!Character.isJavaIdentifierPart(c[i])) {
				return false;
			}
		}
		return true;
	}

}
