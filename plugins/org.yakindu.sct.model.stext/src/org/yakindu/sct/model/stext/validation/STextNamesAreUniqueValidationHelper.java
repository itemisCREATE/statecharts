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

import java.util.ArrayList;
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

/**
 * @author rbeckmann
 *
 */
public class STextNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper
		implements
			INamesAreUniqueValidationHelper {
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
		QualifiedName qName = description.getName();
		IEObjectDescription existing = nameMap.put(qName, description);
		IEObjectDescription existingLowerCase = caseInsensitiveMap.put(qName.toLowerCase(), description);
    IEObjectDescription existingLastElement = lastElementMap.put(qName.getLastSegment(), description);
		if (existing != null) {
			EClass common = checkForCommonSuperClass(existing, description);
			if (inSameResource(existing, description) && common != null) {
				createDuplicateNameError(description, common, acceptor);
				createDuplicateNameError(existing, common, acceptor);
			}
		} else if (existingLowerCase != null) {
			if (inSameResource(existingLowerCase, description)
					&& existingLowerCase.getEClass().equals(description.getEClass())) {
				createDuplicateNameWarning(description, description.getEClass(), acceptor);
				createDuplicateNameWarning(existingLowerCase, description.getEClass(), acceptor);
			}
		}
		if (existingLastElement != null) {
			duplicateLastElement(description, existingLastElement, acceptor);
		}
	}

	protected void duplicateLastElement(IEObjectDescription description, IEObjectDescription lastElementPut,
			ValidationMessageAcceptor acceptor) {
	}

	protected void duplicateCaseInsensitiveFQN(IEObjectDescription description, IEObjectDescription lowerCasePut,
			ValidationMessageAcceptor acceptor) {
		createDuplicateNameWarning(description, description.getEClass(), acceptor);
		createDuplicateNameWarning(lowerCasePut, description.getEClass(), acceptor);
	}

	protected void duplicateFQN(IEObjectDescription description, IEObjectDescription old, EClass common,
			ValidationMessageAcceptor acceptor) {
		createDuplicateNameError(description, common, acceptor);
		createDuplicateNameError(old, common, acceptor);
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

	protected EClass checkForCommonSuperClass(IEObjectDescription one, IEObjectDescription two) {
		List<EClass> flatOne = buildSuperClassList(one.getEClass());
		List<EClass> flatTwo = buildSuperClassList(two.getEClass());

		for (EClass eC : flatOne) {
			if (flatTwo.contains(eC))
				return eC;
		}

		return null;
	}

	protected List<EClass> buildSuperClassList(EClass eClass) {
		List<List<EClass>> superClasses = new ArrayList<>();

		buildSuperClassList(superClasses, eClass, 0);

		List<EClass> result = new ArrayList<>();
		for (List<EClass> list : superClasses) {
			result.addAll(list);
		}

		return result;
	}

	protected void buildSuperClassList(List<List<EClass>> superClasses, EClass eClass, int depth) {
		if (superClasses.size() <= depth) {
			superClasses.add(depth, new ArrayList<>());
		}

		List<EClass> superTypes = eClass.getESuperTypes();

		superClasses.get(depth).add(eClass);

		for (EClass superType : superTypes) {
			buildSuperClassList(superClasses, superType, depth + 1);
		}
	}
}
