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

import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private IInterpreterScope scope = new InterpreterScope(null);

	private IValueFactory valueFactory;
	
	private volatile boolean canceled;
		
	/**
	 * 
	 */
	public InterpreterContext(IValueFactory valueFactory) {
		this.valueFactory = valueFactory;
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
	
	/**
	 * @return the scope
	 */
	public IInterpreterScope getScope() {
		return scope;
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
	
}
