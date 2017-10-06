/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.language;

import org.yakindu.sct.generator.core.language.IFunction;
import org.yakindu.sct.generator.core.language.factory.FunctionFactory;

/**
 * @author rbeckmann
 *
 */
public class CFunctionFactory extends FunctionFactory {
	/* (non-Javadoc)
	 * @see org.yakindu.sct.generator.common.factory.FunctionFactory#newFunction()
	 */
	@Override
	public IFunction function() {
		// TODO Auto-generated method stub
		IFunction function =  super.function();
		function.setType(Type.VOID);
		return function;
	}
}
