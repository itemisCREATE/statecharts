package org.yakindu.sct.generator.core.impl;

import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

public interface ISGraphGenerator {
	abstract void generate(Statechart statechart, GeneratorEntry entry);
}
