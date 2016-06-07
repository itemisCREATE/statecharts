package org.yakindu.sct.examples.ui.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TODO Delete me
public class MockExampleService implements IExampleService {

	@Override
	public List<ExampleData> getAllExamples() {
		List<ExampleData> result = new ArrayList<>();
		try {
			URL[] url = { new URL("http://fab404.com/wp-content/uploads/2013/06/knockknockfactory404.jpg") };
			ExampleData[] domain = new ExampleData[2];
			ExampleData[] edGeneric = new ExampleData[10];
			for (int i = 0; i < edGeneric.length; i++) {
				edGeneric[i] = new ExampleData("Generic", "my.id.nr" + i, "myTitle" + i, "super description!", url);
				result.add(edGeneric[i]);
			}
			domain[0] = createNode("Generic", edGeneric);
			result.add(domain[0]);
			ExampleData[] edPro = new ExampleData[10];
			for (int i = 0; i < edPro.length; i++) {
				edPro[i] = new ExampleData("Pro", "my.id.nr" + (10 + i), "myTitlePro" + i,
						"super describere thats latin", url);
				result.add(edPro[i]);
			}
			domain[1] = createNode("Pro", edPro);

			ExampleData root = createNode("Certified Examples", domain);
			result.add(domain[1]);
			result.add(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected ExampleData createNode(String domain, ExampleData[] exdat) {
		ExampleData result = new ExampleData(null, exdat, domain);
		for (int i = 0; i < exdat.length; i++) {
			exdat[i].setParent(result);
		}
		return result;
	}

}
