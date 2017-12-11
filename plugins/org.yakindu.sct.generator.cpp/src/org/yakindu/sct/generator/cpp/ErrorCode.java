package org.yakindu.sct.generator.cpp;

public enum ErrorCode {
	OCB_INIT_MASK("0b1000000100000000", "OCB_INIT_ERROR_MASK"),
	OCB_DEFAULT_INIT("0b00000001", "OCB_DEFAULT_INIT_ERROR"),
	OCB_NAMED_INIT("0b00000010", "OCB_NAMED_INIT_ERROR"),
	OCB_INTERNAL_INIT("0b00000100", "OCB_INTERNAL_INIT_ERROR")
	;
	
	protected String value;
	protected String name;
	ErrorCode(String value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
