package org.yakindu.sct.simulation.core.sexec;

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.language.ISCLanguage;
import org.yakindu.sct.simulation.core.language.ISCLanguageProvider;
import org.yakindu.sct.simulation.core.language.SimpleSCLanguage;

import com.google.inject.Module;

public class SCTLanguageProvider implements ISCLanguageProvider {

	public static final String SCT_LANGUAGE_ID = "org.yakindu.language.sct";

	@Override
	public ISCLanguage getLanguage() {
		return new SimpleSCLanguage(SCT_LANGUAGE_ID, "sct", null);
	}

	@Override
	public boolean isInstanceOfLanguage(Statechart sc) {
		return sc.eResource().getURI().toString().endsWith("sct");
	}

	@Override
	public Module getSimulationModule() {
		return new SimulationModule();
	}

}
