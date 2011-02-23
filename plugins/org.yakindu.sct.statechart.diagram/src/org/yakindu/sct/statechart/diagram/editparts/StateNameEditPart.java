package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.StatechartPackage;
/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 *
 */
public class StateNameEditPart extends TextAwareLabelEditPart {

	public StateNameEditPart(View view) {
		super(view, StatechartPackage.Literals.NAMED_ELEMENT__NAME);
	}


	public void setLabel(IFigure label) {
		setFigure(label);
	}

	@Override
	protected IFigure createFigure() {
		//Figure is set from parent addChild
		return null;
	}


}
