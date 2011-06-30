/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.clipboard;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartClipboardSupportFactory implements
		IClipboardSupportFactory {

	private final IClipboardSupport support = new StatechartClipboardSupport();

	public StatechartClipboardSupportFactory() {
		super();
	}

	public IClipboardSupport newClipboardSupport(EPackage ePackage) {
		return support;
	}
}
