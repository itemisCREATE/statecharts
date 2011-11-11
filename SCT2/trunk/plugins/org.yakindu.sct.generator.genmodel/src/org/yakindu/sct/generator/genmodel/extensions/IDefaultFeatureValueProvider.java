package org.yakindu.sct.generator.genmodel.extensions;

import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IDefaultFeatureValueProvider {

	public FeatureConfiguration createDefaultFeatureConfiguration(FeatureType type, Statechart statechart);
}
