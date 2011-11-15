package org.yakindu.sct.generator.core.features;

import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.SGenFactory;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractDefaultFeatureValueProvider implements
		IDefaultFeatureValueProvider {

	protected static final SGenFactory factory = SGenFactory.eINSTANCE;

	protected abstract void setDefaultValue(
			FeatureParameterValue parameterValue, Statechart statechart);

	public final FeatureConfiguration createDefaultFeatureConfiguration(
			FeatureType type, Statechart statechart) {
		FeatureConfiguration config = createConfiguration(type);
		EList<FeatureParameter> parameters = type.getParameters();
		for (FeatureParameter parameter : parameters) {
			FeatureParameterValue parameterValue = createParameterValue(
					parameter, statechart);
			config.getParameterValues().add(parameterValue);
		}
		return config;
	}

	protected FeatureParameterValue createParameterValue(
			FeatureParameter parameter, Statechart statechart) {
		FeatureParameterValue parameterValue = factory
				.createFeatureParameterValue();
		parameterValue.setParameter(parameter);
		setDefaultValue(parameterValue, statechart);
		return parameterValue;
	}

	protected FeatureConfiguration createConfiguration(FeatureType type) {
		FeatureConfiguration result = factory.createFeatureConfiguration();
		result.setType(type);
		return result;
	}

}
