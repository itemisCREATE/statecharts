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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.FontData;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.gmf.runtime.editparts.TextAwareLabelEditPart;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;
import org.yakindu.sct.ui.editor.utils.FontScalingUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RegionNameEditPart extends TextAwareLabelEditPart implements IPropertyChangeListener {

	public RegionNameEditPart(View view) {
		super(view, BasePackage.Literals.NAMED_ELEMENT__NAME, DiagramActivator.PLUGIN_ID);
	}

	public void setLabel(IFigure label) {
		setFigure(label);
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		// Delegate creation requests to the figure compartment edit part
		if (request instanceof CreateRequest) {
			for (Object object : getParent().getChildren()) {
				if (object instanceof RegionCompartmentEditPart) {
					return (EditPart) object;
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	protected IFigure createFigure() {
		// Figure is set from parent addChild
		return null;
	}

	@Override
	protected void setFont(FontData fontData) {
		super.setFont(FontScalingUtil.scaleFont(fontData));
	}

	@Override
	public void activate() {
		super.activate();
		DiagramActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		DiagramActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (StatechartPreferenceConstants.PREF_FONT_SCALING.equals(event.getProperty())) {
			refreshVisuals();
		}
	}
}
