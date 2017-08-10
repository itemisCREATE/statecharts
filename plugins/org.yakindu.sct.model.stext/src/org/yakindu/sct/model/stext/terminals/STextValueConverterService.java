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
