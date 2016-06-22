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
package org.yakindu.sct.examples.ui.wizards.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.examples.ui.wizards.ExampleData;

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
				e.printStackTrace();
			}
		}
//		result = sortList(result);
		return result;
	}

	protected List<ExampleData> sortList(List<ExampleData> result) {
		List<String> domains = new ArrayList<String>();
		for (int i = 0; i < result.size(); i++) {
			if (!domains.contains(result.get(i).getDomain())) {
				domains.add(result.get(i).getDomain());
			}
		}
		ExampleData[] root = new ExampleData[domains.size()];
		for (int i = 0; i < root.length; i++) {
			root[i] = new ExampleData(null, null, domains.get(i));
		}
		for (int d = 0; d < root.length; d++) {
			int size = 0;
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getDomain().equals(root[d].getTitle())) {
					result.get(i).setParent(root[d]);
					size++;
				}
			}
			ExampleData[] children = new ExampleData[size];
			for (int i = 0, c = 0; i < result.size(); i++) {
				if (result.get(i).getParent() == root[d]) {
					children[c] = result.get(i);
					c++;
				}
			}
			root[d].setChildren(children);
			result.add(root[d]);
		}
		return result;

	}
}
