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
 * An enumeration of actions to resolve paste collisions.
 * 
 * @author khussey
 */
public class PasteAction
	extends AbstractEnumerator {

	/**
	 * An internal unique identifier for this enumerated type.
	 */
	private static int nextOrdinal = 0;

	/**
	 * Indicates that that the collision should be resolved by just adding the
	 * conflicting pasted element with an altered name to distinguish it from
	 * the existing one.  Note that for scalar references, this is equivalent
	 * to a {@link #REPLACE}.
	 */
	public static final PasteAction ADD = new PasteAction("Add"); //$NON-NLS-1$

	/**
	 * Indicates that that the collision should be resolved by just adding the
	 * conflicting pasted element with an altered name to distinguish it from
	 * the existing one.  Note that for scalar references, this is equivalent
	 * to a {@link #REPLACE}.
	 */
	public static final PasteAction CLONE = new PasteAction("Clone"); //$NON-NLS-1$

	/**
	 * Indicates that the collision should be resolved by discarding the
	 * new element (not pasting it).
	 */
	public static final PasteAction DISCARD = new PasteAction("Discard"); //$NON-NLS-1$

	/**
	 * Indicates that the collision should be resolved by just not doing
	 * anything.  The new element will not be pasted.
	 */
	public static final PasteAction IGNORE = new PasteAction("Ignore"); //$NON-NLS-1$

	/**
	 * Indicates that the collision should be resolved by merging the
	 * new element into the existing one.  The merge will be strong or weak
	 * according to the merge hints provided to the paste operation.
	 */
	public static final PasteAction MERGE = new PasteAction("Merge"); //$NON-NLS-1$

	/**
	 * The "undefined" value.  This is an invalid paste action, which can be used
	 * to indicate that the determination of an appropriate paste action has
	 * not been done. 
	 */
	public static final PasteAction NO_ACTION = new PasteAction("No Action"); //$NON-NLS-1$

	/**
	 * Indicates that the collision should be resolved by replacing the
	 * existing element with the new one.
	 */
	public static final PasteAction REPLACE = new PasteAction("Replace"); //$NON-NLS-1$

	/**
	 * The list of values for this enumerated type.
	 */
	private static final PasteAction[] VALUES = {ADD, CLONE, DISCARD, IGNORE,
		MERGE, NO_ACTION, REPLACE};

	/**
	 * Constructs a new paste action with the specified name.
	 * 
	 * @param name The name of the new paste action.
	 */
	private PasteAction(String name) {
		super(nextOrdinal++,name);
	}

	/**
	 * Retrieves the list of constants for this enumerated type.
	 * 
	 * @return The list of constants for this enumerated type.
	 */
	protected List getValues() {
		return Collections.unmodifiableList(Arrays.asList(VALUES));
	}
}