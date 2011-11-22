package org.yakindu.sct.generator.core.features;

import org.eclipse.core.runtime.IStatus;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDefaultFeatureValueProvider {

	public FeatureConfiguration createDefaultFeatureConfiguration(
			FeatureType type, Statechart statechart);
	
	public IStatus validateParameterValue(FeatureParameterValue value);

	public boolean isProviderFor(FeatureTypeLibrary library);
	
	
}
