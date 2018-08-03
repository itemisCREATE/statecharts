/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service.git;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.examples.wizard.service.data.ExampleData;

import com.google.gson.Gson;

/**
 * 
 * @author t00manysecretss
 * 
 */
public class JsonMetaDataReader implements IExampleDataReader {

	public List<ExampleData> parse(List<Path> metadata) {
		List<ExampleData> result = new ArrayList<>();
		Gson gson = new Gson();
		for (Path file : metadata) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
				ExampleData ed = gson.fromJson(reader, ExampleData.class);
				reader.close();
				ed.setProjectDir(file.toFile().getParentFile());
				result.add(ed);
			} catch (Exception e) {
				System.err.println("Error parsing metadata " + file.toAbsolutePath().toString());
				e.printStackTrace();
			}
		}
		return result;
	}
}
