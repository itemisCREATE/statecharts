package de.itemis.xtext.utils.gmf.directedit;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * 
 * Implemented by EditParts, which contain text that should be edited via Xtext.
 * The interface provides a subset of the methods delivered by
 * {@link org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart}.
 * 
 * @author muelder
 * 
 */
public interface IXTextAwareEditPart extends IGraphicalEditPart {

	/**
	 * Returns the text to edit
	 */
	String getEditText();

	/**
	 * Called when edit text was modified and edit part should update itself to
	 * reflect the changes.
	 */
	public void setLabelText(String text);

}
