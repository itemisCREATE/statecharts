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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;
import org.eclipselabs.mscript.language.interpreter.value.IValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class InterpreterContext implements IInterpreterContext {

	private IValueFactory valueFactory;
	private boolean staticOnly;
	
	private volatile boolean canceled;
	
	private MultiStatus status = new MultiStatus(LanguagePlugin.PLUGIN_ID, 0, "", null);
	
	/**
	 * 
	 */
	public InterpreterContext(IValueFactory valueFactory, boolean staticOnly) {
		this.valueFactory = valueFactory;
		this.staticOnly = staticOnly;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#getValueFactory()
	 */
	public IValueFactory getValueFactory() {
		return valueFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.IInterpreterContext#isStaticOnly()
	 */
	public boolean isStaticOnly() {
		return staticOnly;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreterContext#addStatus(org.eclipse.core.runtime.IStatus)
	 */
	public void addStatus(IStatus status) {
		this.status.add(status);
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
	
}
