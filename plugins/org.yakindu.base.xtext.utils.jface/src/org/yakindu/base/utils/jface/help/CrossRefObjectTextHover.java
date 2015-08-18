/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.utils.jface.help;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;

import com.google.inject.Inject;

/**
 * Initially copied from {@link DispatchingEObjectTextHover}. This
 * implementation bypasses the {@link IGlobalServiceProvider} because there is a
 * check to the resource file extensions for cross references.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CrossRefObjectTextHover extends DispatchingEObjectTextHover implements
		IEObjectHover {

	private IInformationControlCreatorProvider lastCreatorProvider;
	@Inject
	private IEObjectHoverProvider hoverProvider;

	
	@Override
	public Object getHoverInfo(EObject first, ITextViewer textViewer,
			IRegion hoverRegion) {
		IInformationControlCreatorProvider creatorProvider = hoverProvider
				.getHoverInfo(first, textViewer, hoverRegion);
		if (creatorProvider == null)
			return null;
		this.lastCreatorProvider = creatorProvider;
		return lastCreatorProvider.getInfo();
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return this.lastCreatorProvider == null ? null : lastCreatorProvider
				.getHoverControlCreator();
	}

	@Override
	@Deprecated
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		final Object hoverInfo2 = getHoverInfo2(textViewer, hoverRegion);
		return hoverInfo2 != null ? hoverInfo2.toString() : null;
	}
}
