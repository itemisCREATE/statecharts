/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.naming;

import java.util.List;

import org.yakindu.sct.model.sexec.naming.tree.TreeStringShortener;

import com.google.inject.ImplementedBy;

/**
 * @author rbeckmann
 *
 */
@ImplementedBy(TreeStringShortener.class)
public interface IStringShortener {
	public void setMaxLength(int length);
	
	/** Adds a string to the shortener. Can be retreived later in shortened form via getString using the token. */
	public void addString(List<String> s, Object token);
	
	/** Retrieves a shortened String from the shortener, using the token that was specified on depositing the original String. */
	public String getString(Object token);
	
	public void reset();
}
