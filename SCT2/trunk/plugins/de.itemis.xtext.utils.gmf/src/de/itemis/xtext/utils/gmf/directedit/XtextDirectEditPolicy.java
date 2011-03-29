/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.directedit;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.xtext.parser.IParseResult;

/**
 * Abstract {@link DirectEditPolicy} base implementation to be used for
 * Xtext-based direct editing.
 * 
 * @author andreas.muelder@itemis.de
 */
public abstract class XtextDirectEditPolicy<T extends EObject> extends DirectEditPolicy {
	
	@SuppressWarnings("unchecked")
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		Assert.isTrue(edit.getCellEditor() instanceof XtextCellEditor);
		XtextCellEditor cellEditor = (XtextCellEditor) edit.getCellEditor();
		//TODO: We have to create Problem Markers for errors 
		@SuppressWarnings("unused")
		List<Diagnostic> diagnostics = cellEditor.getDiagnostics();
		IParseResult result = cellEditor.getParseResult();
		return getDirectEditCommand(edit, (T)result.getRootASTElement());
	}


	protected abstract Command getDirectEditCommand(DirectEditRequest edit,
			T rootASTElement);

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXtextAwareEditPart) getHost()).setLabelText(value);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
