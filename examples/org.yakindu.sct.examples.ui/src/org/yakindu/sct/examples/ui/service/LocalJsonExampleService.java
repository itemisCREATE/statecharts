package org.yakindu.sct.examples.ui.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.google.gson.Gson;

public class LocalJsonExampleService implements IExampleService {

	private String sep = System.getProperty("file.separator");
	private File root = new File(System.getProperty("user.home") + "\\Desktop\\jsons");

	public void setRoot(File file) {
		this.root = file;
	}

	@Override
	public List<ExampleData> getAllExamples() {
		List<File> projects = searchMetaInRoot();
		List<ExampleData> result = readJsonData(projects);
		result = sortList(result);
		return result;
	}

	protected List<File> searchMetaInRoot() {
		List<File> result = new ArrayList<File>();
		for (int i = 0; i < root.listFiles().length; i++) {
			File meta = new File(root.listFiles()[i].getPath() + sep + "metadata.json");
			if (meta.exists()) {
				result.add(meta);
			}
		}
		return result;
	}
	
	protected List<ExampleData> readJsonData(List<File> projects) {
		List<ExampleData> result = new ArrayList<ExampleData>();
		Iterator<File> ifi = projects.iterator();
		Gson gson = new Gson();
		while(ifi.hasNext()) {
			try {
				File file = ifi.next();
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String json = "",s = "";
				while((s = reader.readLine()) != null) {
					json += s;
				}
				reader.close();
				System.out.println(json);
				ExampleData ed = gson.fromJson(json, ExampleData.class);
				ed.setProjectDir(file.getParentFile());
				result.add(ed);
			} catch(Exception e) {e.printStackTrace();}
		}
		return result;
	}
	
	protected List<ExampleData> sortList(List<ExampleData> result) {
		List<String> domains = new ArrayList<String>();
		for(int i=0;i<result.size();i++) {
			if(!domains.contains(result.get(i).getDomain())) {
				domains.add(result.get(i).getDomain());
			}
		}
		ExampleData[] root = new ExampleData[domains.size()];
		for(int i=0;i<root.length;i++) {
			root[i] = new ExampleData(null,null,domains.get(i));
		}
		for(int d=0;d<root.length;d++) {
			int size = 0;
			for(int i=0;i<result.size();i++) {
				if(result.get(i).getDomain().equals(root[d].getTitle())) {
					result.get(i).setParent(root[d]);
					size++;
				}
			}
			ExampleData[] children = new ExampleData[size];
			for(int i=0,c=0;i<result.size();i++) {
				if(result.get(i).getParent() == root[d]) {
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
