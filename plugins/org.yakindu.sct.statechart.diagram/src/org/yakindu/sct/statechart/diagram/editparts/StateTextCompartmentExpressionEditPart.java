package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

import de.itemis.xtext.utils.gmf.directedit.IXTextAwareEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StateTextCompartmentExpressionEditPart extends
		PlugableXTextLabelEditPart implements IXTextAwareEditPart {

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view);
	}


	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
