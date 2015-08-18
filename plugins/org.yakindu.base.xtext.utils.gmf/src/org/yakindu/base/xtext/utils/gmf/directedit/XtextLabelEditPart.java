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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.base.xtext.utils.gmf.directedit.DoubleClickDirectEditDragTracker.IDoubleClickCallback;
import org.yakindu.base.xtext.utils.gmf.figures.HighlightingWrappingLabel;

/**
 * Abstract base implementation for all Labels that that use Xtext for direct
 * editing.
 * 
 * 
 * @author muelder
 * 
 */
public abstract class XtextLabelEditPart extends CompartmentEditPart implements IXtextAwareEditPart {

	protected abstract DirectEditManager createDirectEditManager();

	public XtextLabelEditPart(final View view) {
		super(view);
	}

	@Override
	protected IFigure createFigure() {
		final WrappingLabel label = new HighlightingWrappingLabel();
		label.setTextWrap(true);
		label.setAlignment(PositionConstants.LEFT | PositionConstants.TOP);
		return label;
	}

	@Override
	public WrappingLabel getFigure() {
		return (WrappingLabel) super.getFigure();
	}

	public void setLabelText(final String text) {
		getFigure().setText(text);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFont();
		refreshFontColor();
		updateLabelText();
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
		if (request instanceof SelectionRequest && ((SelectionRequest) request).getLastButtonPressed() == 3)
			return null;
		IDoubleClickCallback callback = new IDoubleClickCallback() {
			public void handleDoubleClick(int btn) {
				performDirectEditRequest(request);
			}
		};
		return new DoubleClickDirectEditDragTracker(this, getTopGraphicEditPart(), callback);
	}

	@Override
	public void performDirectEditRequest(final Request request) {
		final DirectEditManager manager = createDirectEditManager();
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive()) {
						if (theRequest.getExtendedData().get(REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							final Character initialChar = (Character) theRequest.getExtendedData().get(
									REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							if (manager instanceof XtextDirectEditManager) {
								((XtextDirectEditManager) manager).show(initialChar);
							} else if (manager instanceof TextDirectEditManager) {
								((TextDirectEditManager) manager).show(initialChar);
							}
						} else {
							manager.show();
						}
					}
				}
			});
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

}
