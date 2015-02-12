package org.yakindu.sct.model.sexec.transformation.test;

import org.junit.Before;
import org.yakindu.sct.domain.default_.modules.DefaultSequencerModule;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

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
		Injector injector = Guice.createInjector(new DefaultSequencerModule());
		injector.injectMembers(this);
	}

}
