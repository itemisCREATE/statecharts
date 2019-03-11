package org.yakindu.sct.generator.java.eventdriven;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.generator.java.GeneratorPredicate;
import org.yakindu.sct.generator.java.JavaIncludeProvider;
import org.yakindu.sct.model.sexec.ExecutionFlow;

import com.google.inject.Inject;

public class JavaEventDrivenIncludeProvider extends JavaIncludeProvider {
	@Inject
	protected GeneratorPredicate extensions;

	@Override
	public Iterable<String> getImports(ExecutionFlow it) {
		List<String> includes = new ArrayList<>();
		if (extensions.needsQueues(it)) {
			includes.add("java.util.Queue");
			includes.add("java.util.LinkedList");
		}
		if (extensions.needsSynchronized()) {
			includes.add("java.util.concurrent.BlockingQueue");
			includes.add("java.util.concurrent.LinkedBlockingQueue");
		}
		return includes;
	}
}
