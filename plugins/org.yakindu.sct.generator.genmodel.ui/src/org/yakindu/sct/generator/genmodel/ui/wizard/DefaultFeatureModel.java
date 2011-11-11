package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.util.List;

/**
 * 
 * @author muelder
 * 
 */
public class DefaultFeatureModel {

	private String fileName = "example.sgen";
	private List<String> statecharts;
	private String generatorId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getStatecharts() {
		return statecharts;
	}

	public String getGeneratorId() {
		return generatorId;
	}

	public void setGeneratorId(String generatorId) {
		this.generatorId = generatorId;
	}

}
