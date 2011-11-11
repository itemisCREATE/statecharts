package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.IMPLEMENTATION_SUFFIX;

import org.yakindu.sct.generator.genmodel.extensions.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.generator.genmodel.extensions.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author muelder
 * 
 */
public class DefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider implements
		IDefaultFeatureValueProvider {

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		if (parameterValue.getParameter().getName().equals(BASE_PACKAGE)) {
			parameterValue.setValue("org.yakindu.sct." + statechart.getName());
		} else if (parameterValue.getParameter().getName()
				.equals(IMPLEMENTATION_SUFFIX)) {
			parameterValue.setValue("impl");
		}
	}

	public boolean isProviderFor(String featureTypeName) {
		return IJavaFeatureConstants.NAMING_FEATURE.equals(featureTypeName);
	}

}
