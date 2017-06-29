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
	
	@Inject
	protected AbstractIDValueConverter idValueConverter;
	
	protected BoolValueConverter boolConverter = new BoolValueConverter();
	protected HexValueConverter hexConverter = new HexValueConverter();
	protected BinaryValueConverter binaryConverter = new BinaryValueConverter();
	protected QIDValueConverter qidConverter = new QIDValueConverter();
	
	@ValueConverter(rule = "BOOL")
	public IValueConverter<Boolean> BOOL() {
		return boolConverter;
	}
	
	@ValueConverter(rule = "HEX")
	public IValueConverter<Integer> HEX() {
		return hexConverter;
	}
	
	@ValueConverter(rule = "BINARY")
	public IValueConverter<Integer> BINARY() {
		return binaryConverter;
	}
	
	@ValueConverter(rule = "QID")
	public IValueConverter<String> QID() {
		qidConverter.setIDValueConvert(idValueConverter);
		return qidConverter;
	}


}
