package org.yakindu.sct.examples.ui.service;

import java.net.URL;
import java.util.List;

public interface IExampleService {

	List<ExampleData> getAllExamples();
		
	public class ExampleData {
		private ExampleData parent;
		private ExampleData[] children;
		private String id;
		private String title;
		private String domain;
		private String discription;
		private URL[] images;
		
		public ExampleData(ExampleData parent,String domain,String id,String title,String discription,URL[] images) {
			this.parent = parent;
			this.domain = domain;
			this.id = id;
			this.title = title;
			this.discription = discription;
			this.images = images;
		}
		
		public ExampleData(ExampleData parent,ExampleData[] children,String title) {
			this.parent = parent;
			this.children = children;
			this.title = title;
		}
		
		public ExampleData getParent() {
			return parent;
		}
		
		public void setParent(ExampleData parent) {
			this.parent = parent;
		}
		
		public ExampleData[] getChildren() {
			return children;
		}
		
		public void setChildren(ExampleData[] children) {
			this.children = children;
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getDomain() {
			return domain;
		}
		
		public void setDomain(String domain) {
			this.domain = domain;
		}
		
		public String getDiscription() {
			return discription;
		}
		
		public void setDiscription(String discription) {
			this.discription = discription;
		}
		
		public URL[] getImages() {
			return images;
		}
		
		public void setImages(URL[] images) {
			this.images = images;
		}
		
		public boolean hasChildren() {
			if(children != null) {
				return true;
			} else {
				return false;
			}
		}
	}
}