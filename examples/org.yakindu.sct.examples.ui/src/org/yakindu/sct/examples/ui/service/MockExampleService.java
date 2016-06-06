package org.yakindu.sct.examples.ui.service;

import java.util.ArrayList;
import java.util.List;

//TODO Delete me
public class MockExampleService implements IExampleService {

	@Override
	public List<ExampleData> getAllExamples() {
		List<ExampleData> result = new ArrayList<>();
		result.add(new ExampleData("my.id", "title", "description"));
		result.add(new ExampleData("my.id2", "title2", "description2"));
		result.add(new ExampleData("my.id3", "title3", "description3"));
		
		return result;
	}

}
