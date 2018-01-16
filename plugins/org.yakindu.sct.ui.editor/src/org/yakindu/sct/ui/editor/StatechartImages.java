/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public enum StatechartImages {

	SUB_STATECHART_PICTOGRAM("icons/obj16/Statechart-Pictogram-16.png"),

	LOGO("icons/obj16/logo-16.png"),

	PRO_LOGO("icons/obj16/logopro-16.png"),
	
	LABS_LOGO("icons/obj16/logolabs-16.png"),

	PRO_EDITION("images/pro.png"),

	MENU("icons/obj16/MENU-16.png"),
	
	DOCU("icons/obj16/docu-16.png"),
	
	EXPR("icons/obj16/expr-16.png"),

	EXPAND("icons/obj16/arrow_right.png"),

	COLLAPSE("icons/obj16/arrow_left.png"),
	
	PIN("icons/obj16/pin-view.gif");

	private final String path;

	private StatechartImages(String path) {
		this.path = path;
	}

	/**
	 * Returns an image. Clients do not need to dispose the image, it will be
	 * disposed automatically.
	 * 
	 * @return an {@link Image}
	 */
	public Image image() {
		final ImageRegistry imageRegistry = DiagramActivator.getDefault()
				.getImageRegistry();
		Image image = imageRegistry.get(path);
		if (image == null) {
			addImageDescriptor();
			image = imageRegistry.get(path);
		}

		return image;
	}

	/**
	 * Returns an image descriptor.
	 * 
	 * @return an {@link ImageDescriptor}
	 */
	public ImageDescriptor imageDescriptor() {
		final ImageRegistry imageRegistry = DiagramActivator.getDefault()
				.getImageRegistry();
		ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(path);
		if (imageDescriptor == null) {
			addImageDescriptor();
			imageDescriptor = imageRegistry.getDescriptor(path);
		}

		return imageDescriptor;
	}

	private void addImageDescriptor() {
		final DiagramActivator plugin = DiagramActivator.getDefault();
		final ImageDescriptor id = ImageDescriptor.createFromURL(plugin
				.getBundle().getEntry(path));
		plugin.getImageRegistry().put(path, id);
	}

}
