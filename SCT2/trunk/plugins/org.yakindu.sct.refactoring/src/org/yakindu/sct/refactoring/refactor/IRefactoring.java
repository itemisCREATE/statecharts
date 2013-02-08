/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor;

/**
 * Base interface for all refactorings.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public interface IRefactoring<T> {
	
	/**
	 * Checks all preconditions that need to be statisfied before the refactoring can be executed.
	 * 
	 * @return true if all preconditions are satisfied, otherwise false
	 */
	public boolean isExecutable();

	/**
	 * Executes the refactoring logic.
	 */
	public void execute();

}
