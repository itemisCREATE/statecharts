package org.yakindu.sct.model.sexec.transformation.test;

import org.junit.Before;
import org.yakindu.sct.domain.default_.modules.DefaultSequencerModule;
import org.yakindu.sct.model.sexec.naming.DefaultNamingService;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author axel terfloth
 * 
 */
public class ModelSequencerTest extends Assert {

	@Inject
	protected IModelSequencer sequencer;

	@Inject
	protected BehaviorMapping behaviorMapping;

	@Inject
	protected StructureMapping structureMapping;

	@Before
	public void setup() {
		Module m = Modules.override(new DefaultSequencerModule()).with(new Module(){
			@Override
			public void configure(Binder binder) {
				binder.bind(INamingService.class).to(DefaultNamingService.class);
			}
		});
		Injector injector = Guice.createInjector(m);
		injector.injectMembers(this);
	}

}
