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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateNameEditPart extends TextAwareLabelEditPart {

	public StateNameEditPart(View view) {
		super(view, SGraphPackage.Literals.NAMED_ELEMENT__NAME,
				DiagramActivator.PLUGIN_ID);
	}

	public void setLabel(IFigure label) {
		setFigure(label);
	}

	@Override
	protected IFigure createFigure() {
		// Figure is set from parent addChild
		return null;
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}
	
	@Override
	protected void updateLabelText() {
		if (resolveSemanticElement().getSubstatechart()!=null) {
			StringBuilder builder = new StringBuilder();
			builder.append(getEditText());
			builder.append("::");
			Statechart substatechart = resolveSemanticElement().getSubstatechart();
			if (substatechart != null) {
				builder.append(substatechart.getName());
			} else {
				builder.append("<Unknown>");
			}
			getWrappingLabel().setText(builder.toString());
		}
		else {
			super.updateLabelText();
		}
		
	};
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.getFeature() == SGraphPackage.Literals.STATE__SUBSTATECHART) {
			updateLabelText();
		}
	}
}
