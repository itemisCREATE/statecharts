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
package org.yakindu.base.xtext.utils.gmf.directedit;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.base.xtext.utils.gmf.figures.SyntaxColoringLabel;
import org.yakindu.base.xtext.utils.gmf.routing.EdgeLabelLocator;
import org.yakindu.base.xtext.utils.jface.viewers.XtextStyledTextCellEditor;

/**
 * Abstract base implementation for all external {@link LabelEditPart} that use
 * Xtext for direct editing.
 * 
 * 
 * @author muelder
 * 
 */
public abstract class ExternalXtextLabelEditPart extends LabelEditPart implements IXtextAwareEditPart {

	protected abstract DirectEditManager createDirectEditManager();

	protected abstract void setContext(Resource resource);

	protected abstract void setLabelStyles();

	public ExternalXtextLabelEditPart(final View view) {
		super(view);
	}

	@Override
	protected IFigure createFigure() {
		final WrappingLabel label = new SyntaxColoringLabel();
		label.setTextWrap(true);
		label.setAlignment(PositionConstants.LEFT | PositionConstants.TOP);
		return label;
	}

	@Override
	public SyntaxColoringLabel getFigure() {
		return (SyntaxColoringLabel) super.getFigure();
	}

	public void setLabelText(final String text) {
		if(text != null && !text.equals(getFigure().getText())) {
			getFigure().setText(text);
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFont();
		refreshFontColor();
		updateLabelText();
		setLabelStyles();
	}

	@Override
	public void refreshBounds() {
		int dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Rectangle bounds = new Rectangle(dx, dy, -1, -1);
		((AbstractGraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new EdgeLabelLocator(
				((AbstractConnectionEditPart) getParent()).getConnectionFigure(), bounds, getKeyPoint()));
	}

	protected void updateLabelText() {
		getFigure().setText(getEditText());

	}

	@Override
	protected void setFontColor(final Color color) {
		getFigure().setForegroundColor(color);
	}

	@Override
	protected void handleNotificationEvent(final Notification notification) {
		if (notification.getNotifier() instanceof ShapeStyle) {
			refreshVisuals();
		} else if (NotationPackage.eINSTANCE.getFontStyle().getEAllAttributes().contains(notification.getFeature())) {
			refreshFont();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	/**
	 * Performs direct edit on double click
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		return new DragEditPartsTrackerEx(this) {
			protected boolean isMove() {
				return true;
			}

			protected boolean handleDoubleClick(int button) {
				performDirectEditRequest(request);
				return super.handleDoubleClick(button);
			}
		};
	}

	@Override
	protected void performDirectEditRequest(final Request request) {
		final DirectEditManager manager = createDirectEditManager();
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive()) {

						if (theRequest.getExtendedData()
								.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							final Character initialChar = (Character) theRequest.getExtendedData()
									.get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							if (manager instanceof XtextDirectEditManager) {
								XtextDirectEditManager xtextDirectEditManager = (XtextDirectEditManager) manager;
								xtextDirectEditManager.show(initialChar);
							} else if (manager instanceof TextDirectEditManager) {
								((TextDirectEditManager) manager).show(initialChar);
							}
						} else {
							manager.show();
						}
						if (manager instanceof XtextDirectEditManager) {
							XtextDirectEditManager xtextDirectEditManager = (XtextDirectEditManager) manager;
							XtextStyledTextCellEditor cellEditor = (XtextStyledTextCellEditor) xtextDirectEditManager
									.getCellEditor();
							setContext(cellEditor.getXtextAdapter().getFakeResourceContext().getFakeResource());
						}
					}
				}
			});
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

}
