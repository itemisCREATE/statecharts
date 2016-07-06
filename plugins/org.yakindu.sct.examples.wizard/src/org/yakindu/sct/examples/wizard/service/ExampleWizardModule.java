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
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExampleWizardModule implements Module {

	public static final String REPOSITORY_URL = "repository_url";

	@Override
	public void configure(Binder binder) {
		binder.bind(IExampleService.class).to(GitRepositoryExampleService.class);
		binder.bindConstant().annotatedWith(Names.named(REPOSITORY_URL)).to("https://github.com/Yakindu/examples");
		binder.bind(IExampleDataReader.class).to(JsonMetaDataReader.class);
	}

}
