/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

public class JavaCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart flow, GeneratorEntry entry) {
		JavaGenerator delegate = getInjector(entry).getInstance(JavaGenerator.class);		
		delegate.generate(createExecutionFlow(flow, entry), entry, getFileSystemAccess(entry));
	}
}
