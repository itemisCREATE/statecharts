package org.yakindu.sct.generator.java.eventdriven;

import java.util.Arrays;
import java.util.Collections;

import org.yakindu.sct.generator.java.GeneratorPredicate;
import org.yakindu.sct.generator.java.JavaIncludeProvider;
import org.yakindu.sct.model.sexec.ExecutionFlow;

import com.google.inject.Inject;

public class JavaEventDrivenIncludeProvider extends JavaIncludeProvider {
	@Inject
	protected GeneratorPredicate extensions;

	@Override
	public Iterable<String> getImports(ExecutionFlow it) {
		if (extensions.needsQueues(it)) {
			return Arrays.asList("java.util.Queue", "java.util.LinkedList");
		} else {
			return Collections.emptyList();
		}
	}
}
