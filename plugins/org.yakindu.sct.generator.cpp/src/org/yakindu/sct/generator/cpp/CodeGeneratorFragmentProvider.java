/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.generator.c.IGenArtifactConfigurations;
import org.yakindu.sct.generator.cpp.providers.ISourceFragment;
import org.yakindu.sct.model.sexec.ExecutionFlow;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * @author rbeckmann
 */
public class CodeGeneratorFragmentProvider {

	@Inject
	protected Injector injector;

	public CharSequence get(String target, ExecutionFlow flow, IGenArtifactConfigurations config) {
		Key<Set<ISourceFragment>> key = Key.get(new TypeLiteral<Set<ISourceFragment>>() {
		}, Names.named(target));
		if (injector.getExistingBinding(key) == null) {
			return "";
		}
		Set<ISourceFragment> fragments = injector.getInstance(key);
		return fragments.stream().map((it) -> it.get(flow, config))
				.collect(Collectors.joining(Strings.newLine() + Strings.newLine()));
	}
}
