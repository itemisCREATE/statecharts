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
package org.yakindu.sct.examples.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public enum ExampleWizardImages {

	COLLAPSE_ALL("icons/collapseall.gif"),
	EXPAND_ALL("icons/expandall.gif");
	
	private final String path;

	private ExampleWizardImages(String path) {
		this.path = path;
	}

	/**
	 * Returns an image. Clients do not need to dispose the image, it will be
	 * disposed automatically.
	 * 
	 * @return an {@link Image}
	 */
	public Image image() {
		final ImageRegistry imageRegistry = ExampleActivator.getDefault().getImageRegistry();
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
		final ImageRegistry imageRegistry = ExampleActivator.getDefault().getImageRegistry();
		ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(path);
		if (imageDescriptor == null) {
			addImageDescriptor();
			imageDescriptor = imageRegistry.getDescriptor(path);
		}

		return imageDescriptor;
	}

	private void addImageDescriptor() {
		final ExampleActivator plugin = ExampleActivator.getDefault();
		final ImageDescriptor id = ImageDescriptor.createFromURL(plugin.getBundle().getEntry(path));
		plugin.getImageRegistry().put(path, id);
	}

}
