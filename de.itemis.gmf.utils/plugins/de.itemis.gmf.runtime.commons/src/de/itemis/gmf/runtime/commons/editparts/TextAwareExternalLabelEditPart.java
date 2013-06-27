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
package de.itemis.gmf.runtime.commons.editparts;

import static org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
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

import de.itemis.gmf.runtime.commons.parsers.StringAttributeParser;

/**
 * This is a common abstract base class for all {@link LabelEditPart} which are
 * {@link ITextAwareEditPart}.
 * 
 * This edit part is only to be used for external labels, i.e. Connection
 * labels. For Labels inside of a Figure use {@link TextAwareLabelEditPart}
 * 
 * @author andreas muelder
 * 
 */
public abstract class TextAwareExternalLabelEditPart extends LabelEditPart
		implements ITextAwareEditPart {

	private final DirectEditManager manager;

	private final EAttribute feature;

	private final String pluginId;

	public TextAwareExternalLabelEditPart(View view, EAttribute feature,
			String pluginId) {
		super(view);
		this.feature = feature;
		this.pluginId = pluginId;
		manager = createDirectEditManager();
	}

	private void updateLabelText() {
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
		getWrappingLabel().setText(text);

	}

	private WrappingLabel getWrappingLabel() {
		return (WrappingLabel) getFigure();
	}

	@Override
	protected IFigure createFigure() {
		return new WrappingLabel();
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
