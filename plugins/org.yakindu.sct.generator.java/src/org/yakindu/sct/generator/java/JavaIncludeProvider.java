package org.yakindu.sct.generator.java;

import java.util.Collections;

import org.yakindu.sct.model.sexec.ExecutionFlow;

public class JavaIncludeProvider {
	public Iterable<CharSequence> getImports(ExecutionFlow it) {
		return Collections.emptyList();
	}
}
