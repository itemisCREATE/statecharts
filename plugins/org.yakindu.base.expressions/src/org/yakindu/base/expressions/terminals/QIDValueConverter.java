/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * 
 * Jonathan Thoene - initial API and implementation
 *
*/
package org.yakindu.base.expressions.terminals;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

/**
 * 
 * @author jonathan thoene - Initial contribution and API
 * 
 */

public class QIDValueConverter extends AbstractValueConverter<String> {

	@Inject
	protected AbstractIDValueConverter idValueConverter;

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		String result = "";
		if (string.split(".").length > 0) {
			for (String str : string.split(".")) {
				String partResult = idValueConverter.toValue(str, node);
				result = reassembleString(string, result, str, partResult);
			}
		} else {
			result = idValueConverter.toValue(string, node);
		}
		return result;
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		String result = "";
		if (value.split(".").length > 0) {
			for (String str : value.split(".")) {
				String partResult = idValueConverter.toString(str);
				result = reassembleString(value, result, str, partResult);
			}
		} else {
			result = idValueConverter.toString(value);
		}
		return result;
	}

	private String reassembleString(String value, String result, String str, String partResult) {
		if (value.split("")[0].equals(str)) {
			result += partResult;
		} else {
			result += ("." + partResult);
		}
		return result;
	}
}
