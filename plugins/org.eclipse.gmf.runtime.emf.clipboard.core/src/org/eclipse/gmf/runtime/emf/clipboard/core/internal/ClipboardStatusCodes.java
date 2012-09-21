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

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;


/**
 * @author Yasser Lulu  
 */
public final class ClipboardStatusCodes {

	/**
	 * 
	 */
	private ClipboardStatusCodes() {
		super();
	}
	
	public static final int OK = 0;
	public static final int ERROR = 1;
	public static final int IGNORED_EXCEPTION_WARNING = 10;

	public static final int CLIPBOARDSUPPORT_MISSING_NSURI = 30;
	public static final int CLIPBOARDSUPPORT_MISSING_CLASS = 31;
	public static final int CLIPBOARDSUPPORT_UNRESOLVED_NSURI = 32;
	public static final int CLIPBOARDSUPPORT_FACTORY_FAILED = 33;
}
