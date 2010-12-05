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
import org.eclipselabs.mscript.language.internal.util.Scope;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformerScope extends Scope<IExpressionTransformerScope, String, VariableDeclaration> implements IExpressionTransformerScope {

	private Compound compound;
	
	/**
	 * 
	 */
	public ExpressionTransformerScope(IExpressionTransformerScope outerScope) {
		super(outerScope);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerScope#getCompound()
	 */
	public Compound getCompound() {
		return compound;
	}
	
	/**
	 * @param compound the compound to set
	 */
	public void setCompound(Compound compound) {
		this.compound = compound;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerScope#add(org.eclipselabs.mscript.language.il.VariableDeclaration)
	 */
	public void add(VariableDeclaration element) {
		super.add(element.getName(), element);
	}
	
}
