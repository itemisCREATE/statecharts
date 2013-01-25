/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.util;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
//TODO COpied
public class TestInjectorProvider implements IInjectorProvider{

	@Override
	public Injector getInjector() {
		// use own runtime module here if required
		return Guice.createInjector(new SequencerModule());
	}

}
