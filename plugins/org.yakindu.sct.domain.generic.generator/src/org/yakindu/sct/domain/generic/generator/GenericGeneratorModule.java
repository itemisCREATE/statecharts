/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.generic.generator;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

import com.google.inject.Binder;

/**
 * @author Johannes Dicks - Initial contribution and API
 *
 */
public class GenericGeneratorModule extends AbstractGenericModule {

	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(ITypeSystem.class).toInstance(GenericTypeSystem.getInstance());
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SGraphNameProvider.class;
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}

	public Class<? extends IResourceDescriptions> bindIResourceDescriptions() {
		return ResourceSetBasedResourceDescriptions.class;
	}
	
	
	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return IEncodingProvider.Runtime.class;
	}

}
