package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StateTextCompartmentExpressionEditPart extends
		PlugableXTextLabelEditPart implements IXtextAwareEditPart {

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view);
	}


	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

}
