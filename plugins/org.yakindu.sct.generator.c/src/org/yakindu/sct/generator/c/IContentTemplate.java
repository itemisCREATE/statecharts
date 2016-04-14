package org.yakindu.sct.generator.c;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public interface IContentTemplate {

	String content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations);
}
