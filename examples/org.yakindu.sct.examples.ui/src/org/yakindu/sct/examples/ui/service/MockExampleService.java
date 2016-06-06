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
			URL[] url = {new URL("http://fab404.com/wp-content/uploads/2013/06/knockknockfactory404.jpg")};
			ExampleData[] edGeneric = new ExampleData[10];
			for(int i=0;i<edGeneric.length;i++) {
				edGeneric[i] = new ExampleData(null,"Generic","my.id.nr"+i,"myTitle"+i,"super discription!",url);
				result.add(edGeneric[i]);
			}
			ExampleData generic = createNode("Generic",edGeneric);
			result.add(generic);
			ExampleData[] edPro = new ExampleData[10];
			for(int i=0;i<edPro.length;i++) {
				edPro[i] = new ExampleData(null,"Pro","my.id.nr"+(10+i),"myTitlePro"+i,"super discribere thats latin",url);
				result.add(edPro[i]);
			}
			ExampleData pro = createNode("Pro",edPro);
			result.add(pro);
		} catch(Exception e) {e.printStackTrace();}
		return result;
	}
	
	protected ExampleData createNode(String domain,ExampleData[] exdat) {
		ExampleData result = new ExampleData(null,exdat,domain);
		for(int i=0;i<exdat.length;i++) {
			exdat[i].setParent(result);
		}
		return result;
	}

}
