/**
 *   Copyright (c) 2018 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *
 *   Contributors:
 * 		@author René Beckmann (beckmann@itemis.de)
 */
package org.yakindu.sct.model.stext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.sct.model.sgraph.SGraphPackage;

public class StateNamesAreUniqueValidationHelper extends STextNamesAreUniqueValidationHelper {
	public static final String STATE_NAME_NOT_UNIQUE = "This state's name is not unique.";

	protected void createDuplicateStateNameError(IEObjectDescription description, ValidationMessageAcceptor acceptor) {
		String msg = STATE_NAME_NOT_UNIQUE;
		EObject object = description.getEObjectOrProxy();
		EStructuralFeature feature = getNameFeature(object);

		acceptor.acceptError(msg, object, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, getErrorCode());

	}

	@Override
	protected void validateEqualSimpleName(IEObjectDescription description, IEObjectDescription doublet,
			ValidationMessageAcceptor acceptor) {
		if (inSameResource(doublet, description)
				&& description.getEClass() == SGraphPackage.Literals.STATE
				&& doublet.getEClass() == SGraphPackage.Literals.STATE
				&& shouldValidate(description)) {
			createDuplicateStateNameError(description, acceptor);
			createDuplicateStateNameError(doublet, acceptor);
		}
	}

	protected boolean shouldValidate(IEObjectDescription desc) {
		return true;
	}

}
