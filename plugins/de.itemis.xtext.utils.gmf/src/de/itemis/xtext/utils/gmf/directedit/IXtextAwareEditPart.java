/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - initial API and implementation
 * 
 */
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
public interface IXtextAwareEditPart extends IGraphicalEditPart {

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
