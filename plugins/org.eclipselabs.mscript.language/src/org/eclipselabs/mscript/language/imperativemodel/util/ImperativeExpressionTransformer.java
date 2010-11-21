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

package org.eclipselabs.mscript.language.imperativemodel.util;

import java.util.List;

import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.imperativemodel.Compound;

/**
 * @author Andreas Unger
 *
 */
public class ImperativeExpressionTransformer extends AstSwitch<Boolean> {

	public void transform(Expression expression, Compound compound, List<ImperativeExpressionTarget> targets) {
	}
	
}
