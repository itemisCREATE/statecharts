/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.interpreter;

import org.yakindu.base.expressions.util.ExpressionExtensions;
import org.yakindu.base.types.Expression;

import com.google.common.base.Supplier;
import com.google.inject.Inject;

/**
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class SlotResolutionExceptionSupplier implements Supplier<IllegalStateException> {

	@Inject
	protected ExpressionExtensions utils;
	
	private Expression exp;
	
	public SlotResolutionExceptionSupplier(Expression exp) {
		this.exp = exp;
	}
	
	public static SlotResolutionExceptionSupplier forContext(Expression exp) {
		return new SlotResolutionExceptionSupplier(exp);
	}

	public IllegalStateException get() {
		return new IllegalStateException("Could not resolve execution slot for expression " + utils.toText(exp));
	}
}
