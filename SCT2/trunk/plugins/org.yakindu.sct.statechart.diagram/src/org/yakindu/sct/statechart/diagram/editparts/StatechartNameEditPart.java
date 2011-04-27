package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.StatechartPackage;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartNameEditPart extends TextAwareLabelEditPart {

	public StatechartNameEditPart(View view) {
		super(view, StatechartPackage.Literals.NAMED_ELEMENT__NAME);
	}

	public void setLabel(IFigure label) {
		setFigure(label);
	}

	@Override
	protected IFigure createFigure() {
		// Figure is set from parent addChild
		return null;
	}
}
