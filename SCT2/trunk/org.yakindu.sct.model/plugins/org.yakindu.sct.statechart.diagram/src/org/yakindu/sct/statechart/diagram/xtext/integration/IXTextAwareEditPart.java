package org.yakindu.sct.statechart.diagram.xtext.integration;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.GraphicalEditPart;

/**
 * 
 * Implemented by editParts, that contains Text that should be edited via xText
 * 
 * @author muelder
 * 
 */
public interface IXTextAwareEditPart extends GraphicalEditPart {
	/**
	 * Returns the text to edit
	 */
	String getEditText();

	/**
	 * Returns the Wrapping label used for DirectEdititing
	 */
	Label getLabel();

	/**
	 * Returns the {@link EAttribute} where to store the xText expression
	 */
	EAttribute getTextFeature();
}
