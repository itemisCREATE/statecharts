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

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;


/**
 * This boolean value converter recognizes 'true' 'yes' 'false' and 'no' as boolean values.
 *  
 * @author axel terfloth
 *
 */
public class BoolValueConverter extends AbstractLexerBasedConverter<Boolean> {

	public Boolean toValue(String string, INode node) {

		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to boolean.", node, null);
		
		if ("true".equals(string.toLowerCase()) || "yes".equals(string.toLowerCase())) {
			return true;
		}
		
		if ("false".equals(string.toLowerCase()) || "no".equals(string.toLowerCase())) {
			return false;
		}
		
		throw new ValueConverterException("Couldn't convert '" + string + "' to boolean.", node, null);
	}

}
