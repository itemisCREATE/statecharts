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

import static org.eclipse.core.runtime.Platform.OS_MACOSX;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import com.google.common.collect.Lists;
public class CompileGTestCommand {
	
	private String dir;
	private List<String> includes = Lists.newArrayList();
	private List<String> sources = Lists.newArrayList();
	private String compiler;
	private String program;
	private String makefileDir;
	private String mainLib;
	private boolean wPedantic = false;
	private boolean wAll = false;
	private boolean wExtra = false;
	private boolean wError = false;
	private boolean wConversion = false;
	
	public CompileGTestCommand directory(String dir) {
		this.dir = dir;
		return this;
	}

	public CompileGTestCommand includes(List<String> includes) {
		this.includes = includes;
		return this;
	}
	
	public CompileGTestCommand wPedantic() {
		this.wPedantic = true;
		return this;
	}
		
	public CompileGTestCommand wAll() {
		this.wAll = true;
		return this;
	}
	
	public CompileGTestCommand wExtra() {
		this.wExtra = true;
		return this;
	}
	
	public CompileGTestCommand wError() {
		this.wError = true;
		return this;
	}
	
	public CompileGTestCommand wConversion() {
		this.wConversion = true;
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

	public CompileGTestCommand makefileDir(String makefileDir) {
		this.makefileDir = makefileDir;
		return this;
	}

	public CompileGTestCommand mainLib(String mainLib) {
		this.mainLib = mainLib;
		return this;
	}

	public List<String> build(boolean build, String...compilerFlags) {
		List<String> command = new ArrayList<>();
		if (makefileDir != null) {
			try {
				generateMakefile();
				command.add("make");
				command.add("-j4");
				System.out.println(command);
				return command;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		command.add(compiler);
		command.add("-g");
		if(build) {
			command.add("-o");
			command.add(getFileName(program));
		} else {
			command.add("-c");
			if(compiler.equals("gcc")) {
					command.add("-std=c90");
			}
		}
		command.add("-O0");
		if(wPedantic) {
			command.add("-pedantic");
			command.add("-pedantic-errors");
		}
		if(wAll) {
			command.add("-Wall");
		}
		if(wExtra) {
			command.add("-Wextra");
		}
		if(wError) {
			command.add("-Werror");
		}
		if(wConversion) {
			command.add("-Wconversion");
		}
		
		if (OS_MACOSX.equals(Platform.getOS())) {
			command.add("-Wno-variadic-macros");
			command.add("-Wno-long-long");
			command.add("-Wno-unused-private-field");
		}
		
		for(String compilerFlag:compilerFlags) {
			command.add(compilerFlag);
		}
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
		if(build) {
			command.add("-lgtest");
			if (mainLib != null) {
				command.add("-l" + mainLib);
			} else {
				command.add("-lgtest_main");
			}
		}
		command.add("-lm");
		command.add("-lstdc++");
		command.add("-pthread");
		// command.add("-pg");

		System.out.println(command);
		return command;
	}

	protected void generateMakefile() throws IOException {
		MakefileGenerator makefile = new MakefileGenerator(Paths.get(makefileDir, "Makefile"));
		Map<String, String> oFiles = new HashMap<>();
		for (String sourceFile : sources) {
			oFiles.put(sourceFile, objectFileName(sourceFile));
		}

		makefile.addJob("all", oFiles.values(), linkingCommand(oFiles.values()));
		
		for (String sourceFile : sources) {
			makefile.addJob(oFiles.get(sourceFile), compileCommand(sourceFile, oFiles.get(sourceFile)));
		}
		
		makefile.generate();
	}
	
	/*
	 * Used for Makefile generating
	 */
	protected String objectFileName(String sourceFilename) {
		return sourceFilename.replace(".", "") + ".o";
	}
	
	protected String linkingCommand(Iterable<String> objectFiles) {
		StringBuilder command = new StringBuilder();
		command.append(compiler);
		command.append(" -o ").append(getFileName(program));
		for (String o : objectFiles) {
			command.append(" ").append(o);
		}
		if (dir != null) {
			command.append(" -L" + dir);
		}
		command.append(" -lgtest");
		if (mainLib != null) {
			command.append(" -l").append(mainLib);
		} else {
			command.append(" -lgtest_main");
		}
		command.append(" -lm -lstdc++ -pthread");
		return command.toString();
	}
	
	protected String compileCommand(String sourceFile, String objectFile) {
		StringBuilder command = new StringBuilder();
		command.append(compiler).append(" -c").append(" -o ").append(objectFile).append(" -O0 ").append(sourceFile);
		if (dir != null)
			command.append(" -I" + dir + "/include");
		for (String include : includes) {
			command.append(" -I" + include);
		}
		return command.toString();
	}

	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}
}
