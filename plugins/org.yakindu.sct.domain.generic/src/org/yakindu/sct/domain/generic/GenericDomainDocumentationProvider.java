/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.generic;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.yakindu.sct.domain.extension.IDomainDocumentationProvider;

public class GenericDomainDocumentationProvider implements IDomainDocumentationProvider {

	@Override
	public URL getDocumentationURL() {
		IPath relativePagePath = new Path(getDocPathString());
		URL fileInPlugin = FileLocator.find(getBundle(), relativePagePath, null);
		try {
			return FileLocator.toFileURL(fileInPlugin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected String getDocPathString() {
		return "docu/default_domain.html";
	}

	protected Bundle getBundle() {
		return GenericDomainActivator.getContext().getBundle();
	}

}
