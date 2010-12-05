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

package org.eclipselabs.mscript.language.interpreter;

import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.internal.util.Scope;

public class InterpreterScope extends Scope<IInterpreterScope, VariableDeclaration, IVariable> implements IInterpreterScope {

	/**
	 * 
	 */
	public InterpreterScope(IInterpreterScope outerScope) {
		super(outerScope);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterScope#add(org.eclipselabs.mscript.language.interpreter.IVariable)
	 */
	public void add(IVariable element) {
		super.add(element.getDeclaration(), element);
	}
	
}