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
 * @noextend
 * @noimplement
 */
public interface IInterpreterContext {
	
	IValueFactory getValueFactory();

	DiagnosticChain getDiagnostics();
		
	IFunctor getFunctor();
	void setFunctor(IFunctor functor);
	
	void enterScope();
	void leaveScope();
	
	void addLocalVariable(IVariable variable);
	IVariable getVariable(VariableDeclaration declaration);
	
	void setCanceled(boolean canceled);
	boolean isCanceled();

}
