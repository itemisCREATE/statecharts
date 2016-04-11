package com.yakindu.sct.standalone.extension;

import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.java.JavaCodeGenerator;

import com.google.common.collect.Lists;

public class JavaGeneratorDescriptor implements IGeneratorDescriptor {
	@Override
	public String getName() {
		return "YAKINDU SCT Java Code Generator";
	}
	@Override
	public List<String> getLibraryIDs() {
		return Lists.newArrayList("org.yakindu.generator.core.features",
				"org.yakindu.generator.core.features.sctbase", "org.yakindu.sct.generator.feature.java");
	}
	@Override
	public Image getImage() {
		return null;
	}
	@Override
	public String getId() {
		return "yakindu::java";
	}
	@Override
	public String getElementRefType() {
		return "org.yakindu.sct.model.sgraph.Statechart";
	}
	@Override
	public String getDescription() {
		return "YAKINDU SCT Java Code Generator";
	}
	@Override
	public String getContentType() {
		return "statechart";
	}
	@Override
	public ISCTGenerator createGenerator() {
		return new JavaCodeGenerator();
	}
}