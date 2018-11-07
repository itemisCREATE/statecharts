/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.gtest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;

import com.google.common.collect.Lists;

public class CompileGTestCommand {
	
	private String dir;
	private List<String> includes = Lists.newArrayList();
	private List<String> sources = Lists.newArrayList();
	private String compiler;
	private String program;

	public CompileGTestCommand directory(String dir) {
		this.dir = dir;
		return this;
	}

	public CompileGTestCommand includes(List<String> includes) {
		this.includes = includes;
		return this;
	}

	public CompileGTestCommand sources(List<String> sources) {
		this.sources  = sources;
		return this;
	}

	public CompileGTestCommand compiler(String compiler) {
		this.compiler = compiler;
		return this;
	}

	public CompileGTestCommand program(String program) {
		this.program = program;
		return this;
	}

	public List<String> build() {
		List<String> command = new ArrayList<>();
		command.add(compiler);
		command.add("-g");
		command.add("-o");
		command.add(getFileName(program));
		command.add("-O2");
		if (dir != null)
			command.add("-I" + dir + "/include");
		for (String include : includes) {
			command.add("-I" + include);
		}
		if (dir != null)
			command.add("-L" + dir);
		for (String sourceFile : sources) {
			command.add(getFileName(sourceFile ));
		}
		command.add("-lgtest");
		command.add("-lgtest_main");
		command.add("-lm");
		command.add("-lstdc++");
		command.add("-pthread");
		// command.add("-pg");

		System.out.println(command);
		return command;
	}

	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}
}
