package org.yakindu.sct.model.stext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.sct.model.sgraph.SGraphPackage;

public abstract class StateNamesAreUniqueValidationHelper extends STextNamesAreUniqueValidationHelper {
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

	protected abstract boolean shouldValidate(IEObjectDescription desc);

}
