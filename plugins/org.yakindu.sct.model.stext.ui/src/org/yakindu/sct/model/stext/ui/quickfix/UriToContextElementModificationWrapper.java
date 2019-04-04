/** 
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.model.stext.ui.quickfix;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

public class UriToContextElementModificationWrapper implements IModification {

	private Issue issue;
	private ISemanticModification semanticModification;

	public UriToContextElementModificationWrapper(Issue issue, ISemanticModification semanticModification) {
		this.semanticModification = semanticModification;
		this.issue = issue;
	}

	@Override
	public void apply(final IModificationContext context) {
		String uriString = issue.getData()[0];
		URI uri = URI.createURI(uriString, true);
		EObject eObject = DiagramPartitioningUtil.getSharedDomain().getResourceSet().getEObject(uri, true);
		try {
			semanticModification.apply(eObject, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
