/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service;

import org.yakindu.sct.examples.wizard.service.git.GitRepositoryExampleService;
import org.yakindu.sct.examples.wizard.service.git.IExampleDataReader;
import org.yakindu.sct.examples.wizard.service.git.JsonMetaDataReader;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExampleWizardModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IExampleService.class).to(GitRepositoryExampleService.class);
		binder.bind(IExampleDataReader.class).to(JsonMetaDataReader.class);
	}

}
