package org.yakindu.sct.generator.cpp;

public enum ErrorCode {
	OCB_INIT_MASK("33024", "OCB_INIT_ERROR_MASK"),
	OCB_DEFAULT_INIT("1", "OCB_DEFAULT_INIT_ERROR"),
	OCB_NAMED_INIT("2", "OCB_NAMED_INIT_ERROR"),
	OCB_INTERNAL_INIT("4", "OCB_INTERNAL_INIT_ERROR")
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
