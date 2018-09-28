/** 
 * Copyright (c) 2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.xtext.utils.jface.viewers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;


public class XtextStyledTextSelectionProvider implements ISelectionProvider {

	private StyledText styledText;
	private XtextResource xtextResource;

	public XtextStyledTextSelectionProvider(StyledText styledText, XtextResource xtextResource) {
		this.styledText = styledText;
		this.xtextResource = xtextResource;
	}

	public void setSelection(ISelection selection) {
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	public ISelection getSelection() {
		if (styledText.isDisposed())
			return StructuredSelection.EMPTY;
		int offset;
		if (styledText.getCaretOffset() > 1) {
			offset = styledText.getCaretOffset() - 1;
		} else {
			offset = 0;
		}
		XtextResource fakeResource = xtextResource;
		IParseResult parseResult = fakeResource.getParseResult();
		if (parseResult == null)
			return StructuredSelection.EMPTY;
		ICompositeNode rootNode = parseResult.getRootNode();
		ILeafNode selectedNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
		final EObject selectedObject = NodeModelUtils.findActualSemanticObjectFor(selectedNode);
		if (selectedObject == null) {
			return StructuredSelection.EMPTY;
		}
		return new StructuredSelection(selectedObject);
	}
}