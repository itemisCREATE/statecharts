package org.yakindu.sct.examples.ui.service;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IExampleService {

	public List<ExampleData> getAllExamples();

	public void importSelectedExample(ExampleData edata, IProgressMonitor monitor);

	public class ExampleData {
		private ExampleData parent;
		private ExampleData[] children;
		private String id;
		private String title;
		private String domain;
		private String description;
		private URL[] images;
		private File projectDir;

		public ExampleData(String domain, String id, String title, String description, URL[] images) {
			this.domain = domain;
			this.id = id;
			this.title = title;
			this.description = description;
			this.images = images;
		}

		public ExampleData(ExampleData parent, ExampleData[] children, String title) {
			this.parent = parent;
			this.children = children;
			this.title = title;
			this.domain = title;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public URL[] getImages() {
			return images;
		}

		public void setImages(URL[] images) {
			this.images = images;
		}

		public File getProjectDir() {
			return projectDir;
		}

		public void setProjectDir(File projectDir) {
			this.projectDir = projectDir;
		}

		public boolean hasChildren() {
			if (children != null) {
				return true;
			} else {
				return false;
			}
		}
	}
}