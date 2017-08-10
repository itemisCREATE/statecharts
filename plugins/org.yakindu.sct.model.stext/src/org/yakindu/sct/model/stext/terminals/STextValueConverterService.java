package org.yakindu.sct.model.stext.terminals;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.yakindu.base.expressions.terminals.ExpressionsValueConverterService;

import com.google.inject.Inject;

public class STextValueConverterService extends ExpressionsValueConverterService{
	
	public static final String XID = "XID";
	public static final String FQN = "FQN";
	
	@Inject
	protected FQNValueConverter fqnConverter;
	
	@Inject
	protected XIDValueConverter xidConverter;
	
	@ValueConverter(rule = XID)
	public IValueConverter<String> XID() {
		return xidConverter;
	}
	
	@ValueConverter(rule = FQN)
	public IValueConverter<String> FQN() {
		return fqnConverter;
	}
}
