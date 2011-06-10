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
package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.statechart.diagram.editparts.StateEditPart;

/**
 * Special implementation of {@link XYLayoutEditPolicy} for the
 * {@link RegionCompartmentEditPart}.
 * 
 * If a State within the region compartment is collapsed, this Edit Policy does
 * not change the width and height in the Notation model for this state.
 * 
 * So the original width and height of the state before it was collapsed, is
 * remembered and used when the state is expanded again.
 * 
 * @author muelder
 * 
 */
public class RegionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		if (child instanceof StateEditPart
				&& ((StateEditPart) child).isCollapsed()) {
			Rectangle newBounds = (Rectangle) constraint;
			View shapeView = (View) child.getModel();
			// Override the new bounds with the original bounds from the
			// notation model here
			newBounds.width = (Integer) ViewUtil.getStructuralFeatureValue(
					shapeView, NotationPackage.eINSTANCE.getSize_Width());
			newBounds.height = (Integer) ViewUtil.getStructuralFeatureValue(
					shapeView, NotationPackage.eINSTANCE.getSize_Height());
			ICommand boundsCommand = new SetBoundsCommand(getHost()
					.getEditingDomain(),
					DiagramUIMessages.SetLocationCommand_Label_Resize,
					new EObjectAdapter(shapeView), newBounds);
			return new ICommandProxy(boundsCommand);
		} else {
			return super.createChangeConstraintCommand(child, constraint);
		}
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
	/**
	 * TODO
	 * This is a workaround for GMF bug #349042
	 * This method can be removed entirely if the provided patch
	 * is applied in GMF
	 */
	@Override
	protected Object getConstraintFor(
			ChangeBoundsRequest request,
			GraphicalEditPart child) {
			Rectangle rect = (Rectangle) super.getConstraintFor(request, child);
			Rectangle cons = getCurrentConstraintFor(child);
			if(cons != null){
				if (request.getSizeDelta().width == 0)
					rect.width = cons.width;
				if (request.getSizeDelta().height == 0)
					rect.height = cons.height;
			}
			return rect;
		}
}
