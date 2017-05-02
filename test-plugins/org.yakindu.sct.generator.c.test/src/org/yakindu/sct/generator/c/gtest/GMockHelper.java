package org.yakindu.sct.generator.c.gtest;

import java.util.List;

public class GMockHelper extends GTestHelper {
	public GMockHelper(Object owner) {
		super(owner);
	}
	
	@Override
	protected List<String> createCommand() {
		List<String> command = super.createCommand();
		command.remove("-lgtest_main");
		command.add("-lgmock_main");
		return command;
	}
	
	@Override
	protected String getCompilerCommand() {
		return "g++";
	}
}
