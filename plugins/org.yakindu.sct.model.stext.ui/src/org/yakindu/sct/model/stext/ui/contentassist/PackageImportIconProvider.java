/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.contentassist;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.internal.ide.model.WorkbenchFile;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
@Singleton
public class PackageImportIconProvider extends WorkbenchFile {

	private Map<ImageDescriptor, Image> fImages = new HashMap<>();

	/**
	 * Provides default icon for import content type
	 */
	public Image getImageFor(PackageImport pkImport) {
		IFile resource = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(pkImport.getFileURI().toPlatformString(true)));
		ImageDescriptor descriptor = getBaseImage(resource);
		return getImage(descriptor);
	}

	private Image getImage(ImageDescriptor descriptor) {
		Image image = fImages.get(descriptor);
		if (image != null) {
			return image;
		}
		image = descriptor.createImage();
		if (image != null) {
			fImages.put(descriptor, image);
		}
		return image;
	}

}
