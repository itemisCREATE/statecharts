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
package org.yakindu.base.gmf.runtime.editparts;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.WrappingLabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.graphics.Color;
import org.yakindu.base.gmf.runtime.parsers.StringAttributeParser;
import org.yakindu.base.xtext.utils.gmf.directedit.DoubleClickDirectEditDragTracker;
import org.yakindu.base.xtext.utils.gmf.directedit.DoubleClickDirectEditDragTracker.IDoubleClickCallback;
import org.yakindu.base.xtext.utils.gmf.figures.HighlightingWrappingLabel;

/**
 * This is a common abstract base class for all Label which are
 * {@link ITextAwareEditPart}.
 * 
 * * This edit part is only to be used for labels inside a figure! for external
 * labels, use {@link TextAwareExternalLabelEditPart}
 * 
 * 
 * @author andreas muelder
 * 
 */
public abstract class TextAwareLabelEditPart extends CompartmentEditPart
		implements ITextAwareEditPart {

	private final DirectEditManager manager;

	protected final EAttribute feature;

	protected final String pluginId;

	public TextAwareLabelEditPart(View view, EAttribute feature, String pluginId) {
		super(view);
		this.feature = feature;
		this.pluginId = pluginId;
		manager = createDirectEditManager();
	}

	protected void updateLabelText() {
		getWrappingLabel().setText(getEditText());
	}

	@Override
	public void activate() {
		super.activate();
		updateLabelText();
	}

	protected DirectEditManager createDirectEditManager() {
		return new TextDirectEditManager(this);
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key.equals(ILabelDelegate.class)) {
			WrappingLabel wrappingLabel = getWrappingLabel();
			if (wrappingLabel == null)
				return super.getAdapter(key);
			return new WrappingLabelDelegate(wrappingLabel);
		}
		return super.getAdapter(key);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		// TODO: Add a Feedback role
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFont();
		refreshFontColor();
	}

	@Override
	protected void setFontColor(Color color) {
		getWrappingLabel().setForegroundColor(color);
	}

	public String getEditText() {
		return getParser().getEditString(
				new EObjectAdapter(resolveSemanticElement()), -1);
	}

	public void setLabelText(String text) {
		updateLabelText();
	}

	protected WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getFigure();
	}

	@Override
	protected IFigure createFigure() {
		return new HighlightingWrappingLabel();
	}

	public ICellEditorValidator getEditTextValidator() {
		return null;
	}

	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	public IParser getParser() {
		return new StringAttributeParser(feature, pluginId);
	}

	public IContentAssistProcessor getCompletionProcessor() {
		return null;
	}
	/**
	 * Performs direct edit on double click
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		if (request instanceof SelectionRequest
				&& ((SelectionRequest) request).getLastButtonPressed() == 3)
			return null;
		IDoubleClickCallback callback = new IDoubleClickCallback() {
			public void handleDoubleClick(int btn) {
				performDirectEditRequest(request);
			}
		};
		return new DoubleClickDirectEditDragTracker(this,
				getTopGraphicEditPart(), callback);
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

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

	// We want to get notified about changes to the primary view, the refresh
	// the visuals when the parent Shape style changes.
	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("parentview", this, getPrimaryView());
	}

	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("parentview");
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() == feature) {
			updateLabelText();
		}
		if (event.getNotifier() instanceof ShapeStyle) {
			refreshVisuals();
		}
		super.handleNotificationEvent(event);
	}
}
