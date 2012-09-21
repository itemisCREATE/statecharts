/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

/**
 * Abstract definition of an
 * {@link org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport}-defined
 * operation that completely overrides the default paste-child behaviour.
 * <p>
 * This class is intended to be extended by clients, to provide an alternative
 * paste operation in the clipboard support.
 * </p>
 * 
 * @see IClipboardSupport#getOverrideChildPasteOperation(PasteChildOperation)
 * 
 * @author Yasser Lulu
 */
public abstract class OverridePasteChildOperation
	extends PasteChildOperation {

	private PasteChildOperation overriddenChildPasteOperation;

    /**
     * Initializes me with the default paste operation that I am overriding.
     * I may want to access this default operation later in performing the
     * paste.
     * 
     * @param overriddenChildPasteOperation the default paste operation that I
     *     override
     */
	public OverridePasteChildOperation(
			PasteChildOperation overriddenChildPasteOperation) {
		super(overriddenChildPasteOperation);
		this.overriddenChildPasteOperation = overriddenChildPasteOperation;
	}

	/**
     * Obtains the default child-paste operation that I am overriding.
     * 
     * @return the overridden paste operation
	 */
	protected PasteChildOperation getOverriddenPasteChildOperation() {
		return overriddenChildPasteOperation;
	}

}