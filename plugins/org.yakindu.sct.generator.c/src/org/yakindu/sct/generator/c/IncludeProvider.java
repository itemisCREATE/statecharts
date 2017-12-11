package org.yakindu.sct.generator.c;

import java.util.List;

import org.yakindu.sct.model.sexec.ExecutionFlow;

public interface IncludeProvider {
	public List<CharSequence> getIncludes(ExecutionFlow it, List<CharSequence> includes, IGenArtifactConfigurations artifactConfigs);
}
