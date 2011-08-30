package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author andreas muelder
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
	protected void performDirectEditRequest(Request request) {
		super.performDirectEditRequest(request);
	}

	@Override
	public String getEditText() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getEditText());
		if (resolveSemanticElement().isSubmachineState()) {
			builder.append("::");
			builder.append(resolveSemanticElement().getSubstatechart()
					.getName());
		}
		return builder.toString();
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}
}
