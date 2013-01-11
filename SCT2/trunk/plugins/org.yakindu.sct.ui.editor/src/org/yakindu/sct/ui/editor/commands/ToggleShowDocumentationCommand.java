/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation (http://www.statecharts.org)
 * 
 */
package org.yakindu.sct.ui.editor.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ToggleShowDocumentationCommand extends AbstractHandler {

	public static final String FEATURE_TO_SHOW = "featureToShow";

	public Object execute(ExecutionEvent event) throws ExecutionException {
		View view = unwrap(HandlerUtil.getCurrentSelection(event));
		StringValueStyle style = (StringValueStyle) view.getNamedStyle(
				NotationPackage.Literals.STRING_VALUE_STYLE, FEATURE_TO_SHOW);
		if (style == null) {
			style = createInitialStyle(view);
		}
		String featureName = style.getStringValue().equals(
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION
						.getName()) ? BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION
				.getName()
				: SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION
						.getName();
		SetValueCommand cmd = new SetValueCommand(new SetRequest(style,
				NotationPackage.Literals.STRING_VALUE_STYLE__STRING_VALUE,
				featureName));
		executeCommand(cmd);
		return null;

	}

	protected StringValueStyle createInitialStyle(View view) {
		StringValueStyle style = NotationFactory.eINSTANCE
				.createStringValueStyle();
		style.setName(FEATURE_TO_SHOW);
		style.setStringValue(SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION
				.getName());
		SetValueCommand cmd = new SetValueCommand(new SetRequest(view,
				NotationPackage.Literals.VIEW__STYLES, style));
		executeCommand(cmd);
		return style;
	}

	protected void executeCommand(SetValueCommand setcommand) {
		try {
			OperationHistoryFactory.getOperationHistory().execute(setcommand,
					new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	protected View unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((IGraphicalEditPart) firstElement).getNotationView();
	}
}
