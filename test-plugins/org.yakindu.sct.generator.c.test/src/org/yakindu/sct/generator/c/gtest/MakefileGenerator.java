/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */

package org.yakindu.sct.generator.c.gtest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class MakefileGenerator {
	private Path path;
	private StringBuilder builder;
	
	public MakefileGenerator(Path path) {
		this.path = path;
		this.builder = new StringBuilder();
	}

	public MakefileGenerator addJob(String jobName, Iterable<String> dependencies, String command) {
		builder.append("\n");
		builder.append(jobName).append(":");
		for (String dep : dependencies) {
			builder.append(" ").append(dep);
		}
		builder.append("\n");
		builder.append("\t").append(command).append("\n");

		return this;
	}

	public MakefileGenerator addJob(String jobName, String command) {
		return addJob(jobName, Collections.emptyList(), command);
	}
	
	public void generate() throws IOException {
		Files.write(path, builder.toString().getBytes());
	}
}
