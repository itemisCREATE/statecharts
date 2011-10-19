package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author andreas muelder
 * 
 */
public class RegionNameEditPart extends TextAwareLabelEditPart {

	public RegionNameEditPart(View view) {
		super(view, SGraphPackage.Literals.NAMED_ELEMENT__NAME,
				DiagramActivator.PLUGIN_ID);
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

}
