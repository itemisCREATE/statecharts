package org.yakindu.sct.generator.core.impl;

public interface IGeneratorLog {

	void writeToConsole(Throwable t);

	void writeToConsole(String line);

	void close() throws Throwable;

}