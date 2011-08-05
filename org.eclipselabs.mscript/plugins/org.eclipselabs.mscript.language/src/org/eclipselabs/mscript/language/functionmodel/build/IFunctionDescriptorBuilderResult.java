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

package org.eclipselabs.mscript.language.functionmodel.build;

import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IFunctionDescriptorBuilderResult {

	/**
	 * @return the functionDescriptor
	 */
	FunctionDescriptor getFunctionDescriptor();

	/**
	 * @return the status
	 */
	IStatus getStatus();

}