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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private static final Scope MOST_OUTER_SCOPE = new Scope(null);
	
	private Scope scope = MOST_OUTER_SCOPE;

	private DiagnosticChain diagnostics;
	private IValueFactory valueFactory;
	
	private volatile boolean canceled;
	
	private IFunctor functor;
	
	/**
	 * 
	 */
	public InterpreterContext(DiagnosticChain diagnostics, IValueFactory valueFactory) {
		this.diagnostics = diagnostics;
		this.valueFactory = valueFactory;
	}
	
	/**
	 * @return the diagnosticChain
	 */
	public DiagnosticChain getDiagnostics() {
		return diagnostics;
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

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#getValueFactory()
	 */
	public IValueFactory getValueFactory() {
		return valueFactory;
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
		scope = new Scope(scope);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#leaveScope()
	 */
	public void leaveScope() {
		scope = scope.getOuterScope();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#addLocalVariable(org.eclipselabs.mscript.language.interpreter.IVariable)
	 */
	public void addLocalVariable(IVariable variable) {
		scope.addVariable(variable);
	}
	
	public IVariable getVariable(VariableDeclaration declaration) {
		IVariable variable = scope.getVariable(declaration);
		if (variable == null) {
			variable = functor.getVariable(declaration);
		}
		return variable;
	}
	
	private static class Scope {

		private Scope outerScope;
		private Map<VariableDeclaration, IVariable> variables = new HashMap<VariableDeclaration, IVariable>();
		
		/**
		 * 
		 */
		public Scope(Scope outerScope) {
			this.outerScope = outerScope;
		}
		
		/**
		 * @return the outerScope
		 */
		public Scope getOuterScope() {
			return outerScope;
		}
		
		public void addVariable(IVariable variable) {
			variables.put(variable.getDeclaration(), variable);
		}
		
		public IVariable getVariable(VariableDeclaration declaration) {
			IVariable variable;
			Scope scope = this;
			do {
				variable = scope.variables.get(declaration);
			} while (variable == null && (scope = scope.outerScope) != null);
			return variable;
		}
		
	}

}
