package org.yakindu.sct.domain.generic.simulation;
import org.yakindu.sct.domain.extension.IModuleProvider;

import com.google.inject.Module;

public class SimulationModuleProvider implements IModuleProvider {

	@Override
	public Module getModule(String... options) {
		return new GenericSimulationModule();
	}

}
