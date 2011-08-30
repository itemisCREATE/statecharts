/*******************************************************************************
 * Copyright (c) 2010  itemis AG (http://www.itemis.de)
 * All rights reserved. 
 * 
 * Contributors:
 *     itemis AG - initial API and implementation
 *******************************************************************************/
package org.yakindu.sct.ui.editor.pictogram;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;

/**
 * This is a data class to comprise a description, an image, as well as a
 * handler (and a context validator).
 * 
 * @author Alexander Nyssen
 */
public class Pictogram {

	/**
	 * This is a data class to comprise a context validator.
	 * 
	 * @author Alexander Nyssen
	 */
	public interface IHandlerContextValidator {

		IHandlerContextValidator DEFAULT = new IHandlerContextValidator() {

			public boolean isValidContext(ExecutionEvent event) {
				return true;
			}
		};

		boolean isValidContext(ExecutionEvent event);
	}

	protected IGraphicalEditPart host;

	private final String description;

	private final Image image;

	private final IHandler handler;

	private final IHandlerContextValidator handlerContextValidator;

	public Pictogram(final String description, final Image image,
			final IHandler handler) {
		this(description, image, handler, IHandlerContextValidator.DEFAULT);
	}

	public Pictogram(final String description, final Image image,
			final IHandler handler,
			final IHandlerContextValidator handlerContextValidator) {
		this.description = description;
		this.image = image;
		this.handler = handler;
		this.handlerContextValidator = handlerContextValidator;
	}

	public String getDescription() {
		return description;
	}

	public Image getImage() {
		return image;
	}

	public IHandler getHandler() {
		return handler;
	}

	public IHandlerContextValidator getHandlerContextValidator() {
		return handlerContextValidator;
	}

	public void setHost(IGraphicalEditPart host) {
		this.host = host;
	}

	public EObject getElement() {
		if (host != null) {
			final Object model = host.getModel();
			if (model != null && model instanceof View) {
				return ((View) host).getElement();
			}
		}
		return null;
	}
}
