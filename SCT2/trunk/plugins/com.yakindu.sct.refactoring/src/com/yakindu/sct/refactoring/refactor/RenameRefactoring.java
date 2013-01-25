/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package com.yakindu.sct.refactoring.refactor;

import java.util.Collection;

import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.stext.resource.impl.StextResource;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.FeatureCall;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
// TODO Use generic
public class RenameRefactoring extends AbstractRefactoring {

	NamedElement element;
	String oldName;
	String newName;

	public RenameRefactoring(NamedElement element, String name) {
		this.element = element;

		if (element.eResource() == null) {
			// something went wrong
			System.err.println("Resource of element to rename is NULL!!");
		}

		this.newName = name;
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	protected void internalExecute() {

		Collection<EObject> elementReferers = findReferers(element);
		element.setName(newName);

		StextResource res = (StextResource) getResource();

		for (EObject referer : elementReferers) {
			if (referer instanceof FeatureCall) {
				FeatureCall featureCall = (FeatureCall) referer;
				featureCall.setFeature(element);
				res.parseSpecificationElement(EcoreUtil2.getContainerOfType(
						referer, SpecificationElement.class));
			} else if (referer instanceof ElementReferenceExpression) {
				((ElementReferenceExpression) referer).setReference(element);
				res.parseSpecificationElement(EcoreUtil2.getContainerOfType(
						referer, SpecificationElement.class));

			}
		}
	}

	private Collection<EObject> findReferers(EObject referedElement) {
		Collection<EObject> result = new HashSet<EObject>();

		Resource res = getResource();
		EList<EObject> contents = res.getContents();
		result = searchForReferers(referedElement, contents);

		return result;
	}

	private Collection<EObject> searchForReferers(EObject referedElement,
			EList<EObject> contents) {
		Collection<EObject> result = new HashSet<EObject>();
		for (EObject content : contents) {
			for (EObject crossRef : content.eCrossReferences()) {
				if (crossRef.eIsProxy()) {
					crossRef = EcoreUtil.resolve(crossRef, content);
				}
				if (EcoreUtil.equals(crossRef, referedElement)) {
					result.add(content);
				}
			}
			result.addAll(searchForReferers(referedElement, content.eContents()));

		}
		return result;
	}

	@Override
	protected Resource getResource() {
		return element.eResource();
	}

}