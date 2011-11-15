package org.yakindu.sct.generator.c.features;

import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

public class CDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	public CDefaultFeatureValueProvider() {
	}

	public boolean isProviderFor(FeatureTypeLibrary library) {
		// TODO
		return false;
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
	}

}
