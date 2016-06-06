package org.yakindu.sct.examples.ui.service;

import java.util.List;

public interface IExampleService {

	List<ExampleData> getAllExamples();

	public static class ExampleData {

		private String id;
		private String title;
		private String description;

		public ExampleData(String id, String title, String description) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
