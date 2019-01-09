/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.generator.java;

import java.util.Collections;

import org.yakindu.sct.model.sexec.ExecutionFlow;

public class JavaIncludeProvider {
	public Iterable<String> getImports(ExecutionFlow it) {
		return Collections.emptyList();
	}
}
