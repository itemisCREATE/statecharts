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

import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * @author Andreas Unger
 * 
 * @noextend
 * @noimplement
 */
public interface IInterpreterContext {
	
	IStaticEvaluationContext getStaticEvaluationContext();
	IComputationContext getComputationContext();

	void enterScope();
	void leaveScope();
	
	IVariable getVariable(VariableDeclaration variableDeclaration);
	void addVariable(IVariable variable);
	
	void setCanceled(boolean canceled);
	boolean isCanceled();

}
