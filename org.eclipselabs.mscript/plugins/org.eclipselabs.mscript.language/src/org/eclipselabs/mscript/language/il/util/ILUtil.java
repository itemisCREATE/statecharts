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

package org.eclipselabs.mscript.language.il.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class ILUtil {

	public static List<InputVariableDeclaration> getDirectFeedthroughInputs(ILFunctionDefinition functionDefinition) {
		List<InputVariableDeclaration> inputs = new ArrayList<InputVariableDeclaration>();
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.isDirectFeedthrough()) {
				inputs.add(inputVariableDeclaration);
			}
		}
		return inputs;
	}

}
