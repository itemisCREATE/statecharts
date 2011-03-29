package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

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
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
