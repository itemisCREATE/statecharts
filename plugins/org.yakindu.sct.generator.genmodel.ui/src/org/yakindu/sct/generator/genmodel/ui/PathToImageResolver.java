/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.genmodel.ui;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.generator.genmodel.ui.internal.GenmodelActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PathToImageResolver {

	public static Image toImage(URL path) {
		if (path == null)
			return null;
		ImageRegistry imageRegistry = GenmodelActivator.getInstance().getImageRegistry();
		Image image = imageRegistry.get(path.toString());
		if (image == null)
			imageRegistry.put(path.toString(), ImageDescriptor.createFromURL(path).createImage());
		return imageRegistry.get(path.toString());
	}

}
