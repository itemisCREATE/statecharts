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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.emf.clipboard.core.AbstractClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteAction;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartClipboardSupport extends AbstractClipboardSupport {

	protected EAttribute getNameAttribute(EClass eClass) {
		return SGraphPackage.Literals.NAMED_ELEMENT__NAME;
	}

	@Override
	public PasteAction getPasteCollisionAction(EClass eClass) {
		return PasteAction.CLONE;
	}

}
