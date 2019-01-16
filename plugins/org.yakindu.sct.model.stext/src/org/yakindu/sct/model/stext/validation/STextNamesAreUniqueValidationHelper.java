/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.model.stext.validation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.sct.commons.EMFHelper;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * @author rbeckmann
 *
 */
public class STextNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper
implements INamesAreUniqueValidationHelper {

	protected OperationCanceledManager operationCanceledManager = new OperationCanceledManager();

	protected Map<QualifiedName, IEObjectDescription> nameMap;
	protected Map<QualifiedName, IEObjectDescription> caseInsensitiveMap;
	protected Map<String, IEObjectDescription> lastElementMap;

	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, ValidationMessageAcceptor acceptor) {
		checkUniqueNames(descriptions, null, acceptor);
	}

	/**
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * The cancel indicator will be queried everytime a description has been
	 * processed. It should provide a fast answer about its canceled state.
	 */
	@Override
	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator,
			ValidationMessageAcceptor acceptor) {
		Iterator<IEObjectDescription> iter = descriptions.iterator();
		this.nameMap = new HashMap<>();
		this.caseInsensitiveMap = new HashMap<>();
		this.lastElementMap = new HashMap<>();
		if (!iter.hasNext())
			return;
		while (iter.hasNext()) {
			IEObjectDescription description = iter.next();
			checkDescriptionForDuplicatedName(description, acceptor);
			operationCanceledManager.checkCanceled(cancelIndicator);
		}
	}

	protected void checkDescriptionForDuplicatedName(IEObjectDescription description,
			ValidationMessageAcceptor acceptor) {
		if (!shouldValidateEClass(description.getEClass())) {
			return;
		}
		QualifiedName qName = description.getName();
		// check for exactly equal names
		IEObjectDescription existing = nameMap.put(qName, description);
		// check for names that only differ in case, like 'x' and 'X'
		IEObjectDescription existingLowerCase = caseInsensitiveMap.put(qName.toLowerCase(), description);
		// check for names where the qualifier is different but the name is the
		// same, like 'region1.StateA' and 'region2.StateA'.
		IEObjectDescription existingLastElement = lastElementMap.put(qName.getLastSegment(), description);
		if (existing != null) {
			validateEqualName(description, existing, acceptor);
		} else if (existingLowerCase != null) {
			validateCapitonym(description, existingLowerCase, acceptor);
		}
		if (existingLastElement != null) {
			duplicateLastElement(description, existingLastElement, acceptor);
		}
	}

	protected void validateEqualName(IEObjectDescription description, IEObjectDescription doublet,
			ValidationMessageAcceptor acceptor) {
		EClass common = checkForCommonSuperClass(doublet, description);
		if (inSameResource(doublet, description) && common != null) {
			createDuplicateNameError(description, common, acceptor);
			createDuplicateNameError(doublet, common, acceptor);
		}
	}
	

	protected void validateCapitonym(IEObjectDescription description, IEObjectDescription doublet,
			ValidationMessageAcceptor acceptor) {
		if (inSameResource(doublet, description) && doublet.getEClass().equals(description.getEClass())) {
			createDuplicateNameWarning(description, description.getEClass(), acceptor);
			createDuplicateNameWarning(doublet, description.getEClass(), acceptor);
		}
	}

	protected void duplicateLastElement(IEObjectDescription description, IEObjectDescription put,
			ValidationMessageAcceptor acceptor) {
	}

	protected boolean shouldValidateEClass(EClass eC) {
		return !eC.isSuperTypeOf(SGraphPackage.Literals.STATECHART);
	}

	protected boolean inSameResource(IEObjectDescription one, IEObjectDescription two) {
		return one.getEObjectOrProxy().eResource().equals(two.getEObjectOrProxy().eResource());
	}

	protected void createDuplicateNameWarning(IEObjectDescription description, EClass eClass,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		EStructuralFeature feature = getNameFeature(object);
		acceptor.acceptWarning(getDuplicateNameWarningMessage(description, eClass, feature), object, feature,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, getErrorCode());
	}

	protected String getDuplicateNameWarningMessage(IEObjectDescription description, EClass eClass,
			EStructuralFeature feature) {
		return getDuplicateNameErrorMessage(description, eClass, feature)
				+ ". Names differ only in case, which can lead to compilation problems.";
	}
	
	
	@Override
	protected void createDuplicateNameError(IEObjectDescription description, EClass clusterType,
			ValidationMessageAcceptor acceptor) {
		EObject object = description.getEObjectOrProxy();
		EStructuralFeature feature = getNameFeature(object);
		String errorMsg = getDuplicateNameErrorMessage(description, clusterType, feature);

		if (errorMsg.contains("''")) {
			errorMsg = errorMsg.replace("Duplicate Entry ''", "Duplicate unnamed Entry");
		}
		acceptor.acceptError(errorMsg, object, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, getErrorCode());
	}

	protected EClass checkForCommonSuperClass(IEObjectDescription one, IEObjectDescription two) {
		List<EClass> flatOne = EMFHelper.getAllSuperClasses(one.getEClass());
		List<EClass> flatTwo = EMFHelper.getAllSuperClasses(two.getEClass());

		for (EClass eC : flatOne) {
			if (flatTwo.contains(eC))
				return eC;
		}
		return null;
	}
}
