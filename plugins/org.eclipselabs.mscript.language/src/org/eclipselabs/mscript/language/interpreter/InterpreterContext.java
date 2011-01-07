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

import org.eclipselabs.mscript.common.internal.util.Scope;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.language.il.VariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private IComputationContext computationContext;

	private InterpreterScope scope = new InterpreterScope(null);

	private volatile boolean canceled;
		
	/**
	 * 
	 */
	public InterpreterContext(IComputationContext computationContext) {
		this.computationContext = computationContext;
	}

	/**
	 * @return the computationContext
	 */
	public IComputationContext getComputationContext() {
		return computationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#isCanceled()
	 */
	public boolean isCanceled() {
		return canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#setCanceled(boolean)
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#enterScope()
	 */
	public void enterScope() {
		scope = new InterpreterScope(scope);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#leaveScope()
	 */
	public void leaveScope() {
		scope = scope.getOuterScope();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#getVariable(org.eclipselabs.mscript.language.il.VariableDeclaration)
	 */
	public IVariable getVariable(VariableDeclaration variableDeclaration) {
		return scope.findInEnclosingScopes(variableDeclaration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#addVariable(org.eclipselabs.mscript.language.il.VariableDeclaration, org.eclipselabs.mscript.language.interpreter.IVariable)
	 */
	public void addVariable(IVariable variable) {
		scope.add(variable);
	}
	
	public static class InterpreterScope extends Scope<InterpreterScope, VariableDeclaration, IVariable> {

		/**
		 * 
		 */
		public InterpreterScope(InterpreterScope outerScope) {
			super(outerScope);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterScope#add(org.eclipselabs.mscript.language.interpreter.IVariable)
		 */
		public void add(IVariable element) {
			super.add(element.getDeclaration(), element);
		}
		
	}
	
}
