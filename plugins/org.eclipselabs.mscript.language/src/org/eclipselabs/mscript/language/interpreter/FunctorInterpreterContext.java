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

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class FunctorInterpreterContext extends InterpreterContext implements IFunctorInterpreterContext {

	private IFunctor functor;

	/**
	 * @param diagnostics
	 * @param valueFactory
	 */
	public FunctorInterpreterContext(DiagnosticChain diagnostics, IValueFactory valueFactory) {
		super(diagnostics, valueFactory);
	}

	/**
	 * @return the functor
	 */
	public IFunctor getFunctor() {
		return functor;
	}
	
	/**
	 * @param functor the functor to set
	 */
	public void setFunctor(IFunctor functor) {
		this.functor = functor;
	}

	public IVariable getVariable(VariableDeclaration declaration) {
		IVariable variable = super.getVariable(declaration);
		if (variable == null) {
			variable = functor.getVariable(declaration);
		}
		return variable;
	}

}
