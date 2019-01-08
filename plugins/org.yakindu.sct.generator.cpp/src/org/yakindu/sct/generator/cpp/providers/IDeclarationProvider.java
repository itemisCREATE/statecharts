package org.yakindu.sct.generator.cpp.providers;

import org.yakindu.sct.generator.c.IGenArtifactConfigurations;
import org.yakindu.sct.model.sexec.ExecutionFlow;

public interface IDeclarationProvider {
	public CharSequence get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs);
}
