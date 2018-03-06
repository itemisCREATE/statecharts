/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.expressions.terminals;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;

import com.google.inject.Inject;

/**
 * Contributes stext specific value converters
 * 
 * @author axel terfloth
 */
public class ExpressionsValueConverterService extends DefaultTerminalConverters {
	
	public static final String QID = "QID";
	public static final String BOOL = "BOOL";
	public static final String HEX = "HEX";
	public static final String BINARY = "BINARY";
	public static final String FLOAT = "FLOAT";
	
	@Inject
	protected AbstractIDValueConverter idValueConverter;
	
	@Inject
	protected BoolValueConverter boolConverter;
	
	@Inject
	protected HexValueConverter hexConverter;
	
	@Inject
	protected BinaryValueConverter binaryConverter;
	
	@Inject
	protected QIDValueConverter qidConverter;
	
	@Inject
	protected FloatValueConverter floatConverter;
	
	@ValueConverter(rule = BOOL)
	public IValueConverter<Boolean> BOOL() {
		return boolConverter;
	}
	
	@ValueConverter(rule = HEX)
	public IValueConverter<Integer> HEX() {
		return hexConverter;
	}
	
	@ValueConverter(rule = BINARY)
	public IValueConverter<Integer> BINARY() {
		return binaryConverter;
	}
	
	@ValueConverter(rule = QID)
	public IValueConverter<String> QID() {
		return qidConverter;
	}
	
	@ValueConverter(rule = FLOAT)
	public IValueConverter<Float> FLOAT() {
		return floatConverter;
	}

}
