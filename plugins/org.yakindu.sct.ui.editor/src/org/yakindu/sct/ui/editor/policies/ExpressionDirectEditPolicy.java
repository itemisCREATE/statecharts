/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.swt.custom.StyledText;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.validation.IMarkerType;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import de.itemis.xtext.utils.gmf.experimental.StyledLabel;
import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor;

/**
 * 
 * @author muelder
 * 
 */
public class ExpressionDirectEditPolicy extends DirectEditPolicy implements
		IMarkerType {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		SetRequest setRequest = new SetRequest(getHost()
				.resolveSemanticElement(),
				SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				request.getCellEditor().getValue());
		SetValueCommand setCommand = new SetValueCommand(setRequest);
		return new ICommandProxy(setCommand);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		XtextStyledTextCellEditor cellEditor = (XtextStyledTextCellEditor) request.getCellEditor();
		String value = (String) cellEditor.getValue();
		((IXtextAwareEditPart) getHost()).setLabelText(value);
		StyledText text = (StyledText)cellEditor.getControl();
		StyledLabel figure = (StyledLabel)getHost().getFigure();
		figure.setRanges(text.getStyleRanges());
	}

}
