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
package org.yakindu.base.expressions.terminals;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * This float value converter provides float values with 'f' as suffix
 * character.
 * 
 * @author robert rudi
 *
 */
public class FloatValueConverter extends AbstractLexerBasedConverter<Float> {

	protected static final String FLOAT_SUFFIX = "f";

	@Override
	public Float toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to float.", node, null);
		try {
			if (string.endsWith(FLOAT_SUFFIX))
				return Float.parseFloat(string.substring(0, string.length() - 1));
			else
				return Float.parseFloat(string);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to float.", node, null);
		}
	}

	@Override
	protected String toEscapedString(Float value) {
		return super.toEscapedString(value) + FLOAT_SUFFIX;
	}

}
