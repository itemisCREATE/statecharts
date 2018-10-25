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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Statechart;
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
		return (getContextObject() != null && EcoreUtil.getRootContainer(getContextObject()) instanceof Statechart);
	}

	@Override
	protected void internalExecute() {
		NamedElement element = getContextObject();
		Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(element, getResource().getResourceSet());
		element.setName(newName);
		
		renameReferences(element, usages);
	}

	private void renameReferences(NamedElement element, Collection<Setting> usages) {
		for (EStructuralFeature.Setting setting : usages) {
			if (setting.getEStructuralFeature().isChangeable() && !setting.getEStructuralFeature().isMany()) {
				EObject holder = setting.getEObject();
				EStructuralFeature f = setting.getEStructuralFeature();
				holder.eSet(f, element);
			}
		}
	}

	@Override
	protected Resource getResource() {
		return getContextObject().eResource();
	}

}