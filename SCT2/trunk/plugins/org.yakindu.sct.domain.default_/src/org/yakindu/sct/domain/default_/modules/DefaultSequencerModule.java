/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.domain.default_.modules;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen (alexander.nyssen@itemis.de) - Refactored to
 *         AbstractGenericModule to allow subclasses to overwrite bindings
 * @author Markus Mühlbrandt - Added binding to DefaultNamingService
 */
public class DefaultSequencerModule extends AbstractGenericModule {

	public static final String ADD_TRACES = "ADD_TRACES";

	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(Boolean.class).annotatedWith(Names.named(ADD_TRACES)).toInstance(Boolean.FALSE);
	}

	public Class<? extends IModelSequencer> bindIModelSequencer() {
		return ModelSequencer.class;
	}

	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SGraphNameProvider.class;
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}
	
	public Class<? extends ITypeSystem> bindITypesystem(){
		return GenericTypeSystem.class;
	}

	public Class<? extends IResourceDescriptions> bindIResourceDescriptions() {
		return ResourceSetBasedResourceDescriptions.class;
	}

}
