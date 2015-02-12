/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.domain.default_.modules;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

/**
 * 
 * Default Module used for type contribution and type inference. Override
 * bindings to specify custom behavior.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultTypeSystemModule extends AbstractGenericModule {

	public Class<? extends ITypeSystem> bindITypeSystem() {
		return DefaultTypeSystem.class;
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}

}
