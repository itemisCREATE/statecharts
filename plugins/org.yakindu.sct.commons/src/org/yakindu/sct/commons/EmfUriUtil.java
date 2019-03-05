/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.commons;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public final class EmfUriUtil {
	
	private EmfUriUtil() {
		// intentional
	}

	public static IFile toFile(URI emfUri) {
		if (emfUri.isPlatformResource()) {
			String platformString = emfUri.toPlatformString(true);
			return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		} else if (emfUri.isFile()) {
			File file = new File(emfUri.toFileString());
			if (!file.exists())
				return null;
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(file.toURI());
			if (files.length == 1) {
				return files[0];
			}
		}
		return null;
	}
}
