/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.test;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.junit.Before;
import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.naming.DefaultNamingService;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 *
 * @author axel terfloth
 *
 */
public abstract class ModelSequencerTest extends Assert {

	@Inject
	protected IModelSequencer sequencer;

	@Inject
	protected BehaviorMapping behaviorMapping;

	@Inject
	protected StructureMapping structureMapping;

	@Before
	public void setup() {
		Module m = new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(INamingService.class).to(DefaultNamingService.class);
				binder.bind(IQualifiedNameProvider.class).to(SGraphNameProvider.class);
				binder.bind(ITypeSystem.class).toInstance(GenericTypeSystem.getInstance());
				binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
				binder.bind(String.class).annotatedWith(Names.named("Separator")).toInstance("_");
			}
		};
		Injector injector = Guice.createInjector(m);
		injector.injectMembers(this);
	}

	protected Step firstStep(Step seq) {
		org.junit.Assert.assertNotNull(seq);
		assert (seq instanceof Sequence);

		return ((Sequence) seq).getSteps().get(0);
	}

}
