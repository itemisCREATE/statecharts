/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.gmf.runtime.emf.clipboard.core;

import org.eclipse.emf.ecore.EPackage;

/**
 * Interface for objects that can create {@link IClipboardSupport}s for
 * supporting clipboard copy/paste operations on EMF models.
 * <p>
 * This interface is intended to be implemented by plug-ins
 * on the <tt>clipboardSupport</tt> extension point.
 * </p>
 * 
 * @see IClipboardSupport
 *
 * @author Christian W. Damus (cdamus)
 */
public interface IClipboardSupportFactory {
	/**
	 * Creates a new clipboard support utility instance.  This method may create
	 * a new instance or may return always the same reusable instance.
	 * Clipboard support utilities are not expected to retain any state that
	 * needs to be disposed.
	 * <p>
	 * A single factory class can support any number of EMF metamodels.  Hence
	 * the parameterization of the factory method by an <code>ePackage</code>.
	 * </p>
	 * 
	 * @param ePackage the <code>EPackage</code> (representing an EMF metamodel)
	 *     for which a clipboard support utility is required.
	 * @return a new clipboard support utility
	 */
	IClipboardSupport newClipboardSupport(EPackage ePackage);
}
