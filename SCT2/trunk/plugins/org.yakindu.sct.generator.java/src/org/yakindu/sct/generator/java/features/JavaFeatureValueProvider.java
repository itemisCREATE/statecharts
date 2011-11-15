package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.IMPLEMENTATION_SUFFIX;

import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author muelder
 * 
 */
public class JavaFeatureValueProvider extends
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

	public boolean isProviderFor(FeatureTypeLibrary library) {
		//TODO
		return false;
	}

}
