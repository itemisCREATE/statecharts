/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.core;

import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;

/**
 * Provides bindings for Code Generators based on {@link GeneratorEntry}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IGeneratorModule {

	public abstract void configure(GeneratorEntry entry, Binder binder);

}
