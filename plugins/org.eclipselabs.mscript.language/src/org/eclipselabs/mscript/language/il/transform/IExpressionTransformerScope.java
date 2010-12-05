/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.il.transform;

import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.internal.util.IScope;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IExpressionTransformerScope extends IScope<IExpressionTransformerScope, String, VariableDeclaration> {

	/**
	 * @return the compound
	 */
	Compound getCompound();
	
	void setCompound(Compound compound);

	void add(VariableDeclaration element);

}