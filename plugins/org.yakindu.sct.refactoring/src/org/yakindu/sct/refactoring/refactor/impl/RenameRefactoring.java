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
package org.yakindu.sct.refactoring.refactor.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;

/**
 * Renames the context object and all references to it. <br>
 * <br>
 * Context:
 * <ul>
 * <li>A {@link NamedElement}.</li>
 * </ul>
 * Preconditions:
 * <ul>
 * <li>None.</li>
 * </ul>
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class RenameRefactoring extends AbstractRefactoring<NamedElement> {

	String newName;

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public void setContextObjects(List<NamedElement> contextObject) {
		this.newName = null;
		super.setContextObjects(contextObject);
	}

	@Override
	public boolean isExecutable() {
		return (getContextObject() != null);
	}

	@Override
	protected void internalExecute() {
		NamedElement element = getContextObject();
		Collection<EObject> elementReferers = findReferers(element);
		element.setName(newName);
		for (EObject referer : elementReferers) {
			if (referer instanceof FeatureCall) {
				FeatureCall featureCall = (FeatureCall) referer;
				featureCall.setFeature(element);
			} else if (referer instanceof ElementReferenceExpression) {
				ElementReferenceExpression expr = (ElementReferenceExpression) referer;
				expr.setReference(element);
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

	private Collection<EObject> searchForReferers(EObject referedElement, EList<EObject> contents) {
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
		return getContextObject().eResource();
	}

}