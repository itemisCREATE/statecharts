package org.yakindu.sct.generator.c.gtest;

public class GMockHelper extends GTestHelper {
	public GMockHelper(Object owner) {
		super(owner);
		this.compiler = Compiler.GPLUSPLUS;
	}

	@Override
	protected String getMainLib() {
		return "gmock_main";
	}
}
