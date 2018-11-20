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
