package org.yakindu.sct.model.stext.conversion;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * 
 * @author axel terfloth
 *
 */
public class HexValueConverter extends AbstractLexerBasedConverter<Integer> {

	public static final String HEX_PREFIX = "0x";
	
	public Integer toValue(String string, INode node) {

		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to number.", node, null);

		try {
			// per form the conversion with string index 2 since the prefix is always '0x'
			return Integer.parseInt(string.substring(2), 16);
		} catch ( NumberFormatException e ) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to number.", node, null);
		}
	}

	@Override
	protected String toEscapedString(Integer value) {
		if (value < 0) { 
			return "-" + HEX_PREFIX + Integer.toString( value * -1, 16).toUpperCase();

		}
		return HEX_PREFIX + Integer.toString(value, 16).toUpperCase();
	}
	
	

}
