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

import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
class ExpressionDescriptor {
	
	private Expression expression;
	private DataType dataType;
	
	/**
	 * 
	 */
	public ExpressionDescriptor(Expression expression, DataType dataType) {
		this.expression = expression;
		this.dataType = dataType;
	}
	
	/**
	 * @return the expression
	 */
	public Expression getExpression() {
		return expression;
	}
	
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	
}
