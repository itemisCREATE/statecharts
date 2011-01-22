package org.yakindu.sct.statechart.diagram.xtext.integration;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * 
 * Implemented by editParts, that contains Text that should be edited via xText
 * 
 * @author muelder
 * 
 */
public interface IXTextAwareEditPart {
	/**
	 * Returns the text to edit
	 */
	String getEditText();
	
	WrappingLabel getWrappingLabel();
}
