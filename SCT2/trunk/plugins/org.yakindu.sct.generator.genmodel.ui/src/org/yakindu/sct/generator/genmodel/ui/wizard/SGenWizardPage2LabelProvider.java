/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.yakindu.sct.generator.core.extensions.FileExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

/**
 * 
 * @author oliver bohl - Initial contribution and API
 * 
 */
class SGenWizardPage2LabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof IFolder) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		} else if (element instanceof IProject) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
		} else if (element instanceof IFile) {
			String generatorID = FileExtensions.getGeneratorForFileExtension(((IFile) element).getFileExtension());
			GeneratorDescriptor genDesc = GeneratorExtensions.getGeneratorDescriptorForId(generatorID);
			return genDesc.getImage();
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return ((IResource) element).getName();
	}
};
