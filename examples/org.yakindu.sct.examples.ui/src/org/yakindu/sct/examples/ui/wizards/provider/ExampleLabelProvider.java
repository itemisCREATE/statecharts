/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.ui.wizards.provider;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.examples.ui.service.IExampleService.ExampleData;

/**
 * 
 * @author t00manysecretss
 * 
 */

public class ExampleLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private ImageDescriptor fileIcon, folderIcon;
	private ResourceManager resourceManager;

	public ExampleLabelProvider(ImageDescriptor fileIcon, ImageDescriptor folderIcon) {
		this.fileIcon = fileIcon;
		this.folderIcon = folderIcon;
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof ExampleData) {
			return new StyledString(((ExampleData) element).getTitle());
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element != null && element instanceof ExampleData) {
			if (((ExampleData) element).hasChildren()) {
				return getResourceManager().createImage(folderIcon);
			} else {
				return getResourceManager().createImage(fileIcon);
			}
		}
		return super.getImage(element);
	}

	@Override
	public void dispose() {
		if (resourceManager != null) {
			resourceManager.dispose();
		}
	}

	protected ResourceManager getResourceManager() {
		if (resourceManager == null) {
			resourceManager = new LocalResourceManager(JFaceResources.getResources());
		}
		return resourceManager;
	}
}
