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
package org.yakindu.sct.generator.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 */
public class GenModelLoader {

	public static GeneratorModel load(IFile file) {
		Resource resource = null;
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		resource = new ResourceSetImpl().getResource(uri, true);
		if (resource == null || resource.getContents().size() == 0 || resource.getErrors().size() > 0)
			return null;
		final GeneratorModel model = (GeneratorModel) resource.getContents().get(0);
		return model;
	}
}
