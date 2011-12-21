package org.yakindu.sct.model.stext.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

/**
 * Contributes stext specific value converters
 * 
 * @author axel terfloth
 */
public class StextValueConverterService extends DefaultTerminalConverters {
	
	protected BoolValueConverter boolConverter = new BoolValueConverter();
	protected HexValueConverter hexConverter = new HexValueConverter();
	
	@ValueConverter(rule = "BOOL")
	public IValueConverter<Boolean> BOOL() {
		return boolConverter;
	}

	
	@ValueConverter(rule = "HEX")
	public IValueConverter<Integer> HEX() {
		return hexConverter;
	}


}
