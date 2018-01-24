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

import com.google.inject.ImplementedBy;

/**
 * @author rbeckmann
 *
 */
@ImplementedBy(TreeStringShortener.class)
public interface IStringShortener {
	public void setMaxLength(int length);
	public StorageToken addString(List<String> s);
	
	public String getString(StorageToken token);
}
