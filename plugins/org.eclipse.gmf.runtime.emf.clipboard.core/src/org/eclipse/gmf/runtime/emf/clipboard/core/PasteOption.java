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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;


/**
 * An enumeration of paste options.
 * 
 * @author khussey
 */
public class PasteOption
	extends AbstractEnumerator {

	/**
	 * An internal unique identifier for this enumerated type.
	 */
	private static int nextOrdinal = 0;

	/**
	 * Paste option indicating that the element(s) referenced by by an
	 * {@link org.eclipse.emf.ecore.EReference} feature of a pasted object must
	 * resolve in a successful paste operation.  If a referenced element
	 * cannot be resolved (either by locating the existing element
	 * in some model or by pasting a copy of it), then the referencing element
	 * also fails to paste.  This applies to both containment and
	 * non-containment references.
	 */
	public static final PasteOption CRITICAL = new PasteOption("Critical"); //$NON-NLS-1$

	/**
	 * Paste option indicating that the copying of the elements referenced by
	 * some {@link org.eclipse.emf.ecore.EReference} feature of an object
	 * being copied is supported for "distant" pastes.  These are pastes into
	 * other application instances.
	 */
	public static final PasteOption DISTANT = new PasteOption("Distant"); //$NON-NLS-1$

	/**
	 * Paste option indicating that the element(s) referenced by by an
	 * {@link org.eclipse.emf.ecore.EReference} feature of a pasted object must
	 * be in the same model as the pasted object.  That is, the reference must
	 * resolve to an element in the target model of the paste operation.
	 */
	public static final PasteOption LOCAL = new PasteOption("Local"); //$NON-NLS-1$

	/**
	 * Paste option indicating that the copying of the elements referenced by
	 * some {@link org.eclipse.emf.ecore.EReference} feature of an object
	 * being copied is critically important to a successful copy.  If the
	 * referenced cannot be resolved (either by locating the existing element
	 * in some model or by pasting a copy of it), then the referencing element
	 * also fails to paste.  This applies to both containment and
	 * non-containment references.
	 */
	public static final PasteOption NORMAL = new PasteOption("Normal"); //$NON-NLS-1$

	/**
	 * Paste option indicating that the container of an object (referenced by
	 * a specific {@link org.eclipse.emf.ecore.EReference} should also be
	 * copied, in case it the actual object can't be pasted at the intended
	 * location but its container can (thus allowing the intended object also
	 * to be pasted under it).
	 */
	public static final PasteOption PARENT = new PasteOption("Parent"); //$NON-NLS-1$

	/**
	 * The list of values for this enumerated type.
	 */
	private static final PasteOption[] VALUES = {CRITICAL, DISTANT, LOCAL,
		NORMAL, PARENT};

	/**
	 * Constructs a new paste option with the specified name.
	 * 
	 * @param name The name of the new paste option.
	 */
	private PasteOption(String name) {
		super(nextOrdinal++,name);
	}

	/**
	 * Retrieves the list of constants for this enumerated type.
	 * 
	 * @return The list of constants for this enumerated type.
	 * 
	 * @see EnumeratedType#getValues()
	 */
	protected List getValues() {
		return Collections.unmodifiableList(Arrays.asList(VALUES));
	}

}