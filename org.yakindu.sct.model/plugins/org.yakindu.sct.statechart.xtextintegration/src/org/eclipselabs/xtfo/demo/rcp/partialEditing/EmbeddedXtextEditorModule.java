/**
 * Copyright (c) 2010 ProxiAD
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Cedric Vidal (ProxiAD) - initial API and implementation
 */

package org.eclipselabs.xtfo.demo.rcp.partialEditing;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.AbstractGenericModule;

public class EmbeddedXtextEditorModule extends AbstractGenericModule {

	public Class<? extends XtextResource> bindXtextResource() {
		return EmbeddedXtextResource.class;
	}

	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return EmbeddedStateBasedContainerManager.class;
	}

}
