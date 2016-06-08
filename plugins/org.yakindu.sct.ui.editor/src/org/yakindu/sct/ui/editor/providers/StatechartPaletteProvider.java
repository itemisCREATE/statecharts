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
package org.yakindu.sct.ui.editor.providers;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.ui.IEditorPart;
import org.yakindu.sct.domain.extension.DomainRegistry;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartPaletteProvider extends AbstractProvider implements IPaletteProvider {

	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root,
			@SuppressWarnings("rawtypes") Map predefinedEntries) {
		IFile adapter = (IFile) editor.getEditorInput().getAdapter(IFile.class);
		String domainID = DomainRegistry
				.determineDomainID(URI.createPlatformResourceURI(adapter.getFullPath().toOSString(), true));
		Injector editorInjector = DomainRegistry.getDomainDescriptor(domainID).getDomainInjectorProvider()
				.getEditorInjector();
		ISCTPaletteFactory factory = editorInjector.getInstance(ISCTPaletteFactory.class);
		factory.createPaletteEntries(root);
	}

	@Override
	public boolean provides(IOperation operation) {
		return false;
	}

	@Override
	public void setContributions(IConfigurationElement configElement) {
	}
}
