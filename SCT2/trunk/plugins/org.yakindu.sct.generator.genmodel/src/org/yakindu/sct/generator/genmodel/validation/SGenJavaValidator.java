package org.yakindu.sct.generator.genmodel.validation;

import org.eclipse.xtext.validation.Check;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenJavaValidator extends AbstractSGenJavaValidator {

	@Check
	public void checkDuplicateGeneratorEntryFeature(
			final FeatureConfiguration config) {
		GeneratorEntry entry = (GeneratorEntry) config.eContainer();
		Iterable<FeatureConfiguration> filter = Iterables.filter(
				entry.getFeatures(), new Predicate<FeatureConfiguration>() {
					@Override
					public boolean apply(FeatureConfiguration input) {
						return (input.getType().getName().equals(config
								.getType().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error("Duplicate feature!",
					SGenPackage.Literals.FEATURE_CONFIGURATION__TYPE);
		}

	}

	@Check
	public void checkDuplicateFeatureParameter(final FeatureParameterValue value) {
		FeatureConfiguration entry = (FeatureConfiguration) value.eContainer();
		Iterable<FeatureParameterValue> filter = Iterables.filter(
				entry.getParameterValues(),
				new Predicate<FeatureParameterValue>() {
					@Override
					public boolean apply(FeatureParameterValue input) {
						return (input.getParameter().getName().equals(value
								.getParameter().getName()));
					}
				});
		if (Iterables.size(filter) > 1) {
			error("Duplicate parameter!",
					SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER);
		}
	}
}
