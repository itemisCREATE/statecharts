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
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.model.statechart.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.parser.AttributeParser;

import de.itemis.xtext.gmf.integration.directediting.XTextDirectEditManager;

/**
 * FIXME: This class shares lot of code with {@link TextAwareLabelEditPart}.
 * That is because java does not support multiple inheritance. Refactor common
 * code into delegate...
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class TransitionExpressionEditPart extends LabelEditPart implements
		ITextAwareEditPart {

	private DirectEditManager manager;

	private static final String UPDATE_NAME_FILTER = "update.name";

	private static final EAttribute feature = StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION;

	/**
	 * Semantic listener that updates the Label in case of model changes.
	 */
	private final NotificationListener updateLabelListener = new NotificationListener() {

		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == feature) {
				getWrappingLabel().setText(getEditText());
			}
		}
	};

	public TransitionExpressionEditPart(View view) {
		super(view);
	}

	public void setLabel(IFigure figure) {
		setFigure(figure);
		manager = new XTextDirectEditManager(this, DiagramActivator.getXtextModule(),
				new DefaultCellEditorLocator());
	}


	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		addListenerFilter(UPDATE_NAME_FILTER, updateLabelListener,
				resolveSemanticElement());
	};

	@Override
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();
		removeListenerFilter(UPDATE_NAME_FILTER);
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

		private static final int minimumWidth = 50;
		private static final int minimumHeight = 15;

		@Override
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle textRectangle = getWrappingLabel().getBounds().getCopy();
			getFigure().translateToAbsolute(textRectangle);
			text.setBounds(textRectangle.x, textRectangle.y,
					Math.max(textRectangle.width, minimumWidth),
					Math.max(textRectangle.height, minimumHeight));
		}
	};

}
