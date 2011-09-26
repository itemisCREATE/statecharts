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
package org.yakindu.sct.ui.editor.clipboardsupport;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;


/**
 * Clipboard support factory to provide a customized {@link NotationClipboardOperationHelper}
 * 
 *  @author muehlbrandt
 *
 */
public class ClipboardSupportFactory implements IClipboardSupportFactory {

	private final IClipboardSupport clipHelper = new NotationClipboardOperationHelper();

	public IClipboardSupport newClipboardSupport(EPackage ePackage) {
		return clipHelper;
	}
}
