/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation.test;

import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import com.google.inject.Inject;

/**
 * 
 * Registers the validator for SGraphPackage since they override register due to
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=387170
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphJavaValidatorTester<T extends AbstractDeclarativeValidator> extends ValidatorTester<T> {
	@Inject
	public SGraphJavaValidatorTester(T validator, EValidatorRegistrar registrar, String languageName) {
		super(validator, registrar, languageName);
		EValidatorRegistryImpl newRegistry = new EValidatorRegistryImpl();
		newRegistry.put(SGraphPackage.eINSTANCE, validator);
		diagnostician = new Diagnostician(newRegistry);
	}

}
