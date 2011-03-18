package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.model.sct.statechart.Statechart;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextExpressionEditPart extends
		PlugableXTextLabelEditPart {

	public StatechartTextExpressionEditPart(View view) {
		super(view);
	}

	@Override
	public Statechart resolveSemanticElement() {
		return (Statechart) super.resolveSemanticElement();
	}


	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
