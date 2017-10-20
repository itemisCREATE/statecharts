package org.yakindu.sct.generator.cpp;

public enum ErrorCode {
	OCB_DEFAULT_INIT("0001", "OCB_DEFAULT_INIT_ERROR"),
	OCB_NAMED_INIT("0010", "OCB_NAMED_INIT_ERROR"),
	OCB_INTERNAL_INIT("0011", "OCB_INTERNAL_INIT_ERROR")
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
