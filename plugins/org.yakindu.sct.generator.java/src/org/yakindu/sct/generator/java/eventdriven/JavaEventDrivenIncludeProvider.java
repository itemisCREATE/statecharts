package org.yakindu.sct.generator.java.eventdriven;

import java.util.Arrays;
import java.util.Collections;

import org.yakindu.sct.generator.java.JavaIncludeProvider;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.extensions.SExecExtensions;

import com.google.inject.Inject;

public class JavaEventDrivenIncludeProvider extends JavaIncludeProvider {
	@Inject
	protected SExecExtensions extensions;

	@Override
	public Iterable<String> getImports(ExecutionFlow it) {
		if (extensions.hasLocalEvents(it)) {
			return Arrays.asList("java.util.Queue", "java.util.LinkedList");
		} else {
			return Collections.emptyList();
		}
	}
}
