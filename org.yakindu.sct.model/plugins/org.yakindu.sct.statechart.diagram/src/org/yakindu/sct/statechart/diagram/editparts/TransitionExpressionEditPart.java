/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.editparts;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.parser.AttributeParser;
import org.yakindu.sct.statechart.diagram.xtext.integration.XTextDirectEditManager;

/**
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class TransitionExpressionEditPart extends LabelEditPart implements
		ITextAwareEditPart {

	private DirectEditManager manager;

	private static final EAttribute feature = StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION;

	public TransitionExpressionEditPart(View view) {
		super(view);
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == feature) {
			getWrappingLabel().setText(getEditText());
		}
		super.handleNotificationEvent(notification);
	}

	public void setLabel(IFigure figure) {
		setFigure(figure);
		manager = new XTextDirectEditManager(this, DiagramActivator
				.getDefault().getExpressionsInjector(),
				new DefaultCellEditorLocator(), SWT.SINGLE);
	}

	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		// TODO: Add a Feedback role
	}

	@Override
	public String getEditText() {
		return getParser().getEditString(
				new EObjectAdapter(resolveSemanticElement()), -1);
	}

	@Override
	public void setLabelText(String text) {
		getWrappingLabel().setText(text);

	}

	private WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getFigure();
	}

	@Override
	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	@Override
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	@Override
	public IParser getParser() {
		return new AttributeParser(feature);
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {
				@Override
				public void run() {
					if (isActive()) {
						if (theRequest.getExtendedData().get(
								REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character
								&& manager instanceof TextDirectEditManager) {
							Character initialChar = (Character) theRequest
									.getExtendedData()
									.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);

							((TextDirectEditManager) manager).show(initialChar);

						} else {
							manager.show();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class DefaultCellEditorLocator implements CellEditorLocator {

		private static final int minimumWidth = 100;

		@Override
		public void relocate(CellEditor celleditor) {
			Rectangle textRectangle = getWrappingLabel().getBounds().getCopy();
			getFigure().translateToAbsolute(textRectangle);
			celleditor.getControl().setBounds(
					textRectangle.x,
					textRectangle.y,
					Math.max(textRectangle.width, minimumWidth),
					Math.max(textRectangle.height, FigureUtilities
							.getFontMetrics(getWrappingLabel().getFont())
							.getHeight()));
		}
	};

}
