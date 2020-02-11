package org.yakindu.sct.generator.cpp;

public enum ErrorCode {
	OCB_INIT_MASK("0x8100", "OCB_INIT_ERROR_MASK", "0b1000000100000000"),
	OCB_DEFAULT_INIT("0x1", "OCB_DEFAULT_INIT_ERROR", "0b00000001"),
	OCB_NAMED_INIT("0x2", "OCB_NAMED_INIT_ERROR", "0b00000010"),
	OCB_INTERNAL_INIT("0x4", "OCB_INTERNAL_INIT_ERROR", "0b00000100")
	;
	
	protected String hexValue;
	protected String name;
	protected String binaryValue;
	
	ErrorCode(String hexValue, String name, String binaryValue) {
		this.hexValue = hexValue;
		this.name = name;
		this.binaryValue = binaryValue;
	}
	
	public String getHexValue() {
		return hexValue;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBinaryValue() {
		return binaryValue;
	}
}
