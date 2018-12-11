/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.model.stext.terminals;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.yakindu.base.expressions.terminals.ExpressionsValueConverterService;

public class STextValueConverterService extends ExpressionsValueConverterService{

	public static final String XID = "XID";
	public static final String FQN = "FQN";

	@ValueConverter(rule = XID)
	public IValueConverter<String> XID() {
		return qidConverter;
	}

	@ValueConverter(rule = FQN)
	public IValueConverter<String> FQN() {
		return qidConverter;
	}
}
